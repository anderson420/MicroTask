package com.example.microtask.services;

import com.example.microtask.domain.Task;
import com.example.microtask.exceptions.NotFounTaskException;
import com.example.microtask.mappers.TaskMapper;
import com.example.microtask.persistence.entities.TaskEntity;
import com.example.microtask.persistence.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> getAllTask() {
        List<TaskEntity> tasksEntities = taskRepository.findAll();
        return taskMapper.toDTOs(tasksEntities);
    }

    @Override
    public Task getTask(Long id) {
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFounTaskException("no se ha encontrado la tarea con el id: "+id));
        return taskMapper.toDTO(task);
    }

    @Override
    public Task createTask(Task task) {
        task.setId(null);
        Task taskCreated = taskMapper.toDTO(taskRepository.save(taskMapper.toEntity(task)));
        return taskCreated;
    }

    @Override
    public Task updateTask(Task task) {
        Optional.ofNullable(task.getId())
                .orElseThrow(() -> new NotFounTaskException("El ID del usuario no puede ser nulo"));
        taskRepository.findById(task.getId()).orElseThrow(() -> new NotFounTaskException("no se ha encontrado la tarea con el id: "+task.getId()));

        TaskEntity taskUpdate = taskRepository.save(taskMapper.toEntity(task));
        return taskMapper.toDTO(taskUpdate);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new NotFounTaskException("no se ha encontrado la tarea con el id: "+id));
        taskRepository.deleteById(id);
    }
}
