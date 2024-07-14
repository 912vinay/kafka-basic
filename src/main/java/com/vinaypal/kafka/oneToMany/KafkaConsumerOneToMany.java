package com.vinaypal.kafka.oneToMany;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerOneToMany {

    @KafkaListener(topics = "demoqueue", groupId = "test0")
    public void listenGroupFoo0(String message) {
        System.out.println("KafkaConsumerOneToMany Message in group test0: " + message);
    }

    @KafkaListener(topics = "demoqueue", groupId = "test1")
    public void listenGroupFoo1(String message) {
        System.out.println("KafkaConsumerOneToMany Message in group test1: " + message);
    }

    @KafkaListener(topics = "demoqueue", groupId = "test2")
    public void listenGroupFoo2(String message) {
        System.out.println("KafkaConsumerOneToMany Message in group test2: " + message);
    }
}
