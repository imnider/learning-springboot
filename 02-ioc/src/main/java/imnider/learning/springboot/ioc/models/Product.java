package imnider.learning.springboot.ioc.models;

public class Product implements Cloneable {
    private int id;
    private String name;
    private Double price;
    
    public Product() {
    }

    public Product(String name, Double price) {
        this.id = (int) (Math.random() * 1000);
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.id, this.name, this.price);
        }
    }
}
