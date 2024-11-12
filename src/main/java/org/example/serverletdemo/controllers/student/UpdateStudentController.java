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

@WebServlet(value = "/update-student")
public class UpdateStudentController extends HttpServlet {
    private StudentDAO _studentDAO;

    public void init() {
        _studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = _studentDAO.find(id);
        req.setAttribute("student", student);
        RequestDispatcher rd = req.getRequestDispatcher("student/Update.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = new Student(
                id,
                req.getParameter("LastName"),
                req.getParameter("FirstName"),
                req.getParameter("City"),
                req.getParameter("Address")
        );
        if(_studentDAO.update(student)) {
            resp.sendRedirect("student");
        } else {
            resp.sendRedirect("update-student?id=", +id);
        }
    }
}
