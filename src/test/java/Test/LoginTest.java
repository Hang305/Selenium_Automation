package Test;

import Common.Urls;
import Drivers.DriverFactory;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest implements Urls {

    public static void main(String[] args) {
//        testLoginPageMainInteractionMethods();
        testLoginPageTraditonalPOM();

    }
    //Return WebElement
    private static void testLoginPageTraditonalPOM() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN));
            Thread.sleep(1000);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.emailElem().sendKeys("hanglee305+persona5@gmail.com");
            loginPage.passwordElem().sendKeys("123456");
            loginPage.clickOnLoginBtn();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Return input
//    private static void testLoginPageMainInteractionMethods() {
//        WebDriver driver = DriverFactory.getChromeDriver();
//        try {
//            driver.get(BASE_URL.concat(LOGIN));
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.inputEmail("hanglee305+persona5@gmail.com");
//            loginPage.inputPassword("123456");
//            loginPage.clickOnLoginBtn();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }

}
