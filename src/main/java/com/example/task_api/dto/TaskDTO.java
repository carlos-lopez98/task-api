package com.example.task_api.dto;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for transferring Task data between layers.
 * Contains simplified task details without exposing internal entity structure.
 *
 * @author CJL
 */
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Long userid;

    public TaskDTO(Long id, String title, String description, LocalDateTime createdAt, Long userid){
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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
