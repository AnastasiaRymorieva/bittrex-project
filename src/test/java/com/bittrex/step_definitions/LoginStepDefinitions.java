package com.bittrex.step_definitions;

import com.bittrex.pages.LoginPage;
import com.bittrex.utilities.ConfigurationReader;
import com.bittrex.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDefinitions {
    public LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);

    }


    @Given("user logs in as {string}")
    public void user_logs_in_as(String role) {
        loginPage.login(role);

    }

    @And("user navigate to {string}")
    public void userNavigateTo(String module) {
        loginPage.navigateTo(module);
    }
}
