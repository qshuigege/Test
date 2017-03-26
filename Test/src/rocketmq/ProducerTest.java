package rocketmq;

import java.util.Scanner;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class ProducerTest {
	public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		final DefaultMQProducer p = new DefaultMQProducer("ProducerGroupName");
		p.setNamesrvAddr("localhost:9876");
		p.setInstanceName("Producer");
		p.start();
		int num = 0;
		while (!(num==999)) {
			Scanner s = new Scanner(System.in);
			num = s.nextInt();
			System.out.println("输入的数字是："+num);
			Message msg = new Message("test_topic1", "test_tags1", "test_keys1", "hello1".getBytes());
			SendResult result = p.send(msg);
			System.out.println("SendResult:"+result);
			
			
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				p.shutdown();
			}
		}));
		
		System.exit(0);
	}
}
