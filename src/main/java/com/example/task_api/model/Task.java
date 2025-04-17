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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
