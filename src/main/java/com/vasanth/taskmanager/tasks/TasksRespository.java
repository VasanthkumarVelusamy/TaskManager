package com.vasanth.taskmanager.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRespository extends JpaRepository<TaskEntity, Long> {
}
