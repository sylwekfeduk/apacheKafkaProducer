package pl.fis.lbd.apachekafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fis.lbd.apachekafka.config.KafkaTopicConfig;

@RestController
@RequestMapping(value = "/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String createArticle() {
        kafkaTemplate.send(KafkaTopicConfig.ARTICLE_TOPIC_NAME,"ARTICLE_CREATED");
        return "Article created";
    }

    @PutMapping
    public String updateArticle() {
        kafkaTemplate.send(KafkaTopicConfig.ARTICLE_TOPIC_NAME,"ARTICLE_UPDATED");
        return "Article updated";
    }
}
