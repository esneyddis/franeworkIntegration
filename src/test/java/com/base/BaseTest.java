package com.base;

import com.api.AbstractTest;
import com.listeners.TestListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListeners.class})
public class BaseTest extends AbstractTest {

    @BeforeClass
    public void setup() {
        // add switch with all the browser options
        WebDriverManager.chromedriver().setup();
        //Create a Chrome driver. All test classes use this.
        if(driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
