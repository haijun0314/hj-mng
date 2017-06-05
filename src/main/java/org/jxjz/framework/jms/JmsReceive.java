package org.jxjz.framework.jms;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
 * JMS
 */
@Service
public class JmsReceive  implements MessageListener { 
	 

	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("ConsumerMessageListener收到了文本消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
}
