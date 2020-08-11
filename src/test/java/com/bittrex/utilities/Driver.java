package com.bittrex.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static final Logger logger = Logger.getLogger(Driver.class);


    //1- Make constructor private
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "chrome-remote":

                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://100.25.139.203:4444/wd/hub");
                        driver = new RemoteWebDriver(url,chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
