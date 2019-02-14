package pl.sdacademy.user;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by adam.
 */
@WebServlet(name = "MembersController", value = "/members")
public class MembersController extends HttpServlet {

    @Inject
    private MemberService memberService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("members", memberService.getMembers());
        request.getRequestDispatcher("WEB-INF/members.jsp").forward(request, response);
    }
}
