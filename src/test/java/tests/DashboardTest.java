package tests;

import driver.CreateDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest{

    @Test
    public void verifyInventoryPageHeader(){
        LoginPage loginPage = new LoginPage(CreateDriver.getInstance().getDriver());
        loginPage.navigateToLoginPage();
        DashboardPage dashboardPage = loginPage.loginValidUser("standard_user", "secret_sauce");
        String inventoryPageHeader = dashboardPage.getInventoryPageHeaderName();
        System.out.println(inventoryPageHeader);
        Assert.assertEquals("Products", inventoryPageHeader);
    }


    @Test
    public void verifyAllProductsAreListed(){
        LoginPage loginPage = new LoginPage(CreateDriver.getInstance().getDriver());
        loginPage.navigateToLoginPage();
        DashboardPage dashboardPage = loginPage.loginValidUser("standard_user", "secret_sauce");
        System.out.println(dashboardPage.getCountOfProductsListed());
        Assert.assertEquals(6, dashboardPage.getCountOfProductsListed());
    }


}
