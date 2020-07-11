package fr.codereviewers.back.mapper;

import fr.codereviewers.back.dto.UserDto;
import fr.codereviewers.back.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends IGenericMapper<UserEntity, UserDto> {
}
