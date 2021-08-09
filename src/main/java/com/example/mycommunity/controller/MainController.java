package com.example.mycommunity.controller;

import com.example.mycommunity.entity.Article;
import com.example.mycommunity.service.ArticleService;
import com.example.mycommunity.util.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private static final int PAGE_SIZE = 5;
    private final ArticleService articleService;

    public MainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String findByPage(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        if (page > 0) {
            Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);
            Page<Article> all = articleService.findAll(pageable);
            model.addAllAttributes(PageUtil.getPageMap(all, page));
            model.addAttribute("page", all);
            return "index";
        } else {
            return null;
        }

    }
}
