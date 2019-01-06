package pl.sdacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Created by adam.
 */
@WebServlet(name = "HelloWorld", value = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>" +
                "<head><title>Hello World Servlet</title></head>" +
                "<body>" +
                "<p>Hello World! <br>Dzisiaj jest " + LocalDateTime.now() + "!</p>" +
                "</body>" +
                "</html>");

    }
}
