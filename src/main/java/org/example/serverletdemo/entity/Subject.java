package org.example.serverletdemo.entity;

public class Subject {
    private Integer idSubject;
    private String name;

    public Subject(Integer idSubject, String name) {
        this.idSubject = idSubject;
        this.name = name;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public String getName() {
        return name;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public void setName(String name) {
        this.name = name;
    }
}
