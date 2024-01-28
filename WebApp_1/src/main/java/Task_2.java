import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Task_2/*")
public class Task_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String URL = req.getRequestURI();
        PrintWriter writer = resp.getWriter();

        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(URL);
        if (matcher.find()) {
            int age = Integer.parseInt(matcher.group());

            if (age >= 18) {
                writer.println("Legal age!");
            } else {
                writer.println("Juvenile!");
            }
            writer.close();
        }
    }
}
