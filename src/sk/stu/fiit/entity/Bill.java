package sk.stu.fiit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final public class Bill implements Serializable{
    
    private LocalDate date;
    private Customer customer = null;
    private final List<Item> items = new ArrayList<>();
    private boolean allowNegative = false;
    private boolean initialized = false;

    // <editor-fold defaultstate="collapsed" desc=" initialized getter and setter ">
    public boolean isInitialized() {
        return initialized;
    }
    
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" allowNegative getter and setter ">
    public boolean isAllowNegative() {
        return allowNegative;
    }
    
    public void setAllowNegative(boolean allowNegative) {
        this.allowNegative = allowNegative;
    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Customer getter and setter ">
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Item list getter, setter and adder ">   
    public List<Item> getItems() {
        return items;
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public void removeItem(int index) {
        this.items.remove(index);
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Date getter and setter ">
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

// </editor-fold>
    
    public double getTotalPrice(){
        double price = 0;
        
        price = items.stream().map(i -> i.getAmount() * i.getProduct().getPrice()).reduce(price, (accumulator, _item) -> accumulator + _item);
        
        if(!allowNegative && price < 0)
            return 0.;
        
        return price;
    }

}
