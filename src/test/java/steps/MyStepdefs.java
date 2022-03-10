package steps;

import Drivers.DriverFactory;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import static Common.Urls.BASE_URL;
import static Common.Urls.LOGIN;

public class MyStepdefs implements En {
    WebDriver driver = DriverFactory.getChromeDriver();
    public MyStepdefs() {

        Given("^I'm on login page$", () -> {
            driver.get(BASE_URL.concat(LOGIN));
        });
        When("^I login to system$", () -> {
        });
        Then("^System displays welcome message$", () -> {
        });
    }
}
