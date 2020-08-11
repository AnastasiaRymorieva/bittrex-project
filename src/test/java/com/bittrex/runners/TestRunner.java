package com.bittrex.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/bittrex/step_definitions"
//        tags = "@fileUploading",
)
@RunWith(Cucumber.class)
public class TestRunner {
}
