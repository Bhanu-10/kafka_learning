package net.javaLearns.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaLearns.springboot.entity.WikimediaData;
import net.javaLearns.springboot.repository.WikimediaDataRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private final WikimediaDataRepository wikimediaDataRepository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "my-group")
    public void consume(String eventMessage) {

        log.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);

    }
}
