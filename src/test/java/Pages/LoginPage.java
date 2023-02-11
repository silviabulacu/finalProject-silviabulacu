package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage{

    WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[3]/div[1]/h1")
    private WebElement pageText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-email\"]")
    private WebElement usernameInput;


   // @FindBy(how = How.XPATH, using = "//*[@id=\"valid-email\"]")
    //private  WebElement username;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password\"]")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"submitinreg\"]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/span")
    private WebElement usernameError;

    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback")
    private WebElement passwordError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_options\"]/div[1]/ul/li[1]/span")
    private WebElement successMessage;


    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/span/span")
    private WebElement logSuccess;

    public void verifyPage() {
        Assert.assertEquals(pageText.getText(),"Intra in cont");
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.submit();
    }

    public String getUsernameError() {
        return usernameError.getText();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }


    public void checkErrorUsername(String error, String expected) {
        Assert.assertEquals(error, expected);
    }

    public void checkSuccess(WebDriver driver) {
        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"acc_button\"]"));

            Actions action = new Actions(driver);
        action.moveToElement(accountButton).perform();
        action.click().build().perform();

        Assert.assertEquals(successMessage.getText(), "Salut Bulacu!");
    }

}
