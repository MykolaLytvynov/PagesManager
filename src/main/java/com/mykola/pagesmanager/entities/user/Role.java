package com.mykola.pagesmanager.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Role entity
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "roles")
public class Role {

    /** Role id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User role */
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @NonNull
    private ERole name;
}
