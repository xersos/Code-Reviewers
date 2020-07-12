package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class CommentDto {
    private long id;

    private UserInfoReducedDto author;

    private ArticleInfoReducedDto article;

    private List<CommentResponseDto> commentResponses;

    private String content;

    private Date createdAt;
}
