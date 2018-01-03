package com.herohuang.doctor.util.http;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.ProtocolVersion;

public class HttpResult implements Serializable {
	private ProtocolVersion protocolVersion;
	private int statusCode;
	private String reasonPhrase;
	private Map<String, String> headers = new LinkedHashMap<String, String>();
	private byte[] responseBody;
	private String contentType;
	private long contentLength = -1;
	private Charset charset = Charset.forName("UTF-8");

	public HttpResult(ProtocolVersion protocolVersion, int statusCode,
			String reasonPhrase) {
		this.protocolVersion = protocolVersion;
		this.statusCode = statusCode;
		this.reasonPhrase = reasonPhrase;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public byte[] getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public ProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(ProtocolVersion protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getResponseBodyAsString() {
		if (responseBody == null) {
			return null;
		}
		if (charset != null) {
			return new String(responseBody, charset);
		} else {
			return new String(responseBody);
		}
	}

	@Override
	public String toString() {
		String resultStr = "statusCode=" + statusCode + ",protocolVersion="
				+ protocolVersion + ",reasonPhrase=" + reasonPhrase
				+ ",contentType=" + contentType + ", headers=" + headers
				+ ",contentLength=" + contentLength;
		if (contentLength < 2048) {
			resultStr += ", responseBody=" + getResponseBodyAsString();
		}
		return resultStr;
	}
}
