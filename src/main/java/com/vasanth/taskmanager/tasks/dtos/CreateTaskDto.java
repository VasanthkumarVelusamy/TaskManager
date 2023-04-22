package com.vasanth.taskmanager.tasks.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDto {
    public String title;
    public String Description;
    public Date dueDate;
}
