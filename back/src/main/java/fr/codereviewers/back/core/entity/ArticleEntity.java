package fr.codereviewers.back.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private List<UserEntity> author;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    private List<CommentEntity> comment;

    @CreatedDate
    private Date createdAt;

    private String content;
}
