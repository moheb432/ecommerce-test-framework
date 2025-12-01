package resources;

import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.Login;
import org.example.LoginResponsse;

import java.io.IOException;

import static resources.Utils.Get_GlobalData;

public class TestDatabuild {
    public Login Payload_Login(String email, String password) throws IOException {

        Login loginPayload = new Login();
        loginPayload.setEmail(email);
        loginPayload.setPassword(password);
        return loginPayload;
        }
}
