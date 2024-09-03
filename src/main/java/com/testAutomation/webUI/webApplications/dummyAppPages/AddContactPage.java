package com.testAutomation.webUI.webApplications.dummyAppPages;

import com.testAutomation.webUI.common.WebTestAutomationUtils;
import org.openqa.selenium.By;

public class AddContactPage {

    By firstNameTxtField = By.cssSelector("#firstName");
    By lastNameTxtField = By.cssSelector("#lastName");
    By birthdateTextField = By.cssSelector("#birthdate");
    By emailTextField = By.cssSelector("#email");
    By phoneTextField = By.cssSelector("#phone");
    By street1TextField = By.cssSelector("#street1");
    By street2TextField = By.cssSelector("#street2");
    By cityTextField = By.cssSelector("#city");
    By stateProvinceTextField = By.cssSelector("#stateProvince");
    By postalCodeTextField = By.cssSelector("#postalCode");
    By countryTextField = By.cssSelector("#country");

    WebTestAutomationUtils genericMethod = new WebTestAutomationUtils();

        // Method to enter first name
        public AddContactPage enterFirstName(String firstName) {
            genericMethod.typeInto(firstNameTxtField, firstName);
            return this; // Return the current page object for method chaining
        }

        // Method to enter last name
        public AddContactPage enterLastName(String lastName) {
            genericMethod.typeInto(lastNameTxtField, lastName);
            return this; // Return the current page object for method chaining
        }

        // Method to enter birthdate
        public AddContactPage enterBirthdate(String birthdate) {
            genericMethod.typeInto(birthdateTextField, birthdate);
            return this; // Return the current page object for method chaining
        }

        // Method to enter email
        public AddContactPage enterEmail(String email) {
            genericMethod.typeInto(emailTextField, email);
            return this; // Return the current page object for method chaining
        }

        // Method to enter phone
        public AddContactPage enterPhone(String phone) {
            genericMethod.typeInto(phoneTextField, phone);
            return this; // Return the current page object for method chaining
        }

        // Method to enter street 1
        public AddContactPage enterStreet1(String street1) {
            genericMethod.typeInto(street1TextField, street1);
            return this; // Return the current page object for method chaining
        }

        // Method to enter street 2
        public AddContactPage enterStreet2(String street2) {
            genericMethod.typeInto(street2TextField, street2);
            return this; // Return the current page object for method chaining
        }

        // Method to enter city
        public AddContactPage enterCity(String city) {
            genericMethod.typeInto(cityTextField, city);
            return this; // Return the current page object for method chaining
        }

        // Method to enter state/province
        public AddContactPage enterStateProvince(String stateProvince) {
            genericMethod.typeInto(stateProvinceTextField, stateProvince);
            return this; // Return the current page object for method chaining
        }

        // Method to enter postal code
        public AddContactPage enterPostalCode(String postalCode) {
            genericMethod.typeInto(postalCodeTextField, postalCode);
            return this; // Return the current page object for method chaining
        }

        // Method to enter country
        public AddContactPage enterCountry(String country) {
            genericMethod.typeInto(countryTextField, country);
            return this; // Return the current page object for method chaining
        }
    }