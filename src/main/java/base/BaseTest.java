package base;
import static base.WebDriverManager.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import util.GetProperty;

import java.io.IOException;

public class BaseTest{

     @BeforeMethod
     public void startBrowser() throws IOException {

         setDriver(new ChromeDriver());
         getDriver().manage().window().maximize();
         getDriver().get(GetProperty.getPropertyValue("url"));

     }


     @AfterMethod
     public void tearDown(){

         if(getDriver() != null){
               getDriver().quit();
               unload();

         }
     }
}

