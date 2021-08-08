package com.example.mycommunity.repository;

import com.example.mycommunity.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Cacheable;

@RepositoryRestResource
@Cacheable
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}