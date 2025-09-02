package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = "org.example.stepDef",
                tags = "",
                plugin = {
                        "pretty",
                        "html:reports/reports1.html"
                }
        )

public class runner extends AbstractTestNGCucumberTests {
}
