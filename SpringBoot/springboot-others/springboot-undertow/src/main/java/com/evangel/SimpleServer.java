package com.evangel;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class SimpleServer {
	public static void main(String[] args) {
		Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
				.setHandler(new HttpHandler() {
					public void handleRequest(HttpServerExchange exchange)
							throws Exception {
						exchange.getResponseHeaders().put(Headers.CONTENT_TYPE,
								"text/plain");
						exchange.getResponseSender().send("Hello ImportSource");
					}
				}).build();
		server.start();
	}
}
// http://localhost:8080/
