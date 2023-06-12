package com.mailTravelIndia.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = "com/mailTravelIndia/step_definitions",
        features = "@target/rerun.txt"
)

// I use this class to run only my failed scenarios, essentially for saving time
public class FailedTestRunner {


}
