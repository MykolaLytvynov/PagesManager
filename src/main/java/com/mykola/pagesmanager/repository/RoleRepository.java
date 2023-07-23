package com.mykola.pagesmanager.repository;

import com.mykola.pagesmanager.entities.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository to work with Role entity
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
