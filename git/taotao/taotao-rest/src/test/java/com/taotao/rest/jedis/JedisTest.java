package com.taotao.rest.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	
	@Test
	public void testJedisPool()
	{
		/*JedisPool pool = new JedisPool("192.168.111.128",6379);
		Jedis jedis = pool.getResource();
		jedis.set("key1", "test");
		String key = jedis.get("key1");
		System.out.println(key);
		jedis.close();
		pool.close();*/
		JedisPool pool = new JedisPool("192.168.111.128",6379);
		Jedis jedis = pool.getResource();
		String key = jedis.hget("INDEX_CONTENT_REDIS_KEY","89");
		System.out.println(key);
		jedis.close();
		pool.close();
	}
	
	
	@Test
	public void testJedisCluster()
	{
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.111.128", 7001));
		nodes.add(new HostAndPort("192.168.111.128", 7002));
		nodes.add(new HostAndPort("192.168.111.128", 7003));
		nodes.add(new HostAndPort("192.168.111.128", 7004));
		nodes.add(new HostAndPort("192.168.111.128", 7005));
		nodes.add(new HostAndPort("192.168.111.128", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("key", "test");
		String str = jedisCluster.get("key");
		System.out.println(str);
		jedisCluster.close();
		
	}
	
	@Test
	public void testSpringJedisPool()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool = (JedisPool)applicationContext.getBean("redisClient");
		Jedis redis = pool.getResource();
		String string = redis.get("key1");
		System.out.println(string);
		redis.close();
		pool.close();
	}
	
	@Test
	public void testSpringJedisCluster()
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster jedisCluster = (JedisCluster)applicationContext.getBean("redisClient");
		String string = jedisCluster.get("key");
		System.out.println(string);
		jedisCluster.close();
	}

}
