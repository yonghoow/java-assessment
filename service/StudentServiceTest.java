package org.generation.service;

import org.generation.model.Course;
import org.generation.model.Student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentServiceTest {
    private StudentService studentService = new StudentService();

    //find student
    @Test
    @DisplayName("To test for invalid student id")
    public void getStudentReturnsNullWhenStudentIdIsInvalid() {
        Student nullStudent = studentService.findStudent("Invalid");
        assertNull(nullStudent);
    }

    //is subscribed
    @Test
    @DisplayName("to test when student id is null")
    public void getStudentReturnsFalseWhenStudentIdNotFound() {
        Boolean nullStudent = studentService.isSubscribed("");
        assertFalse(nullStudent);
    }

}
