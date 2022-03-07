import Drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

import static Comon.Urls.BASE_URL;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
