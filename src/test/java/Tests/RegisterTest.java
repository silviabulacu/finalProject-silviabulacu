package Tests;

import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest {

    public RegistrationPage registrationPage;

    @DataProvider(name = "registerData")
    public Iterator<Object[]> registerDataProvider() {

        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] { "", "popescu", "email@email.com", "0711111111", "Parola@1", "Parola@1", "Camp obligatoriu!", "firstNameInputError"} );
        dp.add(new String[] { "iulia", "", "email@email.com", "0711111111", "Parola@1", "Parola@1", "Camp obligatoriu!", "getLastNameInputError" } );
        dp.add(new String[] { "iulia", "popescu", "", "0711111111", "Parola@1", "Parola@1", "Adresa de email trebuie completata.", "getEmailInputError" } );
        dp.add(new String[] { "iulia", "popescu", "emailgresit", "0711111111", "Parola@1", "Parola@1", "Adresa de email trebuie sa aiba formatul ex: name@domain.com fara spatii libere inainte sau dupa", "getEmailInputError" } );
        dp.add(new String[] { "iulia", "popescu", "email@email.com", "", "Parola@1", "Parola@1", "Numarul de telefon trebuie completat.", "getPhoneInputError"} );
        dp.add(new String[] { "iulia", "popescu", "email@email.com", "0711111111", "", "Parola@1", "Parola obligatorie.", "getPasswordInputError" } );
        dp.add(new String[] { "iulia", "popescu", "email@email.com", "0711111111", "Parola@1", "testParola@1", "Parola nu corespunde",  "getConfirmPasswordInputError" } );
        return dp.iterator();
    }

    @Test(dataProvider = "registerData")
    public void testRegister(Method method,
                             String firstNameText,
                             String lastNameText,
                             String emailText,
                             String phoneText,
                             String passwordText,
                             String confirmPasswordText,
                             String error,
                             String errorType
    ) {
        test = ExtentTestManager.startTest(method.getName(), "Register test");

        driver.get(baseUrl + "/inregistrare");

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        registrationPage.register(firstNameText, lastNameText, emailText, phoneText, passwordText, confirmPasswordText);

        registrationPage.checkError(errorType, error);
    }
}