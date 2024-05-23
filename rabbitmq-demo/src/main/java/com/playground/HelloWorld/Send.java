package com.playground.HelloWorld;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.lang.Exception;

public class Send {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
      System.out.println("Init Rabbit MQ demo");

      ConnectionFactory factory = new ConnectionFactory();
      factory.setHost("localhost");

      try (Connection connection = factory.newConnection();
           Channel channel = connection.createChannel()
      ) {
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello, World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
      }
    }
}