package com.page;

import com.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    WebElement userName;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement clickOnLoginButton;

    /**
     * BasePage class. BasePage class contains the common methods of all page
     * classes such as click, writeText, readText, assertEquals etc. Here is it’s code.
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering name")
    public LoginPage enterName(String user) {
        sendKeys(userName, user);
        return this;
    }

    @Step("Entering password")
    public LoginPage enterPassword (String pass) {
        sendKeys(password, pass);
        return this;

    }

    @Step("Clicking Login Button")
    public LoginPage clickOnLoginButton() {
        click(clickOnLoginButton);
        return this;
    }


}
