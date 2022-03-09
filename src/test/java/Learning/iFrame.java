package Learning;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iFrame implements Urls {
    public static void iframe() throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

            //Navigate to the test page
            driver.get(BASE_URL.concat(IFRAME));

            //Switch to iFrame IMPORTANT!!!!!!!!!!
            WebElement iFrameElem = driver.findElement(By.cssSelector("[id$='ifr']"));
            driver.switchTo().frame(iFrameElem);

            //Clear default text then input a new one
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            Thread.sleep(1000);
            editorInputElem.sendKeys("This is the new texts");

            //Switch back to default frame
//            driver.switchTo().defaultContent();
            Thread.sleep(2000);

            // Another interface


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
