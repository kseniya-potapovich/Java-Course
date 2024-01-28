import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Task_1/*")
public class Task_1 extends HttpServlet {

    private static final LocalDateTime minskTime = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
    private static final LocalDateTime washingtonTime = LocalDateTime.now(ZoneId.of("America/New_York"));
    private static final LocalDateTime beijingTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String URL = req.getRequestURI();
        PrintWriter writer = resp.getWriter();

        Pattern pattern = Pattern.compile(".*/([^/]+)$");
        Matcher matcher = pattern.matcher(URL);
        if (matcher.find()) {
            String city = matcher.group(1);
            if (Objects.equals(city, "minsk")) {
                writer.println("/minsk " + formatter(minskTime));
            } else if (Objects.equals(city, "washington")) {
                writer.println("/washington " + formatter(washingtonTime));
            } else if (Objects.equals(city, "beijing")) {
                writer.println("/beijing " + formatter(beijingTime));
            } else {
                writer.println("I don't know this city(");
            }
            writer.close();
        }
    }

    private String formatter(LocalDateTime cityTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return cityTime.format(formatter);
    }
}
