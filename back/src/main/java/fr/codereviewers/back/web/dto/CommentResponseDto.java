package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class CommentResponseDto {

    private long id;

    private CommentInfoReducedDto comment;

    private UserInfoReducedDto author;

    private String content;

    private Date createdAt;
}
