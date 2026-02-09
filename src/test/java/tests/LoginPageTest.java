package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    LoginPage login;

    @BeforeMethod
    public void setupPage() {
        login = new LoginPage();
    }

    @Test
    public void verifyLoginWithValidCredentialsTest() throws IOException {
        String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actUrl = login.verifyLoginWithValidCredentials();
        Assert.assertEquals(actUrl, expUrl, "URL Mismatch");

    }

    @Test
    public void verifyLoginWithInvalidCredentialsTest() throws IOException, InterruptedException {
        String expMessage =  "Invalid credentials";
        String actMessage = login.verifyLoginWithInvalidCredentials();
        Assert.assertEquals(actMessage, expMessage, "Error Message not displayed");

    }


    @Test
    public void verifyforgetPasswordWithValidUsername() throws IOException {
        boolean expResult = true;
        boolean actResult = login.verifyForgetPassword();
        Assert.assertEquals(actResult, expResult, "Forget Password Failed!");
    }



    @DataProvider(name = "LoginTestDataProvider")
    public Object[][] getDataWithProvider() {
        return new Object[][]{
                {"Admin" , "admin123"},
                {"user" , "pass123"},
                {"Test", "10000"},
                {"Ad min", "     "}
        };
    }

    @Test(dataProvider = "LoginTestDataProvider")
    public void verifyLoginWithMultipleCredentialsTest(String username, String password) throws IOException {
        String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actUrl = login.verifyLoginWithMultipleCredentials(username, password);

        Assert.assertEquals(actUrl, expUrl);

    }

}
