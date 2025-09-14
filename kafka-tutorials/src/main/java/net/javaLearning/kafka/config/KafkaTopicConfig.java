package net.javaLearning.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTestTopic() {
        return TopicBuilder.name("kafka-tutorial")
                //   .partitions(3)          // Number of partitions
                //  .replicas(1)           // Replication factor (use 1 for local setup)
                .build();
    }

    @Bean
    public NewTopic createTestJsonTopic() {
        return TopicBuilder.name("kafka-tutorial-json")
                //   .partitions(3)          // Number of partitions
                //  .replicas(1)           // Replication factor (use 1 for local setup)
                .build();
    }
}
