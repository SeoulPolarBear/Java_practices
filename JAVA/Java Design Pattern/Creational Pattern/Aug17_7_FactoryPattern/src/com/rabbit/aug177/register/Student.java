package com.rabbit.aug177.register;

public class Student {


    private int num;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void printInfo(){
        System.out.println(num);System.out.println(name);
        System.out.println(age);
    }
}
