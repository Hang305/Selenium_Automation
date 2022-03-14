package Models.Components;

import Pages.Component;
import Pages.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ComponentCssSelector(value = ".verify-email-wrapper")
public class VerifyEmailComponent extends Component {
    private JavascriptExecutor jsExecutor;
    private String email, emailContent, confirmationCode;
    ArrayList<String> tabs;

    private static By enterEmailSel = By.cssSelector("input[placeholder='anything']");
    private static By createEmailSel = By.cssSelector("button[class='btn btn-primary']");
    private static By openEmailSel = By.cssSelector("td[class='col-xs-5 ng-binding']");
    private static By contentEmailSel = By.cssSelector("div[class='ng-binding ng-scope']");

    private static By enterCodeSel = By.cssSelector(".verify-email-form-input-textbox");
    private static By verifyCodeEmailSel = By.cssSelector(".verify-email-form-btn");
    private static By contentAddressEmail = By.cssSelector(".verify-email-form-content-email");
    private static By titleSel = By.tagName("h2");
    private static By contentVerifyEmail = By.cssSelector(".verify-email-form-content p");
    private static By resendEmailBtnSel = By.cssSelector(".verify-email-form-resend-btn");

    public VerifyEmailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public String getEmailContent() {
        return emailContent;
    }
    public String getConfirmationCode() {
        return confirmationCode;
    }
    public String inputEmail(String email) {
        return email;
    }

    //return input enterEmail
    public VerifyEmailComponent enterEmail(String email) {
        this.driver.findElement(enterEmailSel).sendKeys(email);
        return this;
    }

    //click on create a email
    public VerifyEmailComponent clickOnCreateEmail() {
        this.driver.findElement(createEmailSel).click();
        return this;
    }

    //click on open check email
    public VerifyEmailComponent clickOnOpenEmail() {
        this.driver.findElement(openEmailSel).click();
        return this;
    }

    public WebElement contentEmailElem(){
        return this.driver.findElement(contentEmailSel);
    }
    //return content email
    public VerifyEmailComponent inputContentEmail() {
        emailContent = this.driver.findElement(contentEmailSel).getText();
        return this;
    }

    //return input enter code from email
    public VerifyEmailComponent enterPinCodeEmail(String pincode) {
        this.driver.findElement(enterCodeSel).sendKeys(pincode);
        return this;
    }

    //click on the verify email button
    public VerifyEmailComponent clickOnVerifyEmail() {
        this.driver.findElement(verifyCodeEmailSel).click();
        return this;
    }

    // navigate to Mailsac pages
    public void navigateToMailsac() {
        jsExecutor.executeScript("window.open('http://mailsac.com','_blank');");
        // Get the current tabs is opened and switch to tab has index =1, Tab mailsac.com at tab 2 has index =1
        tabs = new ArrayList<>(driver.getWindowHandles());
        //Switch to tab mailsac.com already open
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.cssSelector("input[placeholder='anything']")).sendKeys(email);
        //Enter "Check the email" button to access mailbox
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        //Click on mail to open content mail
        driver.findElement(By.cssSelector("td[class='col-xs-4 ng-binding']")).click();
        //Get text of content mail and set for emailContent variable
        emailContent = driver.findElement(By.cssSelector("div[class='ng-binding ng-scope']")).getText();
        //Using regex to verify the list number in email content
        Pattern data = Pattern.compile("[0-9]{6}");
        Matcher matcher = data.matcher(emailContent);
        matcher.find();
        // Set value with 6 numbers (confirmation code) to confirmationCode variable
        confirmationCode = emailContent.substring(matcher.start(), matcher.end());

        //Switch to tab playground.mailslurp.com (index = 0)
        driver.switchTo().window(tabs.get(0));

    }

}