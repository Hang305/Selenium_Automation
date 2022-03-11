package Pages;

import Models.Components.Header.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BasePage extends Component {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        super(driver, driver.findElement(By.tagName("html")));
    }

    public HeaderComponent headerComp() {
        return findComponent(HeaderComponent.class, driver);
    }
}
