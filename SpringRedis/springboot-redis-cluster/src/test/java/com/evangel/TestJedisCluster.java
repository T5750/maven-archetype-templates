package com.evangel;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import redis.clients.jedis.JedisCluster;

import com.evangel.redis.MyRedisTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes = ClusterApplication.class)
@SpringBootTest(classes = ClusterApplication.class)
@WebAppConfiguration
public class TestJedisCluster {
	@Inject
	private JedisCluster jedisCluster;
	@Autowired
	private MyRedisTemplate myRedisTemplate;
	private final static String PREFIX = "test";

	@Test
	public void testJedis() {
		// redis.clients.jedis.exceptions.JedisConnectionException:
		// Could not get a resource from the pool
		// jedisCluster.set("test_jedis_cluster", "38967");
		myRedisTemplate.set(PREFIX, "test_jedis_cluster", "38967");
		// Assert.assertEquals("38967", jedisCluster.get("test_jedis_cluster"));
		Assert.assertEquals("38967",
				myRedisTemplate.get(PREFIX, "test_jedis_cluster"));
		// jedisCluster.del("test_jedis_cluster");
		myRedisTemplate.deleteWithPrefix(PREFIX, "test_jedis_cluster");
	}

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Test
	public void redisTest() {
		String key = "redisTestKey";
		String value = "I am test value";
		ValueOperations<String, String> opsForValue = redisTemplate
				.opsForValue();
		// 数据插入测试：
		opsForValue.set(key, value);
		String valueFromRedis = opsForValue.get(key);
		// logger.info("redis value after set: {}", valueFromRedis);
		assertThat(valueFromRedis, is(value));
		// 数据删除测试：
		redisTemplate.delete(key);
		valueFromRedis = opsForValue.get(key);
		// logger.info("redis value after delete: {}", valueFromRedis);
		assertThat(valueFromRedis, equalTo(null));
	}
}