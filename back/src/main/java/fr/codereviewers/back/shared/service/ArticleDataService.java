package fr.codereviewers.back.shared.service;

import fr.codereviewers.back.core.dao.ArticleRepository;
import fr.codereviewers.back.shared.mapper.ArticleMapper;
import fr.codereviewers.back.web.dto.ArticleDto;
import fr.codereviewers.back.core.entity.ArticleEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleDataService {

    private final ArticleRepository articleRepository;
    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    @Autowired
    public ArticleDataService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> getAll() {
        List<ArticleDto> dtos = new ArrayList<>();
        List<ArticleEntity> articles = this.articleRepository.findAll();
        articles.forEach(articleEntity -> {
            dtos.add(articleMapper.entityToDTO(articleEntity));
        });

        return dtos;
    }
}
