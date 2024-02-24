package servlets.userServlet;

import repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.String.valueOf;

@WebServlet("/get")
public class getUserById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserRepository user = new UserRepository();
        req.setAttribute("user", user.getById(Long.valueOf(String.valueOf(id))));
        getServletContext().getRequestDispatcher("/getUserById.jsp").forward(req, resp);
    }
}
