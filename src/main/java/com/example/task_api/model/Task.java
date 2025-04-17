package com.example.task_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * Represents a task that is assigned to a user
 *
 * @author CJL
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    /*
     *JPA Marks all fields to columns without needing the @column annotation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    private String description;


    private LocalDateTime createdAt = LocalDateTime.now();

    /*
     * JPA doesn't need us to use the @JoinColumn - implicitly JPA will link objects correctly
     * But the name assigned to the column will default - here we set it to user_id explicitly
     */
    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    private User user;
}
