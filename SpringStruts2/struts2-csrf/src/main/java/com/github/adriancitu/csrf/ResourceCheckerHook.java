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

import java.io.Closeable;

/**
 * Hook that will be used to decide if a resource should be protected against
 * CSRF attacks. Each method have as parameter an {@link ExecutionContext}; the
 * active resource can be retrieved from the active http request that can be
 * retrieved using {@link ExecutionContext#getHttpRequest()}.
 * 
 * The implementations should be thread safe because only one instance by CSRF
 * filter instance will be created.
 * 
 * @author Adrian CITU
 */
public interface ResourceCheckerHook extends Closeable {

	/**
	 * @param executionContext the execution context
	 * @return {@link ResourceStatus#MUST_NOT_BE_PROTECTED} if the resource
	 * should not be CSRF protected, {@link ResourceStatus#MUST_BE_PROTECTED_BUT_NO_COOKIE_ATTACHED}
	 * if the resource should be CSRF protected but there is no CSRF cookie presented
	 * in the http request (usually it happens when the resource is accessed the first time),
	 * {@link ResourceStatus#MUST_BE_PROTECTED_AND_COOKIE_ATTACHED} if the resource
	 * should be CSRF protected and a CSRF cookie is present in the http request. 
	 * 
	 */
	ResourceStatus checkResourceStatus(ExecutionContext executionContext);
}
