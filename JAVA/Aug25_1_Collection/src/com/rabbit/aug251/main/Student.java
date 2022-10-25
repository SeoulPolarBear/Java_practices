package com.rabbit.aug251.main;
// JavaBean : 자바를 커피로 비유(실제 java 모양)
//DTO, VO
public class Student {
        private String name;
        private int korean;
        private int English;
        private int Math;

        public Student(){
            
        }

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        English = english;
        Math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }
    public void printInfo(){
        System.out.printf("이름 : %s  /",name);
        System.out.printf("국어 점수 : %d   /",korean);
        System.out.printf("영어 점수 : %d   /",English);
        System.out.printf("수학 점수 : %d\n",Math);
    }
}
