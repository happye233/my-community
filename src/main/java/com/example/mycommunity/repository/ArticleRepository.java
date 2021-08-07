package com.example.mycommunity.repository;

import com.example.mycommunity.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Cacheable;

@RepositoryRestResource(collectionResourceRel = "article", path = "article")
@Cacheable
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
