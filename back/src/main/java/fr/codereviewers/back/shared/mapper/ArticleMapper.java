package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.web.dto.ArticleDto;
import fr.codereviewers.back.core.entity.ArticleEntity;
import fr.codereviewers.back.web.dto.CommentDto;
import fr.codereviewers.back.web.dto.UserInfoReducedDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class ArticleMapper implements IGenericDtoMapper<ArticleEntity, ArticleDto> {

    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);
    private UserReducedMapper userReducedMapper = Mappers.getMapper(UserReducedMapper.class);

    @Override
    public ArticleDto entityToDTO(ArticleEntity articleEntity) {
        List<UserInfoReducedDto> authorsDtos = new ArrayList<>();
        List<CommentDto> commentDtos = new ArrayList<>();
        ArticleDto articleDto = new ArticleDto();

        articleEntity.getAuthor().stream().forEach(author -> {
            authorsDtos.add(userReducedMapper.entityToDTO(author));
        });

        articleEntity.getComment().stream().forEach(comment -> {
            commentDtos.add(commentMapper.entityToDTO(comment));
        });

        articleDto.setId(articleEntity.getId());
        articleDto.setAuthor(authorsDtos);
        articleDto.setComment(commentDtos);
        articleDto.setTitle(articleEntity.getTitle());
        articleDto.setCreatedAt(articleEntity.getCreatedAt());
        articleDto.setContent(articleEntity.getContent());

        return articleDto;
    }
}
