package com.example.mycommunity.repository;

import com.example.mycommunity.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Cacheable;

@RepositoryRestResource(collectionResourceRel = "reply", path = "reply")
@Cacheable
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
}
