package fr.codereviewers.back.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class ArticleInfoReducedDto {
    private long id;
    private List<UserInfoReducedDto> authors;
    private String title;
}
