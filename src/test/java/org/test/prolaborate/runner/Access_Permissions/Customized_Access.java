package org.test.prolaborate.runner.Access_Permissions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featureFiles/AccessPermissions/CustomizedAccess.feature", glue = "org.test.prolaborate.stepDefinitions", dryRun = false, strict = true, plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: " } , tags = {"@tag28"} )
public class Customized_Access {
}
