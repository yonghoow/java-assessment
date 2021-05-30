package org.generation.service;

import org.generation.model.Course;
import org.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        //TODO implement
        System.out.println("Available students: ");
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //Check if student has already enrolled to the course
        if (students.containsKey(studentId) )
        {
            students.get(studentId).enrollToCourse(course);
        }

    }


}
