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

import javax.servlet.ServletResponse;
import java.io.Closeable;


/**
 * Hook that will be used to make actions based and on http response.
 * 
 * Each method have as parameter an {@link ExecutionContext}; the 
 * active http response can be retrieved using 
 * {@link ExecutionContext#getHttpResponse()}.
 * 
 * The implementations should be thread safe because only one instance
 * by CSRF filter instance will be created by (CSRF) filter instance.
 * 
 * @author Adrian CITU
 *
 */
public interface ResponseBuilderHook extends Closeable {
	
	/**
	 * Modify if needed the httpResponse 
	 * (that can be found in the <code>executionParameter</code>)
	 * parameter using {@link ExecutionContext#getHttpResponse()} depending
	 * on the CSRFCheckStatus.
	 *  
	 * @param executionContext the execution context.
	 * @param status the status of the CSRF check of the request.
	 */
	ServletResponse buildResponse(ExecutionContext executionContext, CSRFStatus status);
}
