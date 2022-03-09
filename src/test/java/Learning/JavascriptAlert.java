package Learning;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptAlert implements Urls {
    private static final By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
    private static final By jsConfirmSel = By.cssSelector("[onclick='jsConfirm()']");
    private static final By jsPromptSel = By.cssSelector("[onclick='jsPrompt()']");
    private static final By resultSel = By.cssSelector("#result");

    public static void javascriptAlert() throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, 10L);

            //Navigate to the test page
            driver.get(BASE_URL.concat(JAVASCRIPT_ALERT));
            WebElement resultElem = driver.findElement(resultSel);


            //JS Alert IMPORTANT !!!!!!!!!!!!!!
            driver.findElement(jsAlertSel).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("JS Alert content: " + jsAlert.getText());
            jsAlert.accept();
            System.out.println(resultElem.getText());
            Thread.sleep(3000);

/*            // Refer to a state elements
               gán lại biến cho elements
               refresh DOM tree
               driver.navigate().refresh();*/


            //JS confirm  IMPORTANT !!!!!!!!!!!!!!
            driver.findElement(jsConfirmSel).click();
            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("JS Confirm content: " + jsConfirm.getText());

         /*   Select [cancel] button with dismiss button
            Select [OK] button with accept button*/
            jsAlert.dismiss();
        /*    //Refer to a state elements
            resultElem = driver.findElement(resultSel);*/

            System.out.println(resultElem.getText());
            Thread.sleep(3000);


            //JS Prompt  IMPORTANT !!!!!!!!!!!
            driver.findElement(jsPromptSel).click();
            Alert jsPromptElem = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("JS Prompt content: " + jsPromptElem.getText());
            Thread.sleep(3000);
            jsPromptElem.sendKeys("This is a new contents");
            Thread.sleep(3000);
            jsAlert.accept();
            System.out.println(resultElem.getText());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
