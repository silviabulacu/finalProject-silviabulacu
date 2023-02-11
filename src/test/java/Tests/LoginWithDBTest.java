package Tests;

import Pages.LoginPage;
import Utils.ExtentTestManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.sql.*;

public class LoginWithDBTest extends BaseTest{

    String username = "";
    String password = "";
    @Test
    public void testlogin(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "Login Test with db");

        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/automation", "root", "");
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes())));
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM credentials where id=1");

            if(result.next()) {
                username = result.getString("username");
                password = result.getString("password");
                System.out.println(result.getInt(1) + "  " + result.getString(2) + "  " + result.getString(3));
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        driver.get(baseUrl + "/autentificare");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(username, password);

        driver.get(baseUrl + "");
        LoginPage loginPageIndex = PageFactory.initElements(driver, LoginPage.class);

        loginPageIndex.checkSuccess(driver);

    }
}
