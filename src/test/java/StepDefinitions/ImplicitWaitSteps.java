package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitSteps {

    WebDriver driver = null;
    @Given("the user is on the SwagLabs page")
    public void the_user_is_on_the_swag_labs_page() {
        String EdgePath = "C:\\Users\\sofia.buitrago\\Documents\\WaitsCommands\\src\\test\\resources\\Drivers\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver",EdgePath);
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.saucedemo.com/v1/");
    }
    @When("the user logs in on the page")
    public void the_user_logs_in_on_the_page() {


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @Then("the user is redirected to the page products")
    public void the_user_is_redirected_to_the_page_products() {

       String productTitle = driver.findElement(By.className("product_label")).getText();

       if(productTitle.equals("Products")){
           System.out.println("Yes we are in!");
       }else{
           System.out.println("FAIL");
       }
        driver.close();
        driver.quit();

    }
}
