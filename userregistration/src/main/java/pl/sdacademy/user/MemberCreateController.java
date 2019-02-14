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
@WebServlet(name = "MemberCreateController", value = "/memberCreate")
public class MemberCreateController extends HttpServlet {

    @Inject
    private MemberService memberService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String memberIdParameter = request.getParameter("memberId");
        if (StringUtils.isNotBlank(memberIdParameter)) {
            long memberId = Long.parseLong(memberIdParameter);
            request.setAttribute("memberAccount", memberService.getMember(memberId));
        } else {
            MemberDTO newMember = new MemberDTO();
            newMember.setAddressDTO(new AddressDTO());
            request.setAttribute("memberAccount", newMember);
        }
        request.getRequestDispatcher("WEB-INF/memberCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String houseNo = request.getParameter("houseNo");

        MemberDTO memberDTO = new MemberDTO();
        String memberIdParameter = request.getParameter("memberId");
        if (StringUtils.isNotBlank(memberIdParameter)) {
            memberDTO.setId(Long.parseLong(memberIdParameter));
        }
        memberDTO.setFirstName(firstName);
        memberDTO.setLastName(lastName);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(city);
        addressDTO.setStreet(street);
        addressDTO.setHouseNo(houseNo);
        memberDTO.setAddressDTO(addressDTO);

        memberService.saveUser(memberDTO);
        response.sendRedirect("members");
    }
}
