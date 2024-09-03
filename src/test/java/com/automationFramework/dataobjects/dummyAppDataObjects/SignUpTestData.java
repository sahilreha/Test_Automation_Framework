package com.automationFramework.dataobjects.dummyAppDataObjects;

import com.testAutomation.commonUtilities.GenericUtility;

public class SignUpTestData {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName + GenericUtility.getRandomNumber();
    }

    public String getLastName() {
        return lastName + GenericUtility.getRandomNumber();
    }

    public String getEmail() {
        return email + GenericUtility.getRandomNumber() + "@test.com";
    }

    public String getPassword() {
        return password;
    }

}