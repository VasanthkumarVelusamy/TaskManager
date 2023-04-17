package com.vasanth.taskmanager.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRespository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByCompletedIsTrue();
    List<TaskEntity> findByCompletedIsFalse();
}