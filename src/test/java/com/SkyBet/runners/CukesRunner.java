package com.SkyBet.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html", //for  normal html report
                "rerun:target/report.txt",          //for running only failed scenarios (saves time)
                "json:target/cucumber.json",        //tells cucumber to generate test result in json format
                // "me.jvt.cucumber.report.PrettyReports:target/cucumber", //for a detail report (better than html)
        },
         features = "src/test/resources/features",
        glue = "com/SkyBet/step_definitions",
        dryRun = false,
        tags = "@wip", //I use tags to add tags to my scenarios such as @smoke @regression
        publish = true // I use this to share my cucumber report, it gives me link on the console below

)

public class CukesRunner {



}
