package com.example.mycommunity.controller;

import com.example.mycommunity.entity.Article;
import com.example.mycommunity.entity.Comment;
import com.example.mycommunity.entity.Tag;
import com.example.mycommunity.repository.CommentRepository;
import com.example.mycommunity.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * article控制器
 */
@Controller
public class ArticleController {
    private final static Integer PAGE_SIZE = 5;
    private final CommentRepository commentRepository;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    /**
     * 查询所有article
     *
     * @return 所有article
     */
    @GetMapping("/article")
    @ResponseBody
    public List<Article> findAllArticle() {
        return articleService.findAll();
    }

    /**
     * @param page 页数
     * @return 页面
     */
    @GetMapping("/articles")
    @ResponseBody
    public Page<Article> findByPage(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return articleService.findAll(pageable);
    }

    /**
     * 根据id查询article
     *
     * @param id article的id
     * @return 查询的article
     */
    @GetMapping("/article/{id}")
    @ResponseBody
    public Article findArticleById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    /**
     * 保存或修改article
     *
     * @param article 需要保存的article
     * @return 保存后的article
     */
    @PostMapping("/article")
    @ResponseBody
    public Article saveArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * 保存评论
     *
     * @param id      article的id
     * @param comment 评论
     * @return 保存后的article
     */
    @PostMapping("/article/{id}/comment")
    @ResponseBody
    public Article saveComment(@PathVariable Long id, @RequestBody Comment comment) {
        Article article = articleService.findById(id);
        List<Comment> comments = article.getComments();
        comments.add(comment);
        article.setComments(comments);
        return articleService.save(article);

    }

    /**
     * 保存标签
     *
     * @param id  article的id
     * @param tag 标签
     * @return 保存后的article
     */
    @PostMapping("/article/{id}/tag")
    @ResponseBody
    public Article saveTag(@PathVariable Long id, @RequestBody Tag tag) {
        Article article = articleService.findById(id);
        Set<Tag> tags = article.getTags();
        tags.add(tag);
        article.setTags(tags);
        return articleService.save(article);
    }
}
