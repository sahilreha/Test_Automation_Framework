package com.automationFramework.dataobjects.dummyAppDataObjects;


import com.testAutomation.commonUtilities.GenericUtility;

public class CreateAccountTestData {

    private String firstname;
    private String lastname;
    private String email;
    private String birthdate;
    private String phone;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String postal;
    private String country;


    public String getFirstname() {
        return firstname + GenericUtility.getRandomNumber();
    }

    public String getLastname() {
        return lastname + GenericUtility.getRandomNumber();
    }


    public String getEmail() {
        return email  + GenericUtility.getRandomNumber() + "@email.com";
    }


    public String getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone ;
    }

    public String getStreet1() {
        return street1 + GenericUtility.getRandomNumber();
    }

    public String getStreet2() {
        return street2 + GenericUtility.getRandomNumber();
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostal() {
        return postal;
    }

    public String getCountry() {
        return country;
    }


}
