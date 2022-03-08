package Pages;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage implements Urls {
    private final WebDriver driver;
    private static final By usernameSel = By.cssSelector("#username");
    private static  final By passwordSel = By.cssSelector("#password");
    private static final By loginBtnSel = By.cssSelector("#login button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameElem (){
        return this.driver.findElement(usernameSel);
    }
    public WebElement passwordElem (){
        return this.driver.findElement(passwordSel);
    }

    //Main interaction methods
    public LoginPage inputUsername(String username){
        this.driver.findElement(usernameSel).sendKeys(username);
        return  this;
    }

    public LoginPage inputPassword(String password){
        this.driver.findElement(passwordSel).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginBtn (){
        this.driver.findElement(loginBtnSel).click();
        return this;
    }


}
