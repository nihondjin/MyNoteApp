package com.example.mynoteapp.model;

import java.io.Serializable;

public class NoteModel implements Serializable {
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public NoteModel(String title) {
        this.title = title;

    }

}
