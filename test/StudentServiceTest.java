package org.generation.test;

import org.generation.model.Course;
import org.generation.model.Student;

import org.generation.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
    private StudentService studentService = new StudentService();

    //find student
    @Test
    @DisplayName("To test for invalid student id")
    public void findStudentReturnsNullWhenStudentIdIsNotFound() {
        Student nullStudent = studentService.findStudent("Invalid");
        assertNull(nullStudent);
    }

    //find student
    @Test
    @DisplayName("to test when student id not matched")
    public void findStudentReturnsTheStudentWhenStudentIdMatchFound() {
        String testId = "1234";
        Student student = new Student (testId, "Santiago", "santiago@generation.org", new Date());
        studentService.subscribeStudent(student);
        Student foundStudent = studentService.findStudent(testId);
        assertEquals(foundStudent, student);
    }
}
