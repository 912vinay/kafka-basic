package com.vinaypal.kafka.miss;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaPartitionConsumerService {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "demoqueue", partitions = { "0", "1" }),groupId = "test11")
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("listenToPartition Received Message: " + message + " from partition: " + partition);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "demoqueue",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")}),
            groupId = "test10")
    public void listenToPartition2(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("listenToPartition2 Received Message: " + message + " from partition: " + partition);
    }
}
