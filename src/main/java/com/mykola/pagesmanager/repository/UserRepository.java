package com.mykola.pagesmanager.repository;

import com.mykola.pagesmanager.entities.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JpaRepository to work with User entity
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Get User by username
     *
     * @param userName - Username
     * @return Optional<User>
     */
    Optional<User> findByUsername(String userName);
}
