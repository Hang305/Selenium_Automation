package Models.Components.Header;

import Pages.Component;
import Pages.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }
}
