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
import java.util.Collection;

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
        request.setAttribute("courses", availableCourses);

        RequestDispatcher view = request.getRequestDispatcher("courses.jsp");
        view.forward(request, response);
    }

}
