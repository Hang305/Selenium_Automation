package Test;

import Common.Hyperlink;
import Common.Urls;
import Drivers.DriverFactory;
import Pages.Persona.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest implements Urls {
    WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeTest
    public void init() {
        driver.get(BASE_URL.concat(SIGNUP));
    }

    // TC01: all elements are blank
    @Test
    public void TC_Register_Blank() {
        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.firstNameElem().sendKeys("");
            registerPage.lastNameElem().sendKeys("");
            registerPage.emailElem().sendKeys("");
            registerPage.passwordElem().sendKeys("");
            registerPage.confirmPassElem().sendKeys("");
            registerPage.signupBtnElem();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //TC02:
    @Test
    public void TC_Register_LoginLink() {
        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.loginLinkElem();
            Hyperlink hyperlink = new Hyperlink(registerPage.loginLinkElem().getText(), registerPage.loginLinkElem().getAttribute("href"));

            Assert.assertEquals("https://iresource.smartdev.vn/login", hyperlink.getLink());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
