package com.antonioledezma.note.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import com.antonioledezma.note.services.NoteService;
import com.antonioledezma.note.entities.Note;


@RestController
@RequestMapping (path = {"/note"})
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping (path = {"/create"})
    public void addNote (@RequestParam (value = "title") String title, @RequestParam (value = "text") String text) {
        this.noteService.create (title, text);
    }

    @GetMapping (path = {"/modify"})
    public void modifyNote (@RequestParam (value = "id") Long id, @RequestParam (value = "title") String title, @RequestParam (value = "text") String text) {
        this.noteService.modify (id, title, text);
    }

    @GetMapping (path = {"/delete"})
    public void deleteNote (@RequestParam (value = "id") Long id) {
        this.noteService.delete (id);
    }

    @GetMapping (path = {"/view/{id}"})
    public Note viewNote (@PathVariable (value = "id") Long id) {
        return this.noteService.findById (id);
    }

    @GetMapping (path = {"/view"})
    public List <Note> viewAllNote () {
        return this.noteService.findAll ();
    }

    @GetMapping (path = {"/**"})
    public String pageNotFound () {
        return "No se reconoce la solicitud.";
    }
}
