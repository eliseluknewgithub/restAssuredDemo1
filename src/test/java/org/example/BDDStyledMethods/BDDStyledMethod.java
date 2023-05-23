package org.example.BDDStyledMethods;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.apache.tools.ant.types.Assertions;
import org.hamcrest.core.Is;
import org.testng.Assert;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;

public class BDDStyledMethod{

    private static Response response;

    public static void performContainsCollection(){

                given().contentType(ContentType.JSON)
                .when().get("http://localhost:3000/posts/")
                .then().body("author",containsInAnyOrder("typicode", "Executiveautomation", "ExecuteAutomation","ExecuteAutomation","45678"))
                .statusCode(200);

//                response = given().contentType(ContentType.JSON)
//                        .when().get(String.format("http://localhost:3000/posts/"))
//                        .then()
//                        .extract().response();
//
//                System.out.println("GET response" + response.jsonPath().getList("author"));


    }



    public static void performPathParameter(){
        response = given()
                .contentType(ContentType.JSON).
                with()
                .pathParams("post",1).
                when()
                .get("http://localhost:3000/posts/{post}").
                then().
                extract().response();

//        given()
//                .contentType(ContentType.JSON).
//                with()
//                .pathParams("post",1).
//                when()
//                .get("http://localhost:3000/posts/{post}").
//                then()
//                .body("author",containsString("typicode"));
    }

    public static void checkGetWithPathParameterResponse(){
        System.out.println("GET Response1" + response.jsonPath().getInt("id"));
        System.out.println("GET Response1" + response.jsonPath().getString("author"));
        Assert.assertEquals(response.jsonPath().getString("author"), "typicode");
    }

    public static void performQueryParameter(){
        response = given()
                .contentType(ContentType.JSON)
                .queryParam("id", 2).
                when()
                .get("http://localhost:3000/posts/")
                .then()
                .extract().response();
//       given()
//                .contentType(ContentType.JSON)
//                .queryParam("id", 1).
//                        when()
//                .get("http://localhost:3000/posts/")
//                .then()
//                .body("author",hasItem("typicode"));

    }

    public static void checkGetWithQueryParamsResponse(){
        System.out.println("GET Response2" + response.jsonPath().getString("author"));
        System.out.println("GET Response2" + response.jsonPath().getString("author[0]"));
        Assert.assertEquals(response.jsonPath().getString("author[0]"), "Executiveautomation");
    }

    public static void PerformPOSTWithBodyParameter(){
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("id","4");
        postContent.put("title", "Robotium Courses");
        postContent.put("author", "ExecuteAutomation");

        System.out.println("postContent" + postContent);

        response = given()
                .contentType(ContentType.JSON).
                with()
                .body(postContent).
                when()
                .post("http://localhost:3000/posts").
                then()
                .extract().response();

        System.out.println("Post Response" + response.jsonPath().getString("author"));
        Assert.assertEquals(response.jsonPath().getString("author"),"ExecuteAutomation");

//        given()
//                .contentType(ContentType.JSON).
//                with()
//                .body(postContent).
//                when()
//                .post("http://localhost:3000/posts").
//                then()
//                .body("author", Is.is("ExecuteAutomation"));

    }

    public static void PerformPUTWithBodyParameter(){
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("id","4");
        postContent.put("title", "ABC");
        postContent.put("author", "ExecuteAutomation");

        System.out.println("postContent" + postContent);

        response =given()
                .contentType(ContentType.JSON).
                with()
                .body(postContent).
                when()
                .put("http://localhost:3000/posts/4").
                then()
                .extract().response();

        System.out.println("PUT Response" + response.jsonPath().getString("title"));
        Assert.assertEquals(response.jsonPath().getString("title"), "ABC");

//        given()
//                .contentType(ContentType.JSON).
//                with()
//                .body(postContent).
//                when()
//                .put("http://localhost:3000/posts/4").
//                then()
//                  .body("title", Is.is("ABC"));

    }

    public static void PerformDelete(){

        response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("http://localhost:3000/posts/4")
                .then()
                .extract().response();

        System.out.println("response" + response);
        Assert.assertEquals(response.statusCode(),200);



//        given()
//                .contentType(ContentType.JSON).
//                when()
//                .delete("http://localhost:3000/posts/4").
//                then()
//                .extract().response();

    }





}
