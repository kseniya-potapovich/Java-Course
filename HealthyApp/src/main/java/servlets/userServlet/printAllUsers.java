package servlets.userServlet;

import repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getAll")
public class printAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository users = new UserRepository();
        req.setAttribute("users", users.getAll());
        getServletContext().getRequestDispatcher("/getAllUsers.jsp").forward(req, resp);
    }
}
