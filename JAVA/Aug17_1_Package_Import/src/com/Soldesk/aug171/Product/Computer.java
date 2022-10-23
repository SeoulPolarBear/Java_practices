package com.Soldesk.aug171.Product;

public class Computer extends Products{

    private String cpu;
    private int ram;
    private int hdd;

    public Computer(String name, int price, String sort, String cpu, int ram, int hdd) {
        super(name, price, sort);
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println(cpu);
        System.out.println(ram);
        System.out.println(hdd);
    }
}
