package com.example.task_api.dto;

import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for transferring User data between layers.
 * Contains essential user information without exposing sensitive or relational details.
 *
 * @author CJL
 */
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
