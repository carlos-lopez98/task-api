package com.example.task_api.dto;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String username;

    public TaskDTO(Long id, String title, String description, LocalDateTime createdAt, String username){
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
}
