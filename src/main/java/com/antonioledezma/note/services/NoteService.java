package com.antonioledezma.note.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.antonioledezma.note.entities.Note;
import com.antonioledezma.note.repositories.NoteRepository;


@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public void create (String title, String text) {
        Note note = new Note (title, text);
        this.noteRepository.save (note);
    }

    public void modify (Long id, String title, String text) {
        Note note = this.noteRepository.findById (id.longValue ());
        note.setTitle (title);
        note.setText (text);
        this.noteRepository.save (note);
    }

    public void delete (Long id) {
        Note note = this.noteRepository.findById (id.longValue ());
        this.noteRepository.delete (note);
    }

    public Note findById (Long id) {
        return this.noteRepository.findById (id.longValue ());
    }

    public List <Note> findAll () {
        return this.noteRepository.findAll ();
    }
}
