package servlets.userServlet;

import crud.UserCRUD;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAll")
public class printAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCRUD users = new UserCRUD();
        req.setAttribute("users", users.getAll());
        getServletContext().getRequestDispatcher("/getAllUsers.jsp").forward(req, resp);
    }
}
