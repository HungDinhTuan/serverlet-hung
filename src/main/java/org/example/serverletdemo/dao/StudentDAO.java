package org.example.serverletdemo.dao;

import org.example.serverletdemo.db.Database;
import org.example.serverletdemo.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements  DAOInterface<Student> {

    @Override
    public List<Student> getAll() {
        String sql = "select * from Persons";
        List<Student> list = new ArrayList<Student>();
        try {
            Database db = Database.createInstance();
            ResultSet rs = db.getStatement().executeQuery(sql);
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("Id"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),
                        rs.getString("Address"),
                        rs.getString("City")
                ));
            }
        }catch (Exception e) {

        }
        return list;
    }

    @Override
    public boolean create(Student student) {
        String sql = "insert into Persons(LastName, FirstName, Address, City) values(?,?,?,?)";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, student.getLastName());
            prst.setString(2, student.getFirstName());
            prst.setString(3, student.getAddress());
            prst.setString(4, student.getCity());
            prst.execute();
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        String sql = "Update Persons set LastName = ?, FirstName = ?, Address = ?, City = ? where Id = ? ";
        try{
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1, student.getLastName());
            prst.setString(2, student.getFirstName());
            prst.setString(3, student.getAddress());
            prst.setString(4, student.getCity());
            prst.setInt(5, student.getId());
            prst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        String sql = "delete from Persons where Id = ?";
        try {
            Database db = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, student.getId());
            prst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public <K> Student find(K id) {
        String sql = "select * from Persons where Id = ?";
        Student student = null;
        try {
            Database db  = Database.createInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setInt(1, (Integer) id);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("Id"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),
                        rs.getString("Address"),
                        rs.getString("City")
                );
            }
            return student;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
