package com.vinaypal.kafka.oneToOne;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "demoqueue", groupId = "test")
    public void listenGroupTest(String message) {
        System.out.println("KafkaConsumerOneToOne listenGroupTest Message in group test: " + message);
    }

    @KafkaListener(topics = "demoqueue", groupId = "test")
    public void listenGroupTest1(String message) {
        System.out.println("KafkaConsumerOneToOne listenGroupTest1 Message in group test: " + message);
    }
}
