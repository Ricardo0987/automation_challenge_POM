package com.automation.definitions;

import com.automation.steps.MobileSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MobileDefinitions {


    @Steps
    MobileSteps mobileSteps;

    @Given("^The user is in the length option$")
    public void theUserIsInTheLengthOption() {
        mobileSteps.openLengthOption();
    }

    @Given("^The user is in the speed option$")
    public void theUserIsInTheSpeedOption() throws InterruptedException {
        mobileSteps.openSpeedOption();
    }

    @When("^Select to convert \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void selectToConvert(String unit, String measure1, String measure2) {
        mobileSteps.selectMeasures(unit, measure1, measure2);
    }

    @Then("^The app shows the correct \"([^\"]*)\"$")
    public void theAppShowsTheCorrectAnswer(String answer) {
        mobileSteps.validateAnswer(answer);
    }

}
