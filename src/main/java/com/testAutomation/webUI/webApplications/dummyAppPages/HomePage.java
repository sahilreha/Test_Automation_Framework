package com.testAutomation.webUI.webApplications.dummyAppPages;

import com.testAutomation.webUI.common.WebTestAutomationUtils;
import org.openqa.selenium.By;

public class HomePage {

    By logoutButton = By.cssSelector("#logout");
    By addANewContactButton = By.cssSelector("#add-contact");

    String startXpath = "//tr[@class='contactTableBodyRow']//td[normalize-space()='";
    String endXpath = "']";


    WebTestAutomationUtils webTestAutomationUtils = new WebTestAutomationUtils();

    public void clickOnLogoutButton(){
        webTestAutomationUtils.click(logoutButton);
    }

    public AddContactPage clickOnAddNewContactButton(){
        webTestAutomationUtils.click(addANewContactButton);
        return new AddContactPage();
    }

    public boolean isNameDisplayed(String firstName, String lastName){
        return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + firstName + " " + lastName + endXpath)).isDisplayed();
    }

    public boolean isBirthDateDisplayed(String birthDate){
       return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + birthDate + endXpath)).isDisplayed();
    }

    public boolean isEmailDisplayed(String email){
        return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + email + endXpath)).isDisplayed();
    }

    public boolean isPhoneDisplayed(String phone){
        return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + phone + endXpath)).isDisplayed();
    }

    public boolean isAddressDisplayed(String street1, String street2) {
        return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + street1 + " " + street2 + endXpath)).isDisplayed();
    }

        public boolean isCountryDisplayed(String country){
        return webTestAutomationUtils.getWebDriver().findElement(By.xpath(startXpath + country + endXpath)).isDisplayed();
    }




}
