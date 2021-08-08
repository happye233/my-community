package com.example.mycommunity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long viewCount = 0L;
    private Long likeCount = 0L;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;
    @OneToMany
    private List<Comment> comments;
    @ManyToMany
    private List<Tag> tags;
}
