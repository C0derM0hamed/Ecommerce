package models;

import patterns.prototype.Prototype;

public class Product implements Prototype ,ProductComponent {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
public Product(int id,String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public  Product clone() {
        return new Product(this.name, this.category, this.price);
    }

    public int getId() {
        return id;
    }

  

}
