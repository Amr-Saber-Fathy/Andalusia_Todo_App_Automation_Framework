package testLinsteners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class SystemListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        // Retrieve the driver attribute we set in the test class
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        ScreenshotUtils.captureScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Case Passed");
    }
}
