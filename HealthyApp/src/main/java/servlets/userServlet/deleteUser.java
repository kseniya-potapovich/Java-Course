package servlets.userServlet;

import crud.UserCRUD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //PrintWriter writer = resp.getWriter();
        UserCRUD user = new UserCRUD();
        user.deleteUser(Long.valueOf(id));
        getServletContext().getRequestDispatcher("/getAll").forward(req, resp);
    }
}
