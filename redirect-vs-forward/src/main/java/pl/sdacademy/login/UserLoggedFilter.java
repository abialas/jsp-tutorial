package pl.sdacademy.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by adam.
 */
@WebFilter(filterName = "UserLoggedFilter", value = "/main")
public class UserLoggedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);

        if (session == null) {
            ((HttpServletResponse) response).sendRedirect("login");
            return;
        }
        chain.doFilter(request, response);
    }

}

