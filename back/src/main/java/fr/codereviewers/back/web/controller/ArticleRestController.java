package fr.codereviewers.back.web.controller;

import fr.codereviewers.back.web.dto.ArticleDto;
import fr.codereviewers.back.core.service.ArticleDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("api/articles")
public class ArticleRestController {

    private final ArticleDataService articleDataService;

    @Autowired
    public ArticleRestController(ArticleDataService articleDataService) {
        this.articleDataService = articleDataService;
    }

    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(articleDataService.getAll());
    }
}
