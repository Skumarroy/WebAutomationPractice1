package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupForm extends BasePage{

    public SignupForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#id_gender1")
    WebElement genderMaleRadioButton;

    public void selectRadioButtonClick(){
        genderMaleRadioButton.click();

    }

    @FindBy(css = "#password")
    WebElement password;

    public void setPassword(String password1){
        password.sendKeys(password1);

    }
    @FindBy(css = "#days")
    WebElement days;

    public void setDays(){

        days.click();
    }

    @FindBy(css = "select[id='days'] option[value='1']")
    WebElement selectdays;

    public void selectDay(){

        selectdays.click();
    }


    @FindBy(css = "#months")
    WebElement months;

    public void setMonths(){

        months.click();
    }


    @FindBy(css = "select[id='months'] option[value='1']")
    WebElement selectMonths;

    public void setSelectMonths(){

        selectMonths.click();
    }
    @FindBy(css = "#years")
    WebElement years;

    public void setYears(){

        years.click();
    }

    @FindBy(css = "option[value='2020']")
    WebElement selectYears;

    public void selectSelectYears(){

        selectYears.click();
    }
    @FindBy(css = "#newsletter")
    WebElement newsletter;

    public void selectNewsletter(){

        newsletter.click();
    }
    @FindBy(css = "#optin")
    WebElement optional;

    public void selectOptional(){

        optional.click();
    }
    @FindBy(css = "#first_name")
    WebElement firstName;
    public void selectFirstName(String first_Name) {
        // Ensure first_Name is not null to avoid any potential NullPointerException
        if (first_Name != null) {
            firstName.sendKeys(first_Name);
        } else {
            throw new IllegalArgumentException("First name cannot be null");
        }
    }

    @FindBy(css = "#last_name")
    WebElement lastName;

    public void setLastName(String Lastname) {
        // Ensure first_Name is not null to avoid any potential NullPointerException
        if (lastName != null) {
            lastName.sendKeys(Lastname);
        } else {
            throw new IllegalArgumentException("last name cannot be null");
        }
    }

    @FindBy(css = "#company")
    WebElement company;

    public void selectCompany(String Company_name){
        company.sendKeys(Company_name);
    }

    @FindBy(css = "#address1")
    WebElement address1;

    public void selectAddress1(String address_1 ){
        address1.sendKeys(address_1);
    }


    @FindBy(css = "#address2")
    WebElement address2;

    public void selectAddress2(String address_2){
        address2.sendKeys(address_2);
    }

    @FindBy(css = "#country")
    WebElement country;

    public void selectCountry(){
        country.click();
    }

    @FindBy(css = "option[value='India']")
    WebElement India;

    public void selectIndia(){
        India.click();
    }

    @FindBy(css = "#state")
    WebElement state;

    public void selectState(String StateName){
        state.sendKeys(StateName);
    }

    @FindBy(css = "#city")
    WebElement city;

    public void selectCity(String CityName){
        city.sendKeys(CityName);
    }

    @FindBy(css = "#zipcode")
    WebElement zipCode;

    public void selectZipCode(int zipCodeData){
        zipCode.sendKeys(String.valueOf(zipCodeData));
    }

    @FindBy(css = "#mobile_number")
    WebElement phone;

    public void selectPhone(int phoneData) {
        phone.sendKeys(String.valueOf(phoneData));
    }

    @FindBy(css = "button[data-qa='create-account']")
    WebElement submitButton;

    public void selectSubmitButton(){
        submitButton.click();
    }

}
