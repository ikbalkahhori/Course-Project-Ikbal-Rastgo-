package webstorerestaurant.com.tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webstorerestaurant.com.pages.HomePage;
import webstorerestaurant.com.utils.Driver;

public class HomePageTest extends TestBase {

    HomePage homePage;
    @Parameters({"searchValue","keyWord"})
    @Test
    public void validateAllTitlesHaveTheKeyWord(String searchValue,String keyWord) throws InterruptedException {
        homePage=new HomePage();
        homePage.searchForItem(searchValue);
        homePage.validationOfTitles(keyWord);
        homePage.addLastItemToCart();
        homePage.clickViewButton();
        homePage.emptyCardButton(driver);
        Assert.assertEquals(homePage.validationOfMessage(driver),"Your cart is empty.");
    }
}
