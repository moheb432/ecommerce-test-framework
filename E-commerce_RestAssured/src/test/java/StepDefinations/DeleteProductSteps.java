package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import resources.TestContext;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static resources.Utils.post_requestspec_json_content;

public class DeleteProductSteps {
    RequestSpecification Req_DeleteAddedProduct;
    Response Delete_AddedProduct_Response;
    @Given("the user provided a valid token ,productId to Delete")
    public void the_user_provided_a_valid_token_product_id_to_delete() throws IOException {
        Req_DeleteAddedProduct = given().log().all().spec(post_requestspec_json_content())
                .pathParam("productId", TestContext.getProductId());
    }
    @When("The user sends a DELETE HTTP request to his Products")
    public void the_user_sends_a_delete_http_request_to_his_products() {
        Delete_AddedProduct_Response=Req_DeleteAddedProduct.delete("/product/delete-product/{productId}");
        if(Delete_AddedProduct_Response.getStatusCode()==200)
            Assert.assertEquals(Delete_AddedProduct_Response.jsonPath().getString("message"),"Product Deleted Successfully");

    }
    @Then("verify the Order is Deleted , get request on the product Id with statuscode {int}")
    public void verify_the_order_is_deleted_get_request_on_the_product_id_with_statuscode(Integer int1) {
        Response Get_DeletedProduct_Response=Req_DeleteAddedProduct.get("/product/get-product-detail/{productId}");
        Assert.assertEquals(Get_DeletedProduct_Response.getStatusCode(), int1);

    }



}
