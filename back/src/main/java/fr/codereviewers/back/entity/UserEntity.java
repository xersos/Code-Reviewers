package fr.codereviewers.back.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
}
