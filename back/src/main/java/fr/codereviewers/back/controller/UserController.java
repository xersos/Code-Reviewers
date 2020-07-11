package fr.codereviewers.back.controller;

import fr.codereviewers.back.dao.UserRepository;
import fr.codereviewers.back.dto.UserDto;
import fr.codereviewers.back.mapper.UserMapper;
import fr.codereviewers.back.service.UserService;
import io.swagger.annotations.Api;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> dtos = this.userService.getAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
    }
}
