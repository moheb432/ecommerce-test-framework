package org.example;

public class Order {
    private String productOrderedId;
    private String country;
    public Order() {}

    public String getCountry(){
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductOrderedId(){
        return productOrderedId;
    }
    public void setProductOrderedId(String productId) {
        this.productOrderedId = productId;
    }

}
