package driver;

import org.openqa.selenium.WebDriver;

public class CreateDriver {

    private static CreateDriver INSTANCE;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private CreateDriver() {
    }

    public static synchronized CreateDriver getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CreateDriver();
        }
        return INSTANCE;
    }

    public void setDriver(String browser){
        driver.set(DriverManager.getBrowserDriver(browser));
    }

    public WebDriver getDriver(){
        return driver.get();
    }

}
