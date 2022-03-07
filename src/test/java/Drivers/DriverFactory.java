package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getChromeDriver() {

        WebDriverManager.chromedriver().setup();
        //Open a webpage
        WebDriver driver = new ChromeDriver();

        return driver;
    }
}
