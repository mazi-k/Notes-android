package com.example.mynotes.domain;

import com.example.mynotes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(R.string.note1_title, R.string.note1, R.string.date1));
        notes.add(new Note(R.string.note2_title, R.string.note2, R.string.date2));
        notes.add(new Note(R.string.note3_title, R.string.note3, R.string.date3));
        return notes;
    }

}
