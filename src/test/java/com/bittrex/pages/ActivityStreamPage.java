package com.bittrex.pages;

import com.bittrex.utilities.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ActivityStreamPage extends BasePage{
    private final static Logger logger = Logger.getLogger(ActivityStreamPage.class);

    @FindBy(id = "microoPostFormLHE_blogPostForm_inner")
    private WebElement sendMessageInputBox;

    @FindBy(css = "[title='Upload files']")
    private WebElement uploadFilesIcon;

    @FindBy(name = "bxu_files[]")
    private WebElement uploadFilesAndImages;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;


    public void clickOnSendMessageInput(){
        wait.until(ExpectedConditions.visibilityOf(sendMessageInputBox)).click();
    }

    /**
     * File path will be provided as a parameter. Should start with src.
     * @param filePath like src/test/resources/testData/image.jpeg
     */
    public void uploadFile(String filePath){
        filePath = System.getProperty("user.dir")+"/"+filePath.replace("/", File.separator);
        logger.info("File path: "+filePath);
       wait.until(ExpectedConditions.visibilityOf(uploadFilesIcon)).click();
        //uploadFilesIcon.click();
        BrowserUtils.waitFor(2);
        uploadFilesAndImages.sendKeys(filePath);
        BrowserUtils.waitFor(2);
    }

    public void clickOnSendButton(){
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
        logger.info("Clicking on the Send button");
    }
}