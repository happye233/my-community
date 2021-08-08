package com.example.mycommunity.listener;

import com.example.mycommunity.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArticleListener extends AbstractRepositoryEventListener<Article> {
    @Override
    protected void onBeforeCreate(Article entity) {
        log.info("create: " + entity);
    }

    @Override
    protected void onBeforeSave(Article entity) {
        log.info("save: " + entity);
    }

    @Override
    protected void onAfterDelete(Article entity) {
        log.info("delete: " + entity);
    }
}
