package fr.codereviewers.back.dto;

import fr.codereviewers.back.entity.ArticleEntity;
import fr.codereviewers.back.entity.CommentResponseEntity;
import fr.codereviewers.back.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class CommentDto {
    private long id;

    private UserDto author;

    private ArticleDto article;

    private List<CommentResponseDto> commentResponses;

    private String content;

    private Date createdAt;
}
