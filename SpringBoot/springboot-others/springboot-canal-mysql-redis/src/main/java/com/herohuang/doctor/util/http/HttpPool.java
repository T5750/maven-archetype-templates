package com.herohuang.doctor.util.http;

import java.nio.charset.CodingErrorAction;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.Consts;
import org.apache.http.client.CookieStore;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HttpPool {
	private enum SingletonPool {
		Pool;
		private final PoolingHttpClientConnectionManager cm;
		private final ScheduledExecutorService schedluedES = Executors
				.newScheduledThreadPool(1);
		private final Logger logger = LoggerFactory.getLogger(getClass());

		private SingletonPool() {
			this.cm = init();
			// 定时把过期链接清除
			IdleConnectionMonitorThread monitor = new IdleConnectionMonitorThread(
					cm);
			schedluedES.scheduleAtFixedRate(monitor, 0, 5, TimeUnit.SECONDS);
			logger.info("{} init success", this);
		}

		/**
		 * 初始化连接配置
		 * 
		 * @return
		 */
		private PoolingHttpClientConnectionManager init() {
			final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(200);
			cm.setDefaultMaxPerRoute(20);
			final SocketConfig socketConfig = SocketConfig.custom()
					.setTcpNoDelay(true).build();
			cm.setDefaultSocketConfig(socketConfig);
			final MessageConstraints messageConstraints = MessageConstraints
					.custom().setMaxHeaderCount(200).setMaxLineLength(2000)
					.build();
			final ConnectionConfig connectionConfig = ConnectionConfig.custom()
					.setMalformedInputAction(CodingErrorAction.IGNORE)
					.setUnmappableInputAction(CodingErrorAction.IGNORE)
					.setCharset(Consts.UTF_8)
					.setMessageConstraints(messageConstraints).build();
			cm.setDefaultConnectionConfig(connectionConfig);
			return cm;
		}

		public CloseableHttpClient getHttpClient() {
			final CookieStore cookieStore = new BasicCookieStore();
			return HttpClients.custom().setConnectionManager(cm)
					.setDefaultCookieStore(cookieStore).build();
		}

		public void shutdown() {
			if (!schedluedES.isShutdown()) {
				schedluedES.shutdownNow();
			}
			cm.shutdown();
			logger.info("{} shutdown success", this);
		}
	}

	private static class IdleConnectionMonitorThread implements Runnable {
		private final Logger logger = LoggerFactory.getLogger(getClass());
		private final PoolingHttpClientConnectionManager cm;

		public IdleConnectionMonitorThread(PoolingHttpClientConnectionManager cm) {
			this.cm = cm;
		}

		public void run() {
			cm.closeExpiredConnections();
			cm.closeIdleConnections(30, TimeUnit.SECONDS);
			logger.trace("Status: {}", cm.getTotalStats());
		}
	}

	public static CloseableHttpClient getClient() {
		return SingletonPool.Pool.getHttpClient();
	}

	public static void shutdown() {
		SingletonPool.Pool.shutdown();
	}
}
