package com.example.microtask.controllers;

import com.example.microtask.domain.Task;
import com.example.microtask.domain.TaskWithUser;
import com.example.microtask.services.TaskWithUserService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/taskwithuser")
public class TaskWithUserRestController {

    @Autowired
    TaskWithUserService taskWithUserService;

    @GetMapping
    public ResponseEntity<List<TaskWithUser>> getTaskWithUser(){
        List<TaskWithUser> taskWithUsers = taskWithUserService.getTasksWithUser();
        return ResponseEntity.ok(taskWithUsers);
    }
}
