package org.example.CoinMarketCapMethods;

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

public class CoinMarketCapMethod {

    public static RequestSpecification Request;

    public CoinMarketCapMethod() {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://pro-api.coinmarketcap.com/v1");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> GetOpsWithAPIKey(String url,String apiKey, Map<String, String> queryParams1, Map<String, String> queryParams2) {
        try{
            Request.header(new Header("X-CMC_PRO_API_KEY", apiKey));
            Request.queryParams(queryParams1);
            Request.queryParams(queryParams2);
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
