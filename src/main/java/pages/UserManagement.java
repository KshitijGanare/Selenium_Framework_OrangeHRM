package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static base.WebDriverManager.*;

public class UserManagement {

    LoginPage login;
    WebDriverWait wait;


    private final By adminMenu = By.xpath("//ul[@class='oxd-main-menu']/li/a[contains(normalize-space(.),'Admin')]");
    private final By addButton = By.xpath("//button[contains(.,'Add')]");

    private final By roleDropdown = By.xpath("(//div[contains(text(),'Select')])[1]");
    private final By employeeInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By suggestions = By.xpath("//div[@role='listbox']//div[@role='option']");

    private final By statusDropdown = By.xpath("(//div[contains(text(),'Select')])[1]");

    private final By usernameField = By.xpath("//label[text()='Username']/ancestor::div[1]/following-sibling::div//input");
    private final By passwordField = By.xpath("//label[text()='Password']/ancestor::div[1]/following-sibling::div//input");
    private final By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/ancestor::div[1]/following-sibling::div[1]//input");

    private final By saveButton = By.xpath("//button[@type='submit']");

    private final By userTableRows = By.xpath("//div[@role='row']/div[@role='cell'][2]");



    public UserManagement() {
        PageFactory.initElements(getDriver(), this);
        login = new LoginPage();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    }

    public boolean verifyAddUser(String role, String empName, String status,
                                 String uName, String pwd, String confirmPwd)
            throws IOException {

        login.verifyLoginWithValidCredentials();

        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton)).click();

        // Select role
        wait.until(ExpectedConditions.visibilityOfElementLocated(roleDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"))).click();

        // Employee Select
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeInput)).sendKeys("a");
        wait.until(driver -> driver.findElements(suggestions).size() > 0);

        List<WebElement> options = getDriver().findElements(suggestions);
        options.get(0).click();

        // Select Status
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='listbox']//span[text()='" + status + "']"))).click();

        // Add User details
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(pwd);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPwd);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        // Verify User Added
        List<WebElement> list =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userTableRows));

        for (WebElement name : list) {
            if (name.getText().contains(uName)) {
                return true;
            }
        }
        return false;
    }
}