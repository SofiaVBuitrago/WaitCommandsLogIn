package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaits {

    WebDriver driver = null;
    @Given("The user is on the Swag Labs page")
    public void the_user_is_on_the_swag_labs_page() {

        String Path = "C:\\Users\\sofia.buitrago\\Documents\\WaitsCommands\\src\\test\\resources\\Drivers\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", Path);
        driver = new EdgeDriver();

        driver.navigate().to("https://www.saucedemo.com/v1/");




    }
    @When("the user interacts with any of the elements, those are already visible")
    public void the_user_interacts_with_any_of_the_elements_those_are_already_visible() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        /*waiting for the user*/

        WebElement userName = driver.findElement(By.id("user-name"));
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys("standard_user");
        /*waiting for the password*/
        WebElement password = driver.findElement(By.name("password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        /*waiting for the login button */
        password.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        Thread.sleep(6000);
        loginBtn.click();

    }
    @Then("the user is sent to the options page")
    public void the_user_is_sent_to_the_options_page() {
        System.out.println("Coronamos hehe");
        driver.close();
        driver.quit();
    }
}
