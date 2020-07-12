package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class UserInfoReducedDto {
    private long id;
    private String pseudo;
    private String mail;
    private Date creationDate;
}
