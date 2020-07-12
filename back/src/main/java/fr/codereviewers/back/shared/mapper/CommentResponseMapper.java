package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.web.dto.CommentResponseDto;
import fr.codereviewers.back.core.entity.CommentResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CommentResponseMapper implements IGenericDtoMapper<CommentResponseEntity, CommentResponseDto> {

    UserReducedMapper userReducedMapper = Mappers.getMapper(UserReducedMapper.class);
    CommentReducedMapper commentReducedMapper = Mappers.getMapper(CommentReducedMapper.class);

    @Override
    public CommentResponseDto entityToDTO(CommentResponseEntity commentResponseEntity) {
        CommentResponseDto responseDto = new CommentResponseDto();
        responseDto.setAuthor(userReducedMapper.entityToDTO(commentResponseEntity.getAuthor()));
        responseDto.setComment(commentReducedMapper.entityToDTO(commentResponseEntity.getComment()));
        responseDto.setContent(commentResponseEntity.getContent());
        responseDto.setCreatedAt(commentResponseEntity.getCreatedAt());
        responseDto.setId(commentResponseEntity.getId());

        return responseDto;
    }
}
