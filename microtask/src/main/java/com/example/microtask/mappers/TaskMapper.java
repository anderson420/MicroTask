package com.example.microtask.mappers;

import com.example.microtask.domain.Task;
import com.example.microtask.persistence.entities.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskEntity toEntity(Task task);
    Task toDTO(TaskEntity taskEntity);
    List<Task> toDTOs(List<TaskEntity> TaskEntyties);
    List<TaskEntity> toEntities(List<Task> Tasks);
}
