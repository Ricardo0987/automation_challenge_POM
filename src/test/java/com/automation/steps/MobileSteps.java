package com.automation.steps;

import com.automation.pageObjects.PrincipalPage;
import net.thucydides.core.pages.PageObject;


public class MobileSteps extends PageObject {
    PrincipalPage principalPage;

    public void openLengthOption() {
        principalPage.openLengthOption();
    }

    public void openSpeedOption() throws InterruptedException {
        principalPage.openSpeedOption();
    }

    public void selectMeasures(String unit, String measure1, String measure2) {
        principalPage.selectMeasures(unit, measure1, measure2);
    }

    public void validateAnswer(String answerStr) {
        principalPage.validateAnswer(answerStr);
    }
}
