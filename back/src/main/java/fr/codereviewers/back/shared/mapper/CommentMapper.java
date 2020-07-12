package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.web.dto.CommentDto;
import fr.codereviewers.back.core.entity.CommentEntity;
import fr.codereviewers.back.web.dto.CommentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class CommentMapper implements IGenericDtoMapper<CommentEntity, CommentDto> {

    UserReducedMapper userMapper = Mappers.getMapper(UserReducedMapper.class);
    CommentResponseMapper responseMapper = Mappers.getMapper(CommentResponseMapper.class);
    ArticleReducedMapper articleReducedMapper = Mappers.getMapper(ArticleReducedMapper.class);

    @Override
    public CommentDto entityToDTO(CommentEntity commentEntity) {
        List<CommentResponseDto> responseDtos = new ArrayList<>();
        CommentDto dto = new CommentDto();

        commentEntity.getCommentResponses().stream().forEach( commentResponseEntity -> {
            responseDtos.add(responseMapper.entityToDTO(commentResponseEntity));
        });

        dto.setAuthor(userMapper.entityToDTO(commentEntity.getAuthor()));
        dto.setCreatedAt(commentEntity.getCreatedAt());
        dto.setContent(commentEntity.getContent());
        dto.setId(commentEntity.getId());
        dto.setCommentResponses(responseDtos);
        dto.setArticle(articleReducedMapper.entityToDTO(commentEntity.getArticle()));

        return dto;
    }
}
