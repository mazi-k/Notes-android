package com.example.mynotes;

import com.example.mynotes.domain.Note;

public interface Observer {

    void updateNote(Note note);
}