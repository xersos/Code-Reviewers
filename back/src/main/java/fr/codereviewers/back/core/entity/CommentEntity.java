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
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private UserEntity author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private ArticleEntity article;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    private List<CommentResponseEntity> commentResponses;

    private String content;

    @CreatedDate
    private Date createdAt;

}
