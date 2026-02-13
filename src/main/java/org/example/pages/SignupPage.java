package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BasePage{

    //Constructor
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By firstNameFieldLocator = By.cssSelector("input[data-testid='first-name']");
    By lastNameFieldLocator = By.cssSelector("input[data-testid='last-name']");
    By emailFieldLocator = By.cssSelector("input[data-testid='email']");
    By passwordFieldLocator = By.cssSelector("input[data-testid='password']");
    By confirmPasswordFieldLocator = By.cssSelector("input[data-testid='confirm-password']");

    By signupButtonLocator = By.cssSelector("button[data-testid='submit']");

    //Error Message
    By fieldErrorMessageLocator = By.xpath("//p[contains(@class,'Mui-required')]");
    By systemErrorMessageLocator = By.className("MuiAlert-message");

    //Methods
    public SignupPage enterFirstName(String firstName){
        driver.findElement(firstNameFieldLocator).sendKeys(firstName);
        return this;
    }

    public SignupPage enterLastName(String lastName){
        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
        return this;
    }

    public SignupPage enterEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
        return this;
    }

    public SignupPage enterPassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
        return this;
    }

    public SignupPage enterConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordFieldLocator).sendKeys(confirmPassword);
        return this;
    }

    public void clickSignupButton(){
        driver.findElement(signupButtonLocator).click();
    }

    //Signup Method
    public void signUp(String firstName, String lastName, String email, String password, String confirmPassword){
        this.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickSignupButton();
    }

    //Methods to get error message text
    public String getFieldErrorMessage(){
        WebElement fieldErrorMessage = driver.findElement(fieldErrorMessageLocator);
        return fieldErrorMessage.getText();
    }

    public String getSystemErrorMessage(){
        WebElement systemErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(systemErrorMessageLocator));
        if(systemErrorMessage == null){
            return "WebElement is not displayed";
        }else {
            return systemErrorMessage.getText();
        }
    }
}
