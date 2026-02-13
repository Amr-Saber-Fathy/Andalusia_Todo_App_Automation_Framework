package org.example.loginTests;

import driverFactory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginHappyScenario {

    WebDriver driver;

    String validEmail = "tester@test.co";
    String validPassword = "test_12test";

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("chrome");
        driver = DriverFactory.getDriver();
        driver.get("https://qacart-todo.herokuapp.com/login");
    }

    @Test
    public void userCanLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(validEmail, validPassword);

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.checkLogoutButtonDisplay(), "Logout Button is not displayed");
    }
}
