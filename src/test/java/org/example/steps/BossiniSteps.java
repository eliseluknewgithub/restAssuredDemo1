package org.example.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.BossiniMethods.BossiniMethod;

public class BossiniSteps {
    private static ResponseOptions<Response> response;

    @Given("^I perform post operation for \"([^\"]*)\" with header \"([^\"]*)\"$")
    public void iPerformPostOperationForWithHeader(String url, String password) throws Throwable {
       response = BossiniMethod.postWithHeader(url, password);

       System.out.println("RESPONSE" + response.getStatusCode());
       System.out.println("RESPONSE" + response.getBody().jsonPath().get("data.memberId"));
    }


}
