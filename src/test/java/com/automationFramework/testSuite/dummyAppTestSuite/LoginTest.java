package com.automationFramework.testSuite.dummyAppTestSuite;


import com.automationFramework.baseTestUtility.TestDataUtils;
import com.automationFramework.dataobjects.dummyAppDataObjects.CreateAccountTestData;
import com.testAutomation.webUI.webApplications.dummyAppPages.AddContactPage;
import com.testAutomation.webUI.webApplications.dummyAppPages.HomePage;
import com.testAutomation.webUI.webApplications.dummyAppPages.LoginPage;
import com.testAutomation.webUI.webApplications.dummyAppPages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends DummyBaseTest {

    // By using the object reference, We can use the test data in our test script
    LoginTestData loginTestData = TestDataUtils.fetchWebTestData("logintestdata", LoginTestData.class);
    SignUpTestData signUpTestData = TestDataUtils.fetchWebTestData("signuptestdata", SignUpTestData.class);
    CreateAccountTestData createAccountTestData = TestDataUtils.fetchWebTestData("createnewaccount", CreateAccountTestData.class);

    //Creating object reference for pages
    LoginPage loginPage = LoginPage.getInstance();
    SignUpPage signUpPage = SignUpPage.getInstance();
    HomePage homePage = new HomePage();
    AddContactPage contactPage = new AddContactPage();

    @Test(priority = 1, description = "Verify that user is able to login with the existing user")
    public void loginWithExistingAccountTest() {

        // Enter login credentials and submit
        loginPage.launchLoginPage();
        loginPage.enterEmail(loginTestData.getUsername())
                .enterPassword(loginTestData.getPassword());
        loginPage.clickOnSubmitButton();

        // Clicking on logout button
        homePage.clickOnLogoutButton();
    }


    @Test( priority = 2, description = "Verify that user is able to create the new account and login with the same credentials")
    public void createAnAccountTest() {
        // Clicking on sing up button
        //loginPage.clickOnSignUpButton();

        signUpPage.launchSignupPage();

        // Verify sign up page is displayed or not

        //Creating an account
        String email = signUpTestData.getEmail();

        System.out.println(email);

        signUpPage.enterFirstName(signUpTestData.getFirstName()).enterLastName(signUpTestData.getLastName())
                .enterEmail(signUpTestData.getEmail()).enterPassword(signUpTestData.getPassword());
        signUpPage.clickOnSubmitButton();

        // Clicking on logout button
        homePage.clickOnLogoutButton();

        // Log in with the created account
        loginPage.enterEmail(email).enterPassword(loginTestData.getPassword());
        loginPage.clickOnSubmitButton();
    }

    @Test(priority = 3, description = "Create an account")
    public void verifyAddAccountTest(){
        //Creating an account
        loginPage.enterEmail(loginTestData.getUsername())
                .enterPassword(loginTestData.getPassword());
        loginPage.clickOnSubmitButton();

        //Creating new contact
        homePage.clickOnAddNewContactButton();

        contactPage.enterFirstName(createAccountTestData.getFirstname())
                .enterLastName(createAccountTestData.getLastname())
                .enterBirthdate(createAccountTestData.getBirthdate())
                .enterEmail(createAccountTestData.getEmail())
                .enterPhone(createAccountTestData.getPhone())
                .enterStreet1(createAccountTestData.getStreet1())
                .enterStreet2(createAccountTestData.getStreet2())
                .enterCity(createAccountTestData.getCity())
                .enterStateProvince(createAccountTestData.getState())
                .enterPostalCode(createAccountTestData.getPostal())
                .enterCountry(createAccountTestData.getCountry());

        signUpPage.clickOnSubmitButton();

        //Verifying on homepage whether the data is displaying or not
        Assert.assertTrue(homePage.isNameDisplayed(createAccountTestData.getFirstname(), createAccountTestData.getLastname()),
                "The Name is not matched");

        /*
        Assert.assertTrue(homePage.isBirthDateDisplayed(createAccountTestData.getBirthdate()),
                "Birth date is not matched");
        Assert.assertTrue(homePage.isEmailDisplayed(createAccountTestData.getEmail()),
                "The email is not matched");
        Assert.assertTrue(homePage.isPhoneDisplayed(createAccountTestData.getPhone()),
                "The phone number is not matched");
        Assert.assertTrue(homePage.isAddressDisplayed(createAccountTestData.getStreet1(), createAccountTestData.getStreet2()),
                "Address is not matched");
        Assert.assertTrue(homePage.isCountryDisplayed(createAccountTestData.getCountry()),
                "The country is not matched");

         */
    }
}
