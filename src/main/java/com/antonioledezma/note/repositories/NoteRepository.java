package com.antonioledezma.note.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.antonioledezma.note.entities.Note;


public interface NoteRepository extends CrudRepository <Note, Long> {
    List<Note> findAll ();
    Note findById (long id);
    long count ();
}
