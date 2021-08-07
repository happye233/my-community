package com.example.mycommunity.repository;

import com.example.mycommunity.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Cacheable;

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
@Cacheable
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
