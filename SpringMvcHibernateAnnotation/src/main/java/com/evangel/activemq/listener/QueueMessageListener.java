package com.evangel.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener implements MessageListener {
	// 当收到消息后，自动调用该方法
	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			if (null != tm) {
				System.out.println(
						"QueueMessageListener监听到了文本消息：\t" + tm.getText());
			} else {
				System.out.println("QueueMessageListener监听到了文本消息：\t null");
			}
			// do something ...
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}