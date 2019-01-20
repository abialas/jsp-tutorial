package pl.sdacademy;

import pl.sdacademy.model.CourseProvider;
import pl.sdacademy.model.CourseType;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "SelectCourse", value = "/SelectCourse.do")
public class CourseSelection extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseType courseType = CourseType.valueOf(request.getParameter("courseType"));

        CourseProvider courseProvider = new CourseProvider();
        Collection<String> availableCourses = courseProvider.getAvailableCourses(courseType);

        PrintWriter writer = response.getWriter();

        writer.println("<html>\n" +
                "<head>\n" +
                "    <title>SDA - courses</title>\n" +
                "</head>" +
                "<body>\n" +
                "    <h1>Selected category: " + courseType.name() +"</h1>" +
                "    <p>Available courses in selected category:</p>" +
                "    <select>" +
                    availableCourses.stream()
                    .map(c -> "<option>" + c + "</option>\n")
                    .collect(Collectors.joining()) +
                "    </select>" +
                "</body>" +
                "</html>");
    }

}
