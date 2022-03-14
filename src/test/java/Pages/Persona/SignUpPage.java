package Pages.Persona;

import Models.Components.SignUpComponent;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SignUpComponent signUpComp() {
        return findComponent(SignUpComponent.class, driver);
    }

    public List<SignUpComponent> loginComponents() {
        return findComponents(SignUpComponent.class, driver);
    }
}
