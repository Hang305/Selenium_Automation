package Test;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class VerifyEmailTest implements Urls {
    WebDriver driver = DriverFactory.getChromeDriver();
    private JavascriptExecutor jsExecutor;
    private String email, emailContent, confirmationCode;
    ArrayList<String> tabs;

    @BeforeClass
    public void beforeTest(){
        //Constructor javavascript executor
        jsExecutor = (JavascriptExecutor) driver;
        driver.get(BASE_URL.concat(VERIFY_EMAIL));
    }

//    @Test(dependsOnMethods = "TC09_SignUpSuccess")
//    public void TC01_VerifyEmail() {
//        try {
//
//            VerifyEmailPage verifyEmailPage = new VerifyEmailPage(driver);
//
//            //Enter "Check the email" button to access mailbox
//            verifyEmailComponent.clickOnCreateEmail();
//
//            //Click on mail to open content mail
//            verifyEmailComponent.clickOnOpenEmail();
//
//            //Get text of content mail and set for emailContent variable
//            emailContent = verifyEmailComponent.contentEmailElem().getText();
//            //Using regex to verify the list number in email content
//            Pattern data = Pattern.compile("[0-9]{6}");
//            Matcher matcher = data.matcher(emailContent);
//            matcher.find();
//
//            // Set value with 6 numbers (confirmation code) to confirmationCode variable
//            confirmationCode = emailContent.substring(matcher.start(), matcher.end());
//
//            //Switch to tab playground.mailslurp.com (index = 0)
//            driver.switchTo().window(tabs.get(0));
//            verifyEmailComponent.enterPinCodeEmail(confirmationCode);
//            verifyEmailComponent.clickOnVerifyEmail();
//
//            Thread.sleep(5000);
//            String actualVerifyCodeTest = driver.getCurrentUrl();
//            String expectedPinCodeTest = BASE_URL.concat(EXPLORE_PAGES);
//            Assert.assertEquals(actualVerifyCodeTest,expectedPinCodeTest);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }


}
