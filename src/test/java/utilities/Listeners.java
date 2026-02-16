package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class Listeners implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {
            String path = ScreenshotUtil.captureScreenshot(BaseClass.getDriver(),
                    result.getMethod().getMethodName());

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}


/*
 When test fails:

TestNG passes failed test object → result.getInstance()

We cast:

failed test → BaseClass → getDriver()


Now listener gets REAL browser driver.

This is how enterprise frameworks do it.

📊 Why Your Design Failed

You thought:

Listener extends BaseClass → same driver


Reality:

TestNG creates:
TestClass instance → has driver
Listener instance → separate object → driver null


--->

Registration Successful
Registered Email: 176c3@gmail.com
Feb 15, 2026 12:41:31 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find CDP implementation matching 145
Feb 15, 2026 12:41:31 PM org.openqa.selenium.chromium.ChromiumDriver lambda$new$5
WARNING: Unable to find version of CDP to use for 145.0.7632.75. You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.18.1` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
Login Successful
Feb 15, 2026 12:41:36 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find CDP implementation matching 145
Feb 15, 2026 12:41:36 PM org.openqa.selenium.chromium.ChromiumDriver lambda$new$5
WARNING: Unable to find version of CDP to use for 145.0.7632.75. You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.18.1` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
Screenshot captured for failed test: verifyAddToCart
Feb 15, 2026 12:41:42 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find CDP implementation matching 145
Feb 15, 2026 12:41:42 PM org.openqa.selenium.chromium.ChromiumDriver lambda$new$5
WARNING: Unable to find version of CDP to use for 145.0.7632.75. You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.18.1` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
Logout Successful

===============================================
EcommerceSuite
Total tests run: 4, Passes: 3, Failures: 1, Skips: 0
===============================================
 
 */
