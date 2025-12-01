package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import resources.TestContext;
import resources.Utils.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.apache.xmlbeans.XmlOptions.XmlOptionsKeys.BASE_URI;
import static resources.TestContext.*;
import static resources.TestContext.getProductId;
import static resources.Utils.post_requestspec;

public class AddproductSteps {
    RequestSpecification Req_Addproduct;
    Response  Addproduct_Response;
    JsonPath Addproduct_Response_json;

    @Given("the user provided a valid token")
    public void theUserProvidedAValidToken() {
        String token = TestContext.getAuthToken();
        if(token==null) {
            setAuthToken("Invalidtoken");
            setUserId("68fdd1d5f669d6cb0a2ca741");
        }
    }
    @Given("the user provided a product details {string} {string} {string} {string} {string} {string}")
    public void the_user_provided_a_product_details(String productName,
                                                    String UserId,
                                                    String productFor,
                                                    String productCategory,
                                                    String productPrice,
                                                    String productImage) throws IOException {
        System.out.println(getUserId());
        Req_Addproduct = given().log().all().spec(post_requestspec())
                .multiPart("productName",productName)
                .multiPart("productAddedBy",UserId)
                .multiPart("productCategory",productCategory)
                .multiPart("productSubCategory","Shirts")
                .multiPart("productPrice",productPrice)
                .multiPart("productDescription","none")
                .multiPart("productFor",productFor)

                .multiPart("productImage",new File(productImage) );

    }
    @When("the user sends a POST HTTP request to add product")
    public void the_user_sends_a_post_http_request_to_add_product() {

    Addproduct_Response=Req_Addproduct.post("/product/add-product");
         Addproduct_Response_json =    Addproduct_Response.then().extract().response().jsonPath();
    }
    @Then("The API should give response code {int}")
    public void the_api_should_give_response_code(int SC_AddProduct) {

        Assert.assertEquals(Addproduct_Response.statusCode(), SC_AddProduct);
        if(SC_AddProduct==201) {
            System.out.println(Addproduct_Response_json.getString("message"));
            Assert.assertEquals(Addproduct_Response_json.get("message"), "Product Added Successfully");
            setProductId(Addproduct_Response_json.getString("productId"));
            Assert.assertNotNull(getProductId());
        }
        else  {setProductId("56166151651655444");
        }
        }

    @Then("verify the product is Added, get request on the product Id with statuscode {int}")
    public void verify_the_product_is_added_get_request_on_the_product_id_with_statuscode(int SC_GetProduct) throws IOException {

        JsonPath Check_Added = given().log().all().spec(post_requestspec())
                .pathParam("ProductId", getProductId())
                .get("/product/get-product-detail/{ProductId}").
                then().statusCode(SC_GetProduct).extract().response().jsonPath();

    }

}
