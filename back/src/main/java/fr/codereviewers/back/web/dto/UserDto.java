package fr.codereviewers.back.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class UserDto {
    private long id;

    private String name;

    private String firstName;

    private String pseudo;

    private String role;

    private String email;

    private String phoneNumber;

    private Date birthDate;

    private Date createdAt;

    private Date lastAccountUpdate;

    private boolean verified;
}
