package com.example.microtask.controllers;

import com.example.microtask.domain.Task;
import com.example.microtask.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTaks(){
        List<Task> tasks  = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task){
        Task taskCreated = taskService.createTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskCreated.getId()).toUri();
        return ResponseEntity.created(location).body(taskCreated);
    }
    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task taskUpdate = taskService.updateTask(task);
        return ResponseEntity.ok(taskUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
