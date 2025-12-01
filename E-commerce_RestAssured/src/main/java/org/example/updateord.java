package org.example;

public class updateord {
    public static String update(String orderID,String tool_id,String customer_name
    ,String quantity) {
        return  "{\"orderId\": \""+orderID+"\",\" toolId\": "+tool_id+",\"customerName\": \""+customer_name+"\",\"quantity\": "+quantity+",\"created\": \"2025-10-10T15:09:50.278Z\",\"comment\": \"\"}";

    }
}
