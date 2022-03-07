package Pages;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LoginTest implements Urls {

    public static void openLoginPage() {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(LOGIN));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
