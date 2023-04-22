package com.vasanth.taskmanager.tasks.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class TaskResponseDto {
    Long id;
    String title;
    String description;
    Date dueDate;
    Boolean completed;
}
