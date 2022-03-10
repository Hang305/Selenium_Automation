package Test;

import Common.Urls;
import Drivers.DriverFactory;
import Pages.Persona.ExplorePage;
import Pages.Persona.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest implements Urls {
    WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeTest
    public void init() {
        driver.get(BASE_URL);
    }

    @Test
    public void TC_Login_Blank() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.emailElem().sendKeys("");
            loginPage.passwordElem().sendKeys("");
            loginPage.clickOnLoginBtn();
            Assert.assertEquals( loginPage.emailErrorElem().getText(),"Required!");
            Assert.assertEquals(loginPage.passErrorElem().getText(),"Required!");

        } catch (Exception e) {
            throw new IllegalArgumentException("The email or password must be the characters");
        }
    }

    @Test
    public void TC_Login_Email_InvalidFormat() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.emailElem().sendKeys("ha");
            loginPage.passwordElem().sendKeys("123456");
            loginPage.clickOnLoginBtn();

            Assert.assertEquals( loginPage.emailErrorElem().getText(),"Invalid email format");

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    @Test
    public void TC_Login_Success() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputEmail("hanglee305+persona5@gmail.com");
            loginPage.inputPassword("123456");
            loginPage.loginBtnElem();

            Thread.sleep(1000);
            System.out.println(driver.getCurrentUrl());
//            Assert.assertEquals(driver.getCurrentUrl(),BASE_URL.concat(EXPLORE_PAGES));
            //actual - expected
            ExplorePage explorePage = new ExplorePage(driver);
            System.out.println(explorePage.titleElem().getText());
            Assert.assertEquals(explorePage.titleElem().getText(),"Explore project");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
