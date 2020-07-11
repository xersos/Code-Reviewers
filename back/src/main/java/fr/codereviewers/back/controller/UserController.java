package fr.codereviewers.back.controller;

import fr.codereviewers.back.dao.UserRepository;
import fr.codereviewers.back.dto.UserDto;
import fr.codereviewers.back.exception.UserNotFoundException;
import fr.codereviewers.back.mapper.UserMapper;
import fr.codereviewers.back.service.UserService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@RequestHeader("Authorization") String authorization,
                                               @PathVariable("id") long id) throws UserNotFoundException {
        UserDto dto = this.userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> findUsers(@RequestHeader("Authorization") String authorization,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("firstname") String firstName,
                                                   @RequestParam("pseudo") String pseudo) throws UserNotFoundException {
        List<UserDto> dtos = this.userService.searchUser(name, firstName, pseudo);
        return ResponseEntity.status(HttpStatus.FOUND).body(dtos);
    }
}
