package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.core.entity.ArticleEntity;
import fr.codereviewers.back.web.dto.ArticleInfoReducedDto;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleReducedMapper extends IGenericMapper<ArticleEntity, ArticleInfoReducedDto> {
}
