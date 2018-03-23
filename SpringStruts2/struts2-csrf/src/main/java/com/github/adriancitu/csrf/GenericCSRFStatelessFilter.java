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
import com.github.adriancitu.csrf.defaultimpl.DefaultTokenBuilderHookImpl;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ServiceLoader;


/**
 * Filter that implements the csrf double submit cookie pattern as explained in
 * @see <h href="https://www.owasp.org/index.php/Cross-Site_Request_Forgery_%28CSRF%29_Prevention_Cheat_Sheet#Double_Submit_Cookie">OWASP CSRF CheatSheet</a>
 * 
 * @author Adrian CITU
 *
 */
public class GenericCSRFStatelessFilter implements Filter {
	
	private static final Logger LOG =
			Logger.getLogger(GenericCSRFStatelessFilter.class);

	//not private only for testing purposes.
	static final String CSRF_HEADER_NAME_PARAMETER = "csrfHeaderName";
	static final String CSRF_COOKIE_NAME_PARAMETER = "csrfCookieName";
	
	private TokenBuilderHook tokenBuilder;
	private ResourceCheckerHook resourceChecker;
	private ResponseBuilderHook responseBuilder;
	
	
	private String csrfHeaderName = "XSRF-TOKEN";
	private String csrfCookieName = "X-XSRF-TOKEN";

	/**
	 * Instantiate the different hooks:
	 * {@link TokenBuilderHook}, {@link ResourceCheckerHook}, 
	 * {@link ResponseBuilderHook} and initialize the values of the 
	 * {@link GenericCSRFStatelessFilter#csrfCookieName} and
	 * {@link GenericCSRFStatelessFilter#csrfHeaderName} from the
	 * configuration file (web.xml).
	 */
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		tokenBuilder = createTokenBuilderHook();
		resourceChecker = createResourceCheckerHook();
		responseBuilder = createResponseBuilderHook();

		csrfCookieName =
				filterConfig.getInitParameter(CSRF_COOKIE_NAME_PARAMETER) != null ? 
						filterConfig.getInitParameter(CSRF_COOKIE_NAME_PARAMETER) 
						: "XSRF-TOKEN";

		csrfHeaderName =
				filterConfig.getInitParameter(CSRF_HEADER_NAME_PARAMETER) != null ? 
						filterConfig.getInitParameter(CSRF_HEADER_NAME_PARAMETER) 
						: "X-XSRF-TOKEN";				
	}

	/**
	 * Create instance of {@link ResourceCheckerHook} using the {@link ServiceLoader}
	 * loading facility or return the {@link DefaultResourceCheckerHookImpl}
	 * if no {@link ResourceCheckerHook} implementation found on classpath.
	 * 
	 * @return instance of {@link ResourceCheckerHook}
	 */
	final ResourceCheckerHook createResourceCheckerHook() {
		for (final ResourceCheckerHook mnge : ServiceLoader
				.load(ResourceCheckerHook.class)) {
			return mnge;
		}
		return new DefaultResourceCheckerHookImpl();
	}
	
	/**
	 * Create instance of {@link TokenBuilderHook} using the {@link ServiceLoader}
	 * loading facility or return the {@link DefaultTokenBuilderHookImpl}
	 * if no {@link ResourceCheckerHook} implementation found on classpath.
	 * 
	 * @return instance of {@link TokenBuilderHook}
	 */
	final TokenBuilderHook createTokenBuilderHook() {
		for (final TokenBuilderHook mnge : ServiceLoader
				.load(TokenBuilderHook.class)) {
			return mnge;
		}
		return new DefaultTokenBuilderHookImpl();
	}

	/**
	 * Create instance of {@link ResponseBuilderHook} using the {@link ServiceLoader}
	 * loading facility or return the {@link DefaultResponseBuilderHookImpl}
	 * if no {@link ResourceCheckerHook} implementation found on classpath.
	 * 
	 * @return instance of {@link ResponseBuilderHook}
	 */
	final ResponseBuilderHook createResponseBuilderHook() {
		for (final ResponseBuilderHook mnge : ServiceLoader
				.load(ResponseBuilderHook.class)) {
			return mnge;
		}
		return new DefaultResponseBuilderHookImpl();
	}
	
	/**
	 * For each request:
	 * <li>
	 *     <ul>
	 *         create an {@link ExecutionContext}
	 *     </ul>
	 *     <ul>
	 *         check the status of the requested http resource using {@link ResourceCheckerHook}
	 *     </ul>
     *     <ul>
     *         if the resource status is {@link ResourceStatus#MUST_NOT_BE_PROTECTED}
     *         or {@link ResourceStatus#MUST_BE_PROTECTED_BUT_NO_COOKIE_ATTACHED} then
     *         create a CSRF cookie having as token the token generates by {@link TokenBuilderHook}
     *     </ul>
     *     <ul>
     *         if the resource status is {@link ResourceStatus#MUST_BE_PROTECTED_AND_COOKIE_ATTACHED}
     *         then compute the {@link CSRFStatus} of the resource and then use the
     *         {@link ResponseBuilderHook} to return the response to the client.
     *     </ul>
	 * </li>
	 */
	@Override
	public void doFilter(
			final ServletRequest request, 
			final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {

            ServletResponse returnResponse = response;

			final ExecutionContext executionContext = new ExecutionContext(
					resourceChecker, 
					responseBuilder, 
					tokenBuilder, 
					(HttpServletRequest)request, 
					(HttpServletResponse)response, 
					chain,
					getCsrfCookieName(),
					getCsrfHeaderName());
			final ResourceStatus resourceStatus =
					resourceChecker.checkResourceStatus(executionContext);

			switch (resourceStatus) {
			case MUST_NOT_BE_PROTECTED:
			case MUST_BE_PROTECTED_BUT_NO_COOKIE_ATTACHED:
				Util.createNewCsrfCookieAndAddItToResponse(executionContext);
				break;
			case MUST_BE_PROTECTED_AND_COOKIE_ATTACHED:
				final CSRFStatus status = 
					computeCSRFStatus((HttpServletRequest)request);
                returnResponse = responseBuilder.buildResponse(executionContext, status);
				break;
			default:
				break;
			}
			
			chain.doFilter(request, returnResponse);
	}


	private CSRFStatus computeCSRFStatus(
			final HttpServletRequest httpRequest) {

		if (httpRequest.getHeader(getCsrfHeaderName()) == null) {
			return CSRFStatus.HEADER_TOKEN_NOT_PRESENT;
		}

		final List<Cookie> cookies = Util.getCookiesByName
				(httpRequest, getCsrfCookieName());

		if (cookies.isEmpty()) {
			return CSRFStatus.COOKIE_NOT_PRESENT;
		}

		if (cookies.stream()
				.anyMatch(cookie ->
						cookie.getValue() != null
								&& cookie.getValue()
								.equals(httpRequest.getHeader(getCsrfHeaderName())))){
			return CSRFStatus.COOKIE_TOKEN_AND_HEADER_TOKEN_MATCH;
		}

		return CSRFStatus.COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH;
	}

	
	@Override
	public void destroy() {
		try {
			tokenBuilder.close();
		} catch (final IOException e) {
			LOG.warn("Cannot close properly TokenBuilderHook instance.", e);
		}

		try {
			resourceChecker.close();
		} catch (final IOException e) {
			LOG.warn("Cannot close properly ResourceCheckerHook instance.", e);
		}
		try {
			responseBuilder.close();
		} catch (final IOException e) {
			LOG.warn("Cannot close properly ResponseBuilderHook instance.", e);
		}
	}

	String getCsrfHeaderName() {
		return csrfHeaderName;
	}

	String getCsrfCookieName() {
		return csrfCookieName;
	}
}
