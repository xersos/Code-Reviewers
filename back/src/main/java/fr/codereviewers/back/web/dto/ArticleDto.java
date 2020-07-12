package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class ArticleDto {
    private long id;
    private String title;
    private List<UserInfoReducedDto> author;
    private List<CommentDto> comment;
    private Date createdAt;
    private String content;
}
