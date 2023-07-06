package com.api;

import com.listeners.TestListeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utilities.ExtentReportMag;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Log4j
@Listeners({TestListeners.class})
public class AbstractTest {
    public static WebDriver driver;
    public ExtentReports extentReports = ExtentReportMag.getInstance();
    public ExtentTest extentTest;
    public AllServices services;


    @BeforeClass
    public void apiSetUp() {
        if (services == null) {
            services = new AllServices();
        }
    }

}
