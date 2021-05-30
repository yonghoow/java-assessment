package org.generation.test;

import org.generation.model.Course;
import org.generation.model.Module;
import org.generation.model.Student;
import org.generation.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServiceTest {
    private CourseService courseService = new CourseService();

    //test get course
    @Test
    @DisplayName("To test for course getter")
    public void getCourseReturnsCourseWhenIdMatchIsFound() {
        String courseCode = "1234";
        Course course = new Course (courseCode, "course name", 10,
                new Module("code", "name", "description"));
        courseService.registerCourse(course);
        Course foundCourse = courseService.getCourse(courseCode);
        assertEquals(foundCourse, course);
     }

     //test null course
    @Test
    @DisplayName("to test for invalid course Id")
    public void getStudentReturnsNullWhenCourseIdNotFound() {
        Course nullCourse = courseService.getCourse("invalid");
        assertNull(nullCourse);
    }
}
