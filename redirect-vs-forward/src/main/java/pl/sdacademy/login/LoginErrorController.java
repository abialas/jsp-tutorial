package pl.sdacademy.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
@WebServlet(name = "LoginErrorController", value = "/loginError")
public class LoginErrorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> validationErrors = (Collection<String>) request.getAttribute("validationErrors");

        String validationMessagesAsHtml = validationErrors.stream()
                .map(message -> "<p>" + message + "</p>")
                .collect(Collectors.joining());

        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<body>\n" +
                "    <form action=\"/login\">\n" +
                        validationMessagesAsHtml +
                "       <input type=\"submit\" value=\"Login\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
