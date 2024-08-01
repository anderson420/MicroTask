package com.example.microtask.services;

import com.example.microtask.domain.Task;
import com.example.microtask.domain.TaskWithUser;
import com.example.microtask.domain.feign.User;
import com.example.microtask.feign.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskWithUserService {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    public List<TaskWithUser> getTasksWithUser(){
        List<Task> tasks = taskService.getAllTask();
        List<TaskWithUser> taskWithUsers = tasks.stream().map(task -> {
            TaskWithUser taskWithUser = new TaskWithUser(task,task.getUserId() == null?null:userService.findUserById(task.getUserId()));
            return taskWithUser;
        }).toList();

    return taskWithUsers;

    }
}
