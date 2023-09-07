package com.base;

import com.api.AbstractTest;
import com.listeners.TestListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({TestListeners.class})
public class BaseTest extends AbstractTest {

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Create a Chrome driver. All test classes use this.
        if (driver == null) {
            if (getProperties("browser").equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--ignore-ssl-errors=yes");
                options.addArguments("--ignore-certificate-errors");
                options.setExperimentalOption("useAutomationExtension", false);
                WebDriverManager.chromedriver().browserVersion("116.0").setup();
                if (getProperties("grid").equals("on")) {
                    URL remoteURL = new URL("http://localhost:4444");
                    driver = new RemoteWebDriver(remoteURL, options);
                } else {
                    driver = new ChromeDriver(options);
                }
            } else if (getProperties("browser").equals("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                if (getProperties("grid").equals("on")) {
                    URL remoteURL = new URL("http://localhost:4444");
                    driver = new RemoteWebDriver(remoteURL, firefoxOptions);
                } else {
                    driver = new FirefoxDriver(firefoxOptions);
                }
            }
        }
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
