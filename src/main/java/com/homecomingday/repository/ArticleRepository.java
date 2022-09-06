package com.homecomingday.repository;

import com.homecomingday.controller.response.ArticleResponseDto;
import com.homecomingday.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Modifying
    @Query("update Article p set p.views = p.views + 1 where p.Id = :id")
    void updateCount(Long id);
//    List <ArticleResponseDto> findAllByOrderByCreatedAtDesc();
    List <Article> findByArticleFlagOrderByCreatedAtDesc(String articleFlag);
}