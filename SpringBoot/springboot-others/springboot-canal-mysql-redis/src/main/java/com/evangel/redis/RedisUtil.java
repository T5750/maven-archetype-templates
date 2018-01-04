package com.evangel.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	// Redis服务器IP
	private static String ADDR = "0.0.0.0";
	// Redis的端口号
	private static int PORT = 6379;
	// 访问密码
	// private static String AUTH = "admin";
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 1024;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;
	// 过期时间
	protected static int expireTime = 60 * 60 * 24;
	// 连接池
	protected static JedisPool pool;
	/** * 静态代码，只在初次调用一次 */
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
		pool = new JedisPool(config, ADDR, PORT, 1000);
	}

	/** * 获取jedis实例 */
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

	/** * 释放jedis资源 * @param jedis * @param isBroken */
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

	/** * 是否存在key * @param key */
	public static boolean existKey(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(0);
			return jedis.exists(key);
		} catch (Exception e) {
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
		return false;
	}

	/** * 删除key * @param key */
	public static void delKey(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(0);
			jedis.del(key);
		} catch (Exception e) {
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
	}

	/** * 取得key的值 * @param key */
	public static String stringGet(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		String lastVal = null;
		try {
			jedis = getJedis();
			jedis.select(0);
			lastVal = jedis.get(key);
			jedis.expire(key, expireTime);
		} catch (Exception e) {
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
		return lastVal;
	}

	/** * 添加string数据 * @param key * @param value */
	public static String stringSet(String key, String value) {
		Jedis jedis = null;
		boolean isBroken = false;
		String lastVal = null;
		try {
			jedis = getJedis();
			jedis.select(0);
			lastVal = jedis.set(key, value);
			jedis.expire(key, expireTime);
		} catch (Exception e) {
			e.printStackTrace();
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
		return lastVal;
	}

	/** * 添加hash数据 * @param key * @param field * @param value */
	public static void hashSet(String key, String field, String value) {
		boolean isBroken = false;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			if (jedis != null) {
				jedis.select(0);
				jedis.hset(key, field, value);
				jedis.expire(key, expireTime);
			}
		} catch (Exception e) {
			isBroken = true;
		} finally {
			closeResource(jedis, isBroken);
		}
	}
}