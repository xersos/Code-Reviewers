package fr.codereviewers.back.service;

import fr.codereviewers.back.dao.UserRepository;
import fr.codereviewers.back.dto.UserDto;
import fr.codereviewers.back.entity.UserEntity;
import fr.codereviewers.back.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUser() {
        List<UserDto> dtos = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll();
        entities.stream().forEach(userEntity -> {
            dtos.add(userMapper.entityToDTO(userEntity));
        });

        return dtos;
    }
}
