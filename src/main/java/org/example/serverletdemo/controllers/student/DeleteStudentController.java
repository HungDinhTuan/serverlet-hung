package org.example.serverletdemo.controllers.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.StudentDAO;
import org.example.serverletdemo.entity.Student;

import java.io.IOException;

@WebServlet(value = "/delete-student")
public class DeleteStudentController extends HttpServlet {
    private StudentDAO _studentDAO;

    public void init() {
        _studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = _studentDAO.find(id);
        if (student != null && _studentDAO.delete(student)) {
            resp.sendRedirect("student");
        } else {
            resp.sendRedirect("student");
        }
    }
}
