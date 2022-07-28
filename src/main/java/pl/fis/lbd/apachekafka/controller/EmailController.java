package pl.fis.lbd.apachekafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.lbd.apachekafka.config.KafkaTopicConfig;

@RestController
@RequestMapping(value = "/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/emailToUser")
    public String sendEmailToUser() {
        kafkaTemplate.send(KafkaTopicConfig.EMAIL_TOPIC_NAME, "EMAIL_SENT");
        return "Email sent";
    }
}
