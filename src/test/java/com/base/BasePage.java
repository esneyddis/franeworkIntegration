package com.base;

import com.page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
@Slf4j
public class BasePage {

    /**
     * Supper class for all the test cases, all the inicialization would be done in this class
     * WebDriver - done
     * RestAssured
     * Wiremock
     * Properties - done
     * Logs
     * Extend Report
     * Db
     * add set up method and tearDown - done
     */
    protected WebDriver driver;
    public WebDriverWait wait;


    @FindBy(id = "login2")
    WebElement loginOption;


    public BasePage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(80));
         PageFactory.initElements(driver, this);
    }



    public BasePage openPage(String url) {
        log.debug("Opening url");
        driver.get(url);
        return this;
    }

    public LoginPage goToLogin() {
        click(loginOption);
        return new LoginPage(driver);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }




}
