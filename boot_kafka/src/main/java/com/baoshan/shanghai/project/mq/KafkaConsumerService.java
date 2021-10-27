package com.baoshan.shanghai.project.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KafkaConsumerService {

    @KafkaListener(topics = "${log.statistical.kafka.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void processMessage(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            System.out.println("----------------- record =" + record);
            System.out.println("------------------ message =" + message);
        }

    }
}
