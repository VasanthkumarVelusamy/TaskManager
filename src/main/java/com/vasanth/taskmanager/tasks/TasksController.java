package com.vasanth.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class TasksController {
    @Autowired
    TasksService tasksService;

    @GetMapping("hello")
    public String getGreetings() {
        return tasksService.getGreetings();
    }
}
