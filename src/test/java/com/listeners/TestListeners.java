package com.listeners;


import com.api.AbstractTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.TestUtils;
import lombok.extern.log4j.Log4j;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Log4j
public class TestListeners extends AbstractTest implements ITestListener, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Starting test " + result.getName());
        extentTest = extentReports.startTest(result.getName());
        Reporter.log("Starting test " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, result.getName() + ": " + "PASSED");
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("This test have failed: " + result.getName() + " " + result.getThrowable());
        Reporter.log("This test have failed: " + result.getName() + " " + result.getThrowable());
        try {
            TestUtils.takeScreenshot(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.log(LogStatus.FAIL, result.getName() + ": " + "FAILED");
        extentReports.endTest(extentTest);
        extentReports.flush();
        log.info("Test have failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }


    @Override
    public void onStart(ITestContext context) {
        extentTest = extentReports.startTest(context.getName());
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.getName().equals("test")) {
            log.info("Changing invocation for the following method: " + testMethod.getName());
            annotation.setInvocationCount(1);

        }
    }
}
