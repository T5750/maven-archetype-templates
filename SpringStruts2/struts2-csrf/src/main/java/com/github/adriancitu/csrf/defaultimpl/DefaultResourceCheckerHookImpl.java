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
package com.github.adriancitu.csrf.defaultimpl;

import com.github.adriancitu.csrf.ExecutionContext;
import com.github.adriancitu.csrf.ResourceCheckerHook;
import com.github.adriancitu.csrf.ResourceStatus;
import com.github.adriancitu.csrf.Util;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Default implementation of the {@link ResourceCheckerHook}.
 * 
 * @author Adrian CITU
 *
 */
public final class DefaultResourceCheckerHookImpl implements ResourceCheckerHook {

	private static final Logger LOG =
			Logger.getLogger(DefaultResourceCheckerHookImpl.class);
	private static final String RESSOURCE = "Ressource ";

	@Override
	public void close() throws IOException {
		//nothing to be done
	}

	/**
	 *
	 * @param executionContext the execution context
	 * @return  @{@link ResourceStatus#MUST_NOT_BE_PROTECTED} for any @{@link Util#GET_HTTP_METHOD},
	 * for all the other request types, it will return {@link ResourceStatus#MUST_BE_PROTECTED_AND_COOKIE_ATTACHED}
	 * if any CSRF cookie is present in the query, {@link ResourceStatus#MUST_BE_PROTECTED_BUT_NO_COOKIE_ATTACHED}
	 * otherwise.
	 */
	@Override
	public ResourceStatus checkResourceStatus(ExecutionContext executionContext) {
		final HttpServletRequest request = executionContext.getHttpRequest();
		
		if(Util.GET_HTTP_METHOD.equals(request.getMethod())) {
			if(LOG.isInfoEnabled()) {
				LOG.info(RESSOURCE + request.getPathInfo()
						+ " should NOT be CSRF protected");
			}
			return ResourceStatus.MUST_NOT_BE_PROTECTED;
		}

		if (!executionContext.getCsrfCookies().isEmpty()) {
			if(LOG.isInfoEnabled()) {
				LOG.info(RESSOURCE + request.getPathInfo()
						+ " should be CSRF protected and a check will be done");
			}
			return ResourceStatus.MUST_BE_PROTECTED_AND_COOKIE_ATTACHED;
		} else {
			if(LOG.isInfoEnabled()) {
				LOG.info(RESSOURCE + request.getPathInfo()
						+ " should be CSRF protected and a cookie will be added");
			}
			return ResourceStatus.MUST_BE_PROTECTED_BUT_NO_COOKIE_ATTACHED;
		}
	}

}
