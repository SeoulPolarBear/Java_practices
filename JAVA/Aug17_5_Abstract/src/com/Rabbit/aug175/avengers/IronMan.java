package com.Rabbit.aug175.avengers;
import com.Rabbit.aug175.smoker.Smoker;
import com.Rabbit.aug175.driver.Driver;
public class IronMan extends Avengers implements Smoker, Driver{

    private int property;

    public IronMan(){

    }

    public IronMan(String name, int age, int property) {
        super(name, age);
        this.property = property;
    }

    @Override
    public void attack(){
        System.out.println("공격은 빔");
    }

    @Override
    public void smoking(){
        System.out.println("흡연을 한다.");
    }

    @Override
    public void Driving(){
        System.out.println("운전을 한다.");
    }
    public void printInfo(){
        super.printInfo();
        System.out.println(property);
    }
}
