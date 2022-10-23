package com.Soldesk.aug171.Product;

public class Products {
    private String name;
    private int price;
    private String sort;

    public Products(String name, int price, String sort) {
        this.name = name;
        this.price = price;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void printInfo() {
        System.out.println(name);
        System.out.println(price);
        System.out.println(sort);
    }
}
