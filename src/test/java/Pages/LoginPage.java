package Pages;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Login extends BasePage{
        //extends BasePage{

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-email\"]")
    private WebElement username;

   // @FindBy(how = How.XPATH, using = "//*[@id=\"valid-email\"]")
    //private  WebElement username;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password\"]")
    private WebElement password;

    @FindBy(how = How.CSS, using = "//*[@id=\"submitinreg\"]")
    private WebElement submitButton;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback")
    private WebElement usernameError;

    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback")
    private WebElement passwordError;

//    public void verifyPage() {
//        Assert.assertEquals(pageText.getText(),"Authentication");
//        Assert.assertEquals(pageTextCss.getText(),"Authentication");
//        Assert.assertEquals(pageTextClass.getText(), "Authentication");
//        Assert.assertEquals(usernameLabel.getText(), "Username");
//        Assert.assertEquals(passwordLabel.getText(), "Password");
//    }

    public Login(WebDriver driver) {
        super(driver);
    }

    public void login() {
//        System.setProperty("webdriver.chrome.driver", "/Users/ciri/Downloads/IdeaProjects/webdriver/chromedriver");

//        WebDriver driver = new ChromeDriver();
//        this.driver.get("https://www.nichiduta.ro/autentificare");
//
//        WebElement username = this.driver.findElement(By.xpath("//*[@id=\"valid-email\"]"));
//        WebElement password = this.driver.findElement(By.xpath("//*[@id=\"valid-password\"]"));
//        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitinreg\"]"));
//
        username.clear();
        username.sendKeys("sylvya_ro@yahoo.com");
        password.clear();
        password.sendKeys("Silvia@123");
        submitButton.submit();
    }
//
//    @Test
//    public void testloginFailed() {
////        System.setProperty("webdriver.chrome.driver", "/Users/ciri/Downloads/IdeaProjects/webdriver/chromedriver");
////
////        WebDriver driver = new ChromeDriver();
//        this.driver.get("https://www.nichiduta.ro/autentificare");
//
//        WebElement username = this.driver.findElement(By.xpath("//*[@id=\"valid-email\"]"));
//        WebElement password = this.driver.findElement(By.xpath("//*[@id=\"valid-password\"]"));
//        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"submitinreg\"]"));
//
//        username.clear();
//        username.sendKeys("sylvya_ro@yahoo.com");
//        password.clear();
//        password.sendKeys("Silvia@123123");
//        submitButton.submit();
//
//        Assert.assertEquals(this.driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/span")).getText(), "Nu exista in baza noastra de date un cont format din combinatia introdusa de dumneavoastra. Va rugam sa mai incercati.");
//
//    }
//
//    public void login(String username, String password, String userError, String passError) {
//        login(username, password);
//        Assert.assertEquals(usernameError.getText(), userError);
//        Assert.assertEquals(passwordError.getText(), passError);
//    }
//
//    public void login(String username, String password) {
//        usernameInput.clear();
//        usernameInput.sendKeys(username);
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//        submitButton.submit();
//    }
//
//    public String getUsernameError() {
//        return usernameError.getText();
//    }
//
//    public String getPasswordError() {
//        return passwordError.getText();
//    }

}
