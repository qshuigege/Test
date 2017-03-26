package cn.net.fusen.ssm.test;

import org.apache.commons.httpclient.HttpClient;
import org.springframework.data.redis.cache.RedisCacheManager;


public class Test { 
	
	public static void main(String[] args) {
		if("Aaa".equalsIgnoreCase("aAA")){
			System.out.println("yeah");
		}else {
			System.out.println("no");
		}
	}
}
