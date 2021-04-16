package com.automation.pageObjects;


import com.automation.utils.MyCustomDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PrincipalPage extends PageObject {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    public WebElementFacade menuButton;
    @FindBy(xpath = "(//*[@resource-id=\"com.ba.universalconverter:id/select_unit_spinner\"])[1]")
    public WebElementFacade measure1;
    @FindBy(xpath = "(//*[@resource-id=\"com.ba.universalconverter:id/select_unit_spinner\"])[2]")
    public WebElementFacade measure2;
    @FindBy(xpath = "//*[@resource-id=\"com.ba.universalconverter:id/action_bar\"]/android.widget.TextView\n")
    public WebElementFacade labelName;
    @FindBy(xpath = "//*[@resource-id=\"com.ba.universalconverter:id/drawerCategoryName\" and contains(@text,\"Length\")]")
    public WebElementFacade lengthItemMenu;
    @FindBy(xpath = "//*[@resource-id=\"com.ba.universalconverter:id/drawerCategoryName\" and contains(@text,\"Speed\")]")
    public WebElementFacade speedItemMenu;
    @FindBy(xpath = "//*[@resource-id=\"com.ba.universalconverter:id/target_value\"]")
    public WebElementFacade answer;
    @FindBy(xpath = "//*[@resource-id=\"com.ba.universalconverter:id/category_list_drawer\"]")
    public WebElementFacade leftMenu;


    public void openLengthOption() {
        if (!labelName.getText().equals("Length")) {
            menuButton.waitUntilVisible();
            menuButton.click();
            lengthItemMenu.click();
        }
        Assert.assertThat(labelName.getText(), Matchers.is("Length"));
    }

    public void openSpeedOption() throws InterruptedException {
        menuButton.waitUntilVisible();
        menuButton.click();
        scrollDown();
        speedItemMenu.click();
        Assert.assertThat(labelName.getText(), Matchers.is("Speed"));
    }


    public void selectMeasures(String unit, String measure1, String measure2) {
        unitSymKeys(unit);
        this.measure1.click();
        unitMeasure(measure1).click();
        this.measure2.click();
        unitMeasure(measure2).click();
    }


    public void validateAnswer(String answerStr) {
        Assert.assertThat(answer.getText(), Matchers.is(answerStr));
    }


    private WebElement unitMeasure(String measure) {
        return getDriver().findElement(By.xpath("//*[@resource-id=\"com.ba.universalconverter:id/select_unit_spinner_menu_symbol\" and contains(@text,\"(" + measure + ")\")]"));
    }

    private void unitSymKeys(String unit) {
        int lengthUnit = unit.length();

        for (int i = 0; i < lengthUnit; i++) {
            WebElement key = getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,\"" + unit.charAt(i) + "\")]"));
            key.click();
        }

    }

    private void scrollDown() throws InterruptedException {
        Thread.sleep(2000);
        AppiumDriver driver = MyCustomDriver.getDriver();
        Dimension size = driver.manage().window().getSize();
        int width = size.width / 2;
        int startPoint = (int) (size.getHeight() * 0.80);
        int endPoint = (int) (size.getHeight() * 0.20);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
    }

}







