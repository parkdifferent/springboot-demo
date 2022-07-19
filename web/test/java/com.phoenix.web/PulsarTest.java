package com.phoenix.web;

import com.alibaba.fastjson.JSON;
import com.phoenix.web.controller.PayStrategy;
import com.phoenix.web.controller.PayStrategyEnum;
import com.phoenix.web.controller.StrategyFactory;
import org.apache.pulsar.client.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author tianfeng
 * @date 2022-01-13 15:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PulsarTest {

    @Test
    public void testMQP() {
        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://1.15.154.27:6650")
                    .build();

            Producer<byte[]> producer = client.newProducer()
                    .topic("my-topic")
                    .create();

            for (int i = 0; i < 50; i++) {
                // 然后你就可以发送消息到指定的broker 和topic上：
                producer.send("My message".getBytes());
            }


            System.out.println(JSON.toJSONString(client));

            System.out.println("success");
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMQC() throws PulsarClientException {

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://1.15.154.27:6650")
                .build();

        Consumer consumer = client.newConsumer()
                .topic("my-topic")
                .subscriptionName("my-subscription")
                .subscribe();

        while (true) {
            // Wait for a message
            Message msg = consumer.receive();

            try {
                // Do something with the message
                System.out.println("Message received: " + new String(msg.getData()));

                // Acknowledge the message so that it can be deleted by the message broker
                consumer.acknowledge(msg);
            } catch (Exception e) {
                // Message failed to process, redeliver later
                consumer.negativeAcknowledge(msg);
            }
        }

    }
}
