package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.AddOrder;
import org.example.Order;
import org.example.OrderResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import resources.TestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static resources.TestContext.*;
import static resources.Utils.post_requestspec;
import static resources.Utils.post_requestspec_json_content;


public class CreateOrderSteps {
    Response CreateOrder_Response;
    OrderResponse AddOrder_Response;
    Order order =new Order();
    List<Order> orders = new ArrayList<Order>();
    AddOrder OrderList = new AddOrder();

    RequestSpecification requestCreateorder;
    @Given("the user provided a valid token and a valid productId and the order {string}")
    public void the_user_provided_a_valid_token_and_a_valid_product_id_and_the_order(String country) throws IOException {
        Assert.assertNotNull(TestContext.getAuthToken(), "The authentication token must not be null after login.");
        System.out.println(TestContext.getProductId());
        Assert.assertNotNull(TestContext.getProductId(), "product id must not be null before ordering.");
        order.setProductOrderedId(getProductId());
        order.setCountry(country);
        orders.add(order);
        OrderList.setorders(orders);
        requestCreateorder = given().
                spec(post_requestspec_json_content()).
                body(OrderList);
    }
    @When("the user sends a POST HTTP request to create order")
    public void the_user_sends_a_post_http_request_to_create_order() {

        CreateOrder_Response=requestCreateorder.post("/order/create-order");
        if(CreateOrder_Response.getStatusCode()==201) {
            AddOrder_Response = CreateOrder_Response.then().extract().response().as(OrderResponse.class);
        }
    }
    @Then("The API should give response code {int} he API should give message Orders added successfully and the Order ID")
    public void the_api_should_give_response_code_he_api_should_give_message_orders_added_successfully_and_the_order_id(int int1) {
        CreateOrder_Response.then().assertThat().statusCode(int1);
        if(int1==201){
        Assert.assertEquals(AddOrder_Response.getmessage(),"Order Placed Successfully");
        Assert.assertNotNull(AddOrder_Response.getOrders().get(0));
        TestContext.setOrderId(AddOrder_Response.getOrders().get(0));
            }
        else{
            System.out.println(CreateOrder_Response.jsonPath().getString("type"));
            Assert.assertEquals(CreateOrder_Response.jsonPath().getString("type"),"Something Went Wrong");

        }
    }

    @Then("verify the Order is Added, get request on the Order Id with statuscode {int}")
    public void verify_the_order_is_added_get_request_on_the_order_id_with_statuscode(Integer int1) throws IOException {
        if(int1==200) {
            RequestSpecification Req_GetAddOrder = given().log().all().spec(post_requestspec())
                    .param("id", getOrderId());
            JsonPath Get_AddOrder_Response = Req_GetAddOrder.get("/order/get-orders-details").
                    then().statusCode(int1).extract().response().jsonPath();
            Assert.assertEquals(Get_AddOrder_Response.getString("message"), "Orders fetched for customer Successfully");
        }
        else{
            setOrderId("55532325161215");
        }
    }


}
