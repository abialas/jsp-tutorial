package pl.sdacademy.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by adam.
 */
public class CourseProvider {

    public Collection<String> getAvailableCourses(CourseType courseType) {
        switch (courseType) {
            case TESTER:
                return Arrays.asList("Selenium", "Ranorex", "Manual Tester");
            case PROGRAMMER:
                return Arrays.asList("Java", "C#", "C++");
            default:
                return Collections.emptyList();
        }
    }

}
