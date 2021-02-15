package com.antonioledezma.note.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Note {
    @Id()
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;

    protected Note () {

    }

    public Note (String title, String text) {
        this.setTitle (title);
        this.setText (text);
    }

    /* Getters */
    public Long getId () {
        return this.id;
    }

    public String getTitle () {
        return this.title;
    }

    public String getText () {
        return this.text;
    }

    /* Setters. */
    private void setId (Long id) {
        this.id = id;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setText (String text) {
        this.text = text;
    }
}
