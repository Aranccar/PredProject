package servlets;

import entity.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/createservlet")
public class CreateServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        UserService.getUserService().createUser(name, password, age);
        doGet(request, response);
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

