/*package servlets;

import entity.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/readservlet")
public class ReadServlet extends javax.servlet.http.HttpServlet  {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            List<User> users = UserService.getUserService().readAllUsers();
            response.setContentType("text/html");
            request.setAttribute("users", users);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/