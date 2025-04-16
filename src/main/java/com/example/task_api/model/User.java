package com.example.task_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents an app user
 * This entity is mapped to the 'app_user' table in the database.
 *
 * @author CJL
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    //Set's the creation timestamp to now
    private LocalDateTime createdAt = LocalDateTime.now();
}
