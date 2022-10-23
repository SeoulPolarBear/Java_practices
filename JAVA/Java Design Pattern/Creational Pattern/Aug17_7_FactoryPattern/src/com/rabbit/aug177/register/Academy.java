package com.rabbit.aug177.register;

public class Academy {
    public int getStudentCount() {
        return StudentCount;
    }

    public void setStudentCount(int studentCount) {
        StudentCount = studentCount;
    }

    private int StudentCount;//default로 0이 들어 있다.
    public Student consult(String name, int age){
        StudentCount++;
        return new Student(StudentCount, name,age);

    }
}
