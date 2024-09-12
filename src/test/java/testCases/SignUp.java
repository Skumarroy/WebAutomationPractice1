package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.SignupForm;
import pageObjects.SignupPage;
import testBase.BaseTest;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class SignUp extends BaseTest {

    @Test(enabled = true)

    public void registerUser() {

        logger.info("Starting Registering the USer to the System");

        SignupPage page = new SignupPage(driver);
        SignupForm form = new SignupForm(driver);
        page.clickLoginButton();
        page.enterName(randomString());
        page.enterEmail(randomString() + "@gmai.com");
        page.SignupButton();

        logger.info("Sign up button done");

        form.selectRadioButtonClick();
        form.setPassword(randomString());
        form.setDays();
        form.selectDay();
        form.setMonths();
        form.setSelectMonths();
        form.setYears();
        form.selectSelectYears();
        form.selectNewsletter();
        form.selectOptional();
        form.selectFirstName(randomAlphaNumeric());
        form.setLastName(randomAlphaNumeric());
        form.selectCompany(randomString());
        form.selectAddress1(randomString());
        form.selectAddress2(randomString());
        form.selectCountry();
        form.selectIndia();
        form.selectState(randomString());
        form.selectCity(randomString());
        form.selectZipCode(randomNumeric());
        form.selectPhone(randomNumeric());
        form.selectSubmitButton();
        logger.info("Sign up successful");

    }

}