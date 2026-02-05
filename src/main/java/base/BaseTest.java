package base;
import static base.WebDriverManager.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import util.GetProperty;
import util.TakeScreenshot;

import java.io.IOException;

import static base.WebDriverManager.*;

public class BaseTest{

     @BeforeMethod
     public void startBrowser() throws IOException {

         setDriver(new ChromeDriver());
         getDriver().manage().window().maximize();
         getDriver().get(GetProperty.getPropertyValue("url"));

     }


     @AfterMethod
     public void tearDown(ITestResult itr) throws IOException {

         if(getDriver() != null){

//             if (itr.getStatus() == ITestResult.FAILURE) {
//                   TakeScreenshot.getScreenshot(itr.getName());
//             }

               getDriver().quit();
               unload();

            }
     }
}

