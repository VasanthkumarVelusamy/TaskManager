package com.vasanth.taskmanager.tasks;

import com.vasanth.taskmanager.notes.NotesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private Boolean completed;
    @OneToMany(targetEntity = NotesEntity.class, cascade = CascadeType.ALL, mappedBy = "task")
    private List<NotesEntity> notes;
}
