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
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String firstName;

    private String pseudo;

    private String role;

    private String email;

    private String phoneNumber;

    private String password;

    private Date birthDate;

    @CreatedDate
    private Date createdAt;

    private Date lastAccountUpdate;

    private boolean verified;

    @ManyToMany
    private List<ArticleEntity> articles;

    @OneToMany
    private List<CommentEntity> comments;

    @OneToMany
    private List<CommentResponseEntity> commentResponses;
}
