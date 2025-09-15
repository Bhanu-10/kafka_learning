package net.learnJava.stock_service.kafka;

import lombok.extern.slf4j.Slf4j;
import net.learnJava.base_domains.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        log.info(String.format("Order event from order service => %s", orderEvent.toString()));

        // save the order into the database
    }


}
