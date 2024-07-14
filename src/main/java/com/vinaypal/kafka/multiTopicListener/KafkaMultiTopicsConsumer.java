package com.vinaypal.kafka.multiTopicListener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMultiTopicsConsumer {

    @KafkaListener(topics = {"demoqueue2","demoqueue"}, groupId = "test")
    public void KafkaMultiTopicsConsumer(String message) {
        System.out.println("KafkaMultiTopicsConsumer Message in group test0: " + message);
    }

    @KafkaListener(topics = {"demoqueue2","demoqueue"}, groupId = "test7")
    public void listenGroupFoo1(String message) {
        System.out.println("KafkaMultiTopicsConsumer Message in group test1: " + message);
    }

}
