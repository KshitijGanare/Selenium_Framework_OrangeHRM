package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserManagement;

import java.io.IOException;

public class UserManagementTest extends BaseTest {

    LoginPage login;
    UserManagement user;

    @BeforeMethod
    public void setupPage() {
        login = new LoginPage();
        user = new UserManagement();

    }


    @Test
    public void verifyAddUserTest() throws IOException, InterruptedException {
       boolean expRes = true;
       boolean actRes = user.verifyAddUser();

       Assert.assertEquals(actRes, expRes);


    }

}
