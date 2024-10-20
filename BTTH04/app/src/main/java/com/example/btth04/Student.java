package com.example.btth04;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String MSSV;
    private String studentClass;
    private double GPA;

    public Student(String name, String MSSV, String studentClass, double GPA) {
        this.name = name;
        this.MSSV = MSSV;
        this.studentClass = studentClass;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
