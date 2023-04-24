package com.vasanth.taskmanager.tasks.exceptions;

public class TaskNotFoundException extends IllegalArgumentException {
    public TaskNotFoundException(Long id) {
        super("task with id " + id + " not found");
    }
}
