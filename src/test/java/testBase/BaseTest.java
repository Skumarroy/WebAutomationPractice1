package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ConfigReader;
import utilities.ExtentReportListener;

import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;

    public static Properties p = new Properties();
    public static FileReader fr;
    public static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    static {
        try {
            // Load the configuration properties file
            fr = new FileReader("src/test/resources/config.properties");
            p.load(fr);
            logger.info("Configuration file loaded successfully.");

            // Load the locators properties file (if needed)
            fr = new FileReader("src/test/resources/locators.properties");
            p.load(fr);
            logger.info("Locators file loaded successfully.");
        } catch (IOException e) {
            logger.info("Error loading properties file: {}", e.getMessage());
            e.printStackTrace();
        }
    }
    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Setting up the browser: {}", browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Chrome browser launched successfully.");

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();  // Use WebDriverManager to set up FirefoxDriver
            driver = new FirefoxDriver();  // Initialize FirefoxDriver
            logger.info("Firefox browser launched successfully.");

        }
        else {
            logger.warn("Browser not supported: {}", browser);
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        // Set the driver in ExtentReportListener
        ExtentReportListener.setDriver(driver);
        driver.manage().window().maximize();
        logger.info("Browser window maximized.");
        driver.get(ConfigReader.getProperty("url")); // Use URL from configuration file
        logger.info("Navigated to the base URL: {}", ConfigReader.getProperty("url"));
    }

   /* public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        logger.info("Chrome browser Website is launched successfully");
        ExtentReportListener.setDriver(driver);

    }*/

    public  String randomString() {

       String randomString= RandomStringUtils.randomAlphabetic(5);

        return randomString;
    }

    public int randomNumeric() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return (int) Long.parseLong(sb.toString());
    }

    public  String randomAlphaNumeric() {

        String randomAlphanumeric= RandomStringUtils.randomAlphanumeric(10);

        return (randomAlphanumeric);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing the browser.");
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }


}
