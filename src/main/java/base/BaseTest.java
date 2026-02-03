package base;
import static base.WebDriverManager.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest{

     @BeforeMethod
     public void startBrowser(){

         setDriver(new ChromeDriver());
         getDriver().manage().window().maximize();
         getDriver().get("https://opensource-demo.orangehrmlive.com/");

     }


     @AfterMethod
     public void tearDown(){
         if(getDriver() != null){
             getDriver().quit();
             unload();
         }
     }

}
