package Pages;

import Common.Urls;
import Drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

public class HomePage implements Urls {
    WebDriver driver = DriverFactory.getChromeDriver();

   public void HomePage (){
       try{

           driver.get(BASE_URL);
           driver.navigate().to("https://iresource.smartdev.vn/");

           //Back to page
           driver.navigate().back();

           driver.navigate().refresh();

           //Navigate to forward page - điều hướng tới trang tiếp theo
           driver.navigate().forward();

           //getTitle()
           driver.getTitle();

           //getCurrentUrl()
           driver.getCurrentUrl();

           //getPageSource()
           driver.getPageSource();

           Thread.sleep(2000);
       }catch(Exception e){
           e.printStackTrace();
       }
        finally{
           driver.quit();
       }
   }

}
