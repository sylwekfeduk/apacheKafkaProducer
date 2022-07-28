package pl.fis.lbd.apachekafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.lbd.apachekafkaproducer.config.KafkaTopicConfig;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String createUser() {
        kafkaTemplate.send(KafkaTopicConfig.USER_TOPIC_NAME, "USER_CREATED");
        return "User created";
    }
}
