package org.example.serverletdemo.dao;

import org.example.serverletdemo.entity.Classroom;

import java.util.List;

public class ClassroomDAO implements DAOInterface<Classroom> {
    @Override
    public List<Classroom> getAll() {
        return List.of();
    }

    @Override
    public boolean create(Classroom classroom) {
        return false;
    }

    @Override
    public boolean update(Classroom classroom) {
        return false;
    }

    @Override
    public boolean delete(Classroom classroom) {
        return false;
    }

    @Override
    public <K> Classroom find(K id) {
        return null;
    }
}

