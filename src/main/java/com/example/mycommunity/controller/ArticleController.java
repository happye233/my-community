package com.example.mycommunity.controller;

import com.example.mycommunity.entity.ArticleEntity;
import com.example.mycommunity.repository.ArticleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * rest article 数据接口
 */
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article")
    public List<ArticleEntity> findAll() {
        return articleRepository.findAll();
    }

    @GetMapping("/article/{id}")
    public Optional<ArticleEntity> findById(@PathVariable Long id) {
        return articleRepository.findById(id);
    }

    @PostMapping("/article")
    public ArticleEntity save(@RequestBody ArticleEntity article) {
        return articleRepository.save(article);
    }

    @PutMapping("/article/{id}")
    public ArticleEntity update(@PathVariable Long id, @RequestBody ArticleEntity article) {
        return articleRepository.save(article);
    }

}
