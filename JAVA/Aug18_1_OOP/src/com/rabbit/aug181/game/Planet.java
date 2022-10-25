package com.rabbit.aug181.game;

public class Planet {
    private String name;
    private double size;
    private boolean canSee;

    public Planet() {
    }

    public Planet(String name, double size, boolean canSee) {
        this.name = name;
        this.size = size;
        this.canSee = canSee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isCanSee() {
        return canSee;
    }

    public void setCanSee(boolean canSee) {
        this.canSee = canSee;
    }
    public void printInfo(){
        System.out.println(name);
        System.out.println(size);
        System.out.println(canSee);
    }

}
