package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     final String BASE_URI = "https://rahulshettyacademy.com/api/ecom";



    @Test
    public void testSuccessfulLogin() throws JsonProcessingException {

        RequestSpecification requestspecs = new RequestSpecBuilder()
                .setBaseUri(BASE_URI).setContentType(ContentType.JSON)
                .build();

        Login loginPayload = new Login();
        loginPayload.setEmail("mohebashraf46@gmail.com");
        loginPayload.setPassword("Moheb 1997");

        RequestSpecification requestlogin = given().
                spec(requestspecs).
                body(loginPayload.Loginrequest());
        LoginResponsse reqlogin = requestlogin.when().post("/auth/login").
                then().
                log().all().
                        statusCode(200). // Assert status code
                        extract().
                response().as(LoginResponsse.class);
        System.out.println(reqlogin.getToken());
//ADD product

        RequestSpecification ADDproduct_specreq = new RequestSpecBuilder()
                .setBaseUri(BASE_URI).addHeader("authorization", reqlogin.getToken())
                .build();

        RequestSpecification Req_Addproduct = given().log().all().spec(ADDproduct_specreq)
                .multiPart("productName","Zara")
                .multiPart("productAddedBy",reqlogin.getUserId())
                .multiPart("productCategory","Fashion")
                .multiPart("productSubCategory","Shirts")
                .multiPart("productPrice","10")
                .multiPart("productDescription","none")
                .multiPart("productFor","Women")
                .multiPart("productImage",new File("C:\\Users\\moheb\\IdeaProjects\\E-commerce\\target\\zara.jpeg") );

        JsonPath Addproduct_Response=Req_Addproduct.post("/product/add-product").
                then().statusCode(201).extract().response().jsonPath();
        Assert.assertEquals(Addproduct_Response.get("message"),"Product Added Successfully");
        String productId=Addproduct_Response.getString("productId");
// get the added product
        JsonPath Check_Added = given().log().all().spec(ADDproduct_specreq)
                .pathParam("ProductId", productId)
                .get("/product/get-product-detail/{ProductId}").
                then().statusCode(200).extract().response().jsonPath();
        Assert.assertEquals(Check_Added.get("message"),"Product Details fetched Successfully");

//create order
        Order order =new Order();
        List<Order> orders = new ArrayList<Order>();

        order.setProductOrderedId(productId);
        order.setCountry("Egypt");

        AddOrder OrderList = new AddOrder();
        orders.add(order);
        OrderList.setorders(orders);
//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(OrderList));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        RequestSpecification AddOrder_specreq = new RequestSpecBuilder()
                .setBaseUri(BASE_URI).addHeader("authorization", reqlogin.getToken())
                .setContentType(ContentType.JSON).build();

        RequestSpecification Req_AddOrder = given().log().all().spec(AddOrder_specreq)
                .body(OrderList);

//Add new order
        OrderResponse AddOrder_Response=Req_AddOrder.post("/order/create-order").
                then().statusCode(201).extract().response().as(OrderResponse.class);
        Assert.assertEquals(AddOrder_Response.getmessage(),"Order Placed Successfully");
//        System.out.println(AddOrder_Response.getOrders().get(0));
// Get the added Order

        RequestSpecification Req_GetAddOrder = given().log().all().spec(ADDproduct_specreq)
                .param("id",AddOrder_Response.getOrders().get(0));
        JsonPath Get_AddOrder_Response=Req_GetAddOrder.get("/order/get-orders-details").
                then().statusCode(200).extract().response().jsonPath();
        Assert.assertEquals(Get_AddOrder_Response.getString("message"),"Orders fetched for customer Successfully");

//Delete Added Order
        RequestSpecification Req_DeleteAddedOrder = given().log().all().spec(AddOrder_specreq)
                .pathParam("orderId",AddOrder_Response.getOrders().get(0));
        JsonPath Delete_AddOrder_Response=Req_DeleteAddedOrder.delete("/order/delete-order/{orderId}").
                then().statusCode(200).extract().response().jsonPath();
        Assert.assertEquals(Delete_AddOrder_Response.getString("message"),"Orders Deleted Successfully");

//Delete Added product
        RequestSpecification Req_DeleteAddedproduct = given().log().all().spec(AddOrder_specreq)
                .pathParam("productId",productId);
        JsonPath Delete_Addedproduct_Response=Req_DeleteAddedproduct.delete("/product/delete-product/{productId}").
                then().statusCode(200).extract().response().jsonPath();
        Assert.assertEquals(Delete_Addedproduct_Response.getString("message"),"Product Deleted Successfully");

    }
}