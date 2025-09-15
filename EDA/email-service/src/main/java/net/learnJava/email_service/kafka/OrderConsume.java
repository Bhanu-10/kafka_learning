package net.learnJava.email_service.kafka;

import lombok.extern.slf4j.Slf4j;
import net.learnJava.base_domains.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsume {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        log.info(String.format("Order event from email service => %s", orderEvent.toString()));
        // send email to the user that order is placed
    }
}
