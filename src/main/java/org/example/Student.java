package org.example;

public class Student {

    private int rollNo;
    private String name;
    private String course;
    private int semester;
    private String email;
    private double marks;

    public Student(int rollNo, String name, String course,
                   int semester, String email, double marks) {

        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.semester = semester;
        this.email = email;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }
}