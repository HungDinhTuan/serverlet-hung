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

@WebServlet(value = "/update-classroom")
public class UpdateClassController extends HttpServlet {
    private ClassroomDAO _classroomDAO;

    public void init() {
        _classroomDAO = new ClassroomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Classroom classroom = _classroomDAO.find(id);
        req.setAttribute("classroom", classroom);
        RequestDispatcher rd = req.getRequestDispatcher("classroom/Update.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Classroom classroom = new Classroom(
                id,
                req.getParameter("Name"),
                req.getParameter("Room")
        );
        if(_classroomDAO.update(classroom)) {
            resp.sendRedirect("classroom");
        } else {
            resp.sendRedirect("classroom-student?id=", +id);
        }
    }
}
