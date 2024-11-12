package org.example.serverletdemo.controllers.subject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.SubjectDAO;
import org.example.serverletdemo.entity.Subject;

import java.io.IOException;

@WebServlet(value = "/delete-subject")
public class DeleteSubjectController extends HttpServlet {
    private SubjectDAO _subjectDAO;

    public void init() {
        _subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Subject subject = _subjectDAO.find(id);
        if (subject != null && _subjectDAO.delete(subject)) {
            resp.sendRedirect("subject");
        } else {
            resp.sendRedirect("subject");
        }
    }
}
