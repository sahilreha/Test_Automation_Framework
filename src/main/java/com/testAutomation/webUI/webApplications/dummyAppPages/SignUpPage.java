package com.testAutomation.webUI.webApplications.dummyAppPages;

import com.testAutomation.webUI.common.WebTestAutomationUtils;
import org.openqa.selenium.By;

public class SignUpPage {
    private static SignUpPage signUpPage;
    public SignUpPage(){

    }

    public static SignUpPage getInstance(){
        if(signUpPage==null){
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }
    String URL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    String titlePage = "Add User";
    By firstNameTextField = By.id("firstName");
    By lastNameTextField = By.id("lastName");
    By emailTextField = By.id("email");
    By passwordTextField = By.cssSelector("#password");
    By submitButton = By.cssSelector("#submit");

    WebTestAutomationUtils webTestAutomationUtils = new WebTestAutomationUtils();


    public void launchSignupPage(){
        webTestAutomationUtils.getWebDriver().get(URL);
    }

    //This method is used to enter the first name
    public SignUpPage enterFirstName(String firstName){
        webTestAutomationUtils.typeInto(firstNameTextField, firstName);
        return this;
    }

    //This method is used to enter the first name
    public SignUpPage enterLastName(String lastName){
        webTestAutomationUtils.typeInto(lastNameTextField, lastName);
        return this;
    }

    //This method is used to enter the first name
    public SignUpPage enterEmail(String email){
        webTestAutomationUtils.typeInto(emailTextField, email);
        return this;
    }

    // This method is used to enter the password
    public SignUpPage enterPassword(String password){
        webTestAutomationUtils.typeInto(passwordTextField, password);
        return this;
    }

    // This method is used to click on submit button
    public HomePage clickOnSubmitButton(){
        webTestAutomationUtils.click(submitButton);
        return new HomePage();
    }

}
