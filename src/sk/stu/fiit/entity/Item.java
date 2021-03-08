package sk.stu.fiit.entity;

import java.io.Serializable;

public class Item implements Serializable {
    
    public Item(){}
    
    public Item(Item item){
        this.product = new Product(item.getProduct());
        this.amount = item.getAmount();
    }
    
    public Item(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
    
    public Item(Product product){
        this.product = product;
        this.amount = 1;
    }
    
    private Product product = null;
    private int amount = 0;
    
    // <editor-fold defaultstate="collapsed" desc=" Product getter and setter ">
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Amount getter and setter ">
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

// </editor-fold>
    
}
