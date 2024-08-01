package com.example.microtask.services;

import com.example.microtask.domain.Task;

import java.util.List;

public interface TaskService {
     List<Task> getAllTask();
     Task getTask(Long id);
     Task createTask(Task task);
     Task updateTask(Task task);
     void deleteTask(Long id);
}