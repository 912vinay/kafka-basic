package com.vinaypal.kafka.conroller;

import com.vinaypal.kafka.entities.Farewell;
import com.vinaypal.kafka.entities.Greeting;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final KafkaTemplate<String, Greeting> greetingKafkaTemplate;
    private final KafkaTemplate<String, Object> multiTypeKafkaTemplate;


    @RequestMapping("/post/{message}")
    public ResponseEntity<String> push(@PathVariable String message)
    {
        kafkaTemplate.send("demoqueue", message);
        kafkaTemplate.send("demoqueue2", message+"2");
        greetingKafkaTemplate.send("greeting", new Greeting("Hello","Test"));


        multiTypeKafkaTemplate.send("multitype", new Greeting("Greetings", "World!"));
        multiTypeKafkaTemplate.send("multitype", new Farewell("Farewell", 25));
        multiTypeKafkaTemplate.send("multitype", "Simple string message");

        return ResponseEntity.ok("We have published your message");
    }
}

