package com.plumblum.JMS;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Destination;


/**
 * @Auther: cpb
 * @Date: 2018/12/20 17:00
 * @Description:
 */
@Component("Produce")
public class Produce {

    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(String destinationName,final String message){
        Destination destination = new ActiveMQQueue(destinationName);
        jmsTemplate.convertAndSend(destination,message);
    }

}
