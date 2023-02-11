package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-name\"]")
    private WebElement firstNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-name-error\"]")
    private WebElement firstNameInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-surname\"]")
    private WebElement lastNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-surname-error\"]")
    private WebElement lastNameInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-reg-email\"]")
    private WebElement emailInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-reg-email-error\"]")
    private WebElement emailInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-phone\"]")
    private WebElement phoneInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-phone-error\"]")
    private WebElement phoneInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password-reg\"]")
    private WebElement passwordInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password-reg-error\"]")
    private WebElement passwordInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password2\"]")
    private WebElement confirmPasswordInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"valid-password2-error\"]")
    private WebElement confirmPasswordInputError;

    @FindBy(how = How.XPATH, using = "//*[@id=\"inregfrm\"]/div[7]/label[1]/span[1]")
    private WebElement agreementTermsInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"submitinreg\"]")
    private WebElement submit;
    

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    @Test
    public void register(String firstNameText,
                         String lastNameText,
                         String emailText,
                         String phoneText,
                         String passwordText,
                         String confirmPasswordText
    ) {

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

    public void checkError(String element, String error)
    {
        switch (element){
            case "firstNameInputError":
                Assert.assertEquals(this.getFirstNameInputError(), error);
                break;
            case "getLastNameInputError":
                Assert.assertEquals(this.getLastNameInputError(), error);
                break;
            case "getEmailInputError":
                Assert.assertEquals(this.getEmailInputError(), error);
                break;
            case "getPhoneInputError":
                Assert.assertEquals(this.getPhoneInputError(), error);
                break;
            case "getPasswordInputError":
                Assert.assertEquals(this.getPasswordInputError(), error);
                break;

        }

    }

    public String getFirstNameInputError() {
        return firstNameInputError.getText();
    }

    public String getLastNameInputError() {
        return lastNameInputError.getText();
    }

    public String getEmailInputError() {
        return emailInputError.getText();
    }

    public String getPhoneInputError() {
        return phoneInputError.getText();
    }

    public String getPasswordInputError() {
        return passwordInputError.getText();
    }

    public String getConfirmPasswordInputError() {
        return confirmPasswordInputError.getText();
    }
}
