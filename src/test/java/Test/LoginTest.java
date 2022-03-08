package Test;

import Common.Urls;
import Drivers.DriverFactory;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest implements Urls {

    public static void main(String[] args) {
        testLoginPageTraditonalPOM();
        testLoginPageMainInteractionMethods();

        //Builder Design Patterns
        testLoginPageMainMethodChaining();
    }

    //Return WebElement
    private static void testLoginPageTraditonalPOM() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.passwordElem().sendKeys("ha");
            loginPage.passwordElem().sendKeys("2743842");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //
    private static void testLoginPageMainInteractionMethods() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("hang");
            loginPage.inputPassword("2743842");
            loginPage.clickOnLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Using form should be used to add all elements
    //Single responsibility - only one method using one funtion
    private static void testLoginPageMainMethodChaining() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(BASE_URL.concat(LOGIN));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("hag")
                    .inputPassword("2743842")
                    .clickOnLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
