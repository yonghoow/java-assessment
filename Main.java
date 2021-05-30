package org.generation;

import org.generation.model.Course;
import org.generation.model.Student;
import org.generation.service.CourseService;
import org.generation.service.StudentService;
import org.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.*;

public class Main
{

    public static void main( String[] args )
            throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3: //added courseService parameter to test
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
                case 8:
                    showAverageGrade( courseService, scanner);
                    break;
            }
        }
        while ( option != 9 );
    }

    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course.getName() );
        courseService.enrollStudent( courseId, student );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

    //added CourseService courseService parameter to test gradeStudent class
    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        System.out.println("Enrolled course:");
        for ( Course course : student.getEnrolledCourses()) {
            System.out.println("Course:");
        }
        System.out.println("Insert course ID to be graded");
        String courseId = scanner.next();
        Course course = student.findCourseById(courseId);
        if (course == null) {
            System.out.println("The student is not enrolled to a course with ID: " + courseId);
        }
        else {
            System.out.println("Insert course grade for: " + course.getName());
            float courseGrade = scanner.nextFloat();
            student.gradeCourse(course.getCode(), courseGrade);
        }
    }

    private static Student getStudentInformation( StudentService studentService, Scanner scanner) {
        System.out.println("Enter student Id: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found");
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation(studentService, scanner);
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner )
            throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner) {

        List<Course> passedCourses = new ArrayList<>();
                System.out.println("Enter student ID: ");
                String studentId = scanner.next();
                Student student = studentService.findStudent(studentId);

                if (student == null) {
                    System.out.println("Student not found");
                }
                else {
                    if (student.findPassedCourses().size() == 0) {
                        System.out.println("No passed courses available");
                    }
                    else {
                        System.out.println(student.findPassedCourses());
                    }
                }
    }

    private static void showAverageGrade(CourseService courseService, Scanner scanner) {
        courseService.showAverage();
    }
}