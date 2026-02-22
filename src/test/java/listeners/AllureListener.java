package listeners;

import base.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static base.WebDriverManager.*;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        if (WebDriverManager.getDriver() != null) {
            captureScreenshot("Failure Screenshot for: " + result.getName());
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        if (WebDriverManager.getDriver() != null) {
            captureScreenshot("Skipped Screenshot");
        }
    }


    private void captureScreenshot(String attachmentName) {
        try {
            byte[] screenshot = ((TakesScreenshot) getDriver()) .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(screenshot), "png");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}