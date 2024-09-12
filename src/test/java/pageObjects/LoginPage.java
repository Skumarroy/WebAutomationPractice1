package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href='/login']")
    WebElement loginButton;

    public  void LoginSignupButton(){
        loginButton.click();
    }

    @FindBy(css = "input[data-qa='login-email']")
    WebElement emailInput;

    public void LoginEmail(String email){

        emailInput.sendKeys(email);
    }

    @FindBy(css = "input[data-qa='login-password']")
    WebElement passwordInput;

    public void LoginPassword(String password){
        passwordInput.sendKeys(password);
    }

    @FindBy(css = "button[data-qa='login-button']")
    WebElement sub;

    public void LoginButton(){
        sub.click();
    }

    @FindBy(css = "a[href='/logout']")
    WebElement logoutButton;

    public void LogoutButton(){
        logoutButton.click();
    }

}
