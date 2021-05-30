package org.generation.model;

public class EnrolledCourse extends Course {
    private float grade = 0;

    public EnrolledCourse(String code, String name, int credits, Module module) {

        super(code, name, credits, module);
    }

    public EnrolledCourse(Course course) {

        super(course.getCode(), course.getName(), course.getCredits(), course.getModule());
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
