package Learning;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MouseHover implements Urls {
    private static final By figureSelector = By.className("figure");
    private static final By figueImageSel = By.tagName("img");
    private static final By figueDecsSel = By.tagName("h5");
    private static final By figueHyperlinkSel = By.tagName("a");

    public static void hoverMouse() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

            //Navigate to the test page
            driver.get(BASE_URL.concat(HOVERS));

            //Find a list of figures on the page
            List<WebElement> figureElems = driver.findElements(figureSelector);
            List<FigureData> figureDataList = new ArrayList<>();

            //Actions
            Actions actions = new Actions(driver);

            //Verification
            if (figureElems.isEmpty()) {
                throw new RuntimeException("[ERROR] The is no user figure on then page!");

            } else {
                for (WebElement figureElem : figureElems) {

                    //Mouse hovers  IMPORTANT!!!!!!!!!
                    actions.moveToElement(figureElem).perform();

                    //Get figure data
                    WebElement figueImgElem = figureElem.findElement(figueImageSel);
                    WebElement figueDecsElem = figureElem.findElement(figueDecsSel);
                    WebElement figueImgLinkElem = figureElem.findElement(figueHyperlinkSel);

                    //Printout
//                    System.out.println(figueImgElem.getAttribute("src"));
//                    System.out.println(figueDecsElem.getText());
//                    System.out.println(figueImgLinkElem.getAttribute("href"));

                    FigureData figureData = new FigureData(figueImgElem.getAttribute("src"),figueDecsElem.getText() ,figueImgLinkElem.getAttribute("href"));
                    figureDataList.add(figureData);
                    Thread.sleep(1000);
                }
            }
            for (FigureData figureData : figureDataList) {
                System.out.println(figureData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
