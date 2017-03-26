package redis;


import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestMain {
	
	private String aaa;
	private int bbb;
	private TestMain tm;
	
	
	public static void main(String[] args) {
//		JedisPool
		JedisPoolConfig c ;
		JedisConnectionFactory f;
		Jedis jedis = new Jedis("localhost");
		boolean flag = jedis.exists("foo");
		System.out.println(flag);
		String foo = jedis.get("useridd");
		System.out.println(foo);
		jedis.close();
	}
}
