package com.bittrex.step_definitions;

import com.bittrex.pages.ActivityStreamPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.Map;

public class ActivityStepDefinitions {
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    private final static Logger logger = Logger.getLogger(ActivityStepDefinitions.class);

    @When("user clicks on send message button")
    public void user_clicks_on_send_message_button() {
        activityStreamPage.clickOnSendMessageInput();

    }

    /**
     * And uploads following file:
     *
     * |File path|src/test/resources/testData/testData.jpg|
     * @param dataTable -> represants cucumber data table attached to the test step
     */

    @When("uploads following file:")
    public void uploads_following_file(Map<String,String > dataTable) {
        activityStreamPage.uploadFile(dataTable.get("File path"));

    }
    @Then("user clicks on send button")
    public void user_clicks_on_send_button() {
        activityStreamPage.clickOnSendButton();

    }

}
