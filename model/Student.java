package org.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    public static final float PASS_MIN_GRADE = 3.0f;
    //HashMap to store the enrolled course

    //Students choose the courses they wanted to be enrolled in
    private final Map<String, EnrolledCourse> enrolledCourses = new HashMap<>();

    private final List<Course> courses = new ArrayList<>();

    //Courses that students enrolled in which are approved
    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        //check if student has already enrolled to the course
        //prevent duplicate of same enrolled course in the HashMap, prevent adding null
        if (!enrolledCourses.containsKey(course.getCode())) {
            enrolledCourses.put(course.getCode(), new EnrolledCourse(course)) ;
        }
        else {
            //print out to tell student that he/she has already enrolled to the course
            System.out.println("Student has already enrolled to the course");
        }
    }

    public void gradeCourse(String courseCode, float grade) {

        if (enrolledCourses.containsKey(courseCode)) {
            enrolledCourses.get(courseCode).setGrade(grade);
        }
    }

    //NEW
    public float getGrade(String courseCode) {

        float grade = 0;
        if (enrolledCourses.containsKey(courseCode)) {
            grade = enrolledCourses.get(courseCode).getGrade();
        }
        return grade;
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
        return approvedCourses.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses()
    {
        //TODO implement this method
        List<Course> passedCourses = new ArrayList<>();
        for (EnrolledCourse enrolledCourse : enrolledCourses.values()) {
            if (enrolledCourse.getGrade() >= PASS_MIN_GRADE) {
                passedCourses.add(enrolledCourse);
            }
        }
        return passedCourses;
    }

    public Course findCourseById(String courseId) {
        return enrolledCourses.getOrDefault(courseId, null);
    }

    //Find courseCode from enrolledCourses
    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        return enrolledCourses.containsKey(courseCode);
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        if (approvedCourses.size() != 0) {
            return courses;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses.values());
    }
}
