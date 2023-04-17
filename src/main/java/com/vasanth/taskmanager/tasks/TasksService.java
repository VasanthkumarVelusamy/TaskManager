package com.vasanth.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    private final TasksRespository tasksRespository;

    public TasksService(TasksRespository tasksRespository) {
        this.tasksRespository = tasksRespository;
    }

    public TaskEntity createTask(TaskEntity task){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setDueDate(task.getDueDate());
        taskEntity.setCompleted(task.getCompleted());
        return tasksRespository.save(taskEntity);
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
