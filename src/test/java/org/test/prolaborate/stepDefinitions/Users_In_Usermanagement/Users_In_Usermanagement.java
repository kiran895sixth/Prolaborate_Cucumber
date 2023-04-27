package org.test.prolaborate.stepDefinitions.Users_In_Usermanagement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.test.prolaborate.baseclass.LoginPage;
import org.test.prolaborate.baseclass.XLdata;
import org.test.prolaborate.stepDefinitions.Users_In_Repository.Users_In_Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users_In_Usermanagement extends LoginPage {
    public static List<String> GroupNames = null;
    public static List<String> UserNames = null;
    public static int columnNo = 2;
    public static String sheet1 = "Login_Data";
    public static String sheet2 = "Users In UsersManagement";
    public static List<String> Dashboards = null;
    public static String password = "Welcome@123";
    public static String uMail = null;
    public static String uFirstName = Users_In_Repository.userFirstName;
    public static String uLastName = Users_In_Repository.userLastName;
    public static String testCaseNo = Users_In_Repository.testCaseNo;
    public static String selectedRepositoryBrowser = null;

    public static List<String> selectedRepository = null;
    public static List<String> selectedGroup = null;
    public static List<String> repositoryLists = null;

    public static String validateText = null;


    @Then("Validate the user is added properly in portal \\(User {int}) \\(row {int}) {string}")
    public void validateTheUserIsAddedProperlyInPortalUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        UserNames = new ArrayList<String>();
        List<WebElement> list = driver.findElements(By.xpath("//td[2]//a//span"));
        for (WebElement webElement : list) {
            UserNames.add(webElement.getText());
        }
        System.out.println(UserNames);
        if (UserNames.contains("test user"+user)) // verify administrator group added
        {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("User added successfully");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("User not added");

        }
    }

    @And("User select repository membership {string}")
    public void userSelectRepositoryMembership(String repositoryMembership) {
        driver.findElement(By.xpath("(//label[text()='Repository Membership']/following::ng-select//span)[1]")).click();
        driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='"+repositoryMembership+"']")).click();
    }

    @Then("Validate the user is added properly in repository \\(User {int}) \\(row {int}) {string}")
    public void validateTheUserIsAddedProperlyInRepositoryUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        UserNames = new ArrayList<String>();
        List<WebElement> list = driver.findElements(By.xpath("//td[2]//a//span"));
        for (WebElement webElement : list) {
            UserNames.add(webElement.getText());
        }
        System.out.println(UserNames);
        if (UserNames.contains("test user"+user)) // verify administrator group added
        {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("User added successfully");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("User not added");

        }
    }

    @Then("Validate user has get {string} \\(User {int}) \\(row {int}) {string}")
    public void validate_user_has_get_User_row(String userType, Integer user, Integer row, String testCase, io.cucumber.datatable.DataTable dataTable) throws IOException {
        System.out.println(testCase);
        List<String> accesses = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Portal Settings']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            accesses.add(feature);
        }
        System.out.println(accesses);
        List<String> adminAccesses = new ArrayList<>();
        List<Map<String, String>> d = dataTable.asMaps(String.class, String.class);
        System.out.println(d.size());
        for(int i = 0; i < d.size(); i++) {
            String s = d.get(i).get(userType);
            if(s != null ){
                adminAccesses.add(s);
            }
        }
        System.out.println(adminAccesses);
        if(adminAccesses.equals(accesses)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }


    @Then("Validate the user status \\(userStatus {string}) \\(userNo {int}) \\(row {int}) {string}")
    public void validateTheUserStatusUserStatusUserNoRow(String status, int user, int row, String testCase) throws IOException, InterruptedException {
        sleep(1000);
        System.out.println(testCase);
        String text = driver.findElement(By.xpath("//span[text()='"+uFirstName+uLastName+user+"@mail.com']/following::label[1]")).getText();
        System.out.println("Status : " + text);
        if (text.equalsIgnoreCase(status)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate the active user can able to login \\(userNo {int}) \\(row {int}) {string}")
    public void validateTheActiveUserCanAbleToLoginUserNoRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(uFirstName+uLastName+user+"@mail.com");
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        try {
            // set password
            driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }catch (Exception e){
            System.out.println("set password page not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
        backward();
    }

    @Then("Validate the inactive user can able to login \\(userNo {int}) \\(row {int}) {string}")
    public void validateTheInactiveUserCanAbleToLoginUserNoRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(uFirstName+uLastName+user+"@mail.com");// user mail
        rp.getLoginPassword().sendKeys(password);// user password
        rp.getSignIn().click();
        sleep();
        if (driver.findElement(By.xpath("//li[contains(text(),'This user is inactive')]")) != null) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
        refresh();
    }

    @And("Note the selected repository and group access")
    public void noteTheSelectedRepositoryAndGroupAccess() throws InterruptedException {
        sleep();
        selectedRepository = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='table-body']//app-checkbox//input"));
        for (int i =0; i < elements.size(); i++) {
            if (elements.get(i).isSelected()){
                String text = driver.findElement(By.xpath("(//div[@class='table-body']//app-checkbox//input//following-sibling::label)[" + i + 1 + "]")).getText();
                selectedRepository.add(text);
            }
            System.out.println(selectedRepository);
            selectedGroup = new ArrayList<>();
            List<WebElement> elements1 = driver.findElements(By.xpath("(//ng-select)["+i+1+"]//fa-icon//following-sibling::span"));
            for(int j = 0; j < elements1.size(); j++){
                selectedGroup.add(elements1.get(j).getText());
            }
            System.out.println(selectedGroup);
        }


    }

    @Then("Validate the repository access is based on access control profile  \\(row {int}) {string}")
    public void validateTheRepositoryAccessIsBasedOnAccessControlProfileRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getProlaborateLogo().click();
        List<String> repository = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//td[1]"));
        for (WebElement element : elements) {
            repository.add(element.getText());
        }
        if(repository.equals(selectedRepository)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else{
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Validate the group access is based on access control profile  \\(row {int}) {string}")
    public void validateTheGroupAccessIsBasedOnAccessControlProfileRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        System.out.println(selectedRepository.get(0));
        driver.findElement(By.xpath("//span[text()='"+selectedRepository.get(0)+"']")).click();
        sleep();
        rp.getMenuButton().click();
        sleep();
        List<String> expFeature = new ArrayList<String>();
        expFeature.add("Reviews");
        List<String> feature = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            feature.add(element.getText());
        }
        System.out.println(feature);
        if(feature.equals(expFeature)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else{
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @Then("Added ADuser should be in user-management user list \\(user {string}) \\(row {int}) {string}")
    public void addedADuserShouldBeInUserManagementUserListUserRow(String user, int row, String testCase) throws IOException, InterruptedException {
        sleep();
        List<WebElement> elements = driver.findElements(By.xpath("//td[2]"));
        for (WebElement element : elements) {
            if (element.getText().contains(user)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }
        }
    }

    @Then("User should see pb alert {string} message \\(row {int}) {string}")
    public void userShouldSeePbAlertMessageRow(String msg, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        String messageShown = driver.findElement(By.xpath("//ngb-alert")).getText();
        System.out.println(testCase);
        System.out.println(messageShown);
        try {
            if (messageShown.contains(msg)) {
                System.out.println("Popup message is shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("Popup message is not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println("PB alert message is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("Select the access profile {string}")
    public void selectTheAccessProfile(String element) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[text()='Access Profile']/following::span[2]")).click();// drop down
        // // box
        sleep();
        driver.findElement(By.xpath("//span[text()='" + element + "']")).click();
    }

    @And("User click on edit in repository membership column respective user in portal users list \\(user {string})")
    public void userClickOnEditInRepositoryMembershipColumnRespectiveUserInPortalUsersListUser(String user) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]/following::a[1]")).click();
    }

    @Then("Validate the repository and group selected based on the access profile choosed \\(repository {string}) \\(group {string}) \\(row {int}) {string}")
    public void validateTheRepositoryAndGroupSelectedBasedOnTheAccessProfileChoosedRepositoryGroupRow(String repository, String group, int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        try {
            boolean selected = driver.findElement(By.xpath("//label[text()='"+repository+"']/preceding-sibling::input")).isSelected();
            String text = driver.findElement(By.xpath("//label[text()='" + repository + "']//following::ng-select[1]//fa-icon//following-sibling::span")).getText();
            if (selected && text.equals(group)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else{
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }
        }catch (Exception e){
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
        refresh();
    }

    @And("Delete the user from the portal \\(user {int})")
    public void deleteTheUserFromThePortalUser(int user) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'"+uFirstName+" "+uLastName+user+"')]//preceding::div[1]")).click();
        rp.getDeleteButton().click();
        sleep();
        rp.getPopupWindowDeleteOption().click();
    }

    @Then("Validate user is deleted from the Prolaborate application are not \\(user {int}) \\(row {int}) {string}")
    public void validateUserIsDeletedFromTheProlaborateApplicationAreNotUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> userList = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//td[2]"));
        for (WebElement element : elements) {
            userList.add(element.getText());
        }
        System.out.println(userList);
        rp.getMenuButton().click();
        rp.getRepositories().click();
        driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
        sleep(1000);
        rp.getMenuButton().click();
        rp.getUsers().click();
        sleep();
        List<String> userListInRep = new ArrayList<String>();
        List<WebElement> elementsInRep = driver.findElements(By.xpath("//td[2]"));
        for (WebElement element : elementsInRep) {
            userListInRep.add(element.getText());
        }
        System.out.println(userListInRep);

            if (!userListInRep.contains(uFirstName+" "+uLastName+user) && !userList.contains(uFirstName+" "+uLastName+user)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }

    }

    @And("User click on delete in more-options \\(user {int})")
    public void userClickOnDeleteInMoreOptionsUser(int user) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("(//span[text()='"+uFirstName+" "+uLastName+user+"']/following::span[text()='More'])[1]")).click();// more option
        driver.findElement(By.xpath("//span[text()='"+uFirstName+" "+uLastName+user+"']/following::span[text()='Delete'][1]")).click();

    }

    @Then("Validate the configuration model window is displayed \\(row {int}) {string}")
    public void validateTheConfigurationModelWindowIsDisplayedRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            String text = driver.findElement(By.xpath("(//ngb-modal-window//div//p)[1]")).getText();
            System.out.println(text);
            sleep(1000);
            if (text.equalsIgnoreCase("Are you sure you want to delete this User?")) {
                System.out.println("confirmation popup message is appear");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("Testcase pass");
            } else {
                System.out.println("confirmation popup message is not appear");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("Testcase fail");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
        refresh();
    }

    @Then("Added user should be shown in dropdown \\(user {int})")
    public void addedUserShouldBeShownInDropdownUser(int user) throws InterruptedException {
        sleep();
        rp.getDropDown1().click();
        List<String> names = new ArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//ng-dropdown-panel//div[2]//span[1]"));
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        System.out.println(names);
        if (names.contains(uFirstName+" "+uLastName+user)) {
            System.out.println("User is shown");
        } else {
            System.out.println("User is not shown");
        }
    }

    @Then("Validate the user is removed from the dropdown \\(user {int}) \\(row {int}) {string}")
    public void validateTheUserIsRemovedFromTheDropdownUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getDropDown1().click();
        List<String> names = new ArrayList();
        List<WebElement> elements = driver.findElements(By.xpath("//ng-dropdown-panel//div[2]//span[1]"));
        for (WebElement element : elements) {
            names.add(element.getText());
        }
        System.out.println(names);
        if (!names.contains(uFirstName+" "+uLastName+user)) {
            System.out.println("Deleted user is not shown");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");

        } else {
            System.out.println("Deleted user is shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");

        }
    }

    @Then("Validate the user is not shown in user group users list \\(user {int}) \\(row {int}) {string}")
    public void validateTheUserIsNotShownInUserGroupUsersListUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'"+uFirstName+" "+uLastName+user+"')]")).isDisplayed();
            System.out.println("user is " + displayed);
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }catch (Exception e){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }

    }

    @And("Delete the multiple user from the portal \\(user {int}) \\(user {int})")
    public void deleteTheMultipleUserFromThePortalUserUser(int user1, int user2) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'"+uFirstName+" "+uLastName+user1+"')]//preceding::div[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'"+uFirstName+" "+uLastName+user2+"')]//preceding::div[1]")).click();
        rp.getDeleteButton().click();
        sleep();
        rp.getPopupWindowDeleteOption().click();
    }

    @Then("Validate user is deleted from the Prolaborate application are not \\(user {int}) \\(user {int}) \\(row {int}) {string}")
    public void validateUserIsDeletedFromTheProlaborateApplicationAreNotUserUserRow(int user1, int user2, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        List<String> userList = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//td[2]"));
        for (WebElement element : elements) {
            userList.add(element.getText());
        }
        System.out.println(userList);
        rp.getMenuButton().click();
        rp.getRepositories().click();
        driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
        sleep(1000);
        rp.getMenuButton().click();
        rp.getUsers().click();
        sleep();
        List<String> userListInRep = new ArrayList<String>();
        List<WebElement> elementsInRep = driver.findElements(By.xpath("//td[2]"));
        for (WebElement element : elementsInRep) {
            userListInRep.add(element.getText());
        }
        System.out.println(userListInRep);

        if (!userListInRep.contains(uFirstName+" "+uLastName+user1) && !userList.contains(uFirstName+" "+uLastName+user1)
                &&!userListInRep.contains(uFirstName+" "+uLastName+user2) && !userList.contains(uFirstName+" "+uLastName+user2)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }

    @And("User create one review with added user \\(user {int}) \\(review {string})")
    public void userCreateOneReviewWithAddedUserUserReview(int user, String reviewName) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[text()='Create Review']")).click();// create review
        sleep();
        driver.findElement(By.xpath("//label[text()='Review Name *']/following::input[1]")).sendKeys(reviewName);
        driver.findElement(By.xpath("//label[text()='Review Dates *']/following::button[2]")).click();// end date
        sleep();
        driver.findElement(By.xpath("//div[contains(@class,'today')]//following::div[2]")).click();// date
        driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
        sleep();
        driver.findElement(By.xpath("//div[@class='p-checkbox-box']")).click();
        sleep();
        driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
        sleep();
        WebElement selectUser = driver.findElement(By.xpath("//div[contains(text(),'"+uFirstName+" "+uLastName+user+"')]"));
        Actions act = new Actions(driver);
        act.moveToElement(selectUser).build().perform();
        sleep();
        driver.findElement(By.xpath("//div[contains(text(),'"+uFirstName+" "+uLastName+user+"')]/following::span[1]")).click();// add
        // userin
        // review
        driver.findElement(By.xpath("(//span[text()='Create Review'])[2]")).click();// create review
        sleep();
        driver.findElement(By.xpath("//span[text()='Open Reviews List']")).click();// open review list
        sleep();
        driver.findElement(By.xpath("//span[text()='"+reviewName+"']")).click();// open review
        sleep();
    }

    @And("User open {string} review")
    public void userOpenReview(String reviewName) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("//span[text()='"+reviewName+"']")).click();
    }

    @Then("Validate the user is removed frome the review \\(user {int}) \\(row {int}) {string}")
    public void validateTheUserIsRemovedFromeTheReviewUserRow(int user, int row, String testCase) throws IOException, InterruptedException {
        sleep();
        if (!driver.getPageSource().contains(uFirstName+" "+uLastName+user)) {
            System.out.println("user is removed from review user list");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        } else {
            System.out.println("user is not removed from review user list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");

        }
    }

    @Then("Validate user can able to delete the another admin user \\(user {int}) \\(row {int}) {string}")
    public void validateUserCanAbleToDeleteTheAnotherAdminUserUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            WebElement checkbox2 = driver.findElement(By.xpath("//span[text()='"+uFirstName+" "+uLastName+user+"']//preceding::div[1]"));
            checkbox2.click();// click user check box
            if (driver.getPageSource().contains("Delete")) {
                System.out.println("admin user can delete another admin user");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            } else {
                System.out.println("admin user can't delete another admin user");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }

    }

    @And("User open \\(user {int})")
    public void userOpenUser(int user) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//span[text()='"+uFirstName+" "+uLastName+user+"']")).click();
    }

    @Then("Validate the user details in edit user page \\(user {int}) \\(row {int}) {string}")
    public void validateTheUserDetailsInEditUserPageUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        List<Boolean> details = new ArrayList<Boolean>();
        String first_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[1]"))
                .getAttribute("value");
        System.out.println(first_name);
        details.add(first_name.equalsIgnoreCase(uFirstName));
        String usermail = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[2]"))
                .getAttribute("value");
        System.out.println(usermail);
        details.add(usermail.equalsIgnoreCase(uFirstName+uLastName+user+"@mail.com"));
        String timezone = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[3]"))
                .getAttribute("value");
        System.out.println(timezone);
        details.add(timezone.equalsIgnoreCase("India Standard Time"));
        String last_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[4]"))
                .getAttribute("value");
        System.out.println(last_name);
        details.add(last_name.equalsIgnoreCase(uLastName+user));
        String status = driver.findElement(By.xpath("//label[text()='Status']/following::span[1]")).getText();
        System.out.println(status);
        details.add(status.equalsIgnoreCase("active"));
        String admin = driver.findElement(By.xpath("//label[text()='Make Super Admin']/following::span[1]"))
                .getText();
        System.out.println(admin);
        details.add(admin.equalsIgnoreCase("Yes"));
        if (!details.contains(false)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @And("User open \\(user {string})")
    public void userOpenUser(String user) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]")).click();
    }

    @Then("Validate the user details in edit user page \\(user {string}) \\(row {int}) {string}")
    public void validateTheUserDetailsInEditUserPageUserRow(String user, int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        String first_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[1]")).getAttribute("value");
        System.out.println(first_name);

        String usermail = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[2]")).getAttribute("value");
        System.out.println(usermail);

        String timezone = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[3]")).getAttribute("value");
        System.out.println(timezone);

        String last_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[4]")).getAttribute("value");
        System.out.println(last_name);

        String status = driver.findElement(By.xpath("//label[text()='Status']/following::span[1]")).getText();
        System.out.println(status);

        String admin = driver.findElement(By.xpath("//label[text()='Make Super Admin']/following::span[1]")).getText();
        System.out.println(admin);

        if (first_name.contains(user) && last_name.isEmpty()
                && usermail.isEmpty() && timezone.equals("India Standard Time") && status.equalsIgnoreCase("active")
                && admin.equalsIgnoreCase("No")){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the SMALuser details in edit user page \\(user {string}) \\(row {int}) {string}")
    public void validateTheSMALuserDetailsInEditUserPageUserRow(String user, int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        String[] a = user.split(" ");
        String userfirstname = a[0];
        System.out.println(userfirstname);
        String userlastname = a[1];
        System.out.println(userlastname);
        List<Boolean> details = new ArrayList<Boolean>();
        String first_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[1]"))
                .getAttribute("value");
        System.out.println(first_name);
        details.add(first_name.equalsIgnoreCase(userfirstname));
        String usermail = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[2]"))
                .getAttribute("value");
        System.out.println(usermail);
        details.add(usermail.equalsIgnoreCase("kiran@prolaborate.com"));
        String timezone = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[3]"))
                .getAttribute("value");
        System.out.println(timezone);
        details.add(timezone.equalsIgnoreCase("India Standard Time"));
        String last_name = driver.findElement(By.xpath("//span[text()='Edit User']/following::input[4]"))
                .getAttribute("value");
        System.out.println(last_name);
        details.add(last_name.equalsIgnoreCase(userlastname));
        String status = driver.findElement(By.xpath("//label[text()='Status']/following::span[1]")).getText();
        System.out.println(status);
        details.add(status.equalsIgnoreCase("active"));
        String admin = driver.findElement(By.xpath("//label[text()='Make Super Admin']/following::span[1]"))
                .getText();
        System.out.println(admin);
        details.add(admin.equalsIgnoreCase("no"));
        if (!details.contains(false)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the registereduser details in user list page \\(user {int}) \\(row {int}) {string}")
    public void validateTheRegistereduserDetailsInUserListPageUserRow(int user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<String> usernameList = new ArrayList<String>();
        List<WebElement> userNames = driver.findElements(By.xpath("//td[2]"));
        for (WebElement users : userNames) {
            usernameList.add(users.getText());
        }
        if (usernameList.contains(uFirstName+" "+uLastName+user)){
            String email = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[1]")).getText();
            System.out.println("user mail is - " + email);
            String type = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[2]")).getText();
            System.out.println("user type is - " + type);
            String licenseType = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[4]")).getText();
            System.out.println("user license type is - " + licenseType);
            String status = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[5]")).getText();
            System.out.println("user status is - " + status);

            if(email.contains(uFirstName+uLastName+user+"@mail.com")&&type.contains("Registered User")
                    &&licenseType.contains("Regular")&&status.contains("Active")){
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }

        }else {
            System.out.println("User name is not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }

    }

    @Then("Validate the adminuser details in user list page \\(user {int}) \\(row {int}) {string}")
    public void validateTheAdminuserDetailsInUserListPageUserRow(int user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<String> usernameList = new ArrayList<String>();
        List<WebElement> userNames = driver.findElements(By.xpath("//td[2]"));
        for (WebElement users : userNames) {
            usernameList.add(users.getText());
        }
        if (usernameList.contains(uFirstName+" "+uLastName+user)){
            String email = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[1]")).getText();
            System.out.println("user mail is - " + email);
            String type = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[2]")).getText();
            System.out.println("user type is - " + type);
            String licenseType = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[4]")).getText();
            System.out.println("user license type is - " + licenseType);
            String status = driver.findElement(By.xpath("//span[text()='" + uFirstName + " " + uLastName + user + "']//following::td[5]")).getText();
            System.out.println("user status is - " + status);

            if(email.contains(uFirstName+uLastName+user+"@mail.com")&&type.contains("Prolaborate Admin")
                    &&licenseType.contains("Regular")&&status.contains("Active")){
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }

        }else {
            System.out.println("User name is not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the ADuser details in user list page \\(user {string}) \\(row {int}) {string}")
    public void validateTheADuserDetailsInUserListPageUserRow(String user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<String> usernameList = new ArrayList<String>();
        List<WebElement> userNames = driver.findElements(By.xpath("//td[2]"));
        for (WebElement users : userNames) {
            usernameList.add(users.getText().trim());
        }
        if (usernameList.contains(user)){
            String email = driver.findElement(By.xpath("//span[text()='"+"  "+ user + "']//following::td[1]")).getText();
            System.out.println("user mail is - " + email);
            String type = driver.findElement(By.xpath("//span[text()='"+"  "+user+"']//following::td[2]")).getText();
            System.out.println("user type is - " + type);
            String licenseType = driver.findElement(By.xpath("//span[text()='"+"  "+user+"']//following::td[4]")).getText();
            System.out.println("user license type is - " + licenseType);
            String status = driver.findElement(By.xpath("//span[text()='"+"  "+user+"']//following::td[5]")).getText();
            System.out.println("user status is - " + status);

            if(email.isEmpty()&&type.contains("Active Directory User")
                    &&licenseType.contains("Regular")&&status.contains("Active")){
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }

        }else {
            System.out.println("User name is not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the ADgroupuser details in user list page \\(user {string}) \\(row {int}) {string}")
    public void validateTheADgroupuserDetailsInUserListPageUserRow(String user, int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        sleep(1000);
        List<String> usernameList = new ArrayList<String>();
        List<WebElement> userNames = driver.findElements(By.xpath("//td[2]"));
        for (WebElement users : userNames) {
            usernameList.add(users.getText().trim());
        }
        if (usernameList.contains(user)){
            String email = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[1]")).getText();
            System.out.println("user mail is - " + email);
            String type = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[2]")).getText();
            System.out.println("user type is - " + type);
            String licenseType = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[4]")).getText();
            System.out.println("user license type is - " + licenseType);
            String status = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[5]")).getText();
            System.out.println("user status is - " + status);

            if(email.isEmpty()&&type.contains("Active Directory Group User")
                    &&licenseType.contains("Regular")&&status.contains("Active")){
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }

        }else {
            System.out.println("User name is not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the SAMLuser details in user list page \\(user {string}) \\(row {int}) {string}")
    public void validateTheSAMLuserDetailsInUserListPageUserRow(String user, int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        sleep(1000);
        List<String> usernameList = new ArrayList<String>();
        List<WebElement> userNames = driver.findElements(By.xpath("//td[2]"));
        for (WebElement users : userNames) {
            usernameList.add(users.getText().trim());
        }
        if (usernameList.contains(user)){
            String email = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[1]")).getText();
            System.out.println("user mail is - " + email);
            String type = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[2]")).getText();
            System.out.println("user type is - " + type);
            String licenseType = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[4]")).getText();
            System.out.println("user license type is - " + licenseType);
            String status = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[5]")).getText();
            System.out.println("user status is - " + status);

            if(email.contains("kiran@prolaborate.com")&&type.contains("Identity Provider User")
                    &&licenseType.contains("Regular")&&status.contains("Active")){
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("TestCase pass");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("TestCase fail");
            }

        }else {
            System.out.println("User name is not shown in list");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @And("User click edit on actions respective \\(user {int})")
    public void userClickEditOnActionsRespectiveUser(int user) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("(//span[text()='"+uFirstName+" "+uLastName+user+"']/following::span[text()='Edit'])[1]")).click();
    }

    @Then("Validate the respective edit user page is displayed \\(row {int}) {string}")
    public void validateTheRespectiveEditUserPageIsDisplayedRow(int row, String testCase) throws IOException {
        try {
            driver.findElement(By.xpath("//h3//span[text()='Edit User']")).isDisplayed();
            System.out.println("Edit user page is displayed");
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }catch (Exception e) {
            System.out.println("Edit user page is not displayed");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }

    }

    @And("User update the {string} \\({string})")
    public void userUpdateThe(String element, String user) throws InterruptedException {
        sleep();
        WebElement f = driver.findElement(By.xpath("//label[text()='"+element+"']/following::input[1]"));
        f.clear();
        f.sendKeys(user);
    }

    @Then("Validate firstname is updated in user list and user profile \\(user {int})")
    public void validateFirstnameIsUpdatedInUserListAndUserProfileUser(int user) throws IOException, InterruptedException {
        sleep();
        validateText = driver.findElement(By.xpath("//span[text()='" + uFirstName + uLastName + user + "@mail.com" + "']//preceding::td[1]")).getText();

    }

    @And("Open my profile")
    public void openMyProfile() {
        rp.getProfile().click();
        driver.findElement(By.xpath("//span[text()='My Profile']")).click();
    }

    @Then("Validate firstname is updated in user profile \\({string}) \\(row {int}) {string}")
    public void validateFirstnameIsUpdatedInUserProfileRow(String user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        String text = driver.findElement(By.xpath("//span[text()='Name']//following::td[1]")).getText();
        if (text.startsWith(user)&&validateText.startsWith(user)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate lastname is updated in user list and user profile \\(user {int})")
    public void validateLastnameIsUpdatedInUserListAndUserProfileUser(int user) throws InterruptedException {
        sleep();
        validateText = driver.findElement(By.xpath("//span[text()='" + uFirstName + uLastName + user + "@mail.com" + "']//preceding::td[1]")).getText();
    }

    @Then("Validate lastname is updated in user profile \\({string}) \\(row {int}) {string}")
    public void validateLastnameIsUpdatedInUserProfileRow(String user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        String text = driver.findElement(By.xpath("//span[text()='Name']//following::td[1]")).getText();
        if (text.endsWith(user)&&validateText.endsWith(user)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }


    @Then("Validate email is updated in user list \\(user {int}) \\(update {string}) \\(row {int}) {string}")
    public void validateEmailIsUpdatedInUserListUserUpdateRow(int user, String updateduser, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        validateText = driver.findElement(By.xpath("//span[text()='"+uFirstName +" "+uLastName+user+"']//following::td[1]")).getText();
        if (validateText.contains(updateduser)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @Then("Validate the user can able to login \\(user {int}) \\(row {int}) {string}")
    public void validateTheUserCanAbleToLoginUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(uFirstName+uLastName+user+"@mail.com");
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        try {
            // set password
            driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
            backward();
        }catch (Exception e){
            System.out.println("set password page not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
        refresh();
    }

    @And("User update user status to {string}")
    public void userUpdateUserStatusTo(String status) {
        driver.findElement(By.id("userStatus")).click();
    }



    @Then("Validate status is updated in user list \\(user {int}) \\(status {string}) \\(row {int}) {string}")
    public void validateStatusIsUpdatedInUserListUserStatusRow(int user, String updatedstatus, int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        validateText = driver.findElement(By.xpath("//span[text()='"+uFirstName +" "+uLastName+user+"']//following::td[5]")).getText();
        if (validateText.contains(updatedstatus)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @And("User click edit on actions respective \\(user {string})")
    public void userClickEditOnActionsRespectiveUser(String user) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("(//span[text()='"+"  "+user+"']/following::span[text()='Edit'])[1]")).click();
    }

    @Then("Validate the ADuser non-editable fields properly disabled {string} {string} {string} \\(row {int}) {string}")
    public void validateTheADuserNonEditableFieldsProperlyDisabledRow(String firstname, String lastname, String email, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        boolean firstNameField = driver.findElement(By.xpath("//label[text()='" + firstname + "']/following::input[1]")).isEnabled();
        System.out.println("First name field is " + firstNameField);
        boolean lastNameField = driver.findElement(By.xpath("//label[text()='" + lastname + "']/following::input[1]")).isEnabled();
        System.out.println("Last name field is " + lastNameField);
        boolean emailField = driver.findElement(By.xpath("//label[text()='" + email + "']/following::input[1]")).isEnabled();
        System.out.println("Email field is "+ emailField);
        if (!firstNameField&&!lastNameField&&!emailField){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }

    }

    @And("User update user role to {string}")
    public void userUpdateUserRoleTo(String role) {
        driver.findElement(By.id("userIsAdmin")).click();
    }

    @Then("Validate role is updated in user list \\(user {int}) \\(role {string}) \\(row {int}) {string}")
    public void validateRoleIsUpdatedInUserListUserRoleRow(int user, String updatedrole, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        validateText = driver.findElement(By.xpath("//span[text()='"+uFirstName +" "+uLastName+user+"']//following::td[2]")).getText();
        if (validateText.contains(updatedrole)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
    }

    @And("User update the set temporary password of \\(user {int}) \\(tempPassword {string})")
    public void userUpdateTheSetTemporaryPasswordOfUserTempPassword(int user, String tempPassword) throws InterruptedException {
        sleep(1000);
        try {
            driver.findElement(By.xpath("(//span[text()='"+uFirstName +" "+uLastName+user+"']/following::span[text()='More'])[1]")).click();
            driver.findElement(By.xpath("//span[text()='Set Temporary Password']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Enter a Password']")).sendKeys(tempPassword);
            driver.findElement(By.xpath("//input[@placeholder='Re-enter the Password']")).sendKeys(tempPassword);
            driver.findElement(By.xpath("//span[text()='Set']")).click();
        }catch (Exception e){
            System.out.println("Set temporary password is not shown");
            System.out.println("TestCase fail");
        }

    }

    @Then("Validate the PB alert message for successful set password")
    public void validateThePBAlertMessageForSuccessfulSetPassword() throws InterruptedException {
        sleep();
//        System.out.println(testCase);
        String text = driver.findElement(By.tagName("ngb-alert")).getText();
        System.out.println(text);
        if (text.contains("Password updated successfully!")) {
            System.out.println("PB alert message is appear");
        } else {
            System.out.println("PB alert message is not appear");
        }
    }

    @Then("Validate the user can able to login by temporary password \\(user {int}) \\(tempPassword {string}) \\(row {int}) {string}")
    public void validateTheUserCanAbleToLoginByTemporaryPasswordUserTempPasswordRow(int user, String tempPassword, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        rp.getLoginUserName().sendKeys(uFirstName+uLastName+user+"@mail.com");
        rp.getLoginPassword().sendKeys(tempPassword);
        rp.getSignIn().click();
        try {
            // set password
            driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("TestCase pass");
            backward();
        }catch (Exception e){
            System.out.println("set password page not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("TestCase fail");
        }
        refresh();
    }

    @Then("Repository membership column should be shown in portal user list \\(row {int}) {string}")
    public void repositoryMembershipColumnShouldBeShownInPortalUserListRow(int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            String displayed = driver.findElement(By.xpath("//tr/th[5]")).getText();
            if (displayed.contains("Repository Membership")) {
                System.out.println("Repository Membership column is shown");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("Repository Membership column is not shown");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println("Repository Membership column is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Edit option should be shown in under the repository membership column in portal user list \\(user {int}) \\(row {int}) {string}")
    public void editOptionShouldBeShownInUnderTheRepositoryMembershipColumnInPortalUserListUserRow(int user, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        try {
            String displayed = driver.findElement(By.xpath("//span[text()='"+uFirstName+" "+uLastName+user+"']//following::td[3]")).getText();
            if (displayed.contains("Edit")) {
                System.out.println("Edit option is shown in Repository Membership column");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("Edit option is not shown in Repository Membership column");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println("Edit option is not shown in Repository Membership column");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate respective model window is shown \\(user {int}) \\(row {int}) {string}")
    public void validateRespectiveModelWindowIsShownUserRow(int user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            String text = driver.findElement(By.xpath("//ngb-modal-window//h4[text()]")).getText();
            if (text.contains("Repository Membership - "+uFirstName+" "+uLastName+user)) {
                System.out.println("Edit option is redirect to  Repository Membership window");
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                System.out.println("Edit option is not redirect to  Repository Membership window");
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        }catch (Exception e) {
            refresh();
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate all repository names are shown in repository membership window \\(row {int}) {string}")
    public void validateAllRepositoryNamesAreShownInRepositoryMembershipWindowRow(int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        try {
            List<String> names = new ArrayList<String>();
            List<WebElement> elements = driver.findElements(By.xpath("//ngb-modal-window//app-checkbox//label"));
            for(int i = 1; i < elements.size(); i++){
                String text = elements.get(i).getText();
                names.add(text);
            }

            System.out.println(names);
            if (repositoryLists.equals(names)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        }catch (Exception e){
            refresh();
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @And("Get the repository list")
    public void getTheRepositoryList() throws InterruptedException {
        sleep();
        repositoryLists = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr//td[1]//a//span"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            repositoryLists.add(text);
        }
        System.out.println(repositoryLists);
    }

    @Then("Validate user group membership field is disabled state until the repository choose \\(row {int}) {string}")
    public void validateUserGroupMembershipFieldIsDisabledStateUntilTheRepositoryChooseRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<Boolean> checkboxs = new ArrayList<Boolean>();
        List<Boolean> dropdowns = new ArrayList<Boolean>();
        List<WebElement> elements = driver.findElements(By.xpath("//ngb-modal-window//app-checkbox//input"));
        for(int i=1; i < elements.size(); i++) {
            checkboxs.add(elements.get(i).isSelected());
        }
        List<WebElement> groupdropdown = driver.findElements(By.xpath("//ngb-modal-window//app-select//input"));
        for(int j=0; j< groupdropdown.size(); j++) {
            dropdowns.add(groupdropdown.get(j).isEnabled());
        }
        if(!checkboxs.contains(true)&&!dropdowns.contains(true)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @And("User select repository {string}")
    public void userSelectRepository(String repository) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//label[text()='"+repository+"']")).click();
    }

    @And("Get the group list")
    public void getTheGroupList() throws InterruptedException {
        sleep();
        GroupNames = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr//td[1]//a//span"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            GroupNames.add(text);
        }
        System.out.println(GroupNames);
    }

    @Then("Validate the user group list is shown in user group membership dropdown after choosed repository {string} \\(row {int}) {string}")
    public void validateTheUserGroupListIsShownInUserGroupMembershipDropdownAfterChoosedRepositoryRow(String repository, int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//label[text()='"+repository+"']//following::ng-select[1]")).click();
            List<String> GroupNamesInDropdown = new ArrayList<>();
            List<WebElement> elements = driver.findElements(By.xpath("//ng-dropdown-panel//span"));
            for (int i = 0; i < elements.size(); i++) {
                String text = elements.get(i).getText();
                GroupNamesInDropdown.add(text);
            }
            if (GroupNames.containsAll(GroupNamesInDropdown)&&(GroupNamesInDropdown.containsAll(GroupNames))) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate the save and cancel button is shown in repository membership model window \\(row {int}) {string}")
    public void validateTheSaveAndCancelButtonIsShownInRepositoryMembershipModelWindowRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//ngb-modal-window//button//span[text()='Cancel']")).isDisplayed();
            boolean displayed1 = driver.findElement(By.xpath("//ngb-modal-window//button//span[text()='Save']")).isDisplayed();
            if (displayed&&displayed1) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            }else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }

        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
        refresh();
    }

    @Then("Validate the choosed repository is aborted properly \\(repository {string}) \\(row {int}) {string}")
    public void validateTheChoosedRepositoryIsAbortedProperlyRepositoryRow(String repository, int row, String testCase) throws IOException {
        System.out.println(testCase);
        boolean selected = driver.findElement(By.xpath("//label[text()='Test Repository']//preceding::input[1]")).isSelected();
        if (!selected){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the repository membership window is disappeared when click close button \\(row {int}) {string}")
    public void validateTheRepositoryMembershipWindowIsDisappearedWhenClickCloseButtonRow(int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        sleep(1000);
        boolean repositoryAndUserGroupsMembership = driver.getPageSource().contains("Repository and User Groups Membership");
        System.out.println(repositoryAndUserGroupsMembership);
        if (!repositoryAndUserGroupsMembership){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User click close button")
    public void userClickCloseButton() {
        driver.findElement(By.xpath("//button[contains(@class,'close')]")).click();
    }

    @And("User click on Repository header")
    public void userClickOnRepositoryHeader() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//label[text()='Repository Name']")).click();
    }

    @Then("Validate all repository is selected \\(row {int}) {string}")
    public void validateAllRepositoryIsSelectedRow(int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<Boolean> isSelected = new ArrayList<>();
        List<WebElement> checkbox = driver.findElements(By.xpath("//ngb-modal-window//input[@type='checkbox']"));
        for (WebElement checkboxElement : checkbox) {
           isSelected.add(checkboxElement.isSelected());
        }
        if (!isSelected.contains(false)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
        refresh();
    }



    @And("User select user group membership \\(repository {string}) {string}")
    public void userSelectUserGroupMembershipRepository(String rep, String group) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("(//label[text()='"+rep+"']//following::span[@class='ng-arrow-wrapper'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='"+group+"']")).click();
    }

    @Then("Validate the PB alert message for successful repository membership assigned \\(row {int}) {string}")
    public void validateThePBAlertMessageForSuccessfulRepositoryMembershipAssignedRow(int row, String testCase) throws IOException {
        String messageShown = driver.findElement(By.xpath("//ngb-alert")).getText();
        System.out.println(testCase);
        System.out.println(messageShown);
            if (messageShown.contains("success")) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }

    }

    @Then("Validate the user is added to the assigned group")
    public void validateTheUserIsAddedToTheAssignedGroup() throws InterruptedException {
        sleep();
        UserNames = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//li//button"));
        for(int i = 0; i < elements.size(); i++) {
            String aClass = elements.get(i).getAttribute("class");
            System.out.println(aClass);
            if (aClass.contains("success")) {
                List<WebElement> elements1 = driver.findElements(By.xpath("//li//span[1]"));
                for(int j = i; j < elements1.size(); j++) {
                    String text = elements1.get(j).getText();
                    System.out.println(text);
                    UserNames.add(text);
                }
            }
        }
        System.out.println(UserNames);
    }

    @Then("Validate the user is added to the assigned repository \\(userNo {int}) \\(row {int}) {string}")
    public void validateTheUserIsAddedToTheAssignedRepositoryUserNoRow(int user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<String> UserNamesInUsersList = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//td[2]"));
        for (int i = 0; i < elements.size(); i++) {
            UserNamesInUsersList.add(elements.get(i).getText());
        }
        System.out.println(UserNamesInUsersList);
        if (UserNames.contains(uFirstName+" "+uLastName+user)&&UserNamesInUsersList.contains(uFirstName+" "+uLastName+user)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else{
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate assigned repository is shown in user account \\(row {int}) {string}")
    public void validateAssignedRepositoryIsShownInUserAccountRow(int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        try {
            driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
            sleep(1000);
            if (driver.getPageSource().contains("Prolaborate - Start Here")) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else{
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate user getting repository configuration access besed on group select \\(row {int}) {string}")
    public void validateUserGettingRepositoryConfigurationAccessBesedOnGroupSelectRow(int row, String testCase) throws IOException, InterruptedException {
        sleep(1000);
        List<String> features = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//h4[text()='Repository Configuration']//following::a/div[1]"));
        for (WebElement element : elements) {
            String feature = element.getText();
            features.add(feature);
        }
        System.out.println(features);
        if (features.contains("Reviews")) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("Testcase pass");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("Testcase fail");
        }
    }
}
