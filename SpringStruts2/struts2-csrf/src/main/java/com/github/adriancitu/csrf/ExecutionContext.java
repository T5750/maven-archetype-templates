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

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * Class containing the execution context.
 * A new instance of this class will be instantiated for each execution
 * of {@link Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, FilterChain)}
 * method.
 * Each instance of execution context will contain the following objects:
 * <ul>
 *  <li> the original http request; {@link ExecutionContext#getHttpRequest()}  </li>
 *  <li> the original http response; {@link ExecutionContext#getHttpResponse()} </li>
 *  <li> the original filter chain; {@link ExecutionContext#geFilterChain()} </li>
 *  <li> the original CSRF Cookie (this is a Java8 Optional);{@link ExecutionContext#getCsrfCookies()}  </li>
 *  <li> the name of the CSRF Cookie; {@link ExecutionContext#getCsrfCookieName()} </li>
 *  <li> the name of the CSRF header; {@link ExecutionContext#getCsrfHeaderName()} </li>
 *  <li> an instance of {@link TokenBuilderHook}; {@link ExecutionContext#getTokenBuilderHook()} </li>
 *  <li> an instance of {@link ResourceCheckerHook}; {@link ExecutionContext#getResourceCheckerHook()} </li>
 *  <li> an instance of {@link ResponseBuilderHook}; {@link ExecutionContext#getResponseBuilderHook()} </li>
 * </ul> 
 * @author Adrian CITU
 *
 */
public final class ExecutionContext {

	private final ResourceCheckerHook resourceChecker;
	private final ResponseBuilderHook responseBuilder;
	private final TokenBuilderHook tokenBuilder;
	private final HttpServletRequest httpRequest;
	private final HttpServletResponse httpResponse;
	private final FilterChain chain;
	private final List<Cookie> csrfCookies;
	private final String csrfCookieName;
	private final String csrfHeaderName;
	
	public ExecutionContext(final ResourceCheckerHook resourceChecker, 
			final ResponseBuilderHook responseBuilder,
			final TokenBuilderHook tokenBuilder, 
			final HttpServletRequest httpRequest,
			final HttpServletResponse httpResponse, 
			final FilterChain chain,
			final String csrfCookieName, 
			final String csrfHeaderName) {
		this.resourceChecker = resourceChecker;
		this.responseBuilder = responseBuilder;
		this.tokenBuilder = tokenBuilder;
		this.httpRequest = httpRequest;
		this.httpResponse = httpResponse;
		this.chain = chain;
		this.csrfCookieName = csrfCookieName;
		this.csrfHeaderName = csrfHeaderName;
		this.csrfCookies = Util.getCookiesByName(httpRequest, csrfCookieName);
	}

	public String getCsrfCookieName() {
		return csrfCookieName;
	}

	public String getCsrfHeaderName() {
		return csrfHeaderName;
	}

	public ResourceCheckerHook getResourceCheckerHook() {
		return resourceChecker;
	}

	public ResponseBuilderHook getResponseBuilderHook() {
		return responseBuilder;
	}

	public TokenBuilderHook getTokenBuilderHook() {
		return tokenBuilder;
	}

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public HttpServletResponse getHttpResponse() {
		return httpResponse;
	}

	public FilterChain geFilterChain() {
		return chain;
	}

	public List<Cookie> getCsrfCookies() {
		return csrfCookies;
	}
	
	
}
