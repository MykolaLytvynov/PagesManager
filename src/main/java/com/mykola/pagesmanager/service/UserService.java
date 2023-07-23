package com.mykola.pagesmanager.service;

import com.mykola.pagesmanager.entities.user.User;
import com.mykola.pagesmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User Service
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Save the new user to the database
     *
     * @param user - the new user
     * @return The saved user
     */
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
