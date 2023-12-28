import drivers.DriverCreator;
import models.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LauncherPage;

import java.util.List;

public class SearchTest {
    @Test
    public void verifyIfSearchTermShowsRelevantResults(){
        //Arrange
        String searchItem = "Product";
        String searchKey = "Product";
        String browser = "chrome";
      //  WebDriver webDriver = null;
        WebDriver webDriver = new DriverCreator().create(browser);
        LauncherPage launcherPage = new LauncherPage(webDriver); // Assume webdriver is created and handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert

        Assert.assertEquals(4, searchItems.size());
        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

    }
    @Test
    public void verifySearchUnavailableProduct() {
        // Arrange
        String unavailableProduct = "Unobtainium Widget";
        WebDriver webDriver = null;
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(unavailableProduct);
        List<Item> searchItems = homepage.getSearchItems();

        // Assert
        Assert.assertTrue(searchItems.isEmpty());
    }
    @Test
    public void verifyBrandSearchListsOnlyBrandItems() {
        // Arrange
        String brandName = "Nike";
        WebDriver webDriver = null;
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        // Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(brandName);
        List<Item> searchItems = homepage.getSearchItems();

        // Assert
      //  Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(brandName)));
    }
   @Test
   public void verifySearchResultCountMatchesDisplayedItems() {
       // Arrange
       String searchItem = "Shoes";
       WebDriver webDriver = null;
       LauncherPage launcherPage = new LauncherPage(webDriver);
       launcherPage.navigateTo("https://web-playground.ultralesson.com/");

       // Act
       HomePage homepage = new HomePage(webDriver);
       homepage.search(searchItem);
       List<Item> searchItems = homepage.getSearchItems();
       //int itemCountDisplayed = homepage.getItemCount();

       // Assert
      // Assert.assertEquals(searchItems.size(), itemCountDisplayed);
   }

}
