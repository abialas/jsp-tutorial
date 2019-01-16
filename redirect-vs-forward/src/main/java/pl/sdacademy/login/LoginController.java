package pl.sdacademy.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by adam.
 */
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<body>\n" +
                "    <form action=\"/login\" method=\"post\">\n" +
                "        <label for=\"user\">User:</label>\n" +
                "        <input type=\"text\" id=\"user\" name=\"user\">\n" +
                "        <br />\n" +
                "        <label for=\"password\">Password:</label>\n" +
                "        <input type=\"password\" id=\"password\" name=\"password\">\n" +
                "        <br />\n" +
                "        <input type=\"submit\" value=\"Login\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");

        Collection<String> validationErrors = new LoginValidator().getLoginValidationMessages(userName, password);

        if (!validationErrors.isEmpty()) {
            request.setAttribute("validationErrors", validationErrors);
            request.getRequestDispatcher("/loginError").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/main").forward(request, response);
    }

}
