package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(testBase.ExtentReportManager.class)

public class AllTestCases extends BaseTest{

    @Test(priority = 0)

    public void registerUser() {
        logger.info("register user created");
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        WebElement element = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(randomString());
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(randomString()+"@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        driver.findElement(By.cssSelector("#id_gender1")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys(randomAlphaNumeric());
        driver.findElement(By.cssSelector("#days")).click();
        driver.findElement(By.cssSelector("select[id='days'] option[value='1']")).click();
        driver.findElement(By.cssSelector("#months")).click();
        driver.findElement(By.cssSelector("select[id='months'] option[value='1']")).click();
        driver.findElement(By.cssSelector("#years")).click();
        driver.findElement(By.cssSelector("option[value='2020']")).click();
        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();
        driver.findElement(By.cssSelector("#first_name")).sendKeys(randomString());
        driver.findElement(By.cssSelector("#last_name")).sendKeys(randomString());
        driver.findElement(By.cssSelector("#company")).sendKeys(randomString());
        driver.findElement(By.cssSelector("#address1")).sendKeys(randomAlphaNumeric());
        driver.findElement(By.cssSelector("#address2")).sendKeys(randomAlphaNumeric());
        driver.findElement(By.cssSelector("#country")).click();
        driver.findElement(By.cssSelector("option[value='India']")).click();
        driver.findElement(By.cssSelector("#state")).sendKeys(randomString());
        driver.findElement(By.cssSelector("#city")).sendKeys(randomString());
        driver.findElement(By.cssSelector("#zipcode")).sendKeys(randomAlphaNumeric());
        driver.findElement(By.cssSelector("#mobile_number")).sendKeys("9999999999");
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
        WebElement element2 = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        System.out.println(element2.getText());
        Assert.assertEquals(element2.getText(), element2.getText());
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
    }


    @Test(priority = 1)

    public void LoginUserWithCorrectEmailAndPassword() {
        logger.info("login with correct user and password");
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        WebElement element = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("abcroy1@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("abc123");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

    }

    @Test(priority = 3)

    public void LoginUserWithInCorrectEmailAndPassword() {
        logger.info("login with Incorrect user and password");
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        WebElement element = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("abcajgsdjroy@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("abc123ackb");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        WebElement element3 = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
        System.out.println(element3.getText());


    }


    @Test(priority = 4)

    public void ContactUsForm() {
        logger.info("ContactUsForm created");
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("John Doe");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("johndoe@example.com");
        driver.findElement(By.cssSelector("input[placeholder='Subject']")).sendKeys("AbcSettingglass");
        driver.findElement(By.cssSelector("#message")).sendKeys("Hello, I'm interested in learning more about your website!");
        WebElement uploadElement = driver.findElement(By.cssSelector("input[name='upload_file']"));
        uploadElement.sendKeys("C:\\Users\\sanjeet.kumar2\\Downloads\\ErrorRecords_1724235946047.xls");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }

    @Test(priority = 5)

    public void searchOnProductDetailsPage() {
        logger.info("searchOnProductDetailsPage created");
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='All Products']"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("#search_product")).sendKeys("Blue Top");
        driver.findElement(By.cssSelector(".fa.fa-search")).click();
        WebElement element3 = driver.findElement(By.xpath("//div[@class='productinfo text-center']//p[contains(text(),'Blue Top')]"));
        System.out.println(element3.getText());


    }


}

