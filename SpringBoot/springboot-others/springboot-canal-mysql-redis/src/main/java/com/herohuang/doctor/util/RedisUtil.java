package com.herohuang.doctor.util;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by herohuang on 19/04/2017.
 */
public class RedisUtil {
	// Redis服务器IP
	private static String HOST = "localhost";
	// Redis的端口号
	private static int PORT = 6379;
	// 访问密码
	private static String PASS = null;
	// 可用连接实例的最大数目
	private static int MAX_ACTIVE = 1024;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例
	private static int MAX_IDLE = 200;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时
	private static int MAX_WAIT = 10000;
	// 过期时间
	protected static int expireTime = 660 * 660 * 24;
	// 连接池
	protected static JedisPool pool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数
		config.setMaxTotal(MAX_ACTIVE);
		// 最多空闲实例
		config.setMaxIdle(MAX_IDLE);
		// 超时时间
		config.setMaxWaitMillis(MAX_WAIT);
		//
		config.setTestOnBorrow(false);
		// pool = new JedisPool(config, ADDR, PORT, 1000);
		pool = new JedisPool(config, HOST, PORT, 1000, PASS);
	}

	protected static synchronized Jedis getJedis() {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
		return jedis;
	}

	protected static void closeResource(Jedis jedis, boolean isBroken) {
		try {
			if (isBroken) {
				pool.returnBrokenResource(jedis);
			} else {
				pool.returnResource(jedis);
			}
		} catch (Exception e) {
		}
	}

	public static void delKey(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(0);
			jedis.del(key);
			// delete com.xxx.*
			if (key.endsWith("*")) {
				Set<String> set = jedis.keys(key);
				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					String keyStr = it.next();
					jedis.del(keyStr);
				}
			}
		} catch (Exception e) {
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
	}
}
