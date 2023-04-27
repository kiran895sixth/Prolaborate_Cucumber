package org.test.prolaborate.stepDefinitions.Access_Permission;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.test.prolaborate.baseclass.LoginPage;
import org.test.prolaborate.baseclass.XLdata;
import org.test.prolaborate.stepDefinitions.Users_In_Repository.Users_In_Repository;
import org.test.prolaborate.stepDefinitions.commonPackage.commonClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Access_permissions extends LoginPage {

    public static List<String> GroupNames = null;
    public static List<String> UserNames = null;
    public static int columnNo = 2;
    public static String sheet1 = "Login_Data";
    public static String sheet2 = "Access Permissions";
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
    public static List<String> artifacts = null;
    public static String  time = null;



    @Then("Validate user can able to choose single access \\(row {int}) {string}")
    public void validate_user_can_able_to_choose_single_access_row(Integer row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        boolean customized = driver.findElement(By.id("Customized")).isSelected();
        if (customized) {
            driver.findElement(By.id("Single")).click();
        }else {
            driver.findElement(By.id("Customized")).click();
            sleep();
            driver.findElement(By.id("Single")).click();
        }
        boolean single = driver.findElement(By.id("Single")).isSelected();
        if (single) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate PB alert message for successful switched \\(row {int}) {string}")
    public void validate_PB_alert_message_for_successful_switched_row(Integer row, String testCase) throws IOException, InterruptedException {
        String messageShown = driver.findElement(By.xpath("//ngb-alert")).getText();
        System.out.println(testCase);
        System.out.println(messageShown);
        sleep(1000);
        try {
            if (messageShown.contains("Successfully")) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println("PB alert message is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate single access help icon mouseover text \\(message {string}) \\(row {int}) {string}")
    public void validateSingleAccessHelpIconMouseoverTextMessageRow(String content, int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        WebElement element = driver.findElement(By.xpath("//label[text()='Single Access']//following::app-helpicon"));
        mouseHover(element);
        String text = driver.findElement(By.xpath("//ngb-tooltip-window")).getText();
        System.out.println(text);
        if (text.contains(content)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate select field shown all access by default \\(row {int}) {string}")
    public void validate_select_field_shown_all_access_by_default_row(Integer row, String testCase) throws IOException, InterruptedException {
        sleep(1000);
        System.out.println(testCase);
        List<String> access = new ArrayList<String>();
        access.add("Read"); access.add("Write"); access.add("Collaborate");
        List<String> acutalAccess = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//ng-select//span//span[text()]"));
        for (WebElement element : elements) {
            String text = element.getText();
            acutalAccess.add(text);
        }
        if (access.equals(acutalAccess)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate apply button show properly \\(row {int}) {string}")
    public void validate_apply_button_show_properly_row(Integer row, String testCase) throws IOException, InterruptedException {
        sleep(1000);
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//span[text()='Apply']")).isDisplayed();
            if (displayed) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate PB alert message for successful applied \\(row {int}) {string}")
    public void validatePBAlertMessageForSuccessfulAppliedRow(int row, String testCase) throws IOException {
        String messageShown = driver.findElement(By.xpath("//ngb-alert")).getText();
        System.out.println(testCase);
        System.out.println(messageShown);
        try {
            if (messageShown.contains("Successfully")) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }
        } catch (Exception e) {
            System.out.println("PB alert message is not shown");
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("Note the artifacts under the sections")
    public void noteTheArtifactsUnderTheSections() throws InterruptedException {
        List<WebElement> browser = driver.findElements(By.xpath("//div//td//span//span//span"));
        artifacts = new ArrayList<String>();
        for (int i = 0; i < browser.size(); i++) {
            artifacts.add(browser.get(i).getText());
        }
        System.out.println(artifacts);
    }

    @And("User click on home button")
    public void userClickOnHomeButton() throws InterruptedException {
        sleep();
        rp.getHomeIcon().click();
    }

    @Then("Validate all artifacts shown in repository browser based on sections \\(row {int}) {string}")
    public void validateAllArtifactsShownInRepositoryBrowserBasedOnSectionsRow(int row, String testCase) throws IOException, InterruptedException {
        sleep();
        System.out.println(testCase);
        List<WebElement> browser = driver.findElements(By.xpath("//p-treenode//li//span[text()]"));
        List<String> browsers = new ArrayList<String>();
        System.out.println(browser.size());
        for (WebElement webElement : browser) {
            browsers.add(webElement.getText());
        }
        System.out.println(browsers);
        if (browsers.equals(artifacts)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User choose {string} access")
    public void userChooseAccess(String access) {
        boolean Acc = driver.findElement(By.id(access)).isSelected();
        if (!Acc) {
            driver.findElement(By.id(access)).click();
        }
    }

    @Then("Validate user can able to do all operations \\(row {int}) {string}")
    public void validateUserCanAbleToDoAllOperationsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute = driver.findElement(By.xpath("//div[@aria-label='Example Model']")).getAttribute("aria-expanded");
        if (!attribute.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Example Model ']//preceding::span[2]")).click();
        }
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[3]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&writeAccess_verification&&collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User navigate to create Review -Select Reciew Items tab")
    public void userNavigateToCreateReviewSelectReciewItemsTab() throws InterruptedException {
        sleep(500);
        driver.findElement(By.xpath("//span[text()='Create Review']")).click();// create review
        driver.findElement(By.xpath("//label[text()='Review Name *']/following::input[1]")).sendKeys("asdf");// review
        // name
        driver.findElement(By.xpath("//label[text()='Review Dates *']/following::button[2]")).click();// end date
        sleep();
        driver.findElement(By.xpath("//div[contains(@class,'today')]//following::div[2]")).click();// date
        driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
    }

    @Then("Validate the repository browser in review shows based on sections \\(row {int}) {string}")
    public void validateTheRepositoryBrowserInReviewShowsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> browser = driver.findElements(By.xpath("//span[@class='p-treenode-label']"));
        List<String> browsers = new ArrayList<String>();
        for (int i = 0; i < browser.size(); i++) {
            browsers.add(browser.get(i).getText());
        }
        System.out.println("Repository Browser in Review  " + browsers);
        System.out.println("Repository Browser in sections  " + artifacts);
        if (artifacts.equals(browsers)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User add {string} Widget")
    public void userAddWidget(String widget) throws InterruptedException {
        refresh();
        sleep();
        driver.findElement(By.xpath("//a[@class='dropdown-toggle btn btn-theme']")).click();// add widget
        driver.findElement(By.xpath("(//span[text()='Add New'])[2]")).click();// add new
        sleep();
        driver.findElement(By.xpath("(//h4[contains(text(),'"+widget+"')]//following::fa-icon)[1]")).click();// select charts
    }

    @And("Close choose report from list window")
    public void closeChooseReportFromListWindow() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//ngb-modal-window[2]//button[contains(@class,'close')]")).click();
    }

    @And("User choose {string} chart type")
    public void userChooseChartType(String chart) throws InterruptedException {
        sleep(1000);
        driver.findElement(By.xpath("//p[text()='"+chart+"']")).click();// select one chart
    }

    @Then("Validate the browser in charts source selection tab shows based on sections \\(row {int}) {string}")
    public void validateTheBrowserInChartsSourceSelectionTabShowsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//h3[text()='Source Selection']/following::span[@class='p-treenode-label']"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println("Repository Browser shows" + browserlist);
        System.out.println("Repository Browser in sections  " + artifacts);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the browser in reports source selection tab shows based on sections \\(row {int}) {string}")
    public void validateTheBrowserInReportsSourceSelectionTabShowsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//h3[text()='Designer Configuration']/following::span[@class='p-treenode-label']"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the browser in hyperlinks select an item window shows based on sections \\(row {int}) {string}")
    public void validateTheBrowserInHyperlinksSelectAnItemWindowShowsBasedOnSectionsRow(int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//table//tr//p-treenode//span//span//span"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the browser in Diagrams select an diagram window shows based on sections \\(row {int}) {string}")
    public void validateTheBrowserInDiagramsSelectAnDiagramWindowShowsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//table//tr//p-treenode//span//span//span"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate admin user get all artifacts based on sections \\(row {int}) {string}")
    public void validateAdminUserGetAllArtifactsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//div//td//span//span//span"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate registered user get all artifacts based on sections \\(row {int}) {string}")
    public void validateRegisteredUserGetAllArtifactsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//div//td//span//span//span"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("Select the active directory user \\(uesr {string})")
    public void selectTheActiveDirectoryUserUesr(String user) throws InterruptedException {
        sleep(4000);
        driver.findElement(By.xpath("//span[text()='"+user+"']/preceding::div[1]")).click();// selecting user
    }

    @And("Login the added \\(inviteuser {string})")
    public void loginTheAddedInviteuser(String user) throws InterruptedException {
        sleep();
        rp.getLoginUserName().sendKeys(user);
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        try {
            // set password
            driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
            driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
            driver.findElement(By.xpath("//button[text()='Save Password']")).click();
            driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
            sleep();
        }catch (Exception e){
            System.out.println("set password page not shown");
        }
    }

    @Then("Validate invite user get all artifacts based on sections \\(row {int}) {string}")
    public void validateInviteUserGetAllArtifactsBasedOnSectionsRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("(//div//td//span//span//span)[1]"));
        List<String> browserlist = new ArrayList<String>();
        for (int i = 0; i < checklist.size(); i++) {
            browserlist.add(checklist.get(i).getText());
        }
        System.out.println(browserlist);
        if (artifacts.equals(browserlist)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("select repository browser package and invite user via email")
    public void selectRepositoryBrowserPackageAndInviteUserViaEmail()  throws InterruptedException {
        sleep();
        mouseHover(driver.findElement(By.xpath("(//div//td//span//span//span)[1]")));
        driver.findElement(By.xpath("(//div//td//span//span//span)[1]")).click();
        driver.findElement(By.xpath("(//div//td//span//span//span)[2]")).click();
        selectedRepositoryBrowser = driver.findElement(By.xpath("(//div//td//span//span//span)[2]")).getText();
        driver.findElement(By.xpath("//span[text()='Share']")).click();
        LocalTime t = LocalTime.now();
        time = t.format(DateTimeFormatter.ofPattern("HHmm"));
        System.out.println(t);
        WebElement emailid = driver.findElement(By.xpath("//label[text()='Enter Email ID(s) *']/following::input[1]"));
        emailid.sendKeys(uFirstName+uLastName+time+"@mailinator.com", Keys.ENTER);
        sleep();
        driver.findElement(By.xpath("//span[text()='Invite']")).click();
    }

    @And("User join the prolaborate via invite link")
    public void userJoinTheProlaborateViaInviteLink() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
//        Robot w = new Robot();
//        w.keyPress(KeyEvent.VK_CONTROL);
//        w.keyPress(KeyEvent.VK_T);
//        w.keyRelease(KeyEvent.VK_CONTROL);
//        w.keyRelease(KeyEvent.VK_T);
        sleep();
        ArrayList<String> li = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(li.size());
        driver.get("https://www.mailinator.com/v4/public/inboxes.jsp");
        sleep();
        WebElement inboxfield = driver.findElement(By.id("inbox_field"));
        inboxfield.sendKeys(uFirstName+uLastName+time);
        driver.findElement(By.xpath("(//button[contains(text(),'GO')][1])[2]")).click();
        waits();
        driver.findElement(By.xpath("//td[contains(text(),'Super Admin has invited you for a Discussion')]")).click();
        refresh();
        sleep();
        driver.findElement(By.xpath("//a[contains(text(),'LINKS')]")).click();
        sleep();
        driver.findElement(By.xpath("//td[text()='"+selectedRepositoryBrowser+"']/following::a[1]")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(4000);
        WebElement first_name = driver
                .findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[1]"));
        first_name.sendKeys(uFirstName);
        driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[2]"))
                .sendKeys(uLastName+time);
        driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[3]"))
                .sendKeys("Welcome@123");
        driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[4]"))
                .sendKeys("Welcome@123");
        driver.findElement(By.xpath("//span[text()='Update']")).click();
        sleep();

    }

    @And("User click login as user in profile")
    public void userClickLoginAsUserInProfile() throws InterruptedException {
        sleep(500);
        rp.getProfile().click();
        driver.findElement(By.xpath("//span[text()='Login as user']")).click();
    }


    @And("User give permission Read and Write")
    public void userGivePermissionReadAndWrite() {
        rp.getDropDown1().click();
        WebElement wirte = driver.findElement(By.id("item-1"));
        WebElement collaborate = driver.findElement(By.id("item-2"));
        if (!wirte.isSelected()){
            wirte.click();
        }
        if (collaborate.isSelected()){
            collaborate.click();
        }

    }

    @Then("Validate user can able to do read and write operations \\(row {int} and {int}) {string}")
    public void validateUserCanAbleToDoReadAndWriteOperationsRowAnd(int row, int row1, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute = driver.findElement(By.xpath("//div[@aria-label='Example Model']")).getAttribute("aria-expanded");
        if (!attribute.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Example Model ']//preceding::span[2]")).click();
        }
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[3]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&writeAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
        if (!collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row1, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row1, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User give permission Read and Collaborate")
    public void userGivePermissionReadAndCollaborate() {
        rp.getDropDown1().click();
        WebElement wirte = driver.findElement(By.id("item-1"));
        WebElement collaborate = driver.findElement(By.id("item-2"));
        if (wirte.isSelected()){
            wirte.click();
        }
        if (!collaborate.isSelected()){
            collaborate.click();
        }
    }

    @Then("Validate user can able to do read and collaborate operations \\(row {int} and {int}) {string}")
    public void validateUserCanAbleToDoReadAndCollaborateOperationsRowAnd(int row, int row1, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute = driver.findElement(By.xpath("//div[@aria-label='Example Model']")).getAttribute("aria-expanded");
        if (!attribute.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Example Model ']//preceding::span[2]")).click();
        }
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[3]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row1, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row1, columnNo);
            System.out.println("--TestCase fail--");
        }
        if (!writeAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User give permission Read")
    public void userGivePermissionRead() {
        rp.getDropDown1().click();
        WebElement wirte = driver.findElement(By.id("item-1"));
        WebElement collaborate = driver.findElement(By.id("item-2"));
        if (wirte.isSelected()){
            wirte.click();
        }
        if (collaborate.isSelected()){
            collaborate.click();
        }
    }

    @Then("Validate user can able to do read operations \\(row {int} and {int}) {string}")
    public void validateUserCanAbleToDoReadOperationsRowAnd(int row, int row1, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute = driver.findElement(By.xpath("//div[@aria-label='Example Model']")).getAttribute("aria-expanded");
        if (!attribute.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Example Model ']//preceding::span[2]")).click();
        }
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[3]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (!writeAccess_verification&&!collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
        if (readAccess_verification) {
            XLdata.pass(path, sheet2, row1, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row1, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate user can able to uncheck the read checkbox \\(row {int}) {string}")
    public void validateUserCanAbleToUncheckTheReadCheckboxRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        rp.getDropDown1().click();
        WebElement read = driver.findElement(By.id("item-0"));
        System.out.println("Read isselected - "+read.isSelected());
        System.out.println("Read isDisabled - "+read.isEnabled());
        if (read.isSelected()&&!read.isEnabled()){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }

    }

    @Then("Validate user can able to choose customized access \\(row {int}) {string}")
    public void validateUserCanAbleToChooseCustomizedAccessRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        boolean single = driver.findElement(By.id("Single")).isSelected();
        if (single) {
            driver.findElement(By.id("Customized")).click();
        }else {
            driver.findElement(By.id("Single")).click();
            sleep();
            driver.findElement(By.id("Customized")).click();
        }
        boolean Customized = driver.findElement(By.id("Customized")).isSelected();
        if (Customized) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate customized access help icon mouseover text \\(message {string}) \\(row {int}) {string}")
    public void validateCustomizedAccessHelpIconMouseoverTextMessageRow(String content, int row, String testCase) throws InterruptedException, IOException {
        sleep();
        System.out.println(testCase);
        WebElement element = driver.findElement(By.xpath("//label[text()='Customized Access']//following::app-helpicon[1]"));
        mouseHover(element);
        String text = driver.findElement(By.xpath("//ngb-tooltip-window")).getText();
        System.out.println(text);
        if (text.contains(content)){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the user or group tap is disabled state untill user choose repository browser \\(row {int}) {string}")
    public void validateTheUserOrGroupTapIsDisabledStateUntillUserChooseRepositoryBrowserRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        String aClass = driver.findElement(By.xpath("//app-access-permissions//div[contains(@class,'table-footer')]")).getAttribute("class");
        System.out.println(aClass);
        driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]")).click();
        sleep(1000);
        String aClass1 = driver.findElement(By.xpath("//app-access-permissions//div[contains(@class,'table-footer')]")).getAttribute("class");
        System.out.println(aClass1);
        if (aClass.contains("disable")&&!aClass1.contains("disable")){
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        }else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }


    }

    @Then("Validate the read and collaborate access is selected by default in customized access permission \\(row {int}) {string}")
    public void validateTheReadAndCollaborateAccessIsSelectedByDefaultInCustomizedAccessPermissionRow(int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        List<String> access = new ArrayList<String>();
        access.add("Read"); access.add("Collaborate");
        List<String> acutalAccess = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//ng-select//span//span[text()]"));
        for (WebElement element : elements) {
            String text = element.getText();
            acutalAccess.add(text);
        }
        if (access.equals(acutalAccess)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate the apply recursively toggle button is on by default \\(row {int}) {string}")
    public void validateTheApplyRecursivelyToggleButtonIsOnByDefaultRow(int row, String testCase) throws IOException, InterruptedException {
        System.out.println(testCase);
        boolean undefined = driver.findElement(By.id("undefined")).isSelected();
        System.out.println(undefined);
        if (undefined) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate add button is shown properly \\(row {int}) {string}")
    public void validateAddButtonIsShownProperlyRow(int row, String testCase) throws InterruptedException, IOException {
        sleep(1000);
        System.out.println(testCase);
        try {
            boolean displayed = driver.findElement(By.xpath("//app-access-permissions//span[text()='Add']")).isDisplayed();
            if (displayed) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            }
        }catch (Exception e) {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User selecte the repository browser")
    public void userSelecteTheRepositoryBrowser() throws InterruptedException {
        sleep();
        WebElement e = driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]"));
        e.click();
        selectedRepositoryBrowser = e.getText();
    }

    @And("selecte the user in user and usergroup dropdown \\(user {int})")
    public void selecteTheUserInUserAndUsergroupDropdownUser(int user) throws InterruptedException {
        sleep(1000);
        rp.getDropDown1().click();
        driver.findElement(By.xpath("//span[text()='"+uFirstName+" "+uLastName+user+"']")).click();
    }

    @And("selecte the user in user and usergroup dropdown \\(user {string})")
    public void selecteTheUserInUserAndUsergroupDropdownUser(String user) throws InterruptedException {
        sleep(1000);
        try{
            driver.findElement(By.xpath("(//app-access-permissions//table)[2]//p[text()='"+user+"']//following::button[contains(@class,'danger')][1]")).click();
            System.out.println("removed super admin access");
        }catch(Exception e){
            System.out.println("removed super admin access");
        }
        rp.getDropDown1().click();
        driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='"+user+"']")).click();
    }

    @Then("Validate user is add in user or group list when click add button \\(user {int}) \\(row {int}) {string}")
    public void validateUserIsAddInUserOrGroupListWhenClickAddButtonUserRow(int user, int row, String testCase) throws IOException {
        System.out.println(testCase);
        List<String> names = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("(//app-access-permissions//table)[2]//p[1]"));
        for (WebElement element : elements) {
            String text = element.getText();
            System.out.println(text);
            names.add(text);
        }
            if (names.contains(uFirstName+" "+uLastName+user)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
            }

    }

    @And("User selecte the repository browser \\(child package {int})")
    public void userSelecteTheRepositoryBrowserChildPackage(int index) throws InterruptedException {
        sleep();
        driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]")).click();
        try{
            driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]//preceding::button[1]")).click();
            sleep();
            WebElement e = driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]//following::li["+index+"]"));
            e.click();
            selectedRepositoryBrowser = e.getText();
        }catch(Exception e){
            System.out.println("Package not choosed");
        }


    }

    @And("User remove super admin access from the customized access")
    public void userRemoveSuperAdminAccessFromTheCustomizedAccess() {
        driver.findElement(By.xpath("(//p-treenode//li//span[text()])[1]")).click();
        try{
            driver.findElement(By.xpath("(//app-access-permissions//table)[2]//p[text()='Super Admin']//following::button[contains(@class,'danger')][1]")).click();
            System.out.println("removed super admin access");
        }catch(Exception e){
            System.out.println("removed super admin access");
        }
    }


    @Then("Validate the repository browser in review shows based on access \\(row {int}) {string}")
    public void validateTheRepositoryBrowserInReviewShowsBasedOnAccessRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        WebElement browser = driver.findElement(By.xpath("//span[@class='p-treenode-label']"));
        String text = browser.getText();
        System.out.println("Repository Browser in Review  " + text);
        System.out.println("Repository Browser in access  " + selectedRepositoryBrowser);
        if (selectedRepositoryBrowser.equals(text)) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("the user shows the artifacts based on access \\(row {int}) {string}")
    public void theUserShowsTheArtifactsBasedOnAccessRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<WebElement> checklist = driver.findElements(By.xpath("//div//td//span//span//span"));
        for (int i = 0; i < checklist.size(); i++) {
            String text = checklist.get(i).getText();
            System.out.println(text);
            if (selectedRepositoryBrowser.equals(text)) {
                XLdata.pass(path, sheet2, row, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row, columnNo);
                System.out.println("--TestCase fail--");
                break;
            }
        }

    }

    @And("Login invite user")
    public void loginInviteUser() throws InterruptedException {
        sleep();
        rp.getLoginUserName().sendKeys(uFirstName+uLastName+time+"@mailinator.com");
        rp.getLoginPassword().sendKeys(password);
        rp.getSignIn().click();
        try {
            // set password
            driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
            driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
            driver.findElement(By.xpath("//button[text()='Save Password']")).click();
            driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
            sleep();
        }catch (Exception e){
            System.out.println("set password page not shown");
        }

    }

    @And("select the inviteuser in user and usergroup dropdown")
    public void selectTheInviteuserInUserAndUsergroupDropdown() {
        rp.getDropDown1().click();
        driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='"+uFirstName+" "+uLastName+time+"']")).click();
    }

    @And("User choose read write collaborate access")
    public void userChooseReadWriteCollaborateAccess() {
        rp.getDropDown2().click();
        WebElement wirte = driver.findElement(By.id("item-1"));
        WebElement collaborate = driver.findElement(By.id("item-2"));
        if (!wirte.isSelected()){
            wirte.click();
        }
        if (!collaborate.isSelected()){
            collaborate.click();
        }
    }

    @Then("Validate user can able to do all operations by customized access \\(row {int}) {string}")
    public void validateUserCanAbleToDoAllOperationsByCustomizedAccessRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[2]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&writeAccess_verification&&collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @Then("Validate invite user can able to do all operations by customized access \\(row {int}) {string}")
    public void validateInviteUserCanAbleToDoAllOperationsByCustomizedAccessRow(int row, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute = driver.findElement(By.xpath("//div[@aria-label='Example Model']")).getAttribute("aria-expanded");
        if (!attribute.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Example Model ']//preceding::span[2]")).click();
        }
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[3]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&writeAccess_verification&&collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row, columnNo);
            System.out.println("--TestCase fail--");
        }
    }

    @And("User click on {string} from header tab")
    public void userClickOnFromHeaderTab(String element) {
        driver.findElement(By.linkText(element)).click();
    }

    @Then("Validate my Diagrams shown properly \\(row {int} {int}) {string}")
    public void validateMyDiagramsShownProperlyRow(int row1, int row2, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        List<String> myDiagrams = new ArrayList<String>();
        List<WebElement> checklist = driver.findElements(By.xpath("//app-diagrams-list-item//h4"));
        for (int i = 0; i < checklist.size(); i++) {
            String text = checklist.get(i).getText();
            System.out.println(text);
            myDiagrams.add(text);
        }
            if (myDiagrams.contains("New wlemen")) {
                XLdata.pass(path, sheet2, row1, columnNo);
                System.out.println("--TestCase pass--");
            } else {
                XLdata.fail(path, sheet2, row1, columnNo);
                System.out.println("--TestCase fail--");
            }
        if (!myDiagrams.contains("Package1")) {
            XLdata.pass(path, sheet2, row2, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row2, columnNo);
            System.out.println("--TestCase fail--");
        }

    }


    @And("select repository browser package and invite user via email \\(parent package)")
    public void selectRepositoryBrowserPackageAndInviteUserViaEmailParentPackage() throws InterruptedException {
        sleep();
        mouseHover(driver.findElement(By.xpath("(//div//td//span//span//span)[1]")));
        driver.findElement(By.xpath("(//div//td//span//span//span)[1]")).click();
        selectedRepositoryBrowser = driver.findElement(By.xpath("(//div//td//span//span//span)[1]")).getText();
        driver.findElement(By.xpath("//span[text()='Share']")).click();
        LocalTime t = LocalTime.now();
        time = t.format(DateTimeFormatter.ofPattern("HHmm"));
        System.out.println(t);
        WebElement emailid = driver.findElement(By.xpath("//label[text()='Enter Email ID(s) *']/following::input[1]"));
        emailid.sendKeys(uFirstName+uLastName+time+"@mailinator.com", Keys.ENTER);
        sleep();
        driver.findElement(By.xpath("//span[text()='Invite']")).click();
    }

    @Then("Validate user can able to do read and collaborate operations \\(row {int}) {string}")
    public void validateUserCanAbleToDoReadAndCollaborateOperationsRow(int row, String arg1) {
    }

    @Then("Validate user can able to do read and collaborate operations based on customized access \\(row {int} and {int}) {string}")
    public void validateUserCanAbleToDoReadAndCollaborateOperationsBasedOnCustomizedAccessRowAnd(int row1, int row2, String testCase) throws InterruptedException, IOException {
        System.out.println(testCase);
        sleep();
        String attribute1 = driver.findElement(By.xpath("//div[@aria-label='Local test package']")).getAttribute("aria-expanded");
        if (!attribute1.contains("true")){
            driver.findElement(By.xpath("//span[text()=' Local test package ']")).click();
        }
        sleep();
        driver.findElement(By.xpath("(//span[@class='p-treenode-label'])[2]")).click();
        sleep();
        rp.getProperties().click();
        sleep();
        boolean readAccess_verification = commonClass.access_verification("Read");
        boolean writeAccess_verification = commonClass.access_verification("Write");
        boolean collaborateAccess_verification = commonClass.access_verification("Collaborate");
        System.out.println(readAccess_verification+" "+writeAccess_verification+" "+collaborateAccess_verification);
        if (readAccess_verification&&collaborateAccess_verification) {
            XLdata.pass(path, sheet2, row1, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row1, columnNo);
            System.out.println("--TestCase fail--");
        }
        if (!writeAccess_verification) {
            XLdata.pass(path, sheet2, row2, columnNo);
            System.out.println("--TestCase pass--");
        } else {
            XLdata.fail(path, sheet2, row2, columnNo);
            System.out.println("--TestCase fail--");
        }
    }
}
