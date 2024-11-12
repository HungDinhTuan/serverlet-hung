package org.example.serverletdemo.dao;

import org.example.serverletdemo.db.Database;
import org.example.serverletdemo.entity.Student;
import org.example.serverletdemo.entity.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements DAOInterface<Subject> {
    @Override
    public List<Subject> getAll() {
        String sql = "select * from Subjects";
        List<Subject> list = new ArrayList<Subject>();
        try {
            Database db = Database.createInstance();
            ResultSet rs = db.getStatement().executeQuery(sql);
            while (rs.next()) {
                list.add(new Subject(
                        rs.getInt("IdSubject"),
                        rs.getString("Name")
                ));
            }
        }catch (Exception e) {}
        return list;
    }

    @Override
    public boolean create(Subject subject) {
        String sql = "insert into Subjects(Name) values(?)";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, subject.getName());
            prst.execute();
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Subject subject) {
        String sql = "Update Subjects set Name = ? where IdSubject = ? ";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, subject.getName());
            prst.setInt(2, subject.getIdSubject());
            prst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Subject subject) {
        String sql = "delete from Subjects where IdSubject = ?";
        try {
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, subject.getIdSubject());
            prst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public <K> Subject find(K id) {
        String sql = "select * from Subjects where IdSubject = ?";
        Subject subject = null;
        try {
            Database db  = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, (Integer) id);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                subject = new Subject(
                        rs.getInt("Id"),
                        rs.getString("Name")
                );
            }
            return subject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
