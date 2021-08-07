package com.example.mycommunity.listener;

import com.example.mycommunity.entity.ArticleEntity;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class ArticleListener extends AbstractRepositoryEventListener<ArticleEntity> {
    @Override
    protected void onBeforeCreate(ArticleEntity entity) {
        System.out.println("create: " + entity);
    }

    @Override
    protected void onBeforeSave(ArticleEntity entity) {
        System.out.println("save: " + entity);
    }

    @Override
    protected void onAfterDelete(ArticleEntity entity) {
        System.out.println("delete: " + entity);
    }
}
