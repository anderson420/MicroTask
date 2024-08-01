package com.example.microtask.domain;

import com.example.microtask.domain.feign.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskWithUser{
    private Long id;
    private String title;
    private String description;
    private String status;
    private User user;
    public TaskWithUser(Task task, User user) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.user = user;
    }
}
