package org.example.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.CoinMarketCapMethods.CoinMarketCapMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinMarketCapSteps {

    private static ResponseOptions<Response> response;

    @Given("^I get CrytocurrencyMap information for \"([^\"]*)\" by API Key \"([^\"]*)\" with query parameters as$")
    public void iGetCrytocurrencyMapInformationForByAPIKeyWithQueryParametersAs(String url, String apiKey, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        Map<String, String> queryParams1 = new HashMap<>();
        queryParams1.put("start", data.get(1).get(0));

        Map<String, String> queryParams2 = new HashMap<>();
        queryParams2.put("limit", data.get(1).get(1));

        response = CoinMarketCapMethod.GetOpsWithAPIKey(url, apiKey, queryParams1, queryParams2);

        System.out.println("RESPONSE" + response.getBody().jsonPath().get("data"));

    }
}
