package com.mykola.pagesmanager.entities.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * User entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    /** User id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Username */
    @NonNull
    private String username;

    /** Email */
    @NonNull
    private String email;

    /** Password encoded with BCryptPasswordEncoder */
    @NonNull
    private String password;

    /** User roles */
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
