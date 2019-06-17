package nj.ccq.yh.provider.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**  

* <p>Description: </p>  

* @author ZTY  

* @date 2019年6月17日  

*/
@Configuration
public class BeanConfig {
	//定义存放消息的队列
	
	/**
	 * 点对点
	 * @return
	 */
	@Bean
	public Queue queue() {
		return  new ActiveMQQueue("ActiveMQQueue");
	}
	
	/**
	 * 发布、订阅
	 */
	@Bean
	public Topic topic() {
		return new ActiveMQTopic("zh-topic");
	}

	
}
