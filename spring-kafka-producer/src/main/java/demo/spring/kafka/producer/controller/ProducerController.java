package demo.spring.kafka.producer.controller;

import demo.spring.kafka.producer.dto.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProducerController {
    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);
    public static String memberId = "1";
    public static int memberCount = 9;
    public static Map<String, Integer> memberByMsgOrder = new HashMap<>();
    @Autowired
    private KafkaTemplate<Object, Object> template;

    public ProducerController(KafkaTemplate<Object, Object> template) {
        this.template = template;
        for (int i = 1; i <= memberCount; i++) {
            memberByMsgOrder.put(String.valueOf(i), 1);
        }
    }

    @GetMapping(path = "/send/foo/{msg}")
    public void sendFoo(@PathVariable String msg) {
        Integer order = memberByMsgOrder.get(memberId);
        Chat data = new Chat(memberId, order + "n-th message : " + msg);
        this.template.send("appdata", memberId, data);
        memberByMsgOrder.put(memberId, ++order);
        if (memberId.equalsIgnoreCase(String.valueOf(memberCount))) {
            memberId = "1";
        } else {
            memberId = String.valueOf(Integer.parseInt(memberId) + 1);
        }
        logger.info("Sent: " + data);
    }

}
