package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TasksServiceTests {
    @Autowired
    private TasksRespository tasksRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void testCreateTask() {
        TasksService tasksService = new TasksService(tasksRespository, modelMapper);
        CreateTaskDto myTask = new CreateTaskDto();
        myTask.setTitle("new task");
        myTask.setDescription("test description");
        myTask.setDueDate(new Date());
        TaskEntity taskEntity = tasksService.createTask(myTask);
        System.out.println(taskEntity);
    }
}
