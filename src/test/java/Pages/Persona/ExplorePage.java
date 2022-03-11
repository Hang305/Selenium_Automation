package Pages.Persona;

import Common.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExplorePage implements Urls {

    private final WebDriver driver;
    private static final By titleSel = By.cssSelector("h2[class='explore-title-top']");

    public ExplorePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement titleElem() {
        return this.driver.findElement(titleSel);
    }
}
