package pages;

import models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{
    By searchIcon = By.cssSelector("summary [aria-label='Search']");
    By searchBar = By.id("Search-In-Modal");
    By searchResults = By.cssSelector("li[id^='predictive-search-option'] a");
    By productName = By.cssSelector(".predictive-search_item-heading");

    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
      //  this.webDriver=webDriver;
        super(webDriver);
    }
    public void search(String searchItem) {
        webDriver.findElement(searchIcon).click();
        webDriver.findElement(searchBar).sendKeys(searchItem);
    }
    public List<Item> getSearchItems() {
       List<WebElement>  elements = webDriver.findElements(searchResults);
        // elements = webDriver.findElement(searchResults);
        List<Item> items = new ArrayList<>();
             for (WebElement element : elements){
                 String name = element.findElement(productName).getText();
                 Item item=new Item();
                 item.setName(name);
                 items.add(item);

             }
        return items;
    }
}
