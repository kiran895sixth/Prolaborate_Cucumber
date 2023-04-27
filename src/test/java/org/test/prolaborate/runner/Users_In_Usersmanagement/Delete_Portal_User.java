package org.test.prolaborate.runner.Users_In_Usersmanagement;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "featureFiles/Users_In_Usersmanagement/Delete_Portal_User.feature", glue = "org.test.prolaborate.stepDefinitions", dryRun = false, strict = true, plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: " } , tags = {"@tag1"} )
public class Delete_Portal_User {

}
