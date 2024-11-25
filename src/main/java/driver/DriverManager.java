package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getBrowserDriver(String browser){
        switch (browser){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw  new IllegalArgumentException("No Matching Browser Found Issue.");
        }
    }


}
