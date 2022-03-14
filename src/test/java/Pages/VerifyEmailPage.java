package Pages;

import Drivers.DriverFactory;
import Models.Components.VerifyEmailComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class VerifyEmailPage extends BasePage{
    WebDriver driver = DriverFactory.getChromeDriver();
    private JavascriptExecutor jsExecutor;
    private String email, emailContent, confirmationCode;
    ArrayList<String> tabs;
    public VerifyEmailPage(WebDriver driver) {
        super(driver);
    }
    public VerifyEmailComponent verifyEmalComp() {
        return findComponent(VerifyEmailComponent.class, driver);
    }

    public List<VerifyEmailComponent> verifyEmailComponents() {
        return findComponents(VerifyEmailComponent.class, driver);
    }
}
