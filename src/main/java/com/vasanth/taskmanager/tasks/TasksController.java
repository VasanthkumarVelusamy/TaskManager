package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.tasks.common.ExceptionResponseDto;
import com.vasanth.taskmanager.tasks.dtos.CreateTaskDto;
import com.vasanth.taskmanager.tasks.dtos.TaskResponseDto;
import com.vasanth.taskmanager.tasks.exceptions.TaskNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(tasksService.getTask(id));
    }

    @PostMapping()
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto task) {
        TaskResponseDto savedTask = tasksService.createTask(task);
        return ResponseEntity
                .created(URI.create("http:/localhost/2019/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            TaskNotFoundException.class
    })
    public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {
        if (e instanceof TaskNotFoundException) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ExceptionResponseDto(e.getMessage()));
        }
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDto(e.getMessage()));
    }

}
