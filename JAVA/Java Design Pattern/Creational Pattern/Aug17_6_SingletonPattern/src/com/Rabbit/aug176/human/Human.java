package com.Rabbit.aug176.human;

public class Human {
    private String name;
    private int age;
    private String nickname;
    //처음부터 Lim 객체는 하나만 사용하겠다는 뜻이다. 싱글톤 패턴
    private static final Human Lim = new Human("임성환",27,"점토");

    public Human(){

    }

    public Human(String name, int age, String nickname) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static Human getLim(){
        return Lim;
    }

    public void printInfo(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(nickname);
    }
}
