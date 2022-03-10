package Models.Components;

import Pages.BasePage;
import Pages.Component;
import Pages.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value =".login-wrapper")
public class LoginComponent extends Component {

    private static final By emailSel = By.cssSelector(".login-form-group input[type='email']");
    private static final By passwordSel = By.cssSelector(".login-form-group input[type='password']");
    private static final By loginBtnSel = By.cssSelector(".login-form-submit button[type='submit']");
    private static final By emailErrorSel = By.cssSelector(".form-group p[class='errors']");
    private static final By passwordErrorSel = By.cssSelector(".form-group+.login-form-group p[class='errors']");

    public LoginComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }
    public WebElement emailElem() {
        return this.driver.findElement(emailSel);
    }

    public WebElement passwordElem() {
        return this.driver.findElement(passwordSel);
    }

    public WebElement emailErrorElem() {
        return this.driver.findElement(emailErrorSel);
    }
    public WebElement passErrorElem() {
        return this.driver.findElement(passwordErrorSel);
    }

}
