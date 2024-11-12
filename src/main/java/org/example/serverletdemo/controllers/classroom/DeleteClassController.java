package org.example.serverletdemo.controllers.classroom;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.serverletdemo.dao.ClassroomDAO;
import org.example.serverletdemo.entity.Classroom;

import java.io.IOException;

@WebServlet(value = "/delete-classroom")
public class DeleteClassController extends HttpServlet {
    private ClassroomDAO _classroomDAO;

    public void init() {
        _classroomDAO = new ClassroomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Classroom classroom = _classroomDAO.find(id);
        if (classroom != null && _classroomDAO.delete(classroom)) {
            resp.sendRedirect("classroom");
        } else {
            resp.sendRedirect("classroom");
        }
    }
}
