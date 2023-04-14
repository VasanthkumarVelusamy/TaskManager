package com.vasanth.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TasksService {
    private final TasksRespository tasksRespository;
    private final HelloBean helloBean;

    public TasksService(TasksRespository tasksRespository, HelloBean helloBean) {
        this.tasksRespository = tasksRespository;
        this.helloBean = helloBean;
    }

    public TaskEntity createTask(String title, String description, Date dueDate){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(title);
        taskEntity.setDescription(description);
        taskEntity.setDueDate(dueDate);
        taskEntity.setCompleted(false);
        return tasksRespository.save(taskEntity);
    }

    public String getGreetings() {
        return helloBean.greetings;
    }
}
