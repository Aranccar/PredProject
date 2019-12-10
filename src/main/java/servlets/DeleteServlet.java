package servlets;

import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/deleteservlet")
public class DeleteServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserService.getUserService().deleteUser(id);
        doGet(request, response);
    }
}
