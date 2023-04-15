package com.vasanth.taskmanager.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks/{taskId}/notes")
public class NotesController {

    @GetMapping
    public String getNotes() {
        return "these are all the notes for taskId:";
    }

    @GetMapping("{notesId}")
    public String getNote(@PathVariable Long taskId, @PathVariable Long notesId) {
        return "This is the note with notes id: " + notesId + "of task: " + taskId;
    }
}
