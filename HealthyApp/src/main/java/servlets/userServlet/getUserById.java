package servlets.userServlet;

import crud.UserCRUD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.valueOf;

@WebServlet("/get")
public class getUserById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserCRUD user = new UserCRUD();
        req.setAttribute("user", user.getById(Long.valueOf(String.valueOf(id))));
        getServletContext().getRequestDispatcher("/getUserById.jsp").forward(req, resp);
    }
}
