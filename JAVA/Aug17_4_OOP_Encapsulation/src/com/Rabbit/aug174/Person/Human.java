package com.Rabbit.aug174.Person;
//캡슐화(Encapsulation)
//멤버변수에 접근할 수 있는 통로!를 만들고 그 통로에 안전장치를 하는 개념!
public class Human {
    private String name;
    private int age;
    private int weight;

    public Human(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
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
    //setXXX : 외부의 접근이 제한된 XXX를 가공할 수 있음
    public void setAge(int age) {
        if(age < 0){
            age *=-1;
        }
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
