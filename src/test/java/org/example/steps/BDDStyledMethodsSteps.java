package org.example.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.example.BDDStyledMethods.BDDStyledMethod;

public class BDDStyledMethodsSteps {
    @Given("^I perform GET operation for \"([^\"]*)\" by BDD styled method$")
    public void iPerformGETOperationForByBDDStyledMethod(String url) {

    }

    @Then("^I should see the author names through BDD styled method$")
    public void iShouldSeeTheAuthorNamesThroughBDDStyledMethod() {

        BDDStyledMethod.performContainsCollection();

    }

    @Given("^I perform GET operation for \"([^\"]*)\" with path params by BDD styled method$")
    public void iPerformGETOperationForWithPathParamsByBDDStyledMethod(String arg0) throws Throwable {
        BDDStyledMethod.performPathParameter();
    }

    @Then("^I should see the author name with one path params through BDD styled method$")
    public void iShouldSeeTheAuthorNameWithOnePathParamsThroughBDDStyledMethod() {
        BDDStyledMethod.checkGetWithPathParameterResponse();
    }

    @Given("^I perform GET operation for \"([^\"]*)\" with query params by BDD styled method$")
    public void iPerformGETOperationForWithQueryParamsByBDDStyledMethod(String arg0) throws Throwable {
        BDDStyledMethod.performQueryParameter();
    }

    @Then("^I should see the author name with one query params through BDD styled method$")
    public void iShouldSeeTheAuthorNameWithOneQueryParamsThroughBDDStyledMethod() {
        BDDStyledMethod.checkGetWithQueryParamsResponse();
    }

    @Given("^I perform POST operation for \"([^\"]*)\" by BDD styled method$")
    public void iPerformPOSTOperationForByBDDStyledMethod(String arg0) throws Throwable {
      BDDStyledMethod.PerformPOSTWithBodyParameter();
    }

    @Given("^I perform PUT operation for \"([^\"]*)\" by BDD styled method$")
    public void iPerformPUTOperationForByBDDStyledMethod(String arg0) throws Throwable {
      BDDStyledMethod.PerformPUTWithBodyParameter();
    }

    @Given("^I perform DELETE operation for \"([^\"]*)\" by BDD styled method$")
    public void iPerformDELETEOperationForByBDDStyledMethod(String arg0) throws Throwable {
      BDDStyledMethod.PerformDelete();
    }
}
