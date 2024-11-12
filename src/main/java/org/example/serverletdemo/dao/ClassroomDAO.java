package org.example.serverletdemo.dao;

import org.example.serverletdemo.db.Database;
import org.example.serverletdemo.entity.Classroom;
import org.example.serverletdemo.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements DAOInterface<Classroom> {

    @Override
    public List<Classroom> getAll() {
        String sql = "select * from Class";
        List<Classroom> list = new ArrayList<Classroom>();
        try {
            Database db = Database.createInstance();
            ResultSet rs = db.getStatement().executeQuery(sql);
            while (rs.next()) {
                list.add(new Classroom(
                        rs.getInt("IdClass"),
                        rs.getString("Name"),
                        rs.getString("Room")
                ));
            }
        }catch (Exception e) {}
        return list;
    }

    @Override
    public boolean create(Classroom classroom) {
        String sql = "insert into Class(Name, Room) values(?,?)";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, classroom.getName());
            prst.setString(2, classroom.getRoom());
            prst.execute();
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Classroom classroom) {
        String sql = "Update Class set Name = ?, Room = ? where Id = ? ";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, classroom.getName());
            prst.setString(2, classroom.getRoom());
            prst.setInt(5, classroom.getIdClass());
            prst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Classroom classroom) {
        String sql = "delete from Class where Id = ?";
        try {
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, classroom.getIdClass());
            prst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public <K> Classroom find(K id) {
        String sql = "select * from Persons where Id = ?";
        Classroom classroom = null;
        try {
            Database db  = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, (Integer) id);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                classroom = new Classroom(
                        rs.getInt("IdClass"),
                        rs.getString("Name"),
                        rs.getString("Room")
                );
            }
            return classroom;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

