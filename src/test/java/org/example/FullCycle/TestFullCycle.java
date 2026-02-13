package org.example.FullCycle;

import driverFactory.DriverFactory;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFullCycle {

    WebDriver driver;

    String email = "tester@test.co";
    String password = "test_12test";

    String todoTitle = "Automation Task Todo";

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void initDriver(){
        DriverFactory.initDriver("Edge");
        driver = DriverFactory.getDriver();

        driver.get("https://qacart-todo.herokuapp.com/login");
    }

    @Test
    public void loginWithValidCredentials(){
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        homePage = new HomePage(driver);

        Assert.assertTrue(homePage.checkLogoutButtonDisplay());
    }

    @Test(dependsOnMethods = {"loginWithValidCredentials"})
    public void addNewTodo(){
        homePage.clickAddNewTodoButton();
        homePage.enterTodoTitle(todoTitle);
        homePage.clickCreateNewTodoButton();

        Assert.assertTrue(homePage.checkAddedTodoTitle(todoTitle));
    }

    @Test(dependsOnMethods = {"addNewTodo"})
    public void markTodoAsDone(){
        homePage.clickDoneCheckbox();

//        Assert.assertTrue(homePage.checkTodoBackGroundColor("#214c61"));
    }

    @Test(dependsOnMethods = {"markTodoAsDone"})
    public void unMarkTodo(){
        homePage.clickDoneCheckbox();

//        Assert.assertTrue(homePage.checkTodoBackGroundColor("#3f51b5"));
    }

    @Test(dependsOnMethods = {"unMarkTodo"})
    public void deleteTodo(){
        homePage.clickDeleteButton();

        Assert.assertTrue(homePage.checkTodoIsDeleted(todoTitle));
    }
}
