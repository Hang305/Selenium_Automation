package Models.Components;

import Pages.Component;
import Pages.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".signup-wrapper")
public class SignUpComponent extends Component {

    private static final By titleSel = By.tagName("h2");
    private static final By personalCheckboxSel = By.cssSelector(".card-signup value=['ROLE_DEV']");
    private static final By creatorCheckboxSel = By.cssSelector(".card-signup value=['ROLE_PO']");
    private static final By firstNameSel = By.cssSelector(".form-group input[name='firstname']");
    private static final By lastNameSel = By.cssSelector(".form-group input[name='lastname']");
    private static final By emailSel = By.cssSelector(".form-group input[name='email']");
    private static final By passwordSel = By.cssSelector(".form-group input[name='password']");
    private static final By confirmPasswordSel = By.cssSelector(".form-group input[name='confirmPassword']");
    private static final By signUpBtnSel = By.cssSelector(".form-group button[type='submit']");
    private static final By loginLinkSel = By.cssSelector(".text-muted-2 a");
    private static final By privacyContentSel = By.cssSelector("text-muted-1");

    private static final By firstNameErrorSel = By.cssSelector("input[name='firstname']+.errors");
    private static final By lastNameErrorSel = By.cssSelector("input[name='lastname']+.errors");
    private static final By emailErrorSel = By.cssSelector("input[name='password']+.errors");
    private static final By passwordErrorSel = By.cssSelector(".label-form+.input-group+.errors]");
    private static final By confirmPasswordErrorSel = By.cssSelector(".label-comfirm+.input-group+.errors");
    private static final By modalAlertSel = By.cssSelector("div[role='alert']");


    public SignUpComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    //get internal persona checkbox element
    public WebElement personaCheckboxElem() {
        return this.driver.findElement(personalCheckboxSel);
    }

    //get project creator checkbox element
    public WebElement projectCreatorCheckboxElem() {
        return this.driver.findElement(creatorCheckboxSel);
    }

    //get title element
    public WebElement titleElem() {
        return this.driver.findElement(titleSel);
    }

    //get login hyperlink element
    public WebElement loginLinkElem() {
        return this.driver.findElement(loginLinkSel);
    }

    //get first name element
    public WebElement firstNameElem() {
        return this.driver.findElement(firstNameSel);
    }
    //get last name element
    public WebElement lastNameElem() {
        return this.driver.findElement(lastNameSel);
    }
    //get email element
    public WebElement emailElem() {
        return this.driver.findElement(emailSel);
    }
    //get last name element
    public WebElement passwordElem() {
        return this.driver.findElement(passwordSel);
    }
    //get email element
    public WebElement confirmPasswordElem() {
        return this.driver.findElement(confirmPasswordSel);
    }

    //get first name error msg alert
    public WebElement firstNameErrorMsgElem() {
        return this.driver.findElement(firstNameErrorSel);
    }

    //get last name error msg alert
    public WebElement lastNameErrorMsgElem() {
        return this.driver.findElement(lastNameErrorSel);
    }

    //get email error msg alert
    public WebElement emailErrorMsgElem() {
        return this.driver.findElement(emailErrorSel);
    }

    //get password error msg alert
    public WebElement passwordErrorMsgElem() {
        return this.driver.findElement(passwordErrorSel);
    }

    //get confirm password error msg alert
    public WebElement confirmPasswordErrorMsgElem() {
        return this.driver.findElement(confirmPasswordErrorSel);
    }

    //get first name error msg alert
    public WebElement emailErrorElem() {
        return this.driver.findElement(emailErrorSel);
    }

    //get modal alert
    public WebElement modelAlertElem() {
        return this.driver.findElement(modalAlertSel);
    }


    //return input title
    public SignUpComponent inputTitle() {
        this.driver.findElement(titleSel).getText().trim();
        return this;
    }

    //return input first name
    public SignUpComponent inputFirstName(String firstName) {
        this.driver.findElement(firstNameSel).sendKeys(firstName);
        return this;
    }

    //return input last name
    public SignUpComponent inputLastName(String lastName) {
        this.driver.findElement(lastNameSel).sendKeys(lastName);
        return this;
    }

    //return input email
    public SignUpComponent inputEmail(String email) {
        this.driver.findElement(emailSel).sendKeys(email);
        return this;
    }

    //return input password
    public SignUpComponent inputPassword(String password) {
        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    //return input confirm password
    public SignUpComponent inputConfirmPassword(String confirmPassword) {
        this.driver.findElement(confirmPasswordSel).sendKeys(confirmPassword);
        return this;
    }

    //return click on sign up button
    public SignUpComponent clickOnSignUpBtn() {
        this.driver.findElement(signUpBtnSel).click();
        return this;
    }

    //return click on login hyperlink
    public SignUpComponent clickOnLoginHyperlink() {
        this.driver.findElement(loginLinkSel).click();
        return this;
    }

    //return input privacy hyperlink
    public SignUpComponent inputPrivacyHyperlink() {
        this.driver.findElement(By.tagName("span")).getText();
        return this;
    }

    // error msg of first name
    public SignUpComponent inputFirstNameError() {
        this.driver.findElement(firstNameErrorSel).getText().trim();
        return this;
    }

    //error msg of last name
    public SignUpComponent inputLastNameError() {
        this.driver.findElement(lastNameErrorSel).getText().trim();
        return this;
    }

    // error msg of email
    public SignUpComponent inputEmailError() {
        this.driver.findElement(emailErrorSel).getText().trim();
        return this;
    }

    //error msg of password
    public SignUpComponent inputPasswordError() {
        this.driver.findElement(passwordErrorSel).getText().trim();
        return this;
    }

    // error msg of confirm password
    public SignUpComponent inputConfirmPasswordError() {
        this.driver.findElement(confirmPasswordErrorSel).getText().trim();
        return this;
    }
}
