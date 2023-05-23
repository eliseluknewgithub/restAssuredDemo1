package org.example.NonBDDReusableMethods;


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

public class NonBDDReusableMethod {

    public static RequestSpecification Request;

    public NonBDDReusableMethod() {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }


    public static ResponseOptions GetOps(String url) throws URISyntaxException {
        // Act
        try {
            return Request.get(new URI(url));
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> GetWithQueryParams(String url, Map<String, String> queryParams) {
        Request.queryParams(queryParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body) {
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {

        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);

    }

    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {

        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);

    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        return Request.delete(url);
    }



}
