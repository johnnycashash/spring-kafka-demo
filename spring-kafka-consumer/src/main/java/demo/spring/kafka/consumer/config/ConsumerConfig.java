package demo.spring.kafka.consumer.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class ConsumerConfig {
    /*
     * Boot will autowire this into the container factory.
     */
    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
        DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(5000L, 2));
        defaultErrorHandler.setLogLevel(KafkaException.Level.DEBUG);
        return defaultErrorHandler;
    }

    @Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new ByteArrayJsonMessageConverter();
    }
 /*   @Bean
    public ApplicationRunner runner(KafkaListenerEndpointRegistry registry) {
        return args -> {
            registry.getListenerContainer("fooGroup").metrics()
                    .forEach((clientId, metrics) -> {
                        System.out.println(clientId);
                        metrics.forEach((key, value) -> System.out.println(key + ":" + value));
                    });
        };
    }*/
}
