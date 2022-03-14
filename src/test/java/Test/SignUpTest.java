package Test;

import Common.Hyperlink;
import Common.Urls;
import Drivers.DriverFactory;
import Models.Components.SignUpComponent;
import Pages.Persona.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpTest implements Urls {

    WebDriver driver = DriverFactory.getChromeDriver();
    private JavascriptExecutor jsExecutor;
    private String email, emailContent, confirmationCode;
    ArrayList<String> tabs;

    @BeforeTest
    public void init() {
        driver.get(BASE_URL.concat(SIGNUP));
        jsExecutor = (JavascriptExecutor) driver;
    }

    // TC01: title is displayed correctly
    @Test
    public void TC01_TitleIsDisplayedCorrectly() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            String actualTitleTest = signUpComponent.titleElem().getText().trim();
            String expectedTitleTest = "Sign Up";

            Assert.assertEquals(actualTitleTest, expectedTitleTest, "[ERROR] The title of Sign Up page is displayed incorrectly!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TC02: Internal persona is checked 
    @Test
    public void TC02_PersonaIsChecked() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            boolean checked = signUpComponent.personaCheckboxElem().isSelected();

            Assert.assertEquals(checked, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC03: all elements are blank
    @Test
    public void TC03_Blank() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();

            signUpComponent.inputFirstName("").toString();
            signUpComponent.inputLastName("");
            signUpComponent.inputPassword("");
            signUpComponent.inputConfirmPassword("");
            signUpComponent.inputEmail("");
            signUpComponent.clickOnSignUpBtn();

            List<String> expectedMessageTest = Arrays.asList("Required!", "Required!", "Required!", "Required!", "Required!");
            List<String> actualMessageTest = Arrays.asList(signUpComponent.inputFirstNameError().toString(), signUpComponent.inputLastNameError().toString(), signUpComponent.inputEmailError().toString(), signUpComponent.inputPasswordError().toString(), signUpComponent.inputConfirmPasswordError().toString());

            Assert.assertEquals(actualMessageTest, expectedMessageTest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC04: FirstName is invalid data with number
    @Test
    public void TC04_FirstName_InvalidData() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();

            signUpComponent.inputFirstName("34");
            signUpComponent.clickOnSignUpBtn();
            String actualMessageTest = signUpComponent.firstNameErrorMsgElem().getText();
            String expectedMessageTest = "Please enter valid name";

            Assert.assertEquals(actualMessageTest, expectedMessageTest);
            signUpComponent.firstNameElem().clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC05: lastname is invalid data with number
    @Test
    public void TC05_LastName_InvalidData() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.inputLastName("34");
            signUpComponent.clickOnSignUpBtn();

            String actualMessageTest = signUpComponent.lastNameErrorMsgElem().getText();
            String expectedMessageTest = "Please enter valid name";
            Assert.assertEquals(actualMessageTest, expectedMessageTest);
            signUpComponent.lastNameElem().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC06: email is invalid with number
    @Test
    public void TC06_Email_InvalidData() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.inputEmail("3423");
            signUpComponent.clickOnSignUpBtn();

            String actualMessageTest = signUpComponent.emailErrorElem().getText();
            String expectedMessageTest = "Invalid email format";
            Assert.assertEquals(actualMessageTest, expectedMessageTest);

            signUpComponent.emailElem().clear();
//            driver.navigate().refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC07: email is invalid with number
    @Test
    public void TC07_Password_InvalidData() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.inputPassword("ha12");
            signUpComponent.clickOnSignUpBtn();

            String actualMessageTest = signUpComponent.passwordErrorMsgElem().getText();
            String expectedMessageTest = "At least one uppercase, one number and one special case character";

            Assert.assertEquals(actualMessageTest, expectedMessageTest);
            signUpComponent.passwordElem().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC08: confirm password is not match password
    @Test
    public void TC08_ConfirmPassword_NotMatch() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.inputConfirmPassword("23");
            signUpComponent.clickOnSignUpBtn();

            String actualMessageTest = signUpComponent.confirmPasswordErrorMsgElem().getText();
            System.out.println(actualMessageTest);
            String expectedMessageTest = "Password doesn’t match";

            Assert.assertEquals(actualMessageTest, expectedMessageTest);
            signUpComponent.confirmPasswordElem().clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TC09: sign up successfully
    @Test
    public void TC09_SignUpSuccess() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.inputFirstName("Hang");
            signUpComponent.inputLastName("test");

            // Set value for email with add randomNumber to Not duplicated email when run more than once
            email = "hang.le" + randomNumber() + "@mailsac.com";
            signUpComponent.inputEmail(email);
            signUpComponent.inputPassword("Ha123@");
            signUpComponent.inputConfirmPassword("Ha123@");
            signUpComponent.clickOnSignUpBtn();

            Thread.sleep(20000);
//            driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
            String actualVerifyEmailTest = driver.getCurrentUrl();
            String expectedVerifyEmailTest = BASE_URL.concat(VERIFY_EMAIL);
            Assert.assertEquals(actualVerifyEmailTest, expectedVerifyEmailTest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    //TC10: verify email
//    @Test
//    public void TC10_verifyEmail(){
//        try {
//            jsExecutor.executeScript("window.open('http://mailsac.com','_blank');");
//            // Get the current tabs is opened and switch to tab has index =1, Tab mailsac.com at tab 2 has index =1
//            tabs = new ArrayList<>(driver.getWindowHandles());
//            //Switch to tab mailsac.com already open
//            driver.switchTo().window(tabs.get(1));
//            driver.findElement(By.cssSelector("input[placeholder='anything']")).sendKeys(email);
//            //Enter "Check the email" button to access mailbox
//            driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
//            //Click on mail to open content mail
//            driver.findElement(By.cssSelector("td[class='col-xs-5 ng-binding']")).click();
//            //Get text of content mail and set for emailContent variable
//            emailContent = driver.findElement(By.cssSelector("div[class='ng-binding ng-scope']")).getText();
//            //Using regex to verify the list number in email content
//            Pattern data = Pattern.compile("[0-9]{6}");
//            Matcher matcher = data.matcher(emailContent);
//            matcher.find();
//            // Set value with 6 numbers (confirmation code) to confirmationCode variable
//            confirmationCode = emailContent.substring(matcher.start(), matcher.end());
//
//            //Switch to tab playground.mailslurp.com (index = 0)
//            driver.switchTo().window(tabs.get(0));
//            driver.findElement(By.cssSelector(".verify-email-form-input-textbox")).sendKeys(confirmationCode);
//            driver.findElement(By.cssSelector(".verify-email-form-btn")).click();
//            Thread.sleep(5000);
//            String actualVerifyEmailTest =driver.getCurrentUrl();
//            String expectedVerifyEmailTest = BASE_URL.concat(EXPLORE_PAGES);
//            Assert.assertEquals(actualVerifyEmailTest, expectedVerifyEmailTest);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //TC11: navigate to the login page
    @Test
    public void TC11_LoginLink() {
        try {
            SignUpPage signUpPage = new SignUpPage(driver);
            SignUpComponent signUpComponent = signUpPage.signUpComp();
            signUpComponent.clickOnLoginHyperlink();
            Hyperlink hyperlink = new Hyperlink(signUpComponent.loginLinkElem().getText(), signUpComponent.loginLinkElem().getAttribute("href"));

            String actualTest = "https://iresource.smartdev.vn/login";
            String expectedTest = hyperlink.getLink();
            Assert.assertEquals(actualTest, expectedTest);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public int randomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt();
        return randomNumber;
    }
}
