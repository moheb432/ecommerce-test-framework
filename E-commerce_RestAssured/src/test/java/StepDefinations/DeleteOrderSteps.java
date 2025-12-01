package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import resources.TestContext;

import java.io.IOException;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static resources.TestContext.getOrderId;
import static resources.Utils.post_requestspec;
import static resources.Utils.post_requestspec_json_content;

public class DeleteOrderSteps {
    RequestSpecification Req_DeleteAddedOrder;
    Response  Delete_AddOrder_Response;
    @Given("the user provided a valid token ,orderID to Delete")
    public void the_user_provided_a_valid_token_order_id_to_delete() throws IOException {
        Req_DeleteAddedOrder = given().log().all().spec(post_requestspec_json_content())
                .pathParam("orderId", TestContext.getOrderId());
    }

    @When("The user sends a DELETE HTTP request to his orders")
    public void the_user_sends_a_delete_http_request_to_his_orders() {
         Delete_AddOrder_Response=Req_DeleteAddedOrder.delete("/order/delete-order/{orderId}");
    }

    @Then("The API should give {int} statuscode")
    public void the_api_should_give_statuscode(Integer int1) {
        Assert.assertEquals(Delete_AddOrder_Response.getStatusCode(), int1);
        if(Delete_AddOrder_Response.getStatusCode()==200)
            Assert.assertEquals(Delete_AddOrder_Response.jsonPath().getString("message"),"Orders Deleted Successfully");

    }

    @Then("verify the Order is Deleted , get request on the Order Id with statuscode {int}")
    public void verify_the_order_is_deleted_get_request_on_the_order_id_with_statuscode(Integer int1) throws IOException {
        RequestSpecification Req_GetAddOrder = given().log().all().spec(post_requestspec())
                .param("id",getOrderId());
        JsonPath Get_AddOrder_Response=Req_GetAddOrder.get("/order/get-orders-details").
                then().assertThat().statusCode(int1).extract().response().jsonPath();
        if(int1==200)
            Assert.assertEquals(Get_AddOrder_Response.getString("message"),"Order not found");
    }
}
