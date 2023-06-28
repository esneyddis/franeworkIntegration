package com.utilities;

import com.api.AbstractTest;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
@Log4j
public class TestUtils extends AbstractTest {

    public static String screenShotName;

    public static void takeScreenshot(ITestResult result) throws IOException {
        if(driver != null) {
            log.info("Taking screenshot");
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("srcFile = " + srcFile);
            screenShotName = result.getName() + ".jpg";
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshot/" + screenShotName));
        } else {
            log.info("Driver is null not screenshot was taken");
        }

    }
}
