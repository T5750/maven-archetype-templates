/**
 * MIT License
 *
 * Copyright (c) 2016 Adrian CITU
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package com.github.adriancitu.csrf;

import com.github.adriancitu.csrf.defaultimpl.DefaultResourceCheckerHookImpl;
import com.github.adriancitu.csrf.defaultimpl.DefaultResponseBuilderHookImpl;
import com.github.adriancitu.test.TestTokenBuilderHookImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ServiceLoader;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GenericCSRFStatelessFilterTest extends TestCase {

	@Before
	public void setUp() throws Exception {

	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test the filter default init parameters.
	 */
	@Test
	public void testInitParametersDefault() throws ServletException {
		FilterConfig fc = mock(FilterConfig.class);

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);

		assertEquals("The (default) init parameter is not the expected one",
				"XSRF-TOKEN", filter.getCsrfCookieName());
		assertEquals("The (default) init parameter is not the expected one",
				"X-XSRF-TOKEN", filter.getCsrfHeaderName());
	}

	/**
	 * Test the filter non-default init parameters.
	 */
	@Test
	public void testInitParametersNonDefault() throws ServletException {
		FilterConfig filterConfig = mock(FilterConfig.class);
		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();

		when(filterConfig.getInitParameter(
				GenericCSRFStatelessFilter.CSRF_COOKIE_NAME_PARAMETER))
					.thenReturn("abc");
		when(filterConfig.getInitParameter(
				GenericCSRFStatelessFilter.CSRF_HEADER_NAME_PARAMETER))
					.thenReturn("123");
		filter.init(filterConfig);

		assertEquals("The init parameter is not the expected one",
				"abc", filter.getCsrfCookieName());
		assertEquals("The init parameter is not the expected one",
				"123", filter.getCsrfHeaderName());

	}



	/**
	 * Tests the creation of default hooks.
	 */
	@Test
	public void testHooksDefaultCreation() throws ServletException {

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();

		ResourceCheckerHook resourceCheckerHook = filter.createResourceCheckerHook();
		assertEquals("The instance of hook was different that "
				+ "was was expected.",
				DefaultResourceCheckerHookImpl.class,
				resourceCheckerHook.getClass());

		ResponseBuilderHook responseBuilder = filter.createResponseBuilderHook();
		assertEquals("The instance of hook was different that "
				+ "was was expected.",
				DefaultResponseBuilderHookImpl.class,
				responseBuilder.getClass());

	}

	/**
	 * Tests the creation of non default hooks using the {@link ServiceLoader}.
	 * For the tests purposes the {@link TokenBuilderHook} have a non default
	 * implementation.
	 */
	@Test
	public void testHooksNonDefaultCreation() throws ServletException {

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		TokenBuilderHook tokenHook = filter.createTokenBuilderHook();
		assertEquals("The instance of hook was different that "
					+ "was was expected.",
				TestTokenBuilderHookImpl.class,
				tokenHook.getClass());
	}

	/**
	 * Test that if in the case the resource should be CSRF protected and
	 * the CSRF header and the CSRF cookie value are the same, then
	 * a new CSRF cookie is added to the response.
	 *
	 */
	@Test
	public void testStatusCOOKIE_TOKEN_AND_HEADER_TOKEN_MATCH()
			throws ServletException, IOException {
		String initialCSRFToken = "someCSRFValue";

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should be CSRF protected
		when(request.getMethod()).thenReturn("POST");
		when(request.getHeader(any())).thenReturn(initialCSRFToken);

		when(request.getCookies()).thenReturn(
				new Cookie[]{
						new Cookie(filter.getCsrfCookieName(),
								initialCSRFToken)
						}
				);

	    HttpServletResponse response = mock(HttpServletResponse.class);

		filter.doFilter(request, response, chain);

		//capture the cookie argument
		ArgumentCaptor<Cookie> cookieArgument =
				ArgumentCaptor.forClass(Cookie.class);
		verify(response).addCookie(cookieArgument.capture());
		Cookie createdCookie = cookieArgument.getValue();

		//and check that a new cookie was added to the response.
		assertFalse(initialCSRFToken.equals(createdCookie.getValue()));
	}

	/**
	 * Test that if in the case the resource should be CSRF protected and
	 * the CSRF header is different than the CSRF cookie value then
	 * a security exception will be thrown with the message
	 * {@link CSRFStatus#COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH#getStatusMessage()}.
	 *
	 */
	@Test
	public void testStatusCOOKIE_TOKEN_AND_HEADER_TOKEN_MISSMATCH()
			throws ServletException, IOException {

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should be CSRF protected
		when(request.getMethod()).thenReturn("POST");
		when(request.getHeader(any())).thenReturn("someHeaderValue");
		when(request.getCookies()).thenReturn(
				new Cookie[]{
						new Cookie(
								filter.getCsrfCookieName(),
								"someOtherValue")
						}
				);

	    HttpServletResponse response = mock(HttpServletResponse.class);


		filter.init(fc);

		try {
			filter.doFilter(request, response, chain);
		} catch (SecurityException ex) {
			assertTrue("The filter execution should throw security exception "
						+ "because the CSRF cookie and CSRF header are different",
					CSRFStatus.COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH.getStatusMessage()
						.equals(ex.getMessage()));
		}
	}

	/**
	 * Check that if there is no CSRF cookie attached to the request then
	 * the {@link CSRFStatus} will be
	 * {@value CSRFStatus#COOKIE_NOT_PRESENT}.
	 */
	@Test
	public void testStatusCSRF_COOKIE_NOT_PRESENT()
			throws ServletException, IOException {

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should be CSRF protected
		when(request.getMethod()).thenReturn("POST");
		when(request.getHeader(any())).thenReturn("someHeaderValue");

		HttpServletResponse response = mock(HttpServletResponse.class);

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);

		try {
			filter.doFilter(request, response, chain);
		} catch (SecurityException ex) {
			assertTrue("The filter execution should throw security exception "
						+ "because there is no CSRF cookie into the request",
						CSRFStatus.COOKIE_NOT_PRESENT.getStatusMessage()
						.equals(ex.getMessage()));
		}
	}

	/**
	 * Check that if there is no CSRF header attached to the request then
	 * the {@link CSRFStatus} will be
	 * {@value CSRFStatus#HEADER_TOKEN_NOT_PRESENT}.
	 */
	@Test
	public void testStatusCSRF_HEADER_NOT_PRESENT()
			throws ServletException, IOException {

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should be CSRF protected
		when(request.getMethod()).thenReturn("POST");
		HttpServletResponse response = mock(HttpServletResponse.class);

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);

		try {
			filter.doFilter(request, response, chain);
		} catch (SecurityException ex) {
			assertTrue("The filter execution should throw security exception "
						+ "because there is no CSRF header into the request",
						CSRFStatus.HEADER_TOKEN_NOT_PRESENT.getStatusMessage()
						.equals(ex.getMessage()));
		}
	}

	/**
	 * Test that when {@link RequestCheckerHook#shouldAddCSRFCookieToResponse(ExecutionContext)}
	 * answers true, a new CSRF cookie is added to the response.
	 */
	@Test
	public void testShouldAddCSRFCookieToResponse()
			throws ServletException, IOException {

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should be CSRF protected
		when(request.getMethod()).thenReturn("POST");
		HttpServletResponse response = mock(HttpServletResponse.class);


		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);
		filter.doFilter(request, response, chain);

		//capture the cookie argument
		ArgumentCaptor<Cookie> cookieArgument =
				ArgumentCaptor.forClass(Cookie.class);
		verify(response).addCookie(cookieArgument.capture());
		Cookie createdCookie = cookieArgument.getValue();

		assertEquals("A cookie with the name "
				+ filter.getCsrfCookieName()
				+ " should be present on the response",
				filter.getCsrfCookieName() ,
				createdCookie.getName());

		assertNotNull("The value of cookie "
				+ filter.getCsrfCookieName()
				+ " should not be empty",
				createdCookie.getValue());
	}


	/**
	 * Check that for a GET request, there is no cookie added to the response;
	 * the {@link ResourceCheckerHook#mustBeCSRFSProtected(ExecutionContext)}
	 * will return false.
	 *
	 */
	@Test
	public void testShouldBeCSRFSProtected()
			throws ServletException, IOException {

		FilterConfig fc = mock(FilterConfig.class);
		FilterChain chain = mock(FilterChain.class);

		HttpServletRequest request = mock(HttpServletRequest.class);
		//this will say to the DefaultResourceCheckerHookImpl that the request
		//should NOT be CSRF protected
		when(request.getMethod()).thenReturn("GET");
		HttpServletResponse response = mock(HttpServletResponse.class);

		GenericCSRFStatelessFilter filter = new GenericCSRFStatelessFilter();
		filter.init(fc);
		filter.doFilter(request, response, chain);

		verify(response, times(1)).addCookie(any());
	}
}
