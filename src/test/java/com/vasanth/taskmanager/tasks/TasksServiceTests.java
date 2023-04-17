package com.vasanth.taskmanager.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TasksServiceTests {
    @Autowired
    private TasksRespository tasksRespository;

    @Test
    public void testCreateTask() {
        TasksService tasksService = new TasksService(tasksRespository);
        TaskEntity myTask = new TaskEntity();
        myTask.setTitle("new task");
        myTask.setDescription("test description");
        myTask.setDueDate(new Date());
        TaskEntity taskEntity = tasksService.createTask(myTask);
        System.out.println(taskEntity);
    }
}
