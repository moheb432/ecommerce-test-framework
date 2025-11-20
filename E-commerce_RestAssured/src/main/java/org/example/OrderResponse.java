package org.example;

import java.util.ArrayList;
import java.util.List;

/*
{
  "orders": [
    "6914a3335008f6a9091a7d3a"
  ],
  "productOrderId": [
    "6914a3315008f6a9091a7d2d"
  ],
  "message": "Order Placed Successfully"
}
*/
public class OrderResponse {

    List<String> orders = new ArrayList<String>();
    List<String> productOrderId = new ArrayList<String>();
    String message;

    public List<String> getOrders() {
        return orders;
    }
    public List<String> getproductOrderId() {
        return  productOrderId;
    }
    public String getmessage() {
        return message;
    }
}
