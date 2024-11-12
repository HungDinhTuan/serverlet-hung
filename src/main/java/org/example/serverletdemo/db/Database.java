package org.example.serverletdemo.db;

import java.sql.*;

public class Database {
    private final String connectionString = "jdbc:mysql://localhost:3306/students_db";
    private final String username = "root";
    private final String password = "123456789";
    private final  String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private static Database _instance ;

    // singleton pattern
    private Database() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(connectionString, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage()  );
        }
    }
    public static  Database createInstance() {
        if (_instance == null) {
            _instance = new Database();
        }
        return _instance;
    }
    public Statement getStatement() throws SQLException {
        return  conn.createStatement();
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
}
