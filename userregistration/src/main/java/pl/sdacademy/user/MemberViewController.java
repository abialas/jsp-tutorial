package pl.sdacademy.user;

import org.apache.commons.lang3.StringUtils;

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
        String memberIdParameter = request.getParameter("memberId");
        if (StringUtils.isNotBlank(memberIdParameter)) {
            request.setAttribute("memberAccount", memberService.getMember(Long.parseLong(memberIdParameter)));
        }
        request.getRequestDispatcher("WEB-INF/memberView.jsp").forward(request, response);
    }

}
