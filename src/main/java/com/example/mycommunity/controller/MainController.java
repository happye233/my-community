package com.example.mycommunity.controller;

import com.example.mycommunity.entity.ArticleEntity;
import com.example.mycommunity.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final ArticleRepository articleRepository;

    public MainController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<ArticleEntity> list = articleRepository.findAll();
        model.addAttribute("article", list);
        return "main";
    }
}
