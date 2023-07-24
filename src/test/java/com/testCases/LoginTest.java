package com.testCases;
import com.base.BaseTest;
import com.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] dataSetting(){
        return new Object[][] {
                {"Nany", "Welcome123"}
        };
    }

    @Test(dataProvider = "dataSetting")
    public void loginInvalidUser(String name, String  pass) {
        LoginPage page = new LoginPage(driver);
        page.openPage(getProperties("urlName"))
             .goToLogin()
              .enterName(name)
              .enterPassword(pass)
              .clickOnLoginButton();
    }
}
