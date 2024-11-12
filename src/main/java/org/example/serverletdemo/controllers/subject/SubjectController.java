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
import java.util.List;

@WebServlet(value = "/subject")
public class SubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy danh sách sinh viên
        SubjectDAO sd = new SubjectDAO();
        List<Subject> list = sd.getAll();
        // trả về giao diện
        request.setAttribute("subjects", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("subject/List.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
