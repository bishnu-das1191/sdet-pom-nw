package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

    //locators

    private By inventoryPageHeader = By.cssSelector(".title");
    private By productNamesEle = By.cssSelector(".inventory_item_name ");


    //constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //methods // logic  related to only Dashboard page


    public String getDashboardURL(){
        return driver.getCurrentUrl();
    }

    public String getInventoryPageHeaderName(){
        waitForVisibility(inventoryPageHeader);
        return driver.findElement(inventoryPageHeader).getText();
    }

    public int getCountOfProductsListed(){
        waitForVisibility(productNamesEle);
        return driver.findElements(productNamesEle).size();
    }



}
