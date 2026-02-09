package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserManagement;
import util.ReadExcelData;

import java.io.IOException;

public class UserManagementTest extends BaseTest {

    LoginPage login;
    UserManagement um;

    @BeforeMethod
    public void setupPage() {
        login = new LoginPage();
        um = new UserManagement();

    }


//    @Test
//    public void verifyAddUserTesth() throws IOException, InterruptedException {
//       boolean expRes = true;
//       boolean actRes = um.verifyAddUser();
//
//       Assert.assertEquals(actRes, expRes);
//
//    }


    @DataProvider(name = "UserTestExcelData")
    public Object[][] getData() throws IOException {
        return ReadExcelData.getAllExcelData("TestSheet");
    }

    @Test(dataProvider = "UserTestExcelData")
    public void verifyAddUserTesth(String role, String name, String status, String user, String pass, String confirmPass) throws IOException, InterruptedException {
        boolean isAdded = um.verifyAddUser(role, name, status, user, pass, confirmPass);
        Assert.assertTrue(isAdded);

    }


}


