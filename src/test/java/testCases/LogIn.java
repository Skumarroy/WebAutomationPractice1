package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class LogIn extends BaseTest {

    @Test

    public void logInSIgnupButton() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.LoginSignupButton();
        loginPage.LoginEmail("abcroy1@gmail.com");
        loginPage.LoginPassword("abc123");
        loginPage.LoginButton();
        loginPage.LogoutButton();
        // Write your test case here
    }
}
