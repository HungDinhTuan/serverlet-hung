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

@WebServlet(value = "/create-student")
public class CreateStudentController extends HttpServlet {
    private StudentDAO _studentDAO;

    @Override
    public void init() throws ServletException {
        _studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/Create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student(
                null,
                req.getParameter("LastName"),
                req.getParameter("FirstName"),
                req.getParameter("Address"),
                req.getParameter("City")
        );
        if(_studentDAO.create(s)){
            resp.sendRedirect("student");
            return;
        }
        resp.sendRedirect("create-student");
    }
}
