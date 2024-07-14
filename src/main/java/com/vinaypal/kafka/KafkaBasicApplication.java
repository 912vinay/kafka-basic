package com.vinaypal.kafka;

import com.vinaypal.kafka.test.KafkaConsumerTest;
import com.vinaypal.kafka.test.KafkaProducerConsumerApplication;
import com.vinaypal.kafka.test.KafkaProducerTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.vinaypal.kafka",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {KafkaProducerTest.class, KafkaConsumerTest.class, KafkaProducerConsumerApplication.class}))
public class KafkaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBasicApplication.class, args);
	}

}
