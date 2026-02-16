// dynamic drivers --> edge, firefox, safari, opera, etc. --> WebDriverManager
// dynamic urls --> config.properties file --> FileInputStream, Properties class
// why WebDriverManager? --> no need to download and set path for drivers, it automatically manages the drivers for us based on the browser we want to use.
/*
 
 With WebDriverManager

It automatically:

Detects browser version

Downloads correct driver

Sets system property

Handles version mismatch
 */

package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

    public static WebDriver driver;
    
    public static final String USER_EMAIL = "b69bc@gmail.com";
    public static final String USER_PASSWORD = "Test@123";

    ReadConfig readConfig = new ReadConfig();

    @BeforeClass
    public void setup() {

        String browser = readConfig.getBrowser();
        String url = readConfig.getBaseURL();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    public static WebDriver getDriver() {   //for listener class and to access driver instance
        return driver;
    }

    
}
