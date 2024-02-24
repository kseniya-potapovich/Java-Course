package servlets.userServlet;

import repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet("/createUser")
public class createUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        User user = new User(Long.valueOf(String.valueOf(id)), firstName, lastName, email, Integer.parseInt(String.valueOf(age)), gender);
        //PrintWriter writer = resp.getWriter();
        UserRepository userCRUD = new UserRepository();
        req.setAttribute("createUser",userCRUD.addUser(user));
        getServletContext().getRequestDispatcher("/responseUser.jsp").forward(req, resp);
    }
}
