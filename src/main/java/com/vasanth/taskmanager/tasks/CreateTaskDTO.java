package com.vasanth.taskmanager.tasks;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String title;
    String Description;
    Date dueDate;
}
