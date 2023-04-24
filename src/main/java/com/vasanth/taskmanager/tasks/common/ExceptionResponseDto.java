package com.vasanth.taskmanager.tasks.common;

import lombok.Data;
import lombok.NonNull;

@Data
public class ExceptionResponseDto {
    @NonNull
    public String message;
}
