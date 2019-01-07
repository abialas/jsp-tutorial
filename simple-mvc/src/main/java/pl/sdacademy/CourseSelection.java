package pl.sdacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by adam.
 */
@WebServlet(name = "SelectCourse", value = "/SelectCourse.do")
public class CourseSelection extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseType = request.getParameter("courseType");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Collection<String> courses = new ArrayList<>();
        if ("TESTER".equals(courseType)) {
            courses = Arrays.asList("Selenium", "Ranorex", "Manual Tester");
        } else if ("PROGRAMMER".equals(courseType)) {
            courses = Arrays.asList("Java", "C#", "C++");
        }

        PrintWriter writer = response.getWriter();
        writer.println("Selected category: " + courseType + "<br>");
        writer.println("Available courses in selected category:<br>");
        writer.println("<select>");
        courses.stream()
                .forEach(c -> writer.println("<option>" + c + "</option>"));
        writer.println("</select>");
    }

}
