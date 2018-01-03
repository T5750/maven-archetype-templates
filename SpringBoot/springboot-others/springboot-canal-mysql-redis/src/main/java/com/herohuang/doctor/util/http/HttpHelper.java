package com.herohuang.doctor.util.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpHelper {
	private static final HttpHelper instance = new HttpHelper();

	public static HttpHelper getInstance() {
		return instance;
	}

	private HttpHelper() {
	}

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final RequestConfig defaultRequestConfig = RequestConfig.custom()
			.setSocketTimeout(30000).setConnectTimeout(30000)
			.setConnectionRequestTimeout(30000).build();

	public HttpResult get(String uri) {
		return get(uri, null);
	}

	public HttpResult get(String uri, Map<String, String> headers) {
		return get(uri, headers, null);
	}

	public HttpResult get(String uri, Map<String, String> headers,
			Map<String, Object> parameters) {
		if (uri == null || uri.isEmpty()) {
			throw new IllegalArgumentException("uri is required");
		}
		RequestBuilder requestBuilder = RequestBuilder.get();
		requestBuilder.setUri(uri);
		if (parameters != null && !parameters.isEmpty()) {
			for (final String key : parameters.keySet()) {
				if (parameters.get(key) != null) {
					requestBuilder.addParameter(key,
							String.valueOf(parameters.get(key)));
				}
			}
		}
		requestBuilder.setConfig(defaultRequestConfig);
		if (headers != null && !headers.isEmpty()) {
			for (final String key : headers.keySet()) {
				requestBuilder.addHeader(key, headers.get(key));
			}
		}
		return parseRequest(HttpPool.getClient(), requestBuilder.build());
	}

	public HttpResult post(String uri) {
		return post(uri, null, null, null);
	}

	public HttpResult post(String uri, Map<String, Object> parameters) {
		return post(uri, null, parameters, null);
	}

	public HttpResult post(String uri, byte[] body) {
		return post(uri, null, null, body);
	}

	public HttpResult post(String uri, Map<String, Object> parameters,
			byte[] body) {
		return post(uri, null, parameters, body);
	}

	public HttpResult post(String uri, Map<String, String> headers,
			Map<String, Object> parameters, byte[] body) {
		if (uri == null || uri.isEmpty()) {
			throw new IllegalArgumentException("uri is required");
		}
		final RequestBuilder requestBuilder = RequestBuilder.post();
		requestBuilder.setUri(uri);
		// Populate request parameters
		if (parameters != null && !parameters.isEmpty()) {
			for (final String key : parameters.keySet()) {
				if (parameters.get(key) != null) {
					requestBuilder.addParameter(key,
							String.valueOf(parameters.get(key)));
				}
			}
		}
		// Populate request body
		if (body != null) {
			requestBuilder.setEntity(new ByteArrayEntity(body));
		}
		// Request configuration can be overridden at the request level.
		// They will take precedence over the one set at the client level.
		requestBuilder.setConfig(defaultRequestConfig);
		// Set custom header
		if (headers != null && !headers.isEmpty()) {
			for (final String key : headers.keySet()) {
				requestBuilder.addHeader(key, headers.get(key));
			}
		}
		return parseRequest(HttpPool.getClient(), requestBuilder.build());
	}

	// --------------------------- Start: PUT Manual---------------------------
	public HttpResult put(String uri) {
		return put(uri, null, null, null);
	}

	public HttpResult put(String uri, Map<String, Object> parameters) {
		return put(uri, null, parameters, null);
	}

	public HttpResult put(String uri, byte[] body) {
		return put(uri, null, null, body);
	}

	public HttpResult put(String uri, Map<String, Object> parameters,
			byte[] body) {
		return put(uri, null, parameters, body);
	}

	public HttpResult put(String uri, Map<String, String> headers,
			Map<String, Object> parameters, byte[] body) {
		if (uri == null || uri.isEmpty()) {
			throw new IllegalArgumentException("uri is required");
		}
		final RequestBuilder requestBuilder = RequestBuilder.put();
		requestBuilder.setUri(uri);
		// Populate request parameters
		if (parameters != null && !parameters.isEmpty()) {
			for (final String key : parameters.keySet()) {
				if (parameters.get(key) != null) {
					requestBuilder.addParameter(key,
							String.valueOf(parameters.get(key)));
				}
			}
		}
		// Populate request body
		if (body != null) {
			requestBuilder.setEntity(new ByteArrayEntity(body));
		}
		// Request configuration can be overridden at the request level.
		// They will take precedence over the one set at the client level.
		requestBuilder.setConfig(defaultRequestConfig);
		// Set custom header
		if (headers != null && !headers.isEmpty()) {
			for (final String key : headers.keySet()) {
				requestBuilder.addHeader(key, headers.get(key));
			}
		}
		return parseRequest(HttpPool.getClient(), requestBuilder.build());
	}

	// --------------------------- End: PUT Manual ---------------------------
	// --------------------------- Start: DELETE Manual
	// ---------------------------
	public HttpResult delete(String uri) {
		return delete(uri, null);
	}

	public HttpResult delete(String uri, Map<String, String> headers) {
		return delete(uri, headers, null);
	}

	public HttpResult delete(String uri, Map<String, String> headers,
			Map<String, Object> parameters) {
		if (uri == null || uri.isEmpty()) {
			throw new IllegalArgumentException("uri is required");
		}
		RequestBuilder requestBuilder = RequestBuilder.delete();
		requestBuilder.setUri(uri);
		if (parameters != null && !parameters.isEmpty()) {
			for (final String key : parameters.keySet()) {
				if (parameters.get(key) != null) {
					requestBuilder.addParameter(key,
							String.valueOf(parameters.get(key)));
				}
			}
		}
		requestBuilder.setConfig(defaultRequestConfig);
		if (headers != null && !headers.isEmpty()) {
			for (final String key : headers.keySet()) {
				requestBuilder.addHeader(key, headers.get(key));
			}
		}
		return parseRequest(HttpPool.getClient(), requestBuilder.build());
	}

	// --------------------------- Start: DELETE Manual
	// ---------------------------
	/**
	 * Check status of the given resource.
	 * 
	 * @param uri
	 *            the uri of the resource
	 * @return the status of the resource
	 */
	public HttpResult head(String uri) {
		if (uri == null || uri.isEmpty()) {
			throw new IllegalArgumentException("uri is required");
		}
		final RequestBuilder requestBuilder = RequestBuilder.head();
		requestBuilder.setUri(uri);
		return parseRequest(HttpPool.getClient(), requestBuilder.build());
	}

	private HttpResult parseRequest(CloseableHttpClient httpClient,
			HttpUriRequest request) {
		logger.debug("Executing request " + request.getURI());
		try {
			final CloseableHttpResponse response = httpClient.execute(request);
			ProtocolVersion protocolVersion = response.getProtocolVersion();
			int code = response.getStatusLine().getStatusCode();
			String reasonPhrase = response.getStatusLine().getReasonPhrase();
			final HttpResult result = new HttpResult(protocolVersion, code,
					reasonPhrase);
			logger.trace("----------------------------------------");
			logger.trace("{}", response.getStatusLine());
			populate(response, result); // 将报文内容加入到result中
			logger.trace("----------------------------------------");
			response.close();
			return result;
		} catch (final ClientProtocolException ex) {
			logger.error(
					"Unexpected Protocol error occurs while executing request {}",
					request.getURI(), ex);
		} catch (final IOException ex) {
			logger.error(
					"Unexpected I/O error occurs while executing request {}",
					request.getURI(), ex);
		}
		return null;
	}

	private void populate(final CloseableHttpResponse response,
			final HttpResult result) throws IOException {
		Header[] headers = response.getAllHeaders();
		if (headers != null && headers.length > 0) {
			for (Header header : headers) {
				result.addHeader(header.getName(), header.getValue());
			}
		}
		final HttpEntity entity = response.getEntity();
		if (entity != null) {
			logger.trace("Response Content-Length: {}",
					entity.getContentLength());
			final ContentType contentType = ContentType.get(entity);
			if (contentType != null) {
				result.setContentType(contentType.getMimeType());
				Charset charset = contentType.getCharset();
				if (charset == null) {
					charset = HTTP.DEF_CONTENT_CHARSET;
				}
				result.setCharset(charset);
			}
			result.setContentLength(entity.getContentLength());
			result.setResponseBody(EntityUtils.toByteArray(entity));
			EntityUtils.consume(entity);// 保证内容完全被消费掉，如果流存在则会被close
		}
	}
}
