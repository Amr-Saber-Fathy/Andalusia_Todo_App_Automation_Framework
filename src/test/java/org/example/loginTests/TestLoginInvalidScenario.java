package org.example.loginTests;

import dataProviders.LoginDataProvider;
import driverFactory.DriverFactory;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginInvalidScenario {

    WebDriver driver;

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("firefox");
        driver = DriverFactory.getDriver();
        driver.get("https://qacart-todo.herokuapp.com/login");
    }

//    @Test
//    public void userCannotLoginWithEmptyEmail(){
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.clickLoginButton();
//
//        String errorMessage = loginPage.getEmailErrorMessage();
//
//        Assert.assertEquals(errorMessage, "Please Insert a correct Email format");
//    }
//
//    @Test
//    public void userCannotLoginWithEmptyPassword(){
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterEmail("test@test.com");
//        loginPage.clickLoginButton();
//
//        String errorMessage = loginPage.getPasswordErrorMessage();
//
//        Assert.assertEquals(errorMessage, "Password must be Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character");
//    }

    @Test(dataProvider = "InvalidLoginData", dataProviderClass = LoginDataProvider.class)
    public void userCannotLoginWithInvalidData(String email, String password, String expectedErrorMessage, int scenarioNumber){
        LoginPage loginPage = new LoginPage(driver);

//        int ScenarioNumber = 1;
//        String ExpectedErrorMessage = "Please Insert a correct Email format";

        loginPage.login(email, password);

        String errorMessage = "";

        switch (scenarioNumber){
            case 1:
                errorMessage = loginPage.getEmailErrorMessage();
                break;
            case 2:
                errorMessage = loginPage.getPasswordErrorMessage();
                break;
            case 3:
                errorMessage = loginPage.getSystemErrorMessage();
                break;
        }

        Assert.assertEquals(errorMessage, expectedErrorMessage);
    }

    @AfterMethod
    public void refreshPage(){
        driver.navigate().refresh();
    }
}
