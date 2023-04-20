package com.vasanth.taskmanager.tasks;

import lombok.Data;

import java.util.Date;

@Data
public class TaskResponseDTO {
    Long id;
    String title;
    String description;
    Date dueDate;
    Boolean completed;
}
