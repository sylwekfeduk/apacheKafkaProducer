package pl.fis.lbd.apachekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String ARTICLE_TOPIC_NAME = "article";
    public static final String USER_TOPIC_NAME = "user";
    public static final String EMAIL_TOPIC_NAME = "email";
    public static final String COMMENT_TOPIC_NAME = "comment";

    @Bean
    public NewTopic articleTopic() {
        return TopicBuilder.name(ARTICLE_TOPIC_NAME)
                .build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder
                .name(USER_TOPIC_NAME)
                .build();
    }

    @Bean
    public NewTopic emailTopic() {
        return TopicBuilder
                .name(EMAIL_TOPIC_NAME)
                .build();
    }

    @Bean
    public NewTopic commentTopic() {
        return TopicBuilder
                .name(COMMENT_TOPIC_NAME)
                .build();
    }
}
