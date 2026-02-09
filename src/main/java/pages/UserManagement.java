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

    @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li/a")
    private List<WebElement> navMenuListOptions;

    LoginPage login;
    WebDriverWait wait;

    public UserManagement() {
        PageFactory.initElements(getDriver(), this);
        login = new LoginPage();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    }

    public boolean verifyAddUser(String role, String empName, String status, String uName, String pwd, String confirmPwd) throws IOException, InterruptedException {

        login.verifyLoginWithValidCredentials();

        By adminLocator = By.xpath("//ul[@class=\"oxd-main-menu\"]/li/a[contains(normalize-space(.),'Admin')]");
        wait.until(ExpectedConditions.elementToBeClickable(adminLocator)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]"))).click();

        // Use parameters directly
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),\"Select\")])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Type for hints...\"]"))).sendKeys(empName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"option\"]/span[contains(text(),'" + empName + "')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),\"Select\")])[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/ancestor::div[1]/following-sibling::div//input"))).sendKeys(uName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Password']/ancestor::div[1]/following-sibling::div//input"))).sendKeys(pwd);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirm Password']/ancestor::div[1]/following-sibling::div[1]//input"))).sendKeys(confirmPwd);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();


        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role=\"row\"]/div[@role='cell'][2]")));
        for (WebElement name : list) {
            if (name.getText().contains(uName)) {
                return true;
            }
        }
        return false;
    }
}