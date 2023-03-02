package demo.spring.kafka.consumer.listeners;

import demo.spring.kafka.consumer.config.ConsumerConfig;
import demo.spring.kafka.consumer.dto.ReceivedChat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaListenerService {
    private final Logger logger = LoggerFactory.getLogger(ConsumerConfig.class);

    @KafkaListener(id = "fooGroup", concurrency = "2", topics = "appdata")
    public void listen(ReceivedChat foo) {
        logger.info("Received: " + foo + "Thread : "+ Thread.currentThread().getName());
        if (foo.getMsg().endsWith("fail")) {
            throw new RuntimeException("failed");
        }
    }

    @KafkaListener(id = "dltGroup", topics = "appdata.DLT")
    public void dltListen(byte[] in) {
        logger.info("Received from DLT: " + new String(in));
    }
}
