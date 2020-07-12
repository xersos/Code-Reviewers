package fr.codereviewers.back.service;

import fr.codereviewers.back.core.dao.UserRepository;
import fr.codereviewers.back.web.dto.UserDto;
import fr.codereviewers.back.core.entity.UserEntity;
import fr.codereviewers.back.exception.UserNotFoundException;
import fr.codereviewers.back.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    @Autowired
    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUser() {
        return entityListToDtoList(userRepository.findAll());
    }

    public UserDto getUserById(long id) throws UserNotFoundException {
        Optional<UserEntity> optEnt = this.userRepository.findById(id);
        if (optEnt.isEmpty()) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        return userMapper.entityToDTO(optEnt.get());
    }

    public List<UserDto> searchUser(String name, String firstName, String pseudo) throws UserNotFoundException {
        Optional<List<UserEntity>> optEntities = this.userRepository.findByNameContainingOrFirstNameContainingOrPseudoContaining(name, firstName, pseudo);
        if(optEntities.isEmpty() || optEntities.get().size() < 1) {
            throw new UserNotFoundException("No user found with this arguments");
        }

        return entityListToDtoList(optEntities.get());
    }

    private List<UserDto> entityListToDtoList(List<UserEntity> entities) {
        List<UserDto> dtos = new ArrayList<>();
        entities.stream().forEach(userEntity -> {
            dtos.add(userMapper.entityToDTO(userEntity));
        });

        return dtos;
    }

}
