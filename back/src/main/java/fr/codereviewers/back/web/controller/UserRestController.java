package fr.codereviewers.back.web.controller;

import fr.codereviewers.back.web.dto.UserDto;
import fr.codereviewers.back.core.exception.UserNotFoundException;
import fr.codereviewers.back.core.service.UserDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("api/users")
public class UserRestController {

    private final UserDataService userDataService;

    @Autowired
    public UserRestController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> dtos = this.userDataService.getAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@RequestHeader("Authorization") String authorization,
                                               @PathVariable("id") long id) throws UserNotFoundException {
        UserDto dto = this.userDataService.getUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> findUsers(@RequestHeader("Authorization") String authorization,
                                                    @RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "firstname", required = false) String firstName,
                                                   @RequestParam(value = "pseudo", required = false) String pseudo) throws UserNotFoundException {
        List<UserDto> dtos = this.userDataService.searchUser(name, firstName, pseudo);
        return ResponseEntity.status(HttpStatus.FOUND).body(dtos);
    }
}
