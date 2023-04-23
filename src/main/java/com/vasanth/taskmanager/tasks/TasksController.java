package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import com.vasanth.taskmanager.tasks.dtos.TaskResponseDto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TasksController {
    public TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

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
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto task) {
        TaskResponseDto savedTask = tasksService.createTask(task);
        return ResponseEntity
                .created(URI.create("http:/localhost/2019/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

}
