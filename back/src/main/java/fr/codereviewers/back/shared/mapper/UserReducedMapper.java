package fr.codereviewers.back.shared.mapper;

import fr.codereviewers.back.core.entity.UserEntity;
import fr.codereviewers.back.web.dto.UserInfoReducedDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserReducedMapper extends IGenericMapper<UserEntity, UserInfoReducedDto> {
}
