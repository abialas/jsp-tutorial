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
@WebServlet(name = "MemberViewController", value = "/memberView")
public class MemberViewController extends HttpServlet {

    @Inject
    private MemberService memberService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long memberId = Long.parseLong(request.getParameter("memberId"));
        request.setAttribute("memberAccount", memberService.getMember(memberId));
        request.getRequestDispatcher("WEB-INF/memberView.jsp").forward(request, response);
    }

}
