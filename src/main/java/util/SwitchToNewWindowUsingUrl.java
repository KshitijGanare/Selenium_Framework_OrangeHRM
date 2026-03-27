package util;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchToNewWindowUsingUrl{

    public static void switchToWindow(WebDriver driver, String goToUrl) {

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String handles: allWindows) {

            driver.switchTo().window(handles);

            if ((driver.getCurrentUrl()).contains(goToUrl)) {
                return; // Exit the method once found
            }

        }

        System.out.println("Target URL not found. Switching back to parent window.");
        driver.switchTo().window(parentWindow);

    }

}


