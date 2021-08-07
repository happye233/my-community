package com.example.mycommunity;

import com.example.mycommunity.entity.CommentEntity;
import com.example.mycommunity.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class MyCommunityApplication {

    private final Logger log = LoggerFactory.getLogger(MyCommunityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyCommunityApplication.class, args);
    }

    //@Bean
    public CommandLineRunner init(CommentRepository repository) {
        return args -> {
            log.info("初始化数据库");
            CommentEntity comment = new CommentEntity();
            comment.setArticleId(13L);
            comment.setAuthor("小光");
            comment.setContent("你好！");
            repository.save(comment);
            System.out.println(repository.findAll());
            log.info("结束初始化数据库");
        };
    }

}
