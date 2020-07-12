package fr.codereviewers.back.core.dao;

import fr.codereviewers.back.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);
    Optional<List<UserEntity>> findByIdOrPseudoOrNameOrFirstName(Long id, String pseudo, String name, String firstName);
    Optional<List<UserEntity>> findByNameContainingOrFirstNameContainingOrPseudoContaining(String name, String firstName, String pseudo);
}
