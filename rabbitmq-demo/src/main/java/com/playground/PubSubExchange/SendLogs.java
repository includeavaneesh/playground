package com.playground.PubSubExchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendLogs {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
        System.out.println("Init Rabbit MQ demo");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()
        ) {
            String exchange = "logs";

            channel.exchangeDeclare(exchange, "fanout");

            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, exchange, "");

            String message = argv.length < 1 ? "info: Hello World!" : String.join(" ", argv);
            channel.basicPublish(exchange, QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent '" + message + "'");
        }
    }
}
