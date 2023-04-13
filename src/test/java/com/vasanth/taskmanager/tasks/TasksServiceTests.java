package com.vasanth.taskmanager.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TasksServiceTests {
    @Autowired private TasksRespository tasksRespository;

    @Test
    public void testCreateTask() {
        TasksService tasksService = new TasksService(tasksRespository);
        TaskEntity taskEntity = tasksService.createTask("new task", "test description", new Date());
        System.out.println(taskEntity);
    }
}
