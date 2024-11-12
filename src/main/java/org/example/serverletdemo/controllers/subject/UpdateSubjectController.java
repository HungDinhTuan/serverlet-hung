package org.example.serverletdemo.controllers.subject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.StudentDAO;
import org.example.serverletdemo.dao.SubjectDAO;
import org.example.serverletdemo.entity.Student;
import org.example.serverletdemo.entity.Subject;

import java.io.IOException;

@WebServlet(value = "/update-subject")
public class UpdateSubjectController extends HttpServlet {
    private SubjectDAO _subjectDAO;

    public void init() {
        _subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Subject subject = _subjectDAO.find(id);
        req.setAttribute("subject", subject);
        RequestDispatcher rd = req.getRequestDispatcher("subject/Update.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Subject subject = new Subject(
                id,
                req.getParameter("Name")
        );
        if(_subjectDAO.update(subject)) {
            resp.sendRedirect("subject");
        } else {
            resp.sendRedirect("update-subject?id=", +id);
        }
    }
}
