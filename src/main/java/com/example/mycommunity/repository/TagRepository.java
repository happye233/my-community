package com.example.mycommunity.repository;

import com.example.mycommunity.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Cacheable;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
@Cacheable
public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
