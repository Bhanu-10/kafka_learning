package net.javaLearning.kafka.prodcons;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaLearning.kafka.dto.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Log4j2
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        log.info(String.format("Message sent -> %s", user.toString()));
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "kafka-tutorial-json")
                .build();
        kafkaTemplate.send(message);
    }
}
