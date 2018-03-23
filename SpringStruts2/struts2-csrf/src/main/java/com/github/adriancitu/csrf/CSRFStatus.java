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


/** 
 * Enumeration representing possible statuses of the cross site scripting 
 * checking.
 * 
 * @author Adrian CITU
 *
 */
public enum CSRFStatus {
	COOKIE_NOT_PRESENT("There is no CSRF cookie in the request but it "
			+ " should be . This it looks like a technical problem on our side."
			+ "Check how (and if) the cookie is created and added to the response."), 
	HEADER_TOKEN_NOT_PRESENT(
			"There is no CSRF header in the "
			+ "request but it should be. This looks like a CSRF attack."), 
	COOKIE_TOKEN_AND_HEADER_TOKEN_MISMATCH(
			"There is a difference between token stored in cookie "
			+ "and the token stored in header."), 
	COOKIE_TOKEN_AND_HEADER_TOKEN_MATCH("CSRF header and cookie are mathing.");
	
	private final String statusMessage;
	
	CSRFStatus(String statusMessage) {
		this.statusMessage = statusMessage;
		
	}

	public String getStatusMessage() {
		return statusMessage;
	}

}
