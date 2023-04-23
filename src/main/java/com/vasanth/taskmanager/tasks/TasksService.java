package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import com.vasanth.taskmanager.tasks.dtos.TaskResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        ModelMapper modelMapper = new ModelMapper();
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

    public Optional<TaskEntity> getTask(Long id) {
        return tasksRespository.findById(id);
    }

}
