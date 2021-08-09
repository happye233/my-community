package com.example.mycommunity.service;

import com.example.mycommunity.entity.Article;
import com.example.mycommunity.entity.Tag;
import com.example.mycommunity.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * article的service层
 */
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * 查询所有article
     * @return 所有article
     */
    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    /**
     * 分页排序查询
     * @param pageable pageble对象
     * @return 分页结果
     */
    public Page<Article> findAll(Pageable pageable){
        return articleRepository.findAll(pageable);
    }

    /**
     * 根据id查询article
     * @param id article的id
     * @return 一个article
     */
    public Article findById(Long id) {
        Optional<Article> temp = articleRepository.findById(id);
        return temp.orElse(null);
    }

    /**
     * 保存article
     * @param article 需要保存的article
     * @return 保存后的article
     */
    public Article save(Article article){
        return articleRepository.save(article);
    }

}
