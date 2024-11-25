package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private String url = "https://www.saucedemo.com/";
    //locators
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButton = By.id("login-button");
    private By invlaidMessage = By.cssSelector(".error-message-container.error");


    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //methods/ logic/ functions

    public LoginPage navigateToLoginPage(){
        driver.get(url);
        return this;
    }

    public DashboardPage loginValidUser(String username, String password){
        login(username, password);
        return new DashboardPage(driver);
    }

    public LoginPage loginInvalidUser(String username, String password){
        login(username, password);
        return this;
    }

    public String getInvalidMessage(){
        waitForVisibility(invlaidMessage);
        return driver.findElement(invlaidMessage).getText();
    }

    private void login(String username, String password){
        waitForVisibility(usernameLocator);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButton).click();
    }

}
