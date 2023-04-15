package com.vasanth.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TasksService {
    private final TasksRespository tasksRespository;

    public TasksService(TasksRespository tasksRespository) {
        this.tasksRespository = tasksRespository;
    }

    public TaskEntity createTask(String title, String description, Date dueDate){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(title);
        taskEntity.setDescription(description);
        taskEntity.setDueDate(dueDate);
        taskEntity.setCompleted(false);
        return tasksRespository.save(taskEntity);
    }

}
