package pl.sdacademy;

import pl.sdacademy.model.CourseProvider;
import pl.sdacademy.model.CourseType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by adam.
 */
@WebServlet(name = "SelectCourse", value = "/SelectCourse.do")
public class CourseSelection extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseType courseType = CourseType.valueOf(request.getParameter("courseType"));

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("Selected category: " + courseType + "<br>");
        writer.println("Available courses in selected category:<br>");
        writer.println("<select>");
        CourseProvider courseProvider = new CourseProvider();
        courseProvider.getAvailableCourses(courseType).stream()
                .forEach(c -> writer.println("<option>" + c + "</option>"));
        writer.println("</select>");
    }

}
