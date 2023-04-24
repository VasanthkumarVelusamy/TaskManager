package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import com.vasanth.taskmanager.tasks.dtos.TaskResponseDto;
import com.vasanth.taskmanager.tasks.exceptions.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    private final TasksRespository tasksRespository;
    private final ModelMapper modelMapper;

    public TasksService(TasksRespository tasksRespository, ModelMapper modelMapper) {
        this.tasksRespository = tasksRespository;
        this.modelMapper = modelMapper;
    }

    public TaskResponseDto createTask(CreateTaskDto task){
        if (task.getDueDate().before(new Date())) {
            throw new IllegalArgumentException("Due date cannot be in the past");
        }
        TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
        taskEntity.setCompleted(false);
        TaskEntity savedTask =  tasksRespository.save(taskEntity);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    public List<TaskEntity> getAllTasks() {
        return tasksRespository.findAll();
    }

    public List<TaskEntity> getTasksByCompletion(Boolean completed) {
        return completed ? tasksRespository.findByCompletedIsTrue() : tasksRespository.findByCompletedIsFalse();
    }

    public TaskResponseDto getTask(Long id) {
        TaskEntity task = tasksRespository.findById(id).orElseThrow(()-> new TaskNotFoundException(id));
        TaskResponseDto fetchedTask = modelMapper.map(task, TaskResponseDto.class);
        return fetchedTask;
    }

}
