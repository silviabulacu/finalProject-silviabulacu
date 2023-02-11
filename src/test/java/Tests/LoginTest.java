package Tests;

import Pages.LoginPage;
import Utils.ExtentTestManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest extends BaseTest{

    @Test
    public void testloginError(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Login Test");

        driver.get(baseUrl + "/autentificare");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyPage();

        loginPage.login("asdasd@asdasdas.com", "Silvia@123");

        loginPage.checkErrorUsername(loginPage.getUsernameError(), "Nu exista in baza noastra de date un cont format din combinatia introdusa de dumneavoastra. Va rugam sa mai incercati.");

    }

    @Test
    public void testloginSuccess(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Login Test");

        driver.get(baseUrl + "/autentificare");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.verifyPage();

        loginPage.login("sylvya_ro@yahoo.com", "Silvia@123");

        driver.get(baseUrl + "");
        LoginPage loginPageIndex = PageFactory.initElements(driver, LoginPage.class);

        loginPageIndex.checkSuccess(driver);

    }
}
