package Pages.Persona;

import Common.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage implements Urls {

    private final WebDriver driver;
    private static final By emailSel = By.cssSelector(".login-form-group input[type='email']");
    private static final By passwordSel = By.cssSelector(".login-form-group input[type='password']");
    private static final By loginBtnSel = By.cssSelector(".login-form-submit button[type='submit']");
    private static final By emailErrorSel = By.cssSelector(".form-group p[class='errors']");
    private static final By passwordErrorSel = By.cssSelector(".form-group+.login-form-group p[class='errors']");

    public LoginPage(WebDriver driver) {
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


    //Main interaction methods
    public LoginPage inputEmail(String email) {
        this.driver.findElement(emailSel).sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {

        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }
    public LoginPage loginBtnElem() {

        this.driver.findElement(loginBtnSel).click();
        return this;
    }
    public LoginPage clickOnLoginBtn() {

        this.driver.findElement(loginBtnSel).click();
        return this;
    }



}
