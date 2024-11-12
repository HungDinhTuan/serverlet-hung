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
import java.util.List;

@WebServlet(value = "/classroom")
public class ClassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy danh sách sinh viên
        ClassroomDAO cd= new ClassroomDAO   ();
        List<Classroom> list = cd.getAll();
        // trả về giao diện
        request.setAttribute("classes", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("classroom/List.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
