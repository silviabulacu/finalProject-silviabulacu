package Tests;

import Pages.RegistrationPage;
import Utils.ExtentTestManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Tests.ObjectModels.RegisterModel;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterWithJsonTest extends BaseTest {

    public RegistrationPage registrationPage;

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/test/resources/data/register.json");
        System.out.println(file);
        RegisterModel[] registerModels = objectMapper.readValue(file, RegisterModel[].class);
        System.out.println(file);

        for (RegisterModel registerModel : registerModels) {
            printData(registerModel);

            dp.add(new Object[]{registerModel});
        }

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void testRegisterWithJson(RegisterModel registerModel, Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Register test with json");
        printData(registerModel);

        driver.get(baseUrl + "/inregistrare");

        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        registrationPage.register(
                registerModel.getFirstname(),
                registerModel.getLastname(),
                registerModel.getEmail(),
                registerModel.getPhone(),
                registerModel.getPassword(),
                registerModel.getConfirmPassword()
        );

        registrationPage.checkError(registerModel.getErrorType(), registerModel.getError());
    }

    private void printData(RegisterModel registerModel) {
        System.out.println(registerModel);
    }
}


