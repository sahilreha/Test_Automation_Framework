package com.testAutomation.webUI.webApplications.dummyAppPages;

import com.testAutomation.webUI.common.WebTestAutomationUtils;
import org.openqa.selenium.By;

public class LoginPage {
    private LoginPage(){
    }
    private static LoginPage loginPage;

    public static LoginPage getInstance(){
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    String URL = "https://thinking-tester-contact-list.herokuapp.com/login";
    By emailTextField = By.cssSelector("#email");
    By passwordTextField = By.cssSelector("#password");
    By submitButton = By.cssSelector("#submit");

    By errorMessage = By.cssSelector("#error");

    By signUpButton = By.id("signup");

    WebTestAutomationUtils webTestAutomationUtils = new WebTestAutomationUtils();

    public void launchLoginPage(){
        webTestAutomationUtils.getWebDriver().get(URL);
    }


    // This method is used to click on sign up button
    public SignUpPage clickOnSignUpButton(){
        webTestAutomationUtils.click(signUpButton);
        return new SignUpPage();
    }

    //This method is used to enter the email
    public LoginPage enterEmail(String email){
         webTestAutomationUtils.typeInto(emailTextField, email);
         return this;
    }

    // This method is used to enter the password
    public LoginPage enterPassword(String password){
        webTestAutomationUtils.typeInto(passwordTextField, password);
        return this;
    }

    // This method is used to click on submit button
    public HomePage clickOnSubmitButton(){
        webTestAutomationUtils.click(submitButton);
        return new HomePage();
    }


    public boolean isErrorValidationMessageAppear(){
        return webTestAutomationUtils.isDisplayed(errorMessage);
    }
}
