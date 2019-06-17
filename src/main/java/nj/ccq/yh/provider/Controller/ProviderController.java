package nj.ccq.yh.provider.Controller;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  

* <p>Description: </p>  

* @author ZTY  

* @date 2019年6月17日  

*/
@RestController
public class ProviderController {
	//注入存放消息的队列，用于下列方法一
	@Autowired
	private Queue queue;
	
	@Autowired
	private Topic topic;
	
	//注入springboot封装的工具类
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	
	@RequestMapping("/send")
	public String send(String name) {
		
		 //方法一：添加消息到消息队列
		jmsTemplate.convertAndSend(queue, name);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsTemplate.convertAndSend("test", name);
		return name;
	}
	
	@GetMapping("/topicSend")
	public String topicSend(String name) {
		jmsTemplate.convertAndSend(topic, name);
		return name;
	}
	
}
