package org.example.BossiniMethods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BossiniMethod {
    private static ResponseOptions<Response> response;
//    public static RequestSpecification Request;

//    public BossiniMethod() {
//        //Arrange
//        RequestSpecBuilder builder = new RequestSpecBuilder();
//        builder.setBaseUri("http://ecoupon-uat-alb-1640614212.ap-southeast-1.elb.amazonaws.com/api");
//        builder.setContentType(ContentType.JSON);
//        RequestSpecification requestSpec = builder.build();
//        Request = RestAssured.given().spec(requestSpec);
//    }
//
//    public static ResponseOptions postWithHeader(String url, String password) throws URISyntaxException {
//            Request.header(new Header("password", password));
//            return Request.get(new URI(url));
//
//    }
    public static ResponseOptions<Response> postWithHeader(String url, String password) {

        return response = given()
                        .contentType(ContentType.JSON).
                        header("password",password).
                        when()
                        .post("http://ecoupon-uat-alb-1640614212.ap-southeast-1.elb.amazonaws.com/api" + url).
                        then().
                        extract().response();
    }




}
