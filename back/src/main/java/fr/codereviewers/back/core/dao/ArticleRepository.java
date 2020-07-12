package fr.codereviewers.back.core.dao;

import fr.codereviewers.back.core.entity.ArticleEntity;
import fr.codereviewers.back.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<List<ArticleEntity>> findAllByAuthorOrderByCreatedAt(UserEntity author);
    Optional<List<ArticleEntity>> findAllByTitleOrCreatedAtAfterOrCreatedAtBeforeOrCreatedAtBeforeAndCreatedAtAfterOrAuthorContaining(String titleWildcard, Date createdAfter, Date createdBefore, Long authorId);
}
