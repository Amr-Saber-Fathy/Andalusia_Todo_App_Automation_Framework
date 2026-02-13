package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By emailFieldLocator = By.id("email");
    By passwordFieldLocator = By.id("password");
    By loginButtonLocator = By.id("submit");

    //Error messages Locators
    By emailErrorMessageLocator = By.id("email-helper-text");
    By passwordErrorMessageLocator = By.id("password-helper-text");
    By systemErrorMessageLocator = By.className("MuiAlert-message");


    //Methods (Applying Method Chaining)
    public LoginPage enterEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    //Applying Facade Model
    public void login(String email, String password){
        this.enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
    }

    //Methods for getting text from error messages
    public String getEmailErrorMessage(){
        WebElement emailError = driver.findElement(emailErrorMessageLocator);
        return emailError.getText();
    }

    public String getPasswordErrorMessage(){
        WebElement emailError = driver.findElement(passwordErrorMessageLocator);
        return emailError.getText();
    }

    public String getSystemErrorMessage(){
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(systemErrorMessageLocator));
        return emailError.getText();
    }
}
