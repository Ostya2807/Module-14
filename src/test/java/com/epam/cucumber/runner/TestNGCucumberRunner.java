package com.epam.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.epam.cucumber.hook",
                "com.epam.cucumber.steps"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        }
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}
