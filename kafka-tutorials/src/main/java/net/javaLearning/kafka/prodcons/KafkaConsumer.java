package net.javaLearning.kafka.prodcons;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaLearning.kafka.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class KafkaConsumer {

    @KafkaListener(topics = "kafka-tutorial", groupId = "group_id")
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));

    }

    @KafkaListener(topics = "kafka-tutorial-json", groupId = "group_id")
    public void consume(User user) {
        log.info(String.format("Message received -> %s", user.toString()));

    }

}
