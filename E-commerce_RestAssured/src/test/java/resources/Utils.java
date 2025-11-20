package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

import static resources.TestContext.getAuthToken;

public class Utils {
    RequestSpecification Get_requestspecs;
    static RequestSpecification post_requestspecs;
    static RequestSpecification post_requestspecs_json;

    public static String Get_GlobalData(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/Global.properties");
        prop.load(fis);
        prop.setProperty("email", prop.getProperty("email"));
        prop.setProperty("password", prop.getProperty("password"));
        prop.setProperty("BASE_URI", prop.getProperty("BASE_URI"));
        System.out.println(prop.getProperty(key));
        return prop.getProperty(key);
    }

    public RequestSpecification get_requestspec() throws IOException {
        if (Get_requestspecs == null) {
            PrintStream stream = new PrintStream(new FileOutputStream("Logging.txt"));
            Get_requestspecs = new RequestSpecBuilder()
                    .setBaseUri(Get_GlobalData("BASE_URI")).setContentType(ContentType.JSON).
                    addFilter(RequestLoggingFilter.logRequestTo(stream)).
                    addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .build();
            return Get_requestspecs;

        } else return Get_requestspecs;

    }


    public static RequestSpecification  post_requestspec() throws IOException {
        if (post_requestspecs == null) {
            PrintStream stream = new PrintStream(new FileOutputStream("Logging2.txt"));
            post_requestspecs = new RequestSpecBuilder()
                    .setBaseUri(Get_GlobalData("BASE_URI")).addHeader("authorization", getAuthToken())
                    .addFilter(RequestLoggingFilter.logRequestTo(stream)).
                    addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .build();
            return post_requestspecs;

        }


        return post_requestspecs;

    }
    public static RequestSpecification  post_requestspec_json_content() throws IOException {
        if (post_requestspecs_json == null) {
            PrintStream stream = new PrintStream(new FileOutputStream("Logging3.txt"));
            post_requestspecs_json = new RequestSpecBuilder()
                    .setBaseUri(Get_GlobalData("BASE_URI")).
                    addHeader("authorization", getAuthToken())
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .setContentType(ContentType.JSON)
                    .build();
            return post_requestspecs_json;

        }


        return post_requestspecs_json;

    }

}