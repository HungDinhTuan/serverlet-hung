package org.example.serverletdemo.controllers.classroom;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.ClassroomDAO;
import org.example.serverletdemo.entity.Classroom;

import java.io.IOException;

@WebServlet(value = "/create-classroom")
public class CreateClassController extends HttpServlet {
    private ClassroomDAO _classroomDAO;

    @Override
    public void init() throws ServletException {
        _classroomDAO = new ClassroomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("classroom/Create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Classroom c = new Classroom(
                null,
                req.getParameter("Name"),
                req.getParameter("Room")
        );
        if(_classroomDAO.create(c)){
            resp.sendRedirect("classroom");
            return;
        }
        resp.sendRedirect("create-classroom");
    }
}
