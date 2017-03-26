package rocketmq;

import java.util.List;
import java.util.Scanner;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class ConsumerTest {
	public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		DefaultMQPushConsumer c = new DefaultMQPushConsumer("ConsumerGroupName");
		c.setNamesrvAddr("localhost:9876");
		c.setInstanceName("Consumer");
		
		//订阅指定topic下tags分别等于test_tags1和test_tags2
		//c.subscribe("test_topic1", "test_tags1 || test_tags2");
		
		//订阅test_topic1下的所有消息
		c.subscribe("test_topic1", "*");
		
		c.registerMessageListener(new MessageListenerConcurrently() {
			
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
					ConsumeConcurrentlyContext context) {
				
				MessageExt msg = msgs.get(0);
				if ("test_topic1".equals(msg.getTopic())) {
					System.out.println("test_topic1");
					if (msg.getTags()!=null&&"test_tags1".equals(msg.getTags())) {
						System.out.println("test_topic1--test_tags1");
					}else if(msg.getTags()!=null&&"test_tags2".equals(msg.getTags())){
						System.out.println("test_topic1--test_tags2");
					}
				}else if ("test_topic2".equals(msg.getTopic())) {
					System.out.println("test_topic2");
				}
				
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		
		c.start();
		System.out.println("Consumer已启动");
		
		Scanner s = new Scanner(System.in);
		System.out.println(s.nextLine());
		s.close();
	}
}
