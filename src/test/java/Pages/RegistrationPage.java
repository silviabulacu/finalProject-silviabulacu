package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class Registration extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-name\"]")
    private WebElement firstNameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-surname\"]")
    private WebElement lastNameInput;


    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-reg-email\"]")
    private WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-phone\"]")
    private WebElement phoneInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password-reg\"]")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password2\"")
    private WebElement confirmPasswordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"inregfrm\"]/div[7]/label[1]/span[1]")
    private WebElement agreementTermsInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"submitinreg\"]")
    private WebElement submit;


    public String firstNameText = "Silvia";
    public String lastNameText = "Bulacu";
    public String emailText = "sylvya_ro@yahoo.com";
    public String phoneText = "0763219015";
    public String passwordText = "Silvia@123";
    public String confirmPasswordText = "Silvia@123";

    public Registration(WebDriver driver) {
        super(driver);
    }

//    public void verifyPage() {
//        Assert.assertEquals(driver.findElement(By.cssSelector(firstName)).getText(), "Client existent");
//        Assert.assertEquals(driver.findElement(By.cssSelector(lastName)).getText(), "Adresa de e-mail:");
//        Assert.assertEquals(driver.findElement(By.cssSelector(email)).getText(), "Parola:");
//    }

    @Test
    public void register(String firstNameText,
                         String lastNameText,
                         String emailText,
                         String phoneText,
                         String passwordText,
                         String confirmPasswordText) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\silvia\\IdeaProjects\\webdriver\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.nichiduta.ro/inregistrare");

        this.firstNameInput.clear();
        this.firstNameInput.sendKeys(firstNameText);

        this.lastNameInput.clear();
        this.lastNameInput.sendKeys(lastNameText);

        this.emailInput.clear();
        this.emailInput.sendKeys(emailText);

        this.phoneInput.clear();
        this.phoneInput.sendKeys(phoneText);

        this.passwordInput.clear();
        this.passwordInput.sendKeys(passwordText);

        this.confirmPasswordInput.clear();
        this.confirmPasswordInput.sendKeys(confirmPasswordText);

        boolean isSelected = this.agreementTermsInput.isSelected();

//performing click operation if element is not checked
        if(isSelected == false) {
            this.agreementTermsInput.click();
        }


        //agreementTerms.clear();
//        agreementTerms.click();

        submit.submit();
    }
}
