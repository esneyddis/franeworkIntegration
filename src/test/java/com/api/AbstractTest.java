package com.api;

import com.listeners.TestListeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utilities.ExtentReportMag;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j
@Listeners({TestListeners.class})
public class AbstractTest {
    public static WebDriver driver;
    public ExtentReports extentReports = ExtentReportMag.getInstance();
    public ExtentTest extentTest;
    public AllServices services;
    public static Properties config = new Properties();

    public static FileInputStream file;


    @BeforeClass
    public void apiSetUp() {
        if (services == null) {
            services = new AllServices();
        }
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

}
