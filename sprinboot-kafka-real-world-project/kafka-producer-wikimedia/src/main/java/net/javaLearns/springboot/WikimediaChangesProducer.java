package net.javaLearns.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recentchange";

        EventHandler handler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";


        EventSource eventSource = new EventSource.Builder(
                handler,
                URI.create(url)
        ).build();

        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

        // to read real time steam data from wikimedia we have to use event source
    }
}

