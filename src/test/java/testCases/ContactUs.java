package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ContactUsFormPage;
import testBase.BaseTest;
import utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ContactUs extends BaseTest {

    @Test
    public void testContactUsForm(){

        ContactUsFormPage cp = new ContactUsFormPage(driver);
        cp.clickContactUsForm();
        cp.setNameInput(randomString());
        cp.setEmailInput(randomString() + "@gmail.com");
        cp.setSubjectInput(randomString());
        cp.setMessageInput(randomString());
        cp.setUploadFileInput("C:\\Users\\sanjeet.kumar2\\Downloads\\ErrorRecords_1724235946047.xls");
        cp.clickSubmitButton();
        logger.info("Contact us information sent successfully");
    }
}
