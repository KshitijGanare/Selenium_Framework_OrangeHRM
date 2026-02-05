package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static base.WebDriverManager.*;

public class TakeScreenshot {

     public static void getScreenshot(String methodName) throws IOException {

         String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

         TakesScreenshot tks = (TakesScreenshot) getDriver();
         File source = tks.getScreenshotAs(OutputType.FILE);
         File destination = new File("failed-screenshots/Failed--" + methodName + "-" + timeStamp + ".png");
         FileHandler.copy(source, destination);

         System.out.println("Screenshot saved to: " + destination.getAbsolutePath());

     }

}
