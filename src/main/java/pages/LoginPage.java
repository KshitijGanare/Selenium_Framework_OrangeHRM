package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GetProperty;

import static base.WebDriverManager.*;
import static util.GetProperty.*;


import java.io.IOException;
import java.time.Duration;


public class LoginPage{

    @FindBy(xpath = "//input[@name=\"username\"]") private WebElement usernameInputField;
    @FindBy(xpath = "//input[@type=\"password\"]") private WebElement passwordInputField;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(normalize-space(),\"Forgot\")]") private WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@name=\"username\"]") private WebElement forgetPsrdInputField;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement resetPsrdBtn;

    WebDriverWait wait;

    public LoginPage(){
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    public String verifyLoginWithValidCredentials() throws IOException {

        wait.until(ExpectedConditions.visibilityOf(loginBtn));

        usernameInputField.sendKeys(GetProperty.getPropertyValue("username"));
        passwordInputField.sendKeys(GetProperty.getPropertyValue("password"));
        loginBtn.click();

        try {
            wait.until(ExpectedConditions.urlContains("dashboard"));
        }catch (TimeoutException e){
            e.printStackTrace();
        }

        return getDriver().getCurrentUrl();

    }


    public String verifyLoginWithInvalidCredentials() throws IOException, InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(loginBtn));

        Thread.sleep(5000);
        usernameInputField.clear();
        usernameInputField.sendKeys("Admin");
        passwordInputField.clear();
        passwordInputField.sendKeys("1234");
        loginBtn.click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));

        return element.getText();

    }

    public boolean verifyForgetPassword() throws IOException {

        forgotPasswordLink.click();

        wait.until(ExpectedConditions.visibilityOf(forgetPsrdInputField));
        forgetPsrdInputField.sendKeys(GetProperty.getPropertyValue("username"));
        resetPsrdBtn.click();

        WebElement resetConfirationMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[contains(normalize-space(),'Reset')]")));

        return resetConfirationMsg.isDisplayed();

    }

    public String verifyLoginWithMultipleCredentials(String username, String password) throws IOException {

        wait.until(ExpectedConditions.visibilityOf(loginBtn));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginBtn.click();

        try {
            wait.until(ExpectedConditions.urlContains("dashboard"));
        }catch (TimeoutException e){
            e.printStackTrace();
        }

        return getDriver().getCurrentUrl();

    }

}
