package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage extends BasePage {


    public ContactUsFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    @FindBy(css = "a[href='/contact_us']")
    WebElement contactUsForm;

    public void clickContactUsForm() {
        contactUsForm.click();
    }


    @FindBy(css = "input[placeholder='Name']")
    WebElement nameInput;

    public void setNameInput(String name) {
        nameInput.sendKeys(name);
    }

    @FindBy(css = "input[placeholder='Email']")
    WebElement emailInput;

    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @FindBy(css = "input[placeholder='Subject']")
    WebElement subjectInput;

    public void setSubjectInput(String subject) {
        subjectInput.sendKeys(subject);
    }

    @FindBy(css = "#message")
    WebElement messageInput;

    public void setMessageInput(String message) {
        messageInput.sendKeys(message);
    }

    @FindBy(css = "input[name='upload_file']")
    WebElement uploadFileInput;

    public void setUploadFileInput(String filePath) {
        uploadFileInput.sendKeys(filePath);
    }

    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    public void clickSubmitButton() {
        submitButton.click();
    }


}
