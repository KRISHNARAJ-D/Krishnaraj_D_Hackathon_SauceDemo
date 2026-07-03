package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        
        System.out.println("Execution Started");

    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Running Test : " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASSED : " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED : " + result.getName());

        System.out.println("Reason : " + result.getThrowable());

        ScreenshotUtil.captureScreenshot(
                BaseTest.driver,
                result.getName());

        ScreenshotUtil.attachScreenshot(
                BaseTest.driver);

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("SKIPPED : " + result.getName());

    }

    @Override
    public void onFinish(ITestContext context) {

       
        System.out.println("Execution Finished");
      

    }

}