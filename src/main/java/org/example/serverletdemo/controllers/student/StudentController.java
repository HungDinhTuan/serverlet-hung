package org.example.serverletdemo.controllers.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.StudentDAO;
import org.example.serverletdemo.entity.Student;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/student")
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy danh sách sinh viên
        StudentDAO sd = new StudentDAO();
        List<Student> list = sd.getAll();
        // trả về giao diện
        request.setAttribute("students", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/List.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
