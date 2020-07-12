package fr.codereviewers.back.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class CommentResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private CommentEntity comment;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private UserEntity author;

    private String content;

    @CreatedDate
    private Date createdAt;
}
