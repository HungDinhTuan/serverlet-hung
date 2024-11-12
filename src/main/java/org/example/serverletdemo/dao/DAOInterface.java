package org.example.serverletdemo.dao;

import java.util.List;

// DAO pattern
public interface DAOInterface<S> {
    List<S> getAll();
    boolean create(S s);
    boolean update(S s);
    boolean delete(S s);
    <K> S find(K id);
}
