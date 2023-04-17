package com.vasanth.taskmanager.tasks;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TasksController {
    @Autowired
    public TasksService tasksService;

    @GetMapping(params = "completed")
    public List<TaskEntity> getTasksByCompletion(@PathParam("completed") Boolean completed) {
        return tasksService.getTasksByCompletion(completed);
    }

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("{id}")
    public Optional<TaskEntity> getTask(@PathVariable Long id) {
        return tasksService.getTask(id);
    }

    @PostMapping()
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return tasksService.createTask(task);
    }

}
