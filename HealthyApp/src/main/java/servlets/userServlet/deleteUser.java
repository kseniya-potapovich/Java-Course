package servlets.userServlet;

import repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //PrintWriter writer = resp.getWriter();
        UserRepository user = new UserRepository();
        req.setAttribute("deleteUser",user.deleteUser(Long.valueOf(id)));
        getServletContext().getRequestDispatcher("/deleteUser.jsp").forward(req, resp);
    }
}
