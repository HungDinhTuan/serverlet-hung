package org.example.serverletdemo.entity;

public class Classroom {
    private Integer idClass;
    private String name;
    private String room;

    public Classroom(Integer idClass, String name, String room) {
        this.idClass = idClass;
        this.name = name;
        this.room = room;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
