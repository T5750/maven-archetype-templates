/**
 * MIT License
 * <p>
 * Copyright (c) 2016 Adrian CITU
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.adriancitu.csrf.defaultimpl;

import com.github.adriancitu.csrf.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.List;


/**
 * Default implementation of {@link ResponseBuilderHook}.
 * @author Adrian CITU
 *
 */
public final class DefaultResponseBuilderHookImpl implements ResponseBuilderHook {

    /**
     * If the {@link CSRFStatus} is {@link CSRFStatus#COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH}
     * then replace the actual CSRF Cookie with a new one using the {@link TokenBuilderHook}
     * taken from the {@link ExecutionContext}.
     * In all the other cases a {@link SecurityException} will be thrown.
     *
     * @param executionContext the execution context.
     * @param status the status of the CSRF check of the request.
     */
    @Override
    public ServletResponse buildResponse(final ExecutionContext executionContext,
                                         final CSRFStatus status) {

        switch (status) {
            case COOKIE_NOT_PRESENT:
            case HEADER_TOKEN_NOT_PRESENT:
            case COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH:
                throw new SecurityException(status.getStatusMessage());
            case COOKIE_TOKEN_AND_HEADER_TOKEN_MATCH:
                replaceCSRFCokkieToResponse(executionContext);
                return executionContext.getHttpResponse();
            default:
                return  executionContext.getHttpResponse();
        }
    }

    private void replaceCSRFCokkieToResponse(final ExecutionContext executionContext) {

        final List<Cookie> oldCookies = executionContext.getCsrfCookies();
        oldCookies.forEach(cookie -> {
            cookie.setMaxAge(0);
            cookie.setValue(null);
        });

        Util.createNewCsrfCookieAndAddItToResponse(executionContext);
    }

    @Override
    public void close() throws IOException {
        return;
    }
}
