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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Adrian CITU
 *
 */
public final class Util {
	public static final String GET_HTTP_METHOD = "GET";
	
	private Util() {
	}

    /**
     *
     * @param req the http request
     * @param cookieName the cookie name
     * @return Retrieve a {@link List} of cookies having the name specified.
     */
	public static List<Cookie> getCookiesByName(
			final HttpServletRequest req, final String cookieName) {
        if (req.getCookies() == null ||  req.getCookies().length == 0) {
            return Collections.emptyList();
        }
		return Arrays.stream(req.getCookies())
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .collect(Collectors.toList());
	}

	/**
	 * Create a secured cookie using as name the {@link ExecutionContext#csrfCookieName}
	 * and as content the token generated using the {@link ExecutionContext#getTokenBuilderHook()}.
	 *
	 * @param ec the execution context to use
	 */
	public static void createNewCsrfCookieAndAddItToResponse (ExecutionContext ec) {
		final Cookie newCookie = new Cookie(
				ec.getCsrfCookieName(),
				ec.getTokenBuilderHook().buildToken(ec));
		newCookie.setSecure(true);
		ec.getHttpResponse().addCookie(newCookie);

	}
}
