package pl.sdacademy.controller;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adam.
 */
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Map<String, String> validationMessages = new HashMap<>();

        if (StringUtils.isBlank(user)) {
            validationMessages.put("user", "User cannot be empty");
        }
        if (StringUtils.isBlank(password)) {
            validationMessages.put("password", "Password cannot be empty");
        }
        if (!"JavaKtw12".equals(user) || !"Sda".equals(password)) {
            validationMessages.put("login", "Invalid login or password");
        }
        if (!validationMessages.isEmpty()) {
            request.setAttribute("validationMessages", validationMessages);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        request.getSession().setAttribute("userName", user);
        response.sendRedirect("/main.jsp");
    }
}
