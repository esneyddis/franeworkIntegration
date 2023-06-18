package com.base;

import com.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
    public static Properties config = new Properties();
    public static FileInputStream file;
    public static Logger log = Logger.getLogger("devapp");

    @FindBy(id = "login2")
    WebElement loginOption;


    public BasePage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(80));
         PageFactory.initElements(driver, this);
    }

    public static String getProperties(String propName){
        try {
            log.debug("Getting properties values");
            config = new Properties();
            file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
            config.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return config.getProperty(propName);
    }

    public BasePage openPage() {
        log.debug("Opening url");
        driver.get(getProperties("urlName"));
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
