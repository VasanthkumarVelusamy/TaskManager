package com.vasanth.taskmanager.notes;

import com.vasanth.taskmanager.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "notes")
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    private String title;
    private String Description;
    @ManyToOne(targetEntity = TaskEntity.class)
    private TaskEntity task;
}
