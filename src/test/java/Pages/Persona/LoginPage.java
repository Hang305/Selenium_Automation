package Pages.Persona;

import Models.Components.LoginComponent;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginComponent loginComp() {
        return findComponent(LoginComponent.class, driver);
    }

    public List<LoginComponent> loginComponents() {
        return findComponents(LoginComponent.class, driver);
    }
}
