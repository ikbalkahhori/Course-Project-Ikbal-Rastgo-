package webstorerestaurant.com.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webstorerestaurant.com.utils.Driver;

public class TestBase {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver();
        driver.get("https://www.webstaurantstore.com/");
    }

    @AfterMethod
    public void tearDown(){
        Driver.tearDown();
    }
}
