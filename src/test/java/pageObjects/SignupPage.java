package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {


    public SignupPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[href='/login']")
    WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(css = "input[placeholder='Name']")
    WebElement nameInput;


    public void enterName(String name) {
        nameInput.clear();  // Clear existing text
        nameInput.sendKeys(name);  // Enter the provided name

    }

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement emailInput;


    public void enterEmail(String email) {
        emailInput.clear();  // Clear existing text
        emailInput.sendKeys(email);  // Enter the provided name
    }

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signupButton;

        public void SignupButton(){
            signupButton.click();
        }

    }
