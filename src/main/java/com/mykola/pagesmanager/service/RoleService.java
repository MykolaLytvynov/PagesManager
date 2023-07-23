package com.mykola.pagesmanager.service;

import com.mykola.pagesmanager.entities.user.Role;
import com.mykola.pagesmanager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Role Service
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Save the new role to the database
     *
     * @param role - the new user
     * @return The saved role
     */
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
