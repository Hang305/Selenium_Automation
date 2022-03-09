package Learning;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown implements Urls {
    public static void dropdown() throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

            //Navigate to the test page
            driver.get(LEARNING_URL.concat(DROPDOWN));

            //Target dropdowns
            WebElement dropDowns = driver.findElement(By.cssSelector("#dropdown"));
            Select select = new Select(dropDowns);
            //OR
//            Select select = driver.findElement(By.cssSelector("#dropdown"));

            //Get text is displayed
            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            //Get index of option with start from 0,1,2...
            select.selectByIndex(2);
            Thread.sleep(1000);

            //Get value of option
            select.selectByValue("1");
            Thread.sleep(1000);

            //Dropdown with data động - xpath get data


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
