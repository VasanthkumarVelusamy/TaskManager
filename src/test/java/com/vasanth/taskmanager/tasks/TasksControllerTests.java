package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TasksControllerTests {
    @Autowired
    private TasksController tasksController;

    @Test
    public void testTasksController() {
//        tasksController.tasksService = tasksService;
        CreateTaskDto task = new CreateTaskDto();
        task.setTitle("test title");
        task.setDescription("test description");
        task.setDueDate(new Date());
        System.out.println(tasksController.createTask(task));
    }
}
