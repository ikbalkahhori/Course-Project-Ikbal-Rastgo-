package webstorerestaurant.com.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import webstorerestaurant.com.utils.BrowserUtils;
import webstorerestaurant.com.utils.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchval")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@data-testid='itemDescription']")
    List<WebElement> allTitles;

    @FindBy(xpath = "//input[@name='addToCartButton' ][ last() ]")
    WebElement lastTitle;

    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    WebElement viewButton;

    @FindBy(xpath = "//a[contains(text(),'Empty Cart')]")
    WebElement emtpyCardButton;

    @FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
    WebElement emtpyCardValidationToRemove;

    @FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
    WebElement cartIsEmpty;



    public void searchForItem(String searchValue) {
        searchBox.sendKeys(searchValue, Keys.ENTER);
    }

    @Parameters("keyWord")
    public void validationOfTitles(String keyWord) {

        for (WebElement title : allTitles) {
            boolean result = title.getText().trim().contains(keyWord);
            Assert.assertTrue(result);
        }
    }

    public void addLastItemToCart() {
        lastTitle.click();
    }

    public void clickViewButton() {
        viewButton.click();
    }

    public void emptyCardButton(WebDriver driver) {
        emtpyCardButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(emtpyCardValidationToRemove));
        wait.until(ExpectedConditions.elementToBeClickable(emtpyCardValidationToRemove));
        emtpyCardValidationToRemove.click();

    }
    public String validationOfMessage(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(cartIsEmpty));
       return BrowserUtils.getText(cartIsEmpty);
    }

}
