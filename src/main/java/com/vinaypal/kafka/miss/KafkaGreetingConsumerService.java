package com.vinaypal.kafka.miss;

import com.vinaypal.kafka.entities.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaGreetingConsumerService {

    @KafkaListener(topics = "greeting" ,groupId = "test13",containerFactory = "greetingKafkaListenerContainerFactory")
    public void listenWithHeaders(
            @Payload Greeting message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println(
                "Received Greeting Message: " + message +
                " from partition: " + partition);
    }
}
