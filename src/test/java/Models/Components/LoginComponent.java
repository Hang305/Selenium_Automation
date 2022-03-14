package Models.Components;

import Pages.Component;
import Pages.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".login-wrapper")
public class LoginComponent extends Component {

    private static final By titleSel = By.tagName("h2");
    private static final By decriptionSel = By.cssSelector(".login-wrapper p");
    private static final By emailSel = By.cssSelector(".login-form-group input[type='email']");
    private static final By passwordSel = By.cssSelector(".login-form-group input[type='password']");
    private static final By loginBtnSel = By.cssSelector(".login-form-submit button[type='submit']");

    private static final By emailErrorSel = By.cssSelector(".form-group p[class='errors']");
    private static final By passwordErrorSel = By.cssSelector(".form-group+.login-form-group p[class='errors']");
    private static final By modalAlertSel = By.cssSelector("div[role='alert']");
    private static final By rememberSel = By.cssSelector(".login-form-group-remember span[class='remeber-mark']");
    private static final By forgetPasswordSel = By.cssSelector(".login-form-forgot a");

    public LoginComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    //get email element
    public WebElement emailElem() {
        return this.driver.findElement(emailSel);
    }

    //get password element
    public WebElement passwordElem() {
        return this.driver.findElement(passwordSel);
    }

    //get login element
    public WebElement loginBtn() {
        return this.driver.findElement(loginBtnSel);
    }

    //get email error message element
    public WebElement emailErrorElem() {
        return this.driver.findElement(emailErrorSel);
    }

    //get password error message element
    public WebElement passErrorElem() {
        return this.driver.findElement(passwordErrorSel);
    }

    //get modal alert
    public WebElement modelAlertElem() {
        return this.driver.findElement(modalAlertSel);
    }

    //get rememberMe
    public WebElement rememberMeElem() {
        return this.driver.findElement(rememberSel);
    }

    //return input title
    public LoginComponent inputTitle() {
        this.driver.findElement(titleSel).getText();
        return this;
    }
    //return input decription
    public LoginComponent inputDecription() {
        this.driver.findElement(decriptionSel).getText();
        return this;
    }

    //return input email
    public LoginComponent inputEmail(String email) {
        this.driver.findElement(emailSel).sendKeys(email);
        return this;
    }

    //return input password
    public LoginComponent inputPassword(String password) {
        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }
}
