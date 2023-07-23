package com.mykola.pagesmanager.dataInitializer;

import com.mykola.pagesmanager.entities.image.ImageCategory;
import com.mykola.pagesmanager.entities.user.ERole;
import com.mykola.pagesmanager.entities.user.Role;
import com.mykola.pagesmanager.entities.user.User;
import com.mykola.pagesmanager.service.ImageCategoryService;
import com.mykola.pagesmanager.service.RoleService;
import com.mykola.pagesmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Class for saving test data to the database (Add user, roles and categories).
 *
 * Implementation of CommandLineRunner. CommandLineRunner is used to execute
 * the code after the Spring Boot application started.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ImageCategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        Role role1 = new Role(ERole.ROLE_USER);
        Role role2 = new Role(ERole.ROLE_ADMIN);
        roleService.save(role1);
        roleService.save(role2);

        // test user has login - "user1" and password - "password"
        User user = new User().builder()
                .username("user1")
                .password("password")
                .email("mail@gmail.com")
                .roles(Set.of(role1))
                .build();
        userService.save(user);

        ImageCategory category1 = new ImageCategory();
        category1.setName("Other");
        ImageCategory category2 = new ImageCategory();
        category2.setName("Java");
        ImageCategory category3 = new ImageCategory();
        category3.setName("Nature");

        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);
    }
}
