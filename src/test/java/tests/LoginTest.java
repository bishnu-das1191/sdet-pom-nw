package tests;

import driver.CreateDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;

import java.io.IOException;

public class LoginTest extends BaseTest{

    @Test
    public void verifyValidLogin(){
        LoginPage loginPage = new LoginPage(CreateDriver.getInstance().getDriver());
        loginPage.navigateToLoginPage();
        DashboardPage dashboardPage = loginPage.loginValidUser("standard_user", "secret_sauce");
        System.out.println(dashboardPage.getDashboardURL());
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",dashboardPage.getDashboardURL());
    }

    @Test
    public void verifyErrorMessageForInvalidCredentials(){
        LoginPage loginPage = new LoginPage(CreateDriver.getInstance().getDriver());
        loginPage.navigateToLoginPage();
        loginPage.loginInvalidUser("root", "123456");
        System.out.println(loginPage.getInvalidMessage());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getInvalidMessage());
    }

    @Test
    public void verifyFailTest(){
        LoginPage loginPage = new LoginPage(CreateDriver.getInstance().getDriver());
        loginPage.navigateToLoginPage();
        loginPage.loginInvalidUser("root", "123456");
        Assert.fail("Test is failed by user");
        //System.out.println(loginPage.getInvalidMessage());
        //Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getInvalidMessage());
    }

    @Test(dataProvider = "BulkData")
    public void getMultipleDataFromExcel(String val1, String val2){
        System.out.print(val1 + " | "+val2);
    }


    @DataProvider(name = "BulkData")
    public Object[][] getBulkData(){

        String sheetName = "sheet1";
        ExcelUtils excelFile = new ExcelUtils("TestData",sheetName);
        Object data[][] = excelFile.getTestData(sheetName);
        return data;
    }






    @Test(dataProvider = "sampleData")
    public void testSampleLogin(String value1, String value2){
        System.out.print(value1 + " | "+value2);
    }


    @DataProvider(name = "sampleData")
    public Object[][] getSampleData(){
        return new Object[][] {
                {"data1", "data2"},
                {"data3","data4"},
                {"data5","data6"}
        };
    }

}
