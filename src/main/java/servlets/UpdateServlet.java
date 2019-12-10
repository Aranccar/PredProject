package servlets;

import entity.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/updateservlet")
public class UpdateServlet extends javax.servlet.http.HttpServlet{
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        User user;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        UserService.getUserService().updateUser(id, name, password, age);
        doGet(request, response);
    }
}