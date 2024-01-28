import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/save-request")
public class validateRequest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name.isEmpty() || email.isEmpty()) {
            resp.sendRedirect("/save-request.jsp");
        } else {
            resp.sendRedirect("pages/success-request.jsp?name=" + name + "&email=" + email);
        }
    }
}
