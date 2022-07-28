package pl.fis.lbd.apachekafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import pl.fis.lbd.apachekafkaproducer.config.KafkaTopicConfig;

@RestController
@RequestMapping(value = "/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String createComment() {
        kafkaTemplate.send(KafkaTopicConfig.COMMENT_TOPIC_NAME, "COMMENT_CREATED");
        return "Comment created";
    }

    @PutMapping
    public String updateComment() {
        kafkaTemplate.send(KafkaTopicConfig.COMMENT_TOPIC_NAME,"COMMENT_UPDATED");
        return "Comment updated";
    }

    @DeleteMapping
    public String deleteComment() {
        kafkaTemplate.send(KafkaTopicConfig.COMMENT_TOPIC_NAME,"COMMENT_DELETED");
        return "Comment deleted";
    }
}
