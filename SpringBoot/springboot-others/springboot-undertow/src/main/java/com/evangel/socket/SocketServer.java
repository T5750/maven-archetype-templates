package com.evangel.socket;

import static io.undertow.Handlers.*;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.websockets.core.AbstractReceiveListener;
import io.undertow.websockets.core.BufferedTextMessage;
import io.undertow.websockets.core.WebSocketChannel;
import io.undertow.websockets.core.WebSockets;

public class SocketServer {
	public static void main(String[] args) {
		Undertow server = Undertow
				.builder()
				.addHttpListener(8080, "localhost")
				.setHandler(
						path().addPrefixPath(
								"/importsourceApp",
								websocket((exchange, channel) -> {
									channel.getReceiveSetter().set(
											getListener());
									channel.resumeReceives();
								}))
								.addPrefixPath(
										"/",
										resource(
												new ClassPathResourceManager(
														SocketServer.class
																.getClassLoader(),
														SocketServer.class
																.getPackage()))
												.addWelcomeFiles("hello.html")))
				.build();
		server.start();
	}

	private static AbstractReceiveListener getListener() {
		return new AbstractReceiveListener() {
			@Override
			protected void onFullTextMessage(WebSocketChannel channel,
					BufferedTextMessage message) {
				final String messageData = message.getData();
				for (WebSocketChannel session : channel.getPeerConnections()) {
					WebSockets.sendText(messageData, session, null);
				}
			}
		};
	}
}
