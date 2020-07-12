package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.core.entity.CommentEntity;
import fr.codereviewers.back.web.dto.CommentInfoReducedDto;
import org.mapstruct.Mapper;

@Mapper
public interface CommentReducedMapper extends IGenericMapper<CommentEntity, CommentInfoReducedDto> {
}
