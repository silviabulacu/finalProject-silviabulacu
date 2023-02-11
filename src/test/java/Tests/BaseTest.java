package Tests;

import Utils.ConstantUtils;
import Utils.GenericUtils;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Utils.ExtentTestManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_DATABASE;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    Base64 base64 = new Base64();
    public ExtentTest test;

    String baseUrl = "https://www.nichiduta.ro";

    @BeforeSuite
    public void startUp(){
        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver = new ChromeDriver();

        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        test = ExtentTestManager.updateTest(test, driver, result);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        ExtentTestManager.extent.flush();

    }

}
