package org.example.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.NonBDDReusableMethods.NonBDDReusableMethod;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class NonBDDReusableMethodsSteps {
    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation for \"([^\"]*)\" by Non BDD Reusable Method$")
    public void iPerformGETOperationForByNonBDDReusableMethod(String url) throws Throwable {
        response = NonBDDReusableMethod.GetOps(url);
    }

    @Then("^I should see the author names through Non BDD Reusable Method$")
    public void iShouldSeeTheAuthorNamesThroughNonBDDReusableMethod() {
        System.out.println(response.getBody().jsonPath().get("author"));
        System.out.println(response.getBody().jsonPath().get("author[0]"));
        Assert.assertEquals(response.getBody().jsonPath().get("author[0]"), "typicode");
    }

    @And("^I perform GET operation for \"([^\"]*)\" with query params by Non BDD Reusable Method$")
    public void iPerformGETOperationForWithQueryParamsByNonBDDReusableMethod(String url, DataTable table) throws Throwable {

        List<List<String>> data = table.raw();
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", data.get(1).get(0));
        System.out.println("queryParams1: " + queryParams );
        // http://localhost:3000/posts?id=1

        response = NonBDDReusableMethod.GetWithQueryParams(url, queryParams);
    }

    @Then("^I should see one author name through Non BDD Reusable Method$")
    public void iShouldSeeOneAuthorNameThroughNonBDDReusableMethod() {
//        Assert.assertEquals(response.getBody().jsonPath().get("author"), "typicode");
        Assert.assertEquals(response.getBody().jsonPath().get("author[0]"), "typicode");
    }

    @And("^I perform GET operation for \"([^\"]*)\" with path params by Non BDD Reusable Method$")
    public void iPerformGETOperationForWithPathParamsByNonBDDReusableMethod(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(1).get(0));
        System.out.println("pathParams1: " + pathParams );
        // http://localhost:3000/posts/1

        response = NonBDDReusableMethod.GetWithPathParams(url, pathParams);
    }

    @Then("^I should see one author name with path params through Non BDD Reusable Method$")
    public void iShouldSeeOneAuthorNameWithPathParamsThroughNonBDDReusableMethod() {
        Assert.assertEquals(response.getBody().jsonPath().get("author"), "typicode");
    }

    @Given("^I Perform Post operation for \"([^\"]*)\" with body by Non BDD Reusable Method$")
    public void iPerformPostOperationForWithBodyByNonBDDReusableMethod(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        System.out.println("DATA" +  data);

        Map<String, String> body = new HashMap<>();

        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        System.out.println("body" + body);

        response = NonBDDReusableMethod.PostOpsWithBody(url,body);
    }

    @Then("^I should see the body has title as \"([^\"]*)\" by Non BDD Reusable Method$")
    public void iShouldSeeTheBodyHasTitleAsByNonBDDReusableMethod(String title) throws Throwable {
        System.out.println(response.getBody().jsonPath().get("title"));
        Assert.assertEquals(response.getBody().jsonPath().get("title"), title);
    }

    @Given("^I Perform Post operation for \"([^\"]*)\" with body$")
    public void iPerformPostOperationForWithBody(String url, DataTable table) throws Throwable {

        List<List<String>> data = table.raw();

        System.out.println("dataTable" + data);

        HashMap<String, String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));
        System.out.println("body" + body);

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("profileNo", data.get(1).get(1));
        System.out.println("pathParams" + pathParams);

        response = NonBDDReusableMethod.PostOpsWithBodyAndPathParams(url, pathParams, body);
        System.out.println("RESPONSE" + response);

    }

    @Then("^I should see the body has name as \"([^\"]*)\" by Non BDD Reusable Method$")
    public void iShouldSeeTheBodyHasNameAsByNonBDDReusableMethod(String name) throws Throwable {
        Assert.assertEquals(response.getBody().jsonPath().get("name"), name);
    }


    @Given("^I ensure to Perform POST operation for \"([^\"]*)\" by Non BDD Reusable Method with body as$")
    public void iEnsureToPerformPOSTOperationForByNonBDDReusableMethodWithBodyAs(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        HashMap<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));
        System.out.println("body1" + body);

        NonBDDReusableMethod.PostOpsWithBody(url, body);


    }

    @And("^I Perform PUT operation  by Non BDD Reusable Method for \"([^\"]*)\" with body as$")
    public void iPerformPUTOperationByNonBDDReusableMethodForWithBodyAs(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        HashMap<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));
        System.out.println("body2" + body);

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));
        System.out.println("pathParams2" + pathParams);

        NonBDDReusableMethod.PUTOpsWithBodyAndPathParams(url, pathParams, body);


    }

    @And("^I perform GET operation with path parameter by Non BDD Reusable Method for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterByNonBDDReusableMethodFor(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));
        System.out.println("pathParams3" + pathParams);

        response = NonBDDReusableMethod.GetWithPathParams(url, pathParams);

    }

    @Then("^I should see the body with title as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyWithTitleAs(String title) throws Throwable {
        System.out.println("TITLE"  + response.getBody().jsonPath().get("title"));
        Assert.assertEquals(response.getBody().jsonPath().get("title"), title);
    }

    @Given("^I Perform DELETE operation for \"([^\"]*)\" by Non BDD Reusable Method$")
    public void iPerformDELETEOperationForByNonBDDReusableMethod(String url, DataTable table) throws Throwable {

        List<List<String>> data = table.raw();

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));
        System.out.println("pathParams" + pathParams);

        response = NonBDDReusableMethod.DeleteOpsWithPathParams(url, pathParams);

    }

    @Then("^I should not see the body with title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithTitleAs(String title) throws Throwable {
        Assert.assertNull(response.getBody().jsonPath().get("title"));
    }
}
