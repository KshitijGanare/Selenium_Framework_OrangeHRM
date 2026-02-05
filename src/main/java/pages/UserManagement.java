package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import static base.WebDriverManager.*;

public class UserManagement {

    @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li/a") private List<WebElement> navMenuListOptions;

    LoginPage login;
    WebDriverWait wait;


    public UserManagement(){
        PageFactory.initElements(getDriver(), this);
        login = new LoginPage();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    }



    public boolean verifyAddUser() throws IOException, InterruptedException {

        login.verifyLoginWithValidCredentials();

        List<WebElement> navList = new LinkedList<>(navMenuListOptions);

        By adminLocator = By.xpath("//ul[@class=\"oxd-main-menu\"]/li/a[contains(normalize-space(.),'Admin')]");
        WebElement adminOption = wait.until(ExpectedConditions.elementToBeClickable(adminLocator));
        adminOption.click();

        try {
            wait.until(ExpectedConditions.urlContains("viewSystemUsers"));
        }catch (Exception e){
            System.out.println("Url not appeared!");
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"button\" and contains(normalize-space(),\"Add\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),\"Select\")])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),\"Admin\")])"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Type for hints...\"]"))).sendKeys("Ranga");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"option\"]/span[contains(text(),\"Ranga\")]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),\"Enabled\")])"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/ancestor::div[1]/following-sibling::div//input"))).sendKeys("Ranga billa");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Password']/ancestor::div[1]/following-sibling::div//input"))).sendKeys("Test@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/ancestor::div[1]/following-sibling::div[1]//input"))).sendKeys("Test@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();

        List<WebElement> list =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role=\"row\"]/div[@role='cell'][2]")));

        for (WebElement name : list){

            if (name.getText().contains("billa")){
                System.out.println("User added" + name.getText());
                return true;
            }

        }

        return false;
    }

}
