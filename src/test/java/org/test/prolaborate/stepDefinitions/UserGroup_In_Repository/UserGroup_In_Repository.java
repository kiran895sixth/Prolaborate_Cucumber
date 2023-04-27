package org.test.prolaborate.stepDefinitions.UserGroup_In_Repository;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.LoginPage;
import org.test.prolaborate.baseclass.XLdata;
import org.test.prolaborate.stepDefinitions.Users_In_Repository.Users_In_Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserGroup_In_Repository extends LoginPage {
    public static List<String> GroupNames = null;
    public static int columnNo = 2;
    public static String sheet1 = "Login_Data";
    public static String sheet2 = "UserGroup in Repository";
    public static List<String> Dashboards = null;
    public static String password = "Welcome@123";
    public static String uMail = null;
    public static String uFirstName = Users_In_Repository.userFirstName;
    public static String uLastName = Users_In_Repository.userLastName;
    public static String testCaseNo = Users_In_Repository.testCaseNo;

    public static String selectedRepositoryBrowser = null;




    @When("Make added user as admin")
    public void make_added_user_as_admin() throws InterruptedException {
        sleep();
        uMail = uFirstName + uLastName + testCaseNo + "@mail.com";
        System.out.println(uMail);
        driver.findElement(By.xpath("//span[text()='" + uMail + "']/following::span[text()='Edit'][1]")).click();
        rp.getMakeSuperAdmin().click();
        rp.getSave().click();
        sleep();
    }

    @Then("New repository user group list shown {string} group  \\(row {int}) {string}")
    public void new_repository_user_group_list_shown_group_row(String groupName, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        GroupNames = new ArrayList<String>();
        List<WebElement> list = driver
                .findElements(By.xpath("//span[@class='d-inline-block align-bottom overflow-hidden line-h-20']"));
        for (WebElement webElement : list) {
            GroupNames.add(webElement.getText());
        }
        System.out.println(GroupNames);
        if (GroupNames.contains(groupName)) // verify administrator group added
        {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Groups shown in list");
        } else {
            System.out.println("Groups not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }

    @Then("{string} group is visible in the Access Permissions User Group list \\(row {int}) {string}")
    public void group_is_visible_in_the_Access_Permissions_User_Group_list_row(String groupName, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getMenuButton().click();// menu button
        sleep(3000);
        rp.getAccessPermission().click();// access permission
        sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Customized Access')]")).click();
        sleep();
        driver.findElement(By.xpath("//p-tree//ul")).click();// repository browser
        sleep();
        rp.getDropDown1().click();// user gorup drop down
        GroupNames = new ArrayList<String>();
        List<WebElement> list = driver
                .findElements(By.xpath("//ng-dropdown-panel//fa-icon//following-sibling::span"));
        for (WebElement webElement : list) {
            GroupNames.add(webElement.getText());
        }
        System.out.println(GroupNames);
        if (GroupNames.contains(groupName)) // verify administrator group added
        {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Groups shown in list");
        } else {
            System.out.println("Groups not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }

    @Then("Admin user added to the {string} Group by default \\(row {int}) {string}")
    public void admin_user_added_to_the_Group_by_default_row(String groupName, Integer row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        String SuperAdmin = driver
                .findElement(By.xpath("//span[contains(text(),'Super Admin')]/following::button[1]")).getAttribute("class");
        String adminUser = driver
                .findElement(By.xpath("//span[contains(text(),'" + uFirstName + " " + uLastName + "')]/following::button[1]")).getAttribute("class");
        System.out.println("Super Admin is Added in group - " + SuperAdmin.contains("btn btn-clear text-success"));
        System.out.println("Admin User is Added in group - " + adminUser.contains("btn btn-clear text-success"));
        if (SuperAdmin.contains("btn btn-clear text-success")) {
            if (adminUser.contains("btn btn-clear text-success")) {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("admin user added in " + groupName + " group ");
            } else {
                System.out.println("admin user not added in " + groupName + " group by default");
                XLdata.pass(path, sheet2, row, columnNo);

            }
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println(" super admin user not added in administrator group ");
        }
    }

    @Then("Featuer set is by default selected in the {string} Group \\(row {int}) {string}")
    public void featuer_set_is_by_default_selected_in_the_Group_row(String groupName, Integer row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size = AllCheckboxes.size();
        switch (groupName) {
            case "Administrators":
                for (int i = 0; i < size - 2; i++) {
                    boolean display = AllCheckboxes.get(i).isSelected();
                    if (display) {
                        System.out.println("checkbox is selected");
                        XLdata.pass(path, sheet2, row, columnNo);
                    } else {
                        System.out.println("checkbox is not selected");
                        XLdata.fail(path, sheet2, row, columnNo);
                        break;
                    }
                }
                break;
            case "Default":
                for (int i = 0; i < size - 2; i++) {
                    boolean display = AllCheckboxes.get(i).isSelected();
                    if (!display) {
                        System.out.println("checkbox is not selected");
                        XLdata.pass(path, sheet2, row, columnNo);
                    } else {
                        System.out.println("checkbox is selected");
                        XLdata.fail(path, sheet2, row, columnNo);
                        break;
                    }
                }
                break;

        }
    }

    @Then("Feature set is disabled in the {string} group \\(row {int}) {string}")
    public void feature_set_is_disabled_in_the_group_row(String groupName, Integer row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        List<WebElement> AllCheckboxes = driver
                .findElements(By.xpath("//input[contains(@class,'input ng-untouched ng-pristine')]"));
        int size = AllCheckboxes.size();
        switch (groupName) {
            case "Administrators":
            case "Default":
                for (int i = 0; i < size - 1; i++) {
                    boolean display = AllCheckboxes.get(i).isEnabled();
                    if (!display) {
                        System.out.println("checkbox is disabled");
                        XLdata.pass(path, sheet2, row, columnNo);
                    } else {
                        System.out.println("checkbox is enabled");
                        XLdata.fail(path, sheet2, row, columnNo);
                        break;
                    }
                }
                break;
        }
    }


    @Then("User not able to remove the admin user from the {string} Group \\(row {int}) {string}")
    public void user_not_able_to_remove_the_admin_user_from_the_Group_row(String groupName, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        WebElement checkbox = driver
                .findElement(By.xpath("//span[contains(text(),'" + uLastName + testCaseNo + "')]/following::button[1]"));
        checkbox.click();
        String c = checkbox.getAttribute("class");
        if (c.equals("btn btn-clear text-success")) {
            System.out.println("Checkbox is Toggled On");
            rp.getSave().click();
            System.out.println("admin user added in " + groupName + " group");
        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        switch (groupName) {
            case "Administrators":
            case "Default":
                driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();// administrator
                sleep();
                boolean checkbox1 = driver.findElement(By.xpath("//span[contains(text(),'Super Admin')]/following::button[1]"))
                        .isEnabled();
                boolean checkbox2 = driver
                        .findElement(By.xpath("//span[contains(text(),'" + uLastName + testCaseNo + "')]/following::button[1]")).isEnabled();
                if ((!checkbox1) && (!checkbox2)) {
                    System.out.println("Checkbox is Disabled");
                    System.out.println("we are not able to remove admin user form administrator group");
                    XLdata.pass(path, sheet2, row, columnNo);

                } else {
                    System.out.println("admin user can be removed");
                    XLdata.fail(path, sheet2, row, columnNo);
                }
                break;
        }

    }


    @When("User login ADgroupUserOrADuser \\(ADgroupUserOrADuser {string})")
    public void user_login_ADgroupUserOrADuser_ADgroupUserOrADuser(String userName) throws InterruptedException {
        rp.getLoginUserName().sendKeys(userName);
        rp.getLoginPassword().sendKeys("Welcome@123");
        rp.getSignIn().click();
    }

    @When("User select default dashboard {string}")
    public void user_select_default_dashboard(String dashboardName) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//label[text()=' Default Dashboard ']/following::span[@class='ng-arrow-wrapper']")).click();
        driver.findElement(By.xpath("//span[text()='" + dashboardName + "']")).click();
    }

    @When("User add the users in group \\(registeredUser {int})")
    public void user_add_the_users_in_group_registeredUser(Integer userNo) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + uLastName + userNo + "')]/following::button[1]")).click();
    }

    @Then("Default dashboard set to the user group is visible to the Dashboard of Registered user \\(registeredUser {int}) \\(dashboard {string}) \\(row {int}) {string}")
    public void default_dashboard_set_to_the_user_group_is_visible_to_the_Dashboard_of_Registered_user_registeredUser_dashboard_row(Integer userNo, String dashboardN, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
//        rp.getLoginUserName().sendKeys(uFirstName + uLastName + userNo + "@mail.com");
//        rp.getLoginPassword().sendKeys(password);
//        rp.getSignIn().click();
//        // set password
//        driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
//        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
//        driver.findElement(By.xpath("//button[text()='Save Password']")).click();
//        driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
//        sleep();
//        try {
//            driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
//            sleep(1000);
//        }catch (Exception e ) {
//            System.out.println("Repository opened");
//        }

        elementWait(driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")));
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        System.out.println(dashboards);
        if (dashboards.contains(dashboardN)) {
            System.out.println("dashboard is visible in registered user account");
            XLdata.pass(path, sheet2, row, columnNo);
        } else {
            System.out.println("dashboard is not visible in registered user account");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }

    @When("User add the users in group \\(ADgroup {string})")
    public void user_add_the_users_in_group_ADgroup(String ADgroup) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + ADgroup + "')]/following::button[1]")).click();
    }

    @Then("Default dashboard set to the user group is visible to the Dashboard of ADgroup \\(ADgroupuser {string}) \\(dashboard {string}) \\(row {int}) {string}")
    public void default_dashboard_set_to_the_user_group_is_visible_to_the_Dashboard_of_ADgroup_ADgroupuser_dashboard_row(String ADgroupuser, String dashboardN, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(ADgroupuser);
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        sleep();
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        if (dashboards.contains(dashboardN)) {
            System.out.println("dashboard is visible in registered user account");
            XLdata.pass(path, sheet2, row, columnNo);
        } else {
            System.out.println("dashboard is not visible in registered user account");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }

    @When("User add the users in group \\(ADuser {string})")
    public void user_add_the_users_in_group_ADuser(String ADuser) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + ADuser + "')]/following::button[1]")).click();
    }

    @Then("Default dashboard set to the user group is visible to the Dashboard of ADuser \\(ADuser {string}) \\(dashboard {string}) \\(row {int}) {string}")
    public void default_dashboard_set_to_the_user_group_is_visible_to_the_Dashboard_of_ADuser_ADuser_dashboard_row(String ADuser, String dashboardN, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(ADuser);
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        sleep();
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        if (dashboards.contains(dashboardN)) {
            System.out.println("dashboard is visible in registered user account");
            XLdata.pass(path, sheet2, row, columnNo);
        } else {
            System.out.println("dashboard is not visible in registered user account");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }


    @When("User add the users in group \\(ADgroupUser {string})")
    public void user_add_the_users_in_group_ADgroupUser(String ADgroupUser) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + ADgroupUser + "')]/following::button[1]")).click();

    }

    @Then("Default dashboard set to the user group is visible to the Dashboard of ADgroupuser \\(ADgroupUser {string}) \\(dashboard {string}) \\(row {int}) {string}")
    public void default_dashboard_set_to_the_user_group_is_visible_to_the_Dashboard_of_ADgroupuser_ADgroupUser_dashboard_row(String ADgroupUser, String dashboardN, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(ADgroupUser);
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        sleep();
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        if (dashboards.contains(dashboardN)) {
            System.out.println("dashboard is visible in user account");
            XLdata.pass(path, sheet2, row, columnNo);
        } else {
            System.out.println("dashboard is not visible in user account");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }


    @When("User add the users in group \\(SAMLuser {string})")
    public void user_add_the_users_in_group_SAMLuser(String SAMLuser) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + SAMLuser + "')]/following::button[1]")).click();
    }

    @Then("Default dashboard set to the user group is visible to the Dashboard of SAMLuser \\(SAMLuser {string}) \\(dashboard {string}) \\(row {int}) {string}")
    public void default_dashboard_set_to_the_user_group_is_visible_to_the_Dashboard_of_SAMLuser_SAMLuser_dashboard_row(String SAMLuser, String dashboardN, Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        if (dashboards.contains(dashboardN)) {
            System.out.println("dashboard is visible in user account");
            XLdata.pass(path, sheet2, row, columnNo);
        } else {
            System.out.println("dashboard is not visible in user account");
            XLdata.fail(path, sheet2, row, columnNo);
        }
    }

    @Then("Default dashboard set to the user group is properly visible in default dashboard field \\(groupName {string}) \\(dashboard {string}) \\(row {int}) {string}")
    public void defaultDashboardSetToTheUserGroupIsProperlyVisibleInDefaultDashboardFieldGroupNameDashboardRow(String groupName, String dashboardN, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();
        sleep();
        String text = driver.findElement(By.xpath("(//ng-select//span)[1]")).getText();
        if (text.equals(dashboardN)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("Remove the user from the group \\(registeredUser {int})")
    public void removeTheUserFromTheGroupRegisteredUser(int userNo) throws InterruptedException {
        sleep();
        boolean checkbox1 = driver
                .findElement(By.xpath("//span[contains(text(),'" + uLastName + userNo + "')]/following::button[1]")).getAttribute("class").contains("success");
        if (checkbox1) {
            driver.findElement(By.xpath("//span[contains(text(),'" + uLastName + userNo + "')]/following::button[1]")).click();
        } else {
            System.out.println("User already Removed");
        }

    }

    @Then("Validate the user is able to  add user in the user group \\(groupName {string}) \\(registeredUser {int}) \\(row {int}) {string}")
    public void validateTheUserIsAbleToAddUserInTheUserGroupGroupNameRegisteredUserRow(String groupName, int userNo, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();// select group
        sleep();
        System.out.println(uLastName);
        String checkbox1 = driver.findElement(By.xpath("//span[contains(text(),'" + uLastName + userNo + "')]/following::button[1]")).getAttribute("class");
        System.out.println(checkbox1);
        if (checkbox1.contains("success")) {
            System.out.println("verifed user is successfully added in the group");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("user is not added in group");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate the user is able to  remove user in the user group \\(groupName {string}) \\(registeredUser {int}) \\(row {int}) {string}")
    public void validateTheUserIsAbleToRemoveUserInTheUserGroupGroupNameRegisteredUserRow(String groupName, int userNo, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();// select group
        sleep();
        boolean checkbox1 = driver
                .findElement(By.xpath("//span[contains(text(),'" + uLastName + userNo + "')]/following::button[1]")).getAttribute("class").contains("success");
        if (!checkbox1) {
            System.out.println("verifed user is successfully Removed from group");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("user is not Removed from group");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @When("User assigned feature to user group \\(feature {string})")
    public void user_assigned_feature_to_user_group_feature(String feature) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//label[text()='" + feature + "']/preceding-sibling::input")).click();
    }

    @Then("Validate assigned feature should be shown \\(feature {string})")
    public void validate_assigned_feature_should_be_shown_feature(String featureName) throws InterruptedException {
        sleep();
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            features.add(feature);
        }
        System.out.println(features);
        if (features.contains(featureName)) {
            System.out.println("feature is shown");
        } else {
            System.out.println("feature is not shown");
        }

    }

    @Then("User open {string} group")
    public void user_open_group(String group) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[text()='" + group + "']")).click();
    }

    @Then("Validate assigned feature should not be shown \\(feature {string}) \\(row {int}) {string}")
    public void validateAssignedFeatureShouldNotBeShownFeatureRow(String featureName, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            features.add(feature);
        }
        System.out.println(features);
        if (!features.contains(featureName)) {
            System.out.println("feature is shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("feature is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @When("User select redio button of {string}")
    public void user_select_redio_button_of(String element) throws InterruptedException {
        sleep();
        if (element.contains("Customized Access")) {
            driver.findElement(By.id("Customized")).click();
        } else if (element.contains("Single Access")) {
            driver.findElement(By.id("Single")).click();
        }

    }

    @When("User select repository browser")
    public void user_select_repository_browser() throws InterruptedException {
        sleep();
        WebElement element = driver.findElement(By.xpath("(//p-treenode)[1]"));
        element.click();
        selectedRepositoryBrowser = element.getText();
        System.out.println(selectedRepositoryBrowser);
    }

    @When("User add access user or usergroup to the repository browser {string}")
    public void userAddAccessUserOrUsergroupToTheRepositoryBrowser(String userGroup) throws InterruptedException {
        sleep();
        rp.getDropDown1().click();
        driver.findElement(By.xpath("//ng-dropdown-panel//fa-icon//following-sibling::span[text()='" + userGroup + "']")).click();
    }

    @Then("Validate assigned repository browaer should be shown")
    public void validate_assigned_repository_browaer_should_be_shown() throws InterruptedException {
        sleep();
        String text = driver.findElement(By.xpath("(//p-treenode)[1]")).getText();
        System.out.println(text);
        if (selectedRepositoryBrowser.equals(text)) {
            System.out.println("repository browser is shown");
        } else {
            System.out.println("repository browser is not shown");
        }
    }

    @Then("Validate assigned repository browser should not be shown  \\(row {int}) {string}")
    public void validate_assigned_repository_browser_should_not_be_shown_row(Integer row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            String text = driver.findElement(By.xpath("(//p-treenode)[1]")).getText();
            System.out.println(text);
            if (!selectedRepositoryBrowser.equals(text)) {
                System.out.println("repository browser is not shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            } else {
                System.out.println("repository browser is shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        } catch (Exception e) {
            System.out.println("repository browser is not shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }
    }

    @Then("Validate assigned default dashboard should not be shown \\(dashboard {string}) \\(row {int}) {string}")
    public void validateAssignedDefaultDashboardShouldNotBeShownDashboardRow(String dashboardN, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
        } catch (Exception e) {
            System.out.println("..continue..");
        }

        sleep(1000);
        elementWait(driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")));
        driver.findElement(By.xpath("//span[text()='Dashboards']/following::a[1]")).click();// dashboard dropdown in// header
        sleep();
        List<String> dashboards = new ArrayList<>();
        List<WebElement> dashboardList = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//div[2]//span[2]"));
        for (WebElement webElement : dashboardList) {
            String dashboard = webElement.getText();
            dashboards.add(dashboard);
        }
        System.out.println(dashboards);
        if (!dashboards.contains(dashboardN)) {
            System.out.println("dashboard is not visible in registered user account");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("dashboard is visible in registered user account");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }


    @When("User add the users in group \\({string})")
    public void user_add_the_users_in_group(String user) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'" + user + "')]/following::button[1]")).click();
    }

    @Then("Remove the user from the group \\({string})")
    public void remove_the_user_from_the_group(String user) throws InterruptedException {
        sleep();
        boolean checkbox1 = driver
                .findElement(By.xpath("//span[contains(text(),'" + user + "')]/following::button[1]")).getAttribute("class").contains("success");
        if (checkbox1) {
            driver.findElement(By.xpath("//span[contains(text(),'" + user + "')]/following::button[1]")).click();
        } else {
            System.out.println("User already Removed");
        }
    }

    @Then("Validate the user is able to add user in the user group \\(groupName {string}) \\({string}) \\(row {int}) {string}")
    public void validateTheUserIsAbleToAddUserInTheUserGroupGroupNameRow(String groupName, String user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();// select group
        sleep();
        String checkbox1 = driver.findElement(By.xpath("//span[contains(text(),'" + user + "')]/following::button[1]")).getAttribute("class");
        System.out.println(checkbox1);
        if (checkbox1.contains("success")) {
            System.out.println("verifed user is successfully added in the group");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("user is not added in group");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate the user is able to remove user in the user group \\(groupName {string}) \\({string})")
    public void validateTheUserIsAbleToRemoveUserInTheUserGroupGroupName(String groupName, String user) throws InterruptedException {
        sleep();
//		System.out.println(testCase);
        driver.findElement(By.xpath("//span[text()='" + groupName + "']")).click();// select group
        sleep();
        boolean checkbox1 = driver
                .findElement(By.xpath("//span[contains(text(),'" + user + "')]/following::button[1]")).getAttribute("class").contains("success");
        if (!checkbox1) {
            System.out.println("verifed user is successfully Removed from group");
        } else {
            System.out.println("user is not Removed from group");
        }
    }

    @And("User click repository package")
    public void userClickRepositoryPackage() throws InterruptedException {
        sleep();
        mouseHover(driver.findElement(By.xpath("(//div//td//span//span//span)[1]")));
        driver.findElement(By.xpath("(//div//td//span//span//span)[1]")).click();
        driver.findElement(By.xpath("(//div//td//span//span//span)[2]")).click();

    }


    @Then("Assigned feature should be shown in menu in user account \\(feature {string}) \\(row {int}) {string}")
    public void assignedFeatureShouldBeShownInMenuInUserAccountFeatureRow(String featureName, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            features.add(feature);
        }
        System.out.println(features);
        if (features.contains(featureName)) {
            System.out.println("feature is shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("feature is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }

    }

    @Then("Features set should be enabled \\(row {int}) {string}")
    public void featuresSetShouldBeEnabledRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<WebElement> AllCheckboxes = driver
                .findElements(By.xpath("//input[contains(@class,'input ng-untouched ng-pristine')]"));
        int size = AllCheckboxes.size();

        for (int i = 0; i < size - 1; i++) {
            boolean display = AllCheckboxes.get(i).isEnabled();
            if (display) {
                System.out.println("checkbox is enabled");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            } else {
                System.out.println("checkbox is disabled");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
                break;
            }
        }


    }

    @Then("Assigned feature should be shown in menu in user account \\(feature {string} {string}) \\(row {int}) {string}")
    public void assignedFeatureShouldBeShownInMenuInUserAccountFeatureRow(String featureName1, String featureName2, int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            features.add(feature);
        }
        System.out.println(features);
        if (features.contains(featureName1) && features.contains(featureName2)) {
            System.out.println("feature is shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("feature is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }


    @And("User assigned all features to the user group")
    public void userAssignedAllFeaturesToTheUserGroup() throws InterruptedException {
        sleep();
        List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div//app-checkbox//input"));
        int size = AllCheckboxes.size();
        System.out.println(size);
        for (int i = 0; i < size - 1; i++) {
            if (i == 6) {
                i++;
            }
            AllCheckboxes.get(i).click();

        }
    }

    @Then("Assigned all feature should be shown in menu in user account \\(row {int}) {string}")
    public void assignedAllFeatureShouldBeShownInMenuInUserAccountRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']/following-sibling::div//div//a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText().trim();
            features.add(feature);
        }
        System.out.println(features);
        List<String> f1 = new ArrayList<String>();
        f1.add("Access Permissions");
        f1.add("Dashboards");
        f1.add("Report Configurations");
        f1.add("Integrated Application Projects");
        f1.add("Modeling Languages");
        f1.add("Repository Settings");
        f1.add("Reviews");
        f1.add("Sections");
        f1.add("Users");
        f1.add("User Groups");
        sleep();
        if (features.containsAll(f1) && f1.containsAll(features)) {
            System.out.println("feature is shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("feature is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("Remove all features from the group")
    public void removeAllFeaturesFromTheGroup() throws InterruptedException {
        sleep();
        List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div//app-checkbox//input"));
        int size = AllCheckboxes.size();
        System.out.println(size);
        for (int i = 0; i < size - 1; i++) {
            if (i == 6) {
                i++;
            }
            AllCheckboxes.get(i).click();

        }
    }

    @Then("Features should not be shown in menu in user account \\(row {int}) {string}")
    public void featuresShouldNotBeShownInMenuInUserAccountRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']/following-sibling::div//div//a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText().trim();
            features.add(feature);
        }
        System.out.println(features);
        List<String> f1 = new ArrayList<String>();
        f1.add("Reviews");
        sleep();
        if (features.containsAll(f1) && f1.containsAll(features)) {
            System.out.println("feature is not shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("feature is shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("User click on delete in more-options \\(groupName {string})")
    public void userClickOnDeleteInMoreOptionsGroupName(String groupname) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("(//span[text()='" + groupname + "']/following::span[text()='More'])[1]")).click();// more option
        driver.findElement(By.xpath("//span[text()='" + groupname + "']/following::span[text()='Delete'][1]")).click();
    }

    @Then("Validate the confirmation popup is displayed \\(row {int}) {string}")
    public void validateTheConfirmationPopupIsDisplayedRow(int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        if (driver.getPageSource().contains("Delete User Group")) {
            System.out.println("confirmation popup is appear");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("confirmation popup is not appear");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }


    @Then("Validate the confirmation popup message \\(row {int}) {string}")
    public void validateTheConfirmationPopupMessageRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        String text = driver.findElement(By.xpath("(//ngb-modal-window//div//p)[1]")).getText();
        System.out.println(text);
        sleep(1000);
        if (text.contains("Are you sure you want to delete this User group?")) {
            System.out.println("confirmation popup message is appear");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("confirmation popup message is not appear");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }



    @Then("Validate the PB alert message \\(row {int}) {string}")
    public void validateThePBAlertMessageRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        String text = driver.findElement(By.tagName("ngb-alert")).getText();
        System.out.println(text);
        if (text.contains("User Group deleted successfully!")) {
            System.out.println("PB alert message is appear");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            System.out.println("PB alert message is not appear");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @And("User clicked delete in the delete confirmation popup")
    public void userClickedDeleteInTheDeleteConfirmationPopup() throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//app-confirmdialog//span[text()='Delete']")).click();
    }

    @Then("Validate the group is deleted when we Click on Delete \\(groupName {string}) \\(row {int}) {string}")
    public void validateTheGroupIsDeletedWhenWeClickOnDeleteGroupNameRow(String groupName, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        GroupNames = new ArrayList<String>();
        List<WebElement> list = driver
                .findElements(By.xpath("//td[1]"));
        for (WebElement webElement : list) {
            GroupNames.add(webElement.getText());
        }
        System.out.println(GroupNames);
        if (!GroupNames.contains(groupName)) {
            System.out.println("group is deleted");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("group is not deleted");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate the administrator group not deletable \\(row {int}) {string}")
    public void validateTheAdministratorGroupNotDeletableRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        String option = driver.findElement(By.xpath("//span[text()='Administrators']/following::td[2]")).getText();
        if (!option.contains("More")) {
            System.out.println("Delete option is disabled");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("Delete option is enabled");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate the default group not deletable \\(row {int}) {string}")
    public void validateTheDefaultGroupNotDeletableRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        String option = driver.findElement(By.xpath("//span[text()='Default']/following::td[2]")).getText();
        if (!option.contains("More")) {
            System.out.println("Delete option is disabled");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("Delete option is enabled");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate deleted group is not shown in access permission page \\(groupName {string}) \\(row {int}) {string}")
    public void validateDeletedGroupIsNotShownInAccessPermissionPageGroupNameRow(String groupname, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> names = new ArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("(//table)[2]//tr//td[1]//div[2]//p[1]"));
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        System.out.println(names);
        if (!names.contains(groupname)) {
            System.out.println("Deleted group is not shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("Deleted group is shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate deleted group is not shown in access permission page user list dropdown \\(groupName {string}) \\(row {int}) {string}")
    public void validateDeletedGroupIsNotShownInAccessPermissionPageUserListDropdownGroupNameRow(String groupname, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> names = new ArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//ng-dropdown-panel//div[2]//span[1]"));
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        System.out.println(names);
        if (!names.contains(groupname)) {
            System.out.println("Deleted group is not shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("Deleted group is shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate added groups are listed in the usergroup page \\(groupname {string}) \\(row {int}) {string}")
    public void validateAddedGroupsAreListedInTheUsergroupPageGroupnameRow(String groupname, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> names = new ArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//tr//td[1]//a//span"));
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        System.out.println(names);
        if (names.contains(groupname)) {
            System.out.println("Added group is listed properly");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        }else{
            System.out.println("Added group is not listed properly");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate group name is shown properly in the usergroup page \\(groupname {string}) \\(row {int}) {string}")
    public void validateGroupNameIsShownProperlyInTheUsergroupPageGroupnameRow(String groupname, int row, String testCase) throws InterruptedException, IOException {

        sleep();
        System.out.println(testCase);
        boolean contains = driver.getPageSource().contains(groupname);
        if (contains){
            System.out.println("Group name is shown ");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else {
            System.out.println("Group name is not shown ");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }

    }

    @Then("Validate status of the group is shown properly \\(status {string}) \\(groupname {string}) \\(row {int}) {string}")
    public void validateStatusOfTheGroupIsShownProperlyStatusGroupnameRow(String status, String groupname, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        String text = driver.findElement(By.xpath("//tr//td[1]//a//span[text()='"+groupname+"']//following::td[1]")).getText();
        System.out.println(text);
        boolean contains = text.equalsIgnoreCase(status);
        if (contains){
            System.out.println("Status of the group is shown ");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else {
            System.out.println("Status of the group is not shown ");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("User click on status toggle")
    public void userClickOnStatusToggle() throws InterruptedException {
        sleep();
        driver.findElement(By.id("requireStatus")).click();
    }

    @Then("Validate sort option should be shown in usergroup header \\(row {int}) {string}")
    public void validateSortOptionShouldBeShownInUsergroupHeaderRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//th[1]//p-sorticon")).isDisplayed();
            System.out.println("Sort option is shown ");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }catch (Exception e){
            System.out.println("Sort option is not shown ");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }

    }

    @Then("Validate sort option should be shown in status header \\(row {int}) {string}")
    public void validateSortOptionShouldBeShownInStatusHeaderRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//th[2]//p-sorticon")).isDisplayed();
            System.out.println("Sort option is shown ");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }catch (Exception e){
            System.out.println("Sort option is not shown ");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("User click on usergroup header")
    public void userClickOnUsergroupHeader() throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//th[1]")).click();
    }

    @Then("Validate list should be in ascending order \\(row {int}) \\(elementIndex {int}) {string}")
    public void validateListShouldBeInAscendingOrderRowElementIndex(int row, int index, String testCase) throws InterruptedException, IOException {
        sleep();
        try {
            System.out.println(testCase);
            String expectname[] = { "Administrators", "Default" , "ZTest" };
            String expectStatus[] = { "Active", "Active" , "Inactive" };
            List<Boolean> list = new ArrayList<>();
            List<WebElement> nameList = driver.findElements(By.xpath("//tr//td[" + index + "]"));
            if (index == 1) {
                for (int i = 0; i < nameList.size(); i++) {
                    System.out.println(nameList.get(i).getText());
                    boolean b = nameList.get(i).getText().equalsIgnoreCase(expectname[i]);
                    list.add(b);
                }
            } else if (index == 2) {
                for (int i = 0; i < nameList.size(); i++) {
                    System.out.println(nameList.get(i).getText());
                    boolean b = nameList.get(i).getText().equalsIgnoreCase(expectStatus[i]);
                    list.add(b);
                }
            }
            if (!list.contains(false)) {
                System.out.println("List shows ASCENDING order");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("List not shows ASCENDING order");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User click on status header")
    public void userClickOnStatusHeader() throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//th[2]")).click();
    }

    @Then("Validate list should be in descending order \\(row {int}) \\(elementIndex {int}) {string}")
    public void validateListShouldBeInDescendingOrderRowElementIndex(int row, int index, String testCase) throws InterruptedException, IOException {
        sleep();
        try {
            System.out.println(testCase);
            String expectname[] = { "ZTest", "Default" , "Administrators" };
            String expectStatus[] = { "Inactive", "Active" , "Active" };
            List<Boolean> list = new ArrayList<>();
            List<WebElement> nameList = driver.findElements(By.xpath("//tr//td[" + index + "]"));
            if (index == 1) {
                for (int i = 0; i < nameList.size(); i++) {
                    System.out.println(nameList.get(i).getText());
                    boolean b = nameList.get(i).getText().equalsIgnoreCase(expectname[i]);
                    list.add(b);
                }
            } else if (index == 2) {
                for (int i = 0; i < nameList.size(); i++) {
                    System.out.println(nameList.get(i).getText());
                    boolean b = nameList.get(i).getText().equalsIgnoreCase(expectStatus[i]);
                    list.add(b);
                }

            }
            if (!list.contains(false)) {
                System.out.println("List shows DESCENDING order");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("List not shows DESCENDING order");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User click on Edit in actions \\(groupName {string})")
    public void userClickOnEditInActionsGroupName(String groupName) {
    driver.findElement(By.xpath("//span[text()='"+groupName+"']//following::span[text()='Edit'][1]")).click();
    }

    @Then("Validate the Select All and Deselect All option is displayed \\(row {int}) {string}")
    public void validateTheSelectAllAndDeselectAllOptionIsDisplayedRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            boolean SelectAll = driver.findElement(By.xpath("//button//span[text()='Select All']")).isDisplayed();
            boolean DeselectAll = driver.findElement(By.xpath("//button//span[text()='Deselect All']")).isDisplayed();
            System.out.println("Select all option shown "+SelectAll);
            System.out.println("Deselect all option shown "+DeselectAll);
            if(SelectAll&DeselectAll){
                System.out.println("options is shown ");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");

            }else {
                System.out.println("options is not displayed ");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e){
            System.out.println("options is not shown ");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }


    @Then("Validate the Select All and Deselect All option is working properly \\(row {int}) {string}")
    public void validateTheSelectAllAndDeselectAllOptionIsWorkingProperlyRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//button//span[text()='Select All']")).click();
            List<WebElement> elements = driver.findElements(By.xpath("//ul//li//span//button"));
            for (int i = 0; i < elements.size(); i++) {
                System.out.println(elements.get(i).getAttribute("class"));
                if (elements.get(i).getAttribute("class").contains("success")){
                    System.out.println("user selected");
                    XLdata.pass(path, sheet2, row, columnNo);
                    System.out.println("Testcase pass");
                }else {
                    System.out.println("user not selected");
                    XLdata.fail(path, sheet2, row, columnNo);
                    System.out.println("Testcase fail");
                    break;
                }
            }
            driver.findElement(By.xpath("//button//span[text()='Deselect All']")).click();
            List<WebElement> elements1 = driver.findElements(By.xpath("//ul//li//span//button"));
            for (int i = 0; i < elements1.size(); i++) {
                System.out.println(elements.get(i).getAttribute("class"));
                if (!elements.get(i).getAttribute("class").contains("success")){
                    System.out.println("user Unselected");
                    XLdata.pass(path, sheet2, row, columnNo);
                    System.out.println("Testcase pass");
                }else {
                    System.out.println("user selected");
                    XLdata.fail(path, sheet2, row, columnNo);
                    System.out.println("Testcase fail");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Then("Validate administrative access help icon mouse over text \\(message {string}) \\(row {int}) {string}")
    public void validateAdministrativeAccessHelpIconMouseOverTextMessageRow(String msg, int row, String testCase) {
        System.out.println(testCase);
        try {
            WebElement element = driver.findElement(By.xpath("//label[text()='Administrative Access']/following-sibling::app-helpicon"));
            mouseHover(element);
            String text = driver.findElement(By.xpath("//ngb-tooltip-window")).getText();
            if(text.contains(msg)){
                System.out.println("Tooltip window shown properly");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else{
                System.out.println("Tooltip window not shown properly");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Then("Validate maximize icon is displayed \\(row {int}) {string}")
    public void validateMaximizeIconIsDisplayedRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//fa-icon[contains(@class,'maxmin-view')]")).isDisplayed();
            if (displayed) {
                System.out.println("option is shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                System.out.println("option is not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }

    }

    @Then("Validate maximize option working properly \\(row {int}) {string}")
    public void validateMaximizeOptionWorkingProperlyRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//fa-icon[contains(@class,'maxmin-view')]")).click();
            String aClass = driver.findElement(By.xpath("//div[contains(@class,'ActiveFullView')]")).getAttribute("class");
            if (aClass.contains("fullview")) {
                System.out.println("Maximize window shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                System.out.println("Maximize window not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate minimize icon is displayed in maximized view \\(row {int}) {string}")
    public void validateMinimizeIconIsDisplayedInMaximizedViewRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//fa-icon[contains(@class,'maxmin-view')]")).isDisplayed();
            if (displayed) {
                System.out.println("Minimize window shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                System.out.println("Minimize window not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate users tap is minimized when click minimize icon \\(row {int}) {string}")
    public void validateUsersTapIsMinimizedWhenClickMinimizeIconRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("(//fa-icon[contains(@class,'maxmin-view')])[2]")).click();
            sleep(1000);
            String aClass = driver.findElement(By.xpath("//div[contains(@class,'ActiveFullView')]")).getAttribute("class");
            if (!aClass.contains("fullview")) {
                System.out.println("Maximize window shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                System.out.println("Maximize window not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate usergroups help learn more link is displayed \\(row {int}) {string}")
    public void validateUsergroupsHelpLearnMoreLinkIsDisplayedRow(int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        refresh();
        sleep(500);
    try {
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'User groups help')]//following::a[text()=' Learn more ']"));
        if(element.isDisplayed()){
            System.out.println("learn more option is available");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else{
            System.out.println("learn more option is not available");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }

    }catch (Exception e) {
        System.out.println("learn more option is not available");
        XLdata.fail(path, sheet2, row, columnNo);
        System.out.println("Testcase fail");
    }
    }

    @Then("Validate learn more link is redircted respective page \\(row {int}) {string}")
    public void validateLearnMoreLinkIsRedirctedRespectivePageRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        String mainTab = driver.getWindowHandle();
        try {
            driver.findElement(By.xpath("//p[contains(text(),'User groups help')]//following::a[text()=' Learn more ']")).click();
            List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);
            if(currentUrl.equals("https://prolaborate.sparxsystems.com/resources/v4/documentation/add-user")){
                System.out.println("learn more redirected to properly");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else{
                System.out.println("learn more redirect not properly");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }

        }catch (Exception e) {
            System.out.println("learn more option is not available");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
        driver.switchTo().window(mainTab);
    }

    @Then("Validate license type shown correctly \\(groups {string} {string}) \\(row {int}) {string}")
    public void validateLicenseTypeShownCorrectlyGroupsRow(String group1, String group2, int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//span[text()='"+group1+"']//following::span[text()='Edit'][1]")).click();
            String text = driver.findElement(By.xpath("//label[text()='License Type']/following-sibling::div")).getText();
            backward();
            sleep(1000);
            driver.findElement(By.xpath("//span[text()='"+group2+"']//following::span[text()='Edit'][1]")).click();
            String text1 = driver.findElement(By.xpath("//label[text()='License Type']/following-sibling::div")).getText();
            if (text.equals("Regular")&&text1.equals("ReadOnly")) {
                System.out.println("License Type is shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                System.out.println("License Type is not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }

        }catch (Exception e) {
            System.out.println(e);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate updated dashboard is shown in default dashboard field \\(dashboard {string}) \\(row {int}) {string}")
    public void validateUpdatedDashboardIsShownInDefaultDashboardFieldDashboardRow(String dashboard, int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            String text = driver.findElement(By.xpath("(//ng-select//span)[1]")).getText();
            if (text.equals(dashboard)) {
                System.out.println("Dashboard is updated");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            } else {
                System.out.println("Dashboard is not updated");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println("Dashboard is not updated");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }

    }

    @Then("Validate updated feature set is selected properly \\(feature selected {string}) \\(feature unselected {string}) \\(row {int}) {string}")
    public void validateUpdatedFeatureSetIsSelectedProperlyFeatureSelectedFeatureUnselectedRow(String selected, String unselected, int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            boolean Selected = driver.findElement(By.xpath("//label[text()='" + selected + "']/preceding-sibling::input")).isSelected();
            System.out.println(selected+" selected - "+Selected);
            boolean Unselected = driver.findElement(By.xpath("//label[text()='" + unselected + "']/preceding-sibling::input")).isSelected();
            System.out.println(unselected+" Unselected - "+Unselected);
            if (Selected&&!Unselected) {
                System.out.println("Feature is updated");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            } else {
                System.out.println("Feature is not updated");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            System.out.println("Feature is not updated");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

}
