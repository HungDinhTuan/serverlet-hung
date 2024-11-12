package org.example.serverletdemo.controllers.subject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.SubjectDAO;
import org.example.serverletdemo.entity.Subject;

import java.io.IOException;

@WebServlet(value = "/create-subject")
public class CreateSubjectController extends HttpServlet {
    private SubjectDAO _subjectDAO;

    @Override
    public void init() throws ServletException {
        _subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("subject/Create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject s = new Subject(
                null,
                req.getParameter("Name")
        );
        if(_subjectDAO.create(s)){
            resp.sendRedirect("subject");
            return;
        }
        resp.sendRedirect("create-subject");
    }
}
