package tests;

import driver.CreateDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser){
        //System.out.println(browser);

        CreateDriver.getInstance().setDriver(browser);
        CreateDriver.getInstance().getDriver().manage().window().maximize();
        CreateDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown(){
        if(CreateDriver.getInstance().getDriver() != null){
            CreateDriver.getInstance().getDriver().quit();
        }
    }

}
