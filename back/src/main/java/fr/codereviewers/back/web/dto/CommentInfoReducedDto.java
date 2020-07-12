package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class CommentInfoReducedDto {
    private long id;
    private UserInfoReducedDto author;
}
