package Test;

import Common.Urls;
import Drivers.DriverFactory;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest implements Urls {
    WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeTest
    public void init() {
        driver.get(BASE_URL.concat(LOGIN));
    }

    @Test
    public void TC_Login_() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.emailElem().sendKeys("hanglee305+persona5@gmail.com");
            loginPage.passwordElem().sendKeys("123456");
            loginPage.clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void TC_Login_Username_Blank() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.emailElem().sendKeys("");
            loginPage.passwordElem().sendKeys("123456");
            loginPage.clickOnLoginBtn();
            System.out.println(loginPage.emailErrorElem());
            Assert.assertEquals("Required!", loginPage.emailErrorElem());

        } catch (Exception e) {
            throw new IllegalArgumentException("The username must be the characters");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
