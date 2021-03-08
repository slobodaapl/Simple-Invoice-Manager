
package sk.stu.fiit.entity;

import java.io.Serializable;


public class Product implements Serializable {
    
    public Product(){}
    
    public Product(Product product){
        this.name = product.getName();
        this.desc = product.getDesc();
        this.price = product.getPrice();
    }
    
    private String name = "Undefined";
    private String desc = "Undefined";
    private double price = 0;
    private boolean initialized = false;

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void setPrice(double price) {
        this.price = price;
    }

}
