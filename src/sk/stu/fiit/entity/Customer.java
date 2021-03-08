package sk.stu.fiit.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    
    public Customer(){}
    
    public Customer(Customer customer){
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.zipcode = customer.getZipcode();
    }
    
    private String name = "Undefined";
    private String address = "Undefined";
    private String city = "Undefined";
    private String zipcode = "Undefined";
    private boolean initalized = false;

    public boolean getInit() {
        return initalized;
    }

    public void setInit(boolean initialized) {
        this.initalized = initialized;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
