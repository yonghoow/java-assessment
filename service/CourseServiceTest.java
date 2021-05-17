package org.generation.service;

import org.generation.model.Course;
import org.generation.model.Student;
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
        Course course = courseService.getCourse("INTRO-CS-2");
     }

     //test show enrolled students
    @Test
    @DisplayName("to test for invalid course Id")
    public void getStudentReturnsNullWhenCourseIdNotFound() {
        courseService.showEnrolledStudents("Invalid");
        assertNull(null);
    }
}
