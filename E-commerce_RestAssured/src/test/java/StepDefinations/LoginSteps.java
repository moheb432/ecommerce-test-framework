package StepDefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Login;
import org.example.LoginResponsse;
import resources.TestDatabuild;
import resources.Utils;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static resources.TestContext.*;

public class LoginSteps extends Utils {
    RequestSpecification requestlogin;
    public LoginResponsse Login_response = new LoginResponsse();
    TestDatabuild Databuild=new TestDatabuild();

    @Given("the user provides valid login details {string} {string}")
    public void the_user_provides_valid_login_details(String email, String passsword) throws IOException {
        RequestSpecification Get_requestspecs = get_requestspec();
        requestlogin = given().
                spec(Get_requestspecs).
                body(Databuild.Payload_Login(email, passsword).Loginrequest());
    }
    @When("the user sends a POST HTTP request to log in")
    public void the_user_sends_a_post_http_request_to_log_in() {
        Response reqlogin = requestlogin.when().post("/auth/login").
                then().
                log().all().extract().response();
        Login_response = reqlogin.as(LoginResponsse.class);
        Login_response.statuscode=reqlogin.statusCode();
    }
    @Then("the API call should be successful with status code {int}")
    public void the_api_call_should_be_successful_with_status_code(int int1) throws IOException {
        if (int1 == 200) {
            assertEquals(Login_response.statuscode, int1);
            assertNotNull(Login_response.getToken());
            setAuthToken(Login_response.getToken());
            setUserId(Login_response.getUserId());
            System.out.println(getAuthToken());

        }
        else {
            TestDatabuild Databuild2=new TestDatabuild();
            Login login_payloadData=Databuild2.Payload_Login("mohebashraf46@gmail.com", "Moheb 1997");
            System.out.println(login_payloadData.Loginrequest());
            Login_response= given().
                    spec(get_requestspec()).
                    body(login_payloadData.Loginrequest()).when().post("/auth/login").
                    then().
                    log().all().extract().
                    response().as(LoginResponsse.class);

            setAuthToken(Login_response.getToken());
            setUserId(Login_response.getUserId());

        }
    }


}
