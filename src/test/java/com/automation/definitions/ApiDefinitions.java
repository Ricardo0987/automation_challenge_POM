package com.automation.definitions;

import com.automation.steps.ApiSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ApiDefinitions {

    @Steps
    ApiSteps apiSteps;


    @Given("^the \"([^\"]*)\" endPoint exists$")
    public void theCharacterEndPointExists(String pathUrl) {
        apiSteps.prepareData(pathUrl);
    }

    @When("^I consume the Api(.+)$")
    public void iConsumeTheApi(String data) {
        apiSteps.consumeTheApi(data);
    }

    @Then("^Check status (.+)$")
    public void checkStatus(int statusCode) {
        apiSteps.checkStatus(statusCode);
    }

    @And("^Check response from character Api(.+)$")
    public void checkResponseFromCharacterApi(String expectedResponse) {
        apiSteps.checkCharacterResponse(expectedResponse);
    }

    @And("^Check response from location Api(.+)$")
    public void checkResponseFromLocationApi(String expectedResponse) {
        apiSteps.checkResponseFromLocationApi(expectedResponse);
    }
    @And("^Check response from episode Api(.+)$")
    public void checkResponseFromEpisodeApi(String expectedResponse) {
        apiSteps.checkResponseFromEpisodeApi(expectedResponse);
    }
}
