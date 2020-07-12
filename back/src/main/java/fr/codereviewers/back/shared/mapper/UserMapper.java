package fr.codereviewers.back.mapper;

import fr.codereviewers.back.web.dto.UserDto;
import fr.codereviewers.back.core.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends IGenericMapper<UserEntity, UserDto> {
}
