package Test;

import Common.Urls;
import Drivers.DriverFactory;
import Models.Components.LoginComponent;
import Pages.Persona.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest implements Urls {

    WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeMethod
    public void init() {
        driver.get(BASE_URL);
    }

    //TC01: Email and password is blank
    @Test
    public void TC01_Blank() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.emailElem().sendKeys("");
            loginComponent.passwordElem().sendKeys("");
            loginComponent.loginBtn().click();

            Assert.assertEquals(loginComponent.emailErrorElem().getText(), "Required!");
            Assert.assertEquals(loginComponent.passErrorElem().getText(), "Required!");

        } catch (Exception e) {
            throw new IllegalArgumentException("The email or password must be the characters");
        }
    }

    //TC02: Input email NOT already on DB
    @Test
    public void TC02_Email_NotAlreadyOnDB() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.inputEmail("ha@gmail.com");
            loginComponent.inputPassword("123456");
            loginComponent.loginBtn().click();

//            driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            Thread.sleep(2000);
            String actualEmailTest = loginComponent.modelAlertElem().getText();
            System.out.println(loginComponent.modelAlertElem().getText());
            String expectedEmailTest = "Email or password is invalid.";

            Assert.assertEquals(actualEmailTest, expectedEmailTest);

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    //TC03:  Input password is NOT already on DB
    @Test
    public void TC03_Password_NotAlreadyOnDB() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.inputEmail("hanglee305+persona5@gmail.com");
            loginComponent.inputPassword("18272");
            loginComponent.loginBtn().click();
            Thread.sleep(3000);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//            driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);

            String actualPasswordTest = loginComponent.modelAlertElem().getText();
            String expectedPasswordTest="Email or password is invalid.";
            Assert.assertEquals(actualPasswordTest,expectedPasswordTest );

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid password format");
        }
    }

    //TC04: Login with invalid format of email
    @Test
    public void TC04_Email_InvalidFormat() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.inputEmail("ha@gmail");
            loginComponent.inputPassword("1298234");
            loginComponent.loginBtn().click();

            Thread.sleep(4000);
            Assert.assertEquals(loginComponent.emailErrorElem().getText(), "Invalid email format");

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    //TC05: Login with invalid length of password
    @Test
    public void TC05_Password_InvalidLength() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.inputEmail("ha@gmail.com");
            loginComponent.inputPassword("12");
            loginComponent.loginBtn().click();
            Thread.sleep(2000);
            String actualPasswordTest = loginComponent.passErrorElem().getText().trim();
            String expectedPasswordTest = "Minimum 8 characters";

            Assert.assertEquals(actualPasswordTest, expectedPasswordTest, "[ERROR] Your password cannot be less than 8 characters and longer than 30 characters.");

        } catch (Exception e) {
            System.out.println("Your password cannot be less than 8 characters and longer than 30 characters.");
        }
    }

    //TC06: Login with valid data
    @Test
    public void TC06_Success() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            loginComponent.inputEmail("hanglee305+persona5@gmail.com");
            loginComponent.inputPassword("123456");
            loginComponent.loginBtn().click();

            Thread.sleep(2000);
            //actual - expected
            Assert.assertEquals(driver.getCurrentUrl(), BASE_URL.concat(EXPLORE_PAGES));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //TC07: Get title
    @Test
    public void TC07_Title() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();

            Assert.assertEquals(loginComponent.inputTitle(), "Log In");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TC08: get description
    @Test
    public void TC08_Decription() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();

            Assert.assertEquals(loginComponent.inputDecription(), "Hello and welcome !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TC09: the default remember is checked
    @Test
    public void TC09_DefaultRemember() {
        try {

            LoginPage loginPage = new LoginPage(driver);
            LoginComponent loginComponent = loginPage.loginComp();
            boolean isSelected = loginComponent.rememberMeElem().isSelected();

            Assert.assertEquals(isSelected, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
