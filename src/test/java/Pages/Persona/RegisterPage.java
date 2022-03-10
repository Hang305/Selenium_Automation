package Pages.Persona;

import Common.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage implements Urls {
    private final WebDriver driver;
    private static final By firstNameSel = By.cssSelector(".form-group input[name='firstname']");
    private static final By lastNameSel = By.cssSelector(".form-group input[name='lastname']");
    private static final By emailSel = By.cssSelector(".form-group input[name='email']");
    private static final By passwordSel = By.cssSelector(".form-group input[name='password']");
    private static final By confirmPassSel = By.cssSelector(".form-group input[name='confirmPassword']");
    private static final By signupBtnSel = By.cssSelector(".form-group button[type='submit']");
    private static final By loginLinkSel = By.linkText("Log In Here");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement firstNameElem() {
        return this.driver.findElement(firstNameSel);
    }
    public WebElement lastNameElem() {
        return this.driver.findElement(lastNameSel);
    }
    public WebElement emailElem() {
        return this.driver.findElement(emailSel);
    }
    public WebElement passwordElem() {
        return this.driver.findElement(passwordSel);
    }
    public WebElement confirmPassElem() {
        return this.driver.findElement(confirmPassSel);
    }
    public WebElement signupBtnElem() {
        return this.driver.findElement(signupBtnSel);
    }
    public WebElement loginLinkElem() {
        return this.driver.findElement(loginLinkSel);
    }

    public RegisterPage inputFirstName(String firstName) {
        this.driver.findElement(firstNameSel).sendKeys(firstName);
        return this;
    }

    public RegisterPage inputLastName(String lastName) {
        this.driver.findElement(lastNameSel).sendKeys(lastName);
        return this;
    }

    public RegisterPage inputEmail(String email) {
        this.driver.findElement(emailSel).sendKeys(email);
        return this;
    }

    public RegisterPage inputPassword(String password) {

        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public RegisterPage inputConfirmPassword(String confirmPassword) {

        this.driver.findElement(confirmPassSel).sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage clickSignUpBtn() {

        this.driver.findElement(signupBtnSel).click();
        return this;
    }

    public RegisterPage clickLoginLink() {

        this.driver.findElement(loginLinkSel);
        return this;
    }

}
