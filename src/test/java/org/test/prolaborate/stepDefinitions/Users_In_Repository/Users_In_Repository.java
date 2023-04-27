package org.test.prolaborate.stepDefinitions.Users_In_Repository;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.test.prolaborate.baseclass.LoginPage;
import org.test.prolaborate.baseclass.PojoClass;
import org.test.prolaborate.baseclass.XLdata;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

public class Users_In_Repository extends LoginPage {

	public static String sheet1 = "Login_Data";
	public static String sheet2 = "Users In Repository";
	public static List<String> GroupNames = null;
	public static List<String> Dashboards = null;
	public static String userFirstName = null;
	public static String userLastName = null;
	public static String password = "Welcome@123";
	public static String userMail = null;
	public static String testCaseNo = null;
	public static String testCaseScenario = null;
	String dateTime = null;
	public static int columnNo = 2;

	@Before
	public void openBrowser() {
		launchFirefoxBrowser();
	}

	@After(order = 0)
	public void colseBrowser() {
		driver.quit();
		System.out.println("\n *Successfully Closed the Browser* \n");
	}

	@Given("User login as admin \\(reportName {string})")
	public void user_login_as_admin_reportName(String fileName) throws InterruptedException, IOException, ConfigurationException {
		login("Admin");
		cucumberReportFile(fileName);
	}

	@Given("User login as admin")
	public void user_login_as_admin() throws InterruptedException, IOException {
		sleep();
		login("Admin");

	}

	@When("User click prolaborate logo")
	public void user_click_prolaborate_logo() throws InterruptedException {
		sleep();
		rp.getProlaborateLogo().click();
	}

	@When("User credentials getting for testdata")
	public void user_credentials_getting_for_testdata(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> d = dataTable.asMaps(String.class, String.class);
		userFirstName = d.get(0).get("UserFirstName");
		userLastName = d.get(0).get("UserLastName");
	}

	// @tag1

	@Given("User open repository {string}")
	public void user_open_repository(String testCase) throws InterruptedException {
		System.out.println(testCase);
		sleep();
		driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
		sleep(2000);

	}

	@When("User open repository")
	public void user_open_repository() throws InterruptedException {
		sleep();
		try {
			driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
			System.out.println("Repository opened");
		}catch (Exception e) {
			System.out.println("Repository opened");
		}
	}

	@When("User click on burger menu")
	public void user_click_on_burger_menu() throws InterruptedException {
		sleep();
		rp.getMenuButton().click();
	}

	@And("User choose {string} usergroup")
	public void userChooseUsergroup(String group) {
		driver.findElement(
						By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='"+group+"']")).click();// user group select
		driver.findElement(
						By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
	}

	@And("User choose {string} dashboard")
	public void userChooseDashboard(String dashboard) {
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='"+dashboard+"']")).click();// default dashboard select
	}

	@When("User click save")
	public void user_click_save() {
		rp.getSave().click();
	}

	@Then("User should be added successfully {int} {string}")
	public void user_should_be_added_successfully(Integer row, String testCase)
			throws IOException, InterruptedException, AWTException {
		testCaseScenario = testCase;
		sleep();
		try {
			boolean mailid = driver
					.findElement(By.xpath("//span[text()='" + userMail + testCaseNo + "@mail.com" + "']"))
					.isDisplayed();
			System.out.println("Added user shown in repository--" + mailid);
			sleep();
			rp.getMenuButton().click();// menu button
			rp.getUsersAndLicenseMangement().click();// click User and License Management link
			sleep();
			boolean mailid1 = driver
					.findElement(By.xpath("//span[text()='" + userMail + testCaseNo + "@mail.com" + "']"))
					.isDisplayed();
			System.out.println("Added user shown in Portal--" + mailid1);
			if (mailid && mailid1) {
				System.out.println(testCaseScenario);
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("**Testcase pass**");
			} else {
				System.out.println(testCaseScenario);
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("**Testcase fail**");
			}
		} catch (Exception e) {
			System.out.println("Added user not shown");
			XLdata.fail(path, sheet2, row, 2);
		}

	}

	// @tag2

	@When("User enter the user credentials without default group {int}")
	public void user_enter_the_user_credentials_without_default_group(Integer TCno) throws IOException {
		testCaseNo = "" + TCno;
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + TCno + "@mail.com");
		rp.getAddUserFirstName().sendKeys(userFirstName);
		rp.getAddUserLastname().sendKeys(userLastName + TCno);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	// tag3

	@When("User enter the user credentials without default dashboard {int}")
	public void user_enter_the_user_credentials_without_default_dashboard(Integer TCno) throws IOException {
		testCaseNo = "" + TCno;
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + TCno + "@mail.com");
		rp.getAddUserFirstName().sendKeys(userFirstName);
		rp.getAddUserLastname().sendKeys(userLastName + TCno);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
	}

	// tag5

	@Then("User add another user with existing user mail {int}")
	public void user_add_another_user_with_existing_user_mail(Integer TCno) throws IOException, InterruptedException {
		sleep();
		testCaseNo = "" + TCno;
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + TCno + "@mail.com");
		rp.getAddUserFirstName().sendKeys(userFirstName);
		rp.getAddUserLastname().sendKeys(userLastName + TCno);
		rp.getAddUserPassword().sendKeys(password);
	}

	@Then("User should see warning message {string} {string}")
	public void user_should_see_warning_message(String validationMessage, String testCase)
			throws IOException, InterruptedException {
		testCaseScenario = testCase;
		sleep();
		try {
			WebElement error_msg = driver.findElement(By.xpath("(//app-validation)[1]"));
			rp.getSave().click();
			if (error_msg.getText().equals(validationMessage)
					&& !driver.getPageSource().contains("User Added to the Repository Successfully")) {
				System.out.println(testCaseScenario);
				XLdata.pass(path, sheet2, 6, 2);
				System.out.println("**Testcase pass**");
			} else {
				System.out.println(testCaseScenario);
				XLdata.fail(path, sheet2, 6, 2);
				System.out.println("**Testcase fail**");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 6, 2);
			System.out.println("**Testcase fail**");
		}

	}

	@Then("User should not able to save {string} {string}")
	public void user_should_not_able_to_save(String validationMessage, String testCase)
			throws InterruptedException, IOException, AWTException {
		testCaseScenario = testCase;
		try {
			sleep();
			rp.getSave().click();
			sleep(1000);
			if (!driver.getPageSource().contains("User Added to the Repository Successfully")) {
				System.out.println(testCaseScenario);
				XLdata.pass(path, sheet2, 7, 2);
				System.out.println("**Testcase pass**");
			} else {
				System.out.println(testCaseScenario);
				XLdata.fail(path, sheet2, 7, 2);
				System.out.println("**Testcase fail**");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 7, 2);
			System.out.println("**Testcase fail**");
		}
		refresh();
		sleep();

	}

	// tag7

	@When("User click users and license management under portal sttings")
	public void user_click_users_and_license_management_under_portal_sttings() throws InterruptedException {
		sleep();
		rp.getUserAndLicenseManagement().click();
	}

	@When("User enter the user credentials \\(userNo {int})")
	public void user_enter_the_user_credentials_userNo(Integer No) throws IOException, InterruptedException {
		sleep();
		testCaseNo = "" + No;
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + No + "@mail.com");
		rp.getAddUserFirstName().sendKeys(userFirstName);
		rp.getAddUserLastname().sendKeys(userLastName + No);
		rp.getAddUserPassword().sendKeys(password);
	}

	@When("User click prolaborate header")
	public void user_click_prolaborate_header() throws InterruptedException {
		sleep();
		rp.getProlaborateLogo().click();
	}

	@When("User enter the existing user mail TCno {int}")
	public void user_enter_the_existing_user_mail_TCno(Integer TCno) throws IOException, InterruptedException {
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + TCno + "@mail.com");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();// password field
		sleep();
	}

	@Then("User should see warning message and import option TCno {int}")
	public void user_should_see_warning_message_and_import_option_TCno(Integer TCno) throws IOException, InterruptedException, AWTException {
		userMail = userFirstName + userLastName;
		try {
			String warning_msg = driver.findElement(By.xpath("//h4[text()='User already exists!']")).getText();
			System.out.println(warning_msg);// warning message
			if (warning_msg.contains("User already exists!")) {
				driver.findElement(By.xpath("//span[text()='Import']")).click();// import
				sleep();
				boolean usermail = driver
						.findElement(By.xpath("//span[text()='" + userMail + TCno + "@mail.com" + "']")) != null;
				if (usermail) {
					System.out.println("user added successfully in repository");
					XLdata.pass(path, sheet2, 8, 2);
					System.out.println("--Testcase pass--");
				} else {
					System.out.println("user not added successfully in repository");
					XLdata.fail(path, sheet2, 8, 2);
					System.out.println("--Testcase fail--");
				}
			} else {
				System.out.println("Warning Message not showed");
				XLdata.fail(path, sheet2, 8, 2);
				System.out.println("--Testcase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 8, 2);
			System.out.println("--Testcase fail--");
		}


	}

	// tag8

	@When("User click repository package {string}")
	public void user_click_repository_package(String packageName) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()=' " + packageName + " ']")).click();
		sleep(3000);
	}

	@When("User add the invite user via invite link {string}")
	public void user_add_the_invite_user_via_invite_link(String packageName, io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException, AWTException {
		List<Map<String, String>> d = dataTable.asMaps(String.class, String.class);
		Robot w = new Robot();
		w.keyPress(KeyEvent.VK_CONTROL);
		w.keyPress(KeyEvent.VK_T);
		w.keyRelease(KeyEvent.VK_CONTROL);
		w.keyRelease(KeyEvent.VK_T);
		sleep();
		ArrayList<String> li = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(li.size());
		driver.switchTo().window(li.get(1));
		driver.get("https://www.mailinator.com/v4/public/inboxes.jsp");
		sleep();
		WebElement inboxfield = driver.findElement(By.id("inbox_field"));
		inboxfield.sendKeys(d.get(0).get("InviteMail"));
		driver.findElement(By.xpath("(//button[contains(text(),'GO')][1])[2]")).click();
		waits();
		driver.findElement(By.xpath("//td[contains(text(),'Super Admin has invited you for a Discussion')]")).click();
		refresh();
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'LINKS')]")).click();
		sleep();
		driver.findElement(By.xpath("//td[text()='" + packageName + "']/following::a[1]")).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(4000);
		WebElement first_name = driver
				.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[1]"));
		first_name.sendKeys(d.get(0).get("FirstName"));
		driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[2]"))
				.sendKeys(d.get(0).get("LastName"));
		driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[3]"))
				.sendKeys(d.get(0).get("Password"));
		driver.findElement(By.xpath("//h4[contains(text(),'Prolaborate Registration')]/following::input[4]"))
				.sendKeys(d.get(0).get("Password"));
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		sleep();
		driver.switchTo().window(tabs.get(0));
	}

	@Then("Invite user should be added in repository user list and portal user list {string}")
	public void invite_user_should_be_added_in_repository_user_list_and_portal_user_list(String user)
			throws InterruptedException, IOException, AWTException {
		sleep();
		try {
			rp.getMenuButton().click();
			rp.getUsers().click();// click user link
			sleep();
			boolean mailid = driver.getPageSource().contains("" + user + "@mailinator.com");// verify user is added in
			// repository
			System.out.println(mailid);
			String type = driver.findElement(By.xpath("//span[text()='" + user + "@mailinator.com']//following::td[1]"))
					.getText();
			rp.getMenuButton().click();
			rp.getUserAndLicenseManagement().click();
			sleep();
			boolean mailid1 = driver.getPageSource().contains("" + user + "@mailinator.com");// verify user is // added in
			// portal
			System.out.println(mailid1);
			if (mailid && mailid1 && type.contains("Registered User")) {
				System.out.println("invited user added in rep and portal user list");
				XLdata.pass(path, sheet2, 9, 2);
				XLdata.pass(path, sheet2, 19, 2);
			} else {
				System.out.println("invited user not added rep and portal user list");
				XLdata.fail(path, sheet2, 9, 2);
				XLdata.fail(path, sheet2, 19, 2);
			}
		}catch (Exception e){
			System.out.println(e);
		}


	}

	// tag9

	@When("User click access permissions under repository configuration")
	public void user_click_access_permissions_under_repository_configuration() throws InterruptedException {
		sleep();
		rp.getAccessPermission().click();
	}

	@Then("User should be see added user in access permissions users dropdown list {string}")
	public void user_should_be_see_added_user_in_access_permissions_users_dropdown_list(String packageName)
			throws InterruptedException, IOException, AWTException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		try {
			sleep();
			driver.findElement(By.id("Customized")).click();
			sleep();
			driver.findElement(By.xpath("//span[text()=' " + packageName + " ']")).click();
			sleep();
			rp.getDropDown1().click();// user list dropdown
			try {
				boolean username = driver.findElement(By.xpath("//span[contains(text(),'" + lastname + "')]"))
						.isDisplayed();
				if (username) {
					System.out.println("user visible in access permission menu");
					XLdata.pass(path, sheet2, 10, 2);

				} else {
					System.out.println("user not visible in access permission menu");
					XLdata.fail(path, sheet2, 10, 2);
				}
			} catch (Exception e) {
				System.out.println("user not visible in access permission menu");
				XLdata.fail(path, sheet2, 10, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 10, 2);
		}

	}

	// tag10

	@When("User click user groups under repository configuration")
	public void user_click_user_groups_under_repository_configuration() throws InterruptedException {
		sleep();
		rp.getUserGroups().click();
	}

	@When("User click create user group")
	public void user_click_create_user_group() {
		rp.getCreateUserGroup().click();
	}

	@When("User create user group")
	public void user_create_user_group() throws IOException {
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		rp.getGroupName().sendKeys(groupname);
		rp.getSave().click();
	}

	@When("Get user groups names")
	public void get_user_groups_names() {
		GroupNames = new ArrayList<String>();
		List<WebElement> row = driver
				.findElements(By.xpath("//span[@class='d-inline-block align-bottom overflow-hidden line-h-20']"));
		for (int i = 0; i < row.size(); i++) {
			GroupNames.add(row.get(i).getText());
		}
		System.out.println(GroupNames);
	}

	@Then("User should be see all user groups in dropdown")
	public void user_should_be_see_all_user_groups_in_dropdown() throws IOException, InterruptedException, AWTException {
		try {
			rp.getMenuButton().click();
			rp.getUsers().click();
			rp.getAddUser().click();
			rp.getDropDown1().click();
			sleep();
			List<WebElement> row1 = driver.findElements(By.xpath("//span[@class='select-option-label ng-star-inserted']"));
			List<String> groupnamelist = new ArrayList<String>();
			for (int i = 0; i < row1.size(); i++) {
				groupnamelist.add(row1.get(i).getText());
			}
			System.out.println(groupnamelist);
			sleep();
			if (GroupNames.containsAll(groupnamelist) && groupnamelist.containsAll(GroupNames)) {
				System.out.println("verifyed the groups are listed as in the user group list");
				XLdata.pass(path, sheet2, 11, 2);
			} else {
				System.out.println("verifyed the groups are NOT listed as in the user group list");
				XLdata.fail(path, sheet2, 11, 2);
			}
		}catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("Delete the user group")
	public void delete_the_user_group() throws InterruptedException, IOException {
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		rp.getMenuButton().click();
		rp.getUserGroups().click();
		sleep();
		driver.findElement(By.xpath("(//span[text()='" + groupname + "']/following::span[text()='More'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='" + groupname + "']/following::span[text()='Delete'])[1]"))
				.click();
		sleep();
		rp.getPopupWindowDeleteOption().click();
		sleep();
	}

	// tag11

	@When("User click dashboards under repository configuration")
	public void user_click_dashboards_under_repository_configuration() throws InterruptedException {
		sleep();
		rp.getMenuDashboard().click();
	}

	@When("User create dashboard {string}")
	public void user_create_dashboard(String dashboardName) throws IOException, InterruptedException {
		sleep();
		rp.getCreateDashboard().click();
		rp.getNewDash().click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle btn btn-theme']")).click();// add widget
		driver.findElement(By.xpath("(//span[text()='Add New'])[2]")).click();// add new
		driver.findElement(By.xpath("(//div[@class='h-100 py-2 px-3 mb-2 cursor-pointer'])[1]")).click();
		sleep();
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Give a title')]")).sendKeys("test");
		driver.findElement(By.xpath("//span[text()='Add Widget']")).click();
		WebElement input = driver.findElement(By.xpath("//ckeditor/div[2]/div[2]/div"));
		input.sendKeys("test");
		driver.findElement(By.xpath("//ngb-modal-window//span[text()='Save']")).click();
		WebElement dname = driver.findElement(By.xpath("//label[text()='Name *']/following::input[1]"));
		dname.clear();
		dname.sendKeys(dashboardName);
		rp.getSave().click();
	}

	@When("Get dashboard names list")
	public void get_dashboard_names_list() throws InterruptedException {
		sleep();
		List<WebElement> row = driver
				.findElements(By.xpath("//span[@class='d-inline-block align-bottom overflow-hidden line-h-20']"));
		Dashboards = new ArrayList<String>();
		for (int i = 0; i < row.size(); i++) {
			Dashboards.add(row.get(i).getText());
		}
		System.out.println(Dashboards);
	}

	@Then("User should be see all dashboards in dashboard list dropdown")
	public void user_should_be_see_all_dashboards_in_dashboard_list_dropdown()
			throws InterruptedException, IOException {
		sleep();
		try {
			rp.getMenuButton().click();
			rp.getUsers().click();// click user link
			sleep();
			rp.getAddUser().click();// click add user button
			driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
			// dashboard
			// dropdown
			List<WebElement> row1 = driver.findElements(By.xpath("//span[@class='select-option-label ng-star-inserted']"));
			List<String> dashboardlist = new ArrayList<String>();
			for (int i = 0; i < row1.size(); i++) {
				dashboardlist.add(row1.get(i).getText());
			}
			System.out.println(dashboardlist);

			if (Dashboards.equals(dashboardlist)) {
				System.out.println("verifyed the dashboards are listed as in the user dashboard list dropdown");
				XLdata.pass(path, sheet2, 12, 2);
			} else {
				System.out.println("verifyed the dashboards are NOT listed as in the user dashboards list dropdown");
				XLdata.fail(path, sheet2, 12, 2);
			}
		}catch (Exception e) {
			System.out.println(e);
		}

	}

	// tag12

	@When("User select user group and dashboard only")
	public void user_select_user_group_and_dashboard_only() throws InterruptedException {
		sleep();
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@Then("User should not able to save")
	public void user_should_not_able_to_save() throws InterruptedException, IOException {
		try {
			sleep();
			List<String> msg = new ArrayList<String>();
			msg.add("Email is required");
			msg.add("Password is required");
			msg.add("First name is required");
			msg.add("Last name is required");
			sleep();
			List<WebElement> row1 = driver.findElements(By.xpath("(//app-validation)"));
			List<String> msgshowed = new ArrayList<String>();
			for (int i = 0; i < row1.size(); i++) {
				msgshowed.add(row1.get(i).getText());
			}
			System.out.println(msgshowed);
			sleep();
			if (msgshowed.equals(msg)) {
				System.out.println("verifyed the user is not allowed to add without fill mandatory fields");
				XLdata.pass(path, sheet2, 13, 2);
			} else {
				System.out.println("verifyed the user is  allowed to add without fill mandatory fields");
				XLdata.fail(path, sheet2, 13, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 13, 2);
		}
	}

	// tag13

	@When("User enter the email without specifieddomain")
	public void user_enter_the_email_without_specifieddomain() throws IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 7, 1);
		String firstname = XLdata.getStringCellData(path, sheet1, 3, 4);
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		String password = XLdata.getStringCellData(path, sheet1, 3, 2);
		rp.getAddUserEmail().sendKeys(mail);
		rp.getAddUserFirstName().sendKeys(firstname);
		rp.getAddUserLastname().sendKeys(lastname);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@Then("User should not able to save user")
	public void user_should_not_able_to_save_user() throws IOException {
		try {
			String er = driver.findElement(By.xpath("(//app-validation)[1]")).getText();
			if (er.contains("Enter a valid Email ID. Include @ and . in the Email")) {
				System.out.println("verifyed proper email field validation message is showed");
				XLdata.pass(path, sheet2, 14, 2);
			} else {
				System.out.println(" proper email field validation message is NOT showed");
				XLdata.fail(path, sheet2, 14, 2);
			}
		} catch (Exception e) {
			System.out.println("the error message is not message not acquired");
			XLdata.fail(path, sheet2, 14, 2);
		}
	}

	// tag14

	@When("User create inactive dashboard")
	public void user_create_inactive_dashboard() throws IOException, InterruptedException {
		String dashboard = XLdata.getStringCellData(xlfile, sheet1, 8, 1);
		sleep();
		rp.getCreateDashboard().click();
		rp.getNewDash().click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle btn btn-theme']")).click();// add widget
		driver.findElement(By.xpath("(//span[text()='Add New'])[2]")).click();// add new
		driver.findElement(By.xpath("(//div[@class='h-100 py-2 px-3 mb-2 cursor-pointer'])[1]")).click();
		sleep();
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Give a title')]")).sendKeys("test");
		driver.findElement(By.xpath("//span[text()='Add Widget']")).click();
		WebElement input = driver.findElement(By.xpath("//ckeditor/div[2]/div[2]/div"));
		input.sendKeys("test");
		driver.findElement(By.xpath("//ngb-modal-window//span[text()='Save']")).click();
		WebElement dname = driver.findElement(By.xpath("//label[text()='Name *']/following::input[1]"));
		dname.clear();
		dname.sendKeys(dashboard);
		driver.findElement(By.id("dashStatus")).click();// change to inactive
		rp.getSave().click();
	}

	@Then("User should not see inactive dashboard in dropdown")
	public void user_should_not_see_inactive_dashboard_in_dropdown() throws IOException {
		String dashboard = XLdata.getStringCellData(xlfile, sheet1, 8, 1);
		try {
			sleep();
			driver.findElement(By.xpath("//label[text()='Default Dashboard']/following::div[1]")).click();
			sleep();
			if (driver.getPageSource().contains(dashboard)) {
				System.out.println("verifed the inactive dash board is  visible in dashboard dropdown");
				XLdata.fail(path, sheet2, 15, 2);
			} else {
				System.out.println("verifed the inactive dash board is not visible in dashboard dropdown");
				XLdata.pass(path, sheet2, 15, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 15, 2);
		}
	}

	// tag15

	@When("User create inactive user group")
	public void user_create_inactive_user_group() throws IOException, InterruptedException {
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		rp.getGroupName().sendKeys(groupname);
		driver.findElement(By.id("requireStatus")).click();// change status to inactive
		sleep();
		rp.getSave().click();
	}

	@Then("User should not see inactive user group")
	public void user_should_not_see_inactive_user_group() throws IOException, InterruptedException {
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		driver.findElement(By.xpath("//label[text()='User Group Membership']/following::div[1]")).click();
		sleep();
		if (driver.getPageSource().contains(groupname)) {
			System.out.println("verifed the inactive user is visible in usergroup dropdown");
			XLdata.pass(path, sheet2, 16, 2);
		} else {
			System.out.println("verifed the inactive user is not visible in usergroup dropdown");
			XLdata.fail(path, sheet2, 16, 2);
		}
	}

	// tag16

	@When("User navigate to create Review -Add Contributors tab")
	public void user_navigate_to_create_Review_Add_Contributors_tab() throws InterruptedException {
		sleep();
		rp.getMenuButton().click();
		driver.findElement(By.xpath("//div[text()=' Reviews ']")).click();// review link
		sleep();
		driver.findElement(By.xpath("//span[text()='Create Review']")).click();// create review
		driver.findElement(By.xpath("//label[text()='Review Name *']/following::input[1]")).sendKeys("asdf");// review
		// name
		driver.findElement(By.xpath("//label[text()='Review Dates *']/following::button[2]")).click();// end date
		sleep();
		driver.findElement(By.xpath("//div[contains(@class,'today')]//following::div[2]")).click();// date
		driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
		sleep();
		driver.findElement(By.xpath("//div[@class='p-checkbox-box']")).click();
		sleep();
		driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
	}

	@Then("User should be see added user in Add Contributors tab")
	public void user_should_be_see_added_user_in_Add_Contributors_tab() throws IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		try {
			boolean user = driver.findElement(By.xpath("//div[contains(text(),'" + lastname + "')]")).isDisplayed();
			if (user) {
				System.out.println("user is visible in review add contributors tab");
				XLdata.pass(path, sheet2, 17, 2);
			} else {
				System.out.println("user is NOT visible in review add contributors tab");
				XLdata.fail(path, sheet2, 17, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 17, 2);
		}
	}

	// tag17

	@When("User invite user via email {string}")
	public void user_invite_user_via_email(String email) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Share']")).click();
		WebElement emailid = driver.findElement(By.xpath("//label[text()='Enter Email ID(s) *']/following::input[1]"));
		emailid.sendKeys(email, Keys.ENTER);
		sleep();
		driver.findElement(By.xpath("//span[text()='Invite']")).click();
	}

	@Then("Invite user should be added in repository user invited collaborators list {string}")
	public void invite_user_should_be_added_in_repository_user_invited_collaborators_list(String email)
			throws IOException, InterruptedException {
		try {
			sleep();
			rp.getMenuButton().click();
			rp.getUsers().click();// click user link
			sleep();
			driver.findElement(By.xpath("//span[text()='Invited Collaborators']")).click();// invited collaborators list
			sleep();
			if (driver.getPageSource().contains(email)) {
				System.out.println("invited user added in invitedcollaborator_list list");
				XLdata.pass(path, sheet2, 18, 2);
			} else {
				System.out.println("invited user not added in invitedcollaborator_list list");
				XLdata.fail(path, sheet2, 18, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 18, 2);
		}
	}

	@Then("Delete the invite user from invites collaborators list {string}")
	public void delete_the_invite_user_from_invites_collaborators_list(String email) throws InterruptedException {
		sleep();
		rp.getMenuButton().click();
		rp.getUsersAndLicenseMangement().click();
		driver.findElement(By.xpath("//span[text()='Invited Collaborators']")).click();// invited collaborators list
		driver.findElement(By.xpath("(//span[text()='" + email + "']//following::span[text()='Delete'])[1]")).click();
		driver.findElement(By.xpath("//h4[text()='Delete User']//following::span[text()='Delete']")).click();
	}

	// @Delete_Repository_User//@tag1

	@When("User delete the added user from repository")
	public void user_delete_the_added_user_from_repository() throws InterruptedException, IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[4]"));
		checkbox.click();// click user check box
		rp.getRemove().click();// click delete button

	}

	@Then("User should see confirmation popup")
	public void user_should_see_confirmation_popup() throws IOException {
		boolean msg = driver.findElement(By.xpath("//p[contains(text(),'Are you sure')]")) != null;
		if (msg) {
			String popup = driver.findElement(By.xpath("//p[contains(text(),'Are you sure')]")).getText();
			if (popup.equals("Are you sure you want to remove this user?")) {
				System.out.println("conformation window showed");
				XLdata.pass(path, sheet2, 25, 2);
				rp.getPopupWindowDeleteOption().click();

			} else {
				System.out.println("conformation window NOT showed");
				XLdata.fail(path, sheet2, 25, 2);
			}
		}
	}

	// @Delete_Repository_User//@tag2

	@When("User delete the added user from repository user list")
	public void user_delete_the_added_user_from_repository_user_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[4]"));
		checkbox.click();// click user check box
		rp.getRemove().click();// click delete button
		rp.getPopupWindowDeleteOption().click();
	}

	@Then("Deleted user should be removed from list")
	public void deleted_user_should_be_removed_from_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		try {
			sleep();
			if (driver.getPageSource().contains(mail)) {
				System.out.println("verifyed user NOT removed from repository user list");
				XLdata.fail(path, sheet2, 26, 2);

			} else {
				System.out.println("verifyed user removed from repository user list");
				XLdata.pass(path, sheet2, 26, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 26, 2);
		}
	}

	// @Delete_Repository_User @tag3

	@Then("User should not see added user in access permissions users dropdown list {string}")
	public void user_should_not_see_added_user_in_access_permissions_users_dropdown_list(String packageName)
			throws IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		try {
			sleep();
			driver.findElement(By.id("Customized")).click();
			sleep();
			driver.findElement(By.xpath("//span[text()=' " + packageName + " ']")).click();
			sleep();
			rp.getDropDown1().click();// user list dropdown
			try {
				boolean username = driver.findElement(By.xpath("//span[contains(text(),'" + lastname + "')]"))
						.isDisplayed();
				if (username) {
					System.out.println("user visible in access permission menu");
					XLdata.fail(path, sheet2, 27, 2);

				} else {
					System.out.println("user not visible in access permission menu");
					XLdata.pass(path, sheet2, 27, 2);
				}
			} catch (Exception e) {
				System.out.println("user not visible in access permission menu");
				XLdata.pass(path, sheet2, 27, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 27, 2);
		}
	}

	// @Delete_Repository_User @tag4

	@When("User set access permission for added user {string}")
	public void user_set_access_permission_for_added_user(String packageName) throws InterruptedException, IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		sleep();
		driver.findElement(By.id("Customized")).click();
		sleep();
		driver.findElement(By.xpath("//span[text()=' " + packageName + " ']")).click();
		sleep();
		rp.getDropDown1().click();// user list dropdown
		driver.findElement(By.xpath("//span[contains(text(),'" + lastname + "')]")).click();
		rp.getAdd().click();
		try {
			boolean displayed = driver.findElement(By.xpath("//p[contains(text(),'" + lastname + "')]")).isDisplayed();
			System.out.println("user added in access permission user list--" + displayed);
		} catch (Exception e) {
			System.out.println("user not added in access permission user list");
		}
	}

	@Then("Access permission is removed for deleted user {string}")
	public void access_permission_is_removed_for_deleted_user(String packageName)
			throws InterruptedException, IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		sleep();
		rp.getMenuButton().click();
		rp.getAccessPermission().click();
		sleep();
		driver.findElement(By.xpath("//span[text()=' " + packageName + " ']")).click();
		sleep();
		try {
			boolean displayed = driver.findElement(By.xpath("//p[contains(text(),'" + lastname + "')]")).isDisplayed();
			if (displayed) {
				System.out.println("user is not removed in access permission user list");
				XLdata.fail(path, sheet2, 28, 2);
			} else {
				System.out.println("user is removed from access permission user list");
				XLdata.pass(path, sheet2, 28, 2);
			}
		} catch (Exception e) {
			System.out.println("user is removed from access permission user list");
			XLdata.pass(path, sheet2, 28, 2);
		}

	}

	// @Delete_Repository_User @tag5

	@When("Add the added user in group")
	public void add_the_added_user_in_group() throws IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		rp.getGroupName().sendKeys(groupname);
		driver.findElement(By.xpath("//span[contains(text(),'" + lastname + "')]/following::button[1]")).click();
		rp.getSave().click();
	}

	@Then("Added user should be removed from group")
	public void added_user_should_be_removed_from_group() throws IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		String groupname = XLdata.getStringCellData(path, sheet1, 4, 1);
		try {
			rp.getMenuButton().click();// menu button
			rp.getUserGroups().click();// user groups link
			sleep();
			driver.findElement(By.xpath("//span[text()='" + groupname + "']")).click();// group link
			sleep();
			if (!driver.getPageSource().contains(lastname)) {
				System.out.println("user removed from user group list");
				XLdata.pass(path, sheet2, 29, 2);
			} else {
				System.out.println("user NOT removed from user group list");
				XLdata.fail(path, sheet2, 29, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 29, 2);
		}
	}

	// @Delete_Repository_User @tag6

	@When("User create one review with added user")
	public void user_create_one_review_with_added_user() throws InterruptedException, IOException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		sleep();
		rp.getMenuButton().click();
		sleep();
		rp.getReviews().click();
		sleep();
		driver.findElement(By.xpath("//span[text()='Create Review']")).click();// create review
		sleep();
		driver.findElement(By.xpath("//label[text()='Review Name *']/following::input[1]")).sendKeys("demoreview");
		driver.findElement(By.xpath("//label[text()='Review Dates *']/following::button[2]")).click();// end date
		sleep();
		driver.findElement(By.xpath("//div[contains(@class,'today')]//following::div[2]")).click();// date
		driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
		sleep();
		driver.findElement(By.xpath("//div[@class='p-checkbox-box']")).click();
		sleep();
		driver.findElement(By.xpath("//span[text()='Next']")).click(); // next button
		sleep();
		WebElement user = driver.findElement(By.xpath("//div[contains(text(),'" + lastname + "')]"));
		Actions act = new Actions(driver);
		act.moveToElement(user).build().perform();
		sleep();
		driver.findElement(By.xpath("//div[contains(text(),'" + lastname + "')]/following::span[1]")).click();// add
		// userin
		// review
		driver.findElement(By.xpath("(//span[text()='Create Review'])[2]")).click();// create review
		sleep();
		driver.findElement(By.xpath("//span[text()='Open Reviews List']")).click();// open review list
		sleep();
		driver.findElement(By.xpath("//span[text()='demoreview']")).click();// open review
		sleep();
	}

	@Then("Added user should be removed from the existing Review")
	public void added_user_should_be_removed_from_the_existing_Review() throws IOException, InterruptedException {
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		sleep();
		rp.getMenuButton().click();
		rp.getReviews().click();
		sleep();
		driver.findElement(By.xpath("//span[text()='demoreview']")).click();
		sleep();
		if (!driver.getPageSource().contains(lastname)) {
			System.out.println("user is removed from review user list");
			XLdata.pass(path, sheet2, 30, 2);
		} else {
			System.out.println("user is not removed from review user list");
			XLdata.fail(path, sheet2, 30, 2);

		}
	}

	@Then("Delete the review")
	public void delete_the_review() {
		rp.getMenuButton().click();
		rp.getReviews().click();
		driver.findElement(By.xpath("//span[text()='demoreview']/following::span[1]")).click();
		rp.getDeleteButton().click();
		rp.getPopupWindowDeleteOption().click();
	}

	// @Delete_Repository_User @tag7

	@When("Login the added user \\(registeredUser {int})")
	public void loginTheAddedUserRegisteredUser(int userNo) throws IOException, InterruptedException {
		sleep();
		rp.getLoginUserName().sendKeys(userFirstName+userLastName+userNo+"@mail.com");
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

	@Then("Repository should be shown")
	public void repository_should_be_shown() throws IOException, InterruptedException {
		sleep();
		if (driver.getPageSource().contains("Test Repository")) {
			System.out.println("User have access to that repository");
		} else {
			System.out.println("User not have access to that repository");
		}
	}

	@Then("Logout the user")
	public void logout_the_user() throws InterruptedException {
		sleep();
		logOut();
	}

	@Then("Login the added user after removed from repository")
	public void login_the_added_user_after_removed_from_repository() throws IOException, InterruptedException {
		sleep();
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String password = XLdata.getStringCellData(path, sheet1, 3, 2);
		rp.getLoginUserName().sendKeys(mail);
		rp.getLoginPassword().sendKeys(password);
		rp.getSignIn().click();
	}

	@Then("Repository should not shown for removed user")
	public void repository_should_not_shown_for_removed_user() throws InterruptedException, IOException {
		sleep();
		if (!driver.getPageSource().contains("Test Repository")) {
			System.out.println("User not have access to that repository");
			XLdata.pass(path, sheet2, 31, 2);
		} else {
			System.out.println("User have access to that repository");
			XLdata.fail(path, sheet2, 31, 2);
		}
	}

	// @Delete_Repository_User @tag8

	@When("User navigate to protal user list")
	public void user_navigate_to_protal_user_list() throws InterruptedException {
		sleep();
		rp.getMenuButton().click();// menu button
		rp.getUsersAndLicenseMangement().click();// click User and License Management link
	}

	@Then("User should be available in list")
	public void user_should_be_available_in_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		try {
			boolean display = driver.findElement(By.xpath("//span[text()='" + mail + "']")).isDisplayed();
			if (display) {
				System.out.println("verifyed user available in  portal user list");
				XLdata.pass(path, sheet2, 32, 2);

			} else {
				System.out.println("verifyed user removed from portal user list");
				XLdata.fail(path, sheet2, 32, 2);
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 32, 2);
		}
	}

	// @Delete_Repository_User @tag9

	@When("User delete the added user from repository user list by check box")
	public void user_delete_the_added_user_from_repository_user_list_by_check_box()
			throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[4]"));
		checkbox.click();// click user check box
		rp.getRemove().click();// click delete button
		rp.getPopupWindowDeleteOption().click();
	}

	@Then("User should not available in repository user list")
	public void user_should_not_available_in_repository_user_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		if (!driver.getPageSource().contains(mail)) {
			System.out.println("verifyed user removed from repository user list");
			XLdata.pass(path, sheet2, 33, 2);

		} else {
			System.out.println("verifyed user NOT removed from repository user list");
			XLdata.fail(path, sheet2, 33, 2);

		}
	}

	// @Delete_Repository_User @tag10

	@When("User enter the valid user2 credentials")
	public void user_enter_the_valid_user2_credentials() throws IOException, InterruptedException {
		sleep();
		String mail1 = XLdata.getStringCellData(path, sheet1, 6, 1);
		String firstname1 = XLdata.getStringCellData(path, sheet1, 6, 4);
		String lastname1 = XLdata.getStringCellData(path, sheet1, 6, 5);
		String password1 = XLdata.getStringCellData(path, sheet1, 6, 2);
		rp.getAddUserEmail().sendKeys(mail1);
		rp.getAddUserFirstName().sendKeys(firstname1);
		rp.getAddUserLastname().sendKeys(lastname1);
		rp.getAddUserPassword().sendKeys(password1);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@When("User delete the multiple user from repository user list by check box")
	public void user_delete_the_multiple_user_from_repository_user_list_by_check_box()
			throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String mail1 = XLdata.getStringCellData(path, sheet1, 6, 1);
		sleep();
		WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[4]"));
		checkbox.click();// click user check box
		WebElement checkbox2 = driver.findElement(By.xpath("//span[text()='" + mail1 + "']/preceding::div[4]"));
		checkbox2.click();// click user check box
		rp.getRemove().click();// click delete button
		rp.getPopupWindowDeleteOption().click();
	}

	@Then("Users should not available in repository user list")
	public void users_should_not_available_in_repository_user_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String mail1 = XLdata.getStringCellData(path, sheet1, 6, 1);
		sleep();
		if (!driver.getPageSource().contains(mail) && !driver.getPageSource().contains(mail1)) {
			System.out.println("verifyed user removed from repository user list");
			XLdata.pass(path, sheet2, 34, 2);

		} else {
			System.out.println("verifyed user NOT removed from repository user list");
			XLdata.fail(path, sheet2, 34, 2);

		}
	}

	@Then("Delete the user2")
	public void delete_the_user2() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 6, 1);
		refresh();
		sleep();
		try {
			rp.getProlaborateLogo().click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
		try {
			rp.getProlaborateLogo().click();
			driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsers().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
	}

	// @Delete_Repository_User @tag11

	@When("User enter the valid admin user credentials")
	public void user_enter_the_valid_admin_user_credentials() throws IOException, InterruptedException {
		sleep();
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		String firstname = XLdata.getStringCellData(path, sheet1, 2, 4);
		String lastname = XLdata.getStringCellData(path, sheet1, 2, 5);
		String password = XLdata.getStringCellData(path, sheet1, 2, 2);
		rp.getAddUserEmail().sendKeys(mail);
		rp.getAddUserFirstName().sendKeys(firstname);
		rp.getAddUserLastname().sendKeys(lastname);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@When("User enter the valid admin user2 credentials")
	public void user_enter_the_valid_admin_user2_credentials() throws IOException, InterruptedException {
		sleep();
		String mail1 = XLdata.getStringCellData(path, sheet1, 5, 1);
		String firstname1 = XLdata.getStringCellData(path, sheet1, 5, 4);
		String lastname1 = XLdata.getStringCellData(path, sheet1, 5, 5);
		String password1 = XLdata.getStringCellData(path, sheet1, 5, 2);
		rp.getAddUserEmail().sendKeys(mail1);
		rp.getAddUserFirstName().sendKeys(firstname1);
		rp.getAddUserLastname().sendKeys(lastname1);
		rp.getAddUserPassword().sendKeys(password1);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@When("Make users as admin")
	public void make_users_as_admin() throws InterruptedException, IOException {
		sleep();
		String mail1 = XLdata.getStringCellData(path, sheet1, 5, 1);
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		rp.getMenuButton().click();
		rp.getUsersAndLicenseMangement().click();// click user& license manage link
		driver.findElement(By.xpath("//span[text()='" + mail + "']/following::span[text()='Edit'][1]")).click();
		rp.getMakeSuperAdmin().click();
		rp.getSave().click();
		sleep();
		driver.findElement(By.xpath("//span[text()='" + mail1 + "']/following::span[text()='Edit'][1]")).click();
		rp.getMakeSuperAdmin().click();
		rp.getSave().click();
	}

	@Then("Admin user should able to delete admin user from repository")
	public void admin_user_should_able_to_delete_admin_user_from_repository() throws IOException, InterruptedException {
		String mail1 = XLdata.getStringCellData(path, sheet1, 5, 1);
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		String password = XLdata.getStringCellData(path, sheet1, 2, 2);
		sleep();
		logOut();
		sleep();
		rp.getLoginUserName().sendKeys(mail);
		rp.getLoginPassword().sendKeys(password);
		rp.getSignIn().click();
		// set password
		driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
		driver.findElement(By.xpath("//button[text()='Save Password']")).click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
		// driver.findElement(By.xpath("//div[@class='header-left
		// pt-2']")).click();//way to repositories list
		sleep();
		driver.findElement(By.xpath("//span[text()='Test Repository']")).click();// click Repository name
		sleep();
		rp.getMenuButton().click();
		rp.getUserAndLicenseManagement().click();// click User and License Management link
		sleep();
		WebElement checkbox2 = driver.findElement(By.xpath("//span[text()='" + mail1 + "']/preceding::div[4]"));
		checkbox2.click();// click user check box
		if (driver.getPageSource().contains("Delete")) {
			System.out.println("admin user can delete another admin user");
			XLdata.pass(path, sheet2, 35, 2);
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
		} else {
			System.out.println("admin user can't delete another admin user");
			XLdata.fail(path, sheet2, 35, 2);
		}
		sleep();
		logOut();
		sleep();
		login("Admin");
		sleep();
	}

	@Then("Delete the admin user")
	public void delete_the_admin_user() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		refresh();
		sleep();
		try {
			rp.getProlaborateLogo().click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
		try {
			rp.getProlaborateLogo().click();
			driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsers().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
	}

	@Then("Delete the admin user2")
	public void delete_the_admin_user2() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 5, 1);
		refresh();
		sleep();
		try {
			rp.getProlaborateLogo().click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
		try {
			rp.getProlaborateLogo().click();
			driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsers().click();
			driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
	}

	// @Get_Repository_User_Details @tag1

	@When("User enter the valid user credentials with demodashboard")
	public void user_enter_the_valid_user_credentials_with_demodashboard() throws IOException {
		String dashboard = XLdata.getStringCellData(xlfile, sheet1, 8, 1);
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String firstname = XLdata.getStringCellData(path, sheet1, 3, 4);
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		String password = XLdata.getStringCellData(path, sheet1, 3, 2);
		rp.getAddUserEmail().sendKeys(mail);
		rp.getAddUserFirstName().sendKeys(firstname);
		rp.getAddUserLastname().sendKeys(lastname);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='" + dashboard + "']")).click();// default dashboard select
	}

	@When("User open edit user page")
	public void user_open_edit_user_page() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		WebElement edit = driver
				.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]"));
		edit.click();// way to edit option
	}

	@Then("Choosed dashboard should be show under default dashboard")
	public void choosed_dashboard_should_be_show_under_default_dashboard() throws IOException, InterruptedException {
		sleep();
		String dashboard = XLdata.getStringCellData(xlfile, sheet1, 8, 1);
		String dashboardname = driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]"))
				.getText();
		System.out.println(dashboardname);
		if (dashboardname.contains(dashboard)) {
			System.out.println("choosed dashboard is visible in under dashboard");
			XLdata.pass(path, sheet2, 42, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println(" choosed dashboard is NOT visible in under dashboard");
			XLdata.fail(path, sheet2, 42, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Get_Repository_User_Details @tag2

	@Then("Default dashboard should be show under default dashboard")
	public void default_dashboard_should_be_show_under_default_dashboard() throws IOException, InterruptedException {
		sleep();
		String dashboardname = driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]"))
				.getText();
		System.out.println(dashboardname);
		if (dashboardname.contains("Prolaborate - Start Here")) {
			System.out.println("default dashboard is visible in uder dashboard");
			XLdata.pass(path, sheet2, 43, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println("default dashboard is NOT visible in uder dashboard");
			XLdata.fail(path, sheet2, 43, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Get_Repository_User_Details @tag5

	@Then("Default time zone should be shown under the time zone")
	public void default_time_zone_should_be_shown_under_the_time_zone() throws IOException {
		String timezone = driver
				.findElement(By.xpath("//*[@id=\"addNewUserForm\"]/div/div[1]/div[3]/div/div/app-input/input"))
				.getAttribute("value");// time zone field
		System.out.println(timezone);
		if (timezone.contains("India Standard Time")) {
			System.out.println("timezone is showing  default ");
			XLdata.pass(path, sheet2, 46, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("timezone is not showing  default ");
			XLdata.fail(path, sheet2, 46, 2);
			System.out.println("--TestCase fail--");

		}
	}

	// @Get_Repository_User_Details @tag6

	@Then("Email ID , First Name and Last Name of the user should be visible")
	public void email_ID_First_Name_and_Last_Name_of_the_user_should_be_visible() throws IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String firstname = XLdata.getStringCellData(path, sheet1, 3, 4);
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		String f = driver.findElement(By.xpath("//label[text()='First Name']/following::input[1]"))
				.getAttribute("value");
		String l = driver.findElement(By.xpath("//label[text()='Last Name']/following::input[1]"))
				.getAttribute("value");
		String e = driver.findElement(By.xpath("//label[text()='Email']/following::input[1]")).getAttribute("value");
		if (e.equals(mail)) {
			System.out.println("Verifed the user emailid properly visible");
			XLdata.pass(path, sheet2, 47, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("the user emailid NOT properly visible");
			XLdata.fail(path, sheet2, 47, 2);
			System.out.println("--TestCase fail--");
		}
		if (f.equals(firstname)) {
			System.out.println("Verifed the user First Name properly visible");
			XLdata.pass(path, sheet2, 48, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("the user First Name NOT properly visible");
			XLdata.fail(path, sheet2, 48, 2);
			System.out.println("--TestCase fail--");
		}
		if (l.equals(lastname)) {
			System.out.println("Verifed the user Last Name properly visible");
			XLdata.pass(path, sheet2, 49, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("the user Last Name NOT properly visible");
			XLdata.fail(path, sheet2, 49, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @List_Repository_Users @tag1

	@Then("User name and email should be shown in list")
	public void user_name_and_email_should_be_shown_in_list() throws IOException, InterruptedException {
		sleep();
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String lastname = XLdata.getStringCellData(path, sheet1, 3, 5);
		List<WebElement> row1 = driver
				.findElements(By.xpath("//span[@class='d-inline-block align-bottom overflow-hidden line-h-20']"));
		for (int i = 0; i < row1.size(); i++) {
			if (row1.get(i).getText().contains(lastname)) {
				System.out.println("Added username is showed in list");
				XLdata.pass(path, sheet2, 60, 2);
				String m = driver
						.findElement(By.xpath("(//span[contains(text(),'" + lastname + "')]/following::td)[1]"))
						.getText();
				if (m.equalsIgnoreCase(mail)) {
					System.out.println("Added user mailid visible in email column");
					XLdata.pass(path, sheet2, 61, 2);

				} else {
					System.out.println("Added user mailid NOT visible in email column");
					XLdata.fail(path, sheet2, 61, 2);
					break;
				}
				break;
			}
			XLdata.fail(path, sheet2, 60, 2);
			XLdata.fail(path, sheet2, 61, 2);
		}
	}

	// @List_Repository_Users @tag3

	@Then("User type should be shown registered user")
	public void user_type_should_be_shown_registered_user() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		sleep();
		String usertype = driver.findElement(By.xpath("//span[text()='" + mail + "']/following::span[3]")).getText();
		if (usertype.contains("Registered User")) {
			System.out.println("user type of non admin user shows Registered User");
			XLdata.pass(path, sheet2, 62, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println(" user type of non admin user NOT shows Registered User");
			XLdata.fail(path, sheet2, 62, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @List_Repository_Users @tag4

	@When("Make user as admin")
	public void make_user_as_admin() throws IOException, InterruptedException {
		sleep();
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		rp.getMenuButton().click();
		rp.getUsersAndLicenseMangement().click();// click user& license manage link
		driver.findElement(By.xpath("//span[text()='" + mail + "']/following::span[text()='Edit'][1]")).click();
		rp.getMakeSuperAdmin().click();
		rp.getSave().click();
	}

	@Then("User type should be shown prolaborate admin")
	public void user_type_should_be_shown_prolaborate_admin() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		sleep();
		String usertype = driver.findElement(By.xpath("//span[text()='" + mail + "']/following::span[3]")).getText();
		if (usertype.contains("Prolaborate Admin")) {
			System.out.println("user type of admin user shows Prolaborate Admin");
			XLdata.pass(path, sheet2, 63, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println(" user type of admin user NOT shows Prolaborate Admin");
			XLdata.fail(path, sheet2, 63, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @List_Repository_Users @tag5
	@And("Add the AD user \\(user {string})")
	public void addTheADUserUser(String user) throws InterruptedException {
		sleep();
		rp.getAddADuser().click();
		sleep();
		rp.getDropDown1().click();
		sleep();
		driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='AD test']")).click();
		sleep(6000);
		driver.findElement(By.xpath("//span[text()='Users']")).click();// choose by user
		sleep(3000);
		driver.findElement(By.xpath("//span[text()='Advanced Search']")).click();
		sleep(3000);
		driver.findElement(By.xpath("//h4[text()='Advanced Search']//following::input[5]")).sendKeys(user);
		sleep(3000);
		driver.findElement(By.id("FormSubmitAdFilter")).click();
		sleep();
		driver.findElement(By.xpath("//span[text()='"+user+"']/preceding::div[1]")).click();// selecting user
		driver.findElement(By.xpath("//span[text()='Add Users']")).click();
		refresh();
		sleep();
	}

	@Then("ADuser type should be shown active directory user")
	public void aduser_type_should_be_shown_active_directory_user() throws IOException, InterruptedException {
		sleep();
		String usertype = driver.findElement(By.xpath("//span[contains(text(),'AD1002')]/following::td[2]")).getText();
		if (usertype.contains("Active Directory User")) {
			System.out.println("user type of ADuser shows Active Directory User");
			XLdata.pass(path, sheet2, 64, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println(" user type of ADuser NOT shows Active Directory User");
			XLdata.fail(path, sheet2, 64, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Delete the ADuser")
	public void delete_the_ADuser() throws IOException, InterruptedException {

		refresh();
		sleep();
		try {
			rp.getProlaborateLogo().click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[contains(text(),'AD1002')]/preceding::div[1]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
		try {
			rp.getProlaborateLogo().click();
			driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsers().click();
			driver.findElement(By.xpath("//span[contains(text(),'AD1002')]/preceding::div[1]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}

	}

	// @List_Repository_Users @tag6

	@When("Add the AD group \\(group {string})")
	public void addTheADGroupGroup(String group) throws InterruptedException {
		sleep();
		rp.getAddADuser().click();
		sleep(4000);
//		rp.getDropDown1().click();
//		sleep();
//		driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='AD test']")).click();
//		sleep(3000);
		driver.findElement(By.id("ad-user-group")).click();
		sleep(6000);
//		driver.findElement(By.xpath("//span[text()='Users']")).click();// choose by user
//		sleep(2000);
//		driver.findElement(By.xpath("//span[text()='Advanced Search']")).click();
//		sleep();
//		driver.findElement(By.xpath("//h4[text()='Advanced Search']//following::input[5]")).sendKeys(group);
//		sleep();
//		driver.findElement(By.id("FormSubmitAdFilter")).click();
		sleep(2000);
		String aClass = driver.findElement(By.xpath("//span[text()='"+group+"']/preceding::div[1]")).getAttribute("class");
		System.out.println(aClass);
		if (!aClass.contains("disabled")){
			driver.findElement(By.xpath("//span[text()='"+group+"']/preceding::div[1]")).click();// selecting user
			driver.findElement(By.xpath("//span[text()='Add Groups']")).click();
			refresh();
			sleep();
		} else {
			refresh();
			sleep();
		}


	}

	@Then("ADgroupuser type should be shown active directory group user")
	public void adgroupuser_type_should_be_shown_active_directory_group_user()
			throws InterruptedException, IOException {
		sleep();
		String usertype = driver.findElement(By.xpath("//span[contains(text(),'NI2')]/following::td[2]")).getText();
		if (usertype.contains("Active Directory Group User")) {
			System.out.println("user type of ADGroupuser shows Active Directory Group User");
			XLdata.pass(path, sheet2, 65, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println(" user type of ADGroupuser NOT shows Active Directory Group User");
			XLdata.fail(path, sheet2, 65, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Delete the ADgroupuser")
	public void delete_the_ADgroupuser() throws InterruptedException {
		refresh();
		sleep();
		try {
			rp.getProlaborateLogo().click();
			sleep();
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[contains(text(),'NI2')]/preceding::div[1]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
		try {
			sleep();
			driver.findElement(By.xpath("//span[text()='Active Directory Groups']")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'shgroup')]/following::span[text()='Delete']")).click();// delete
			// option
			driver.findElement(By.xpath("//span[contains(text(),'Remove Anyway')]")).click();// delete button
		} catch (Exception e) {
			System.out.println("ADGroup not available");
		}
	}

	// @List_Repository_Users @tag7

	@When("User login with sso")
	public void user_login_with_sso() throws InterruptedException {
		sleep();
		rp = new PojoClass();
		rp.getSso().click();
		sleep();
		WebElement element = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		element.clear();
		element.sendKeys("kiran@mailinator.com");
		driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("Sso type should be shown Identity Provider User")
	public void sso_type_should_be_shown_Identity_Provider_User() throws InterruptedException, IOException {
		sleep();
		try {
			String usertype = driver.findElement(By.xpath("//span[contains(text(),'kiran')]/following::td[2]"))
					.getText();
			if (usertype.contains("Identity Provider User")) {
				System.out.println("user type of sso user shows Identity Provider User");
				XLdata.pass(path, sheet2, 66, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println(" user type of sso user NOT shows Identity Provider User");
				XLdata.fail(path, sheet2, 66, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 66, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Delete the sso user")
	public void delete_the_sso_user() throws InterruptedException {
		refresh();
		sleep();
		try {
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'kiran@prolaborate.com')]/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
	}

	// @List_Repository_Users @tag8

	@Then("User status should be shown active")
	public void user_status_should_be_shown_active() throws InterruptedException, IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		sleep();
		String status = driver.findElement(By.xpath("//span[text()='" + mail + "']/following::label[1]")).getText();// status
		// field
		if (status.contains("Active")) {
			System.out.println("user details with active status on");
			System.out.println("Verifed the status of active user its show active");
			XLdata.pass(path, sheet2, 67, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println("the status of active user its show inactive");
			XLdata.fail(path, sheet2, 67, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @List_Repository_Users @tag9

	@When("Make user as inactive")
	public void make_user_as_inactive() throws InterruptedException, IOException {
		sleep();
		rp.getUserStatus().click();
	}

	@Then("User status should be shown inactive")
	public void user_status_should_be_shown_inactive() throws InterruptedException, IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 2, 1);
		sleep();
		String statuschange = driver.findElement(By.xpath("//span[text()='" + mail + "']/following::label[1]"))
				.getText();// status field
		if (statuschange.equalsIgnoreCase("inactive")) {
			System.out.println("user details with active status off");
			System.out.println("Verifed the status of inactive user its show inactive");
			XLdata.pass(path, sheet2, 68, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("the status of inactive user its show active");
			XLdata.fail(path, sheet2, 68, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag1

	@When("User update the first name and save")
	public void user_update_the_first_name_and_save() throws InterruptedException, IOException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String c_firstname = XLdata.getStringCellData(path, sheet1, 3, 6);
		sleep();
		WebElement edit = driver
				.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]"));
		edit.click();// way to edit optin for profile
		WebElement f = driver.findElement(By.xpath("//label[text()='First Name']/following::input[1]"));
		f.clear();
		f.sendKeys(c_firstname);
		rp.getSave().click();
	}

	@Then("Seccess message sholud be shown {int}")
	public void seccess_message_sholud_be_shown(Integer row) throws InterruptedException, IOException {
		try {
			String msg = driver.findElement(By.xpath("//ngb-alert")).getText();
			if (msg.contains("User Details Updated Successfully")) {
				System.out.println("User can able to edit and save the details");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User cannot able to edit and save the details");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag2

	@When("User update the last name and save")
	public void user_update_the_last_name_and_save() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String c_lastname = XLdata.getStringCellData(path, sheet1, 3, 7);
		sleep();
		WebElement edit = driver
				.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]"));
		edit.click();// way to edit optin for profile
		WebElement f = driver.findElement(By.xpath("//label[text()='Last Name']/following::input[1]"));
		f.clear();
		f.sendKeys(c_lastname);
		rp.getSave().click();
	}

	// @Update_Repository_User @tag3

	@Then("Updated first name should be visible in users list")
	public void updated_first_name_should_be_visible_in_users_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String c_firstname = XLdata.getStringCellData(path, sheet1, 3, 6);
		sleep();
		String username = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::span[3]")).getText();
		sleep();
		if (username.startsWith(c_firstname)) {
			System.out.println("Updated name is showed in list");
			XLdata.pass(path, sheet2, 82, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println("Name is not updated in list");
			XLdata.fail(path, sheet2, 82, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag4

	@Then("Updated last name should be visible in users list")
	public void updated_last_name_should_be_visible_in_users_list() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String c_lastname = XLdata.getStringCellData(path, sheet1, 3, 7);
		sleep();
		String username = driver.findElement(By.xpath("//span[text()='" + mail + "']/preceding::span[3]")).getText();
		sleep();
		if (username.endsWith(c_lastname)) {
			System.out.println("Updated name is showed in list");
			XLdata.pass(path, sheet2, 83, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println("Name is not updated in list");
			XLdata.fail(path, sheet2, 83, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag7

	@Then("Updated first name should be visible in users profile")
	public void updated_first_name_should_be_visible_in_users_profile() throws IOException, InterruptedException {
		String c_firstname = XLdata.getStringCellData(path, sheet1, 3, 6);
		sleep();
		driver.findElement(By.xpath("//img[@class='d-inline-block rounded-circle user-icon']")).click();// click profile
		driver.findElement(By.xpath("//span[text()='My Profile']")).click();// my profile
		sleep();
		String profilename = driver.findElement(By.xpath("//span[text()='Name']/following::td[1]")).getText();
		sleep();
		if (profilename.startsWith(c_firstname)) {
			System.out.println("user name properly showed in my profile");
			XLdata.pass(path, sheet2, 86, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("user name not showed in my profile");
			XLdata.fail(path, sheet2, 86, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag8

	@Then("Updated last name should be visible in users profile")
	public void updated_last_name_should_be_visible_in_users_profile() throws IOException, InterruptedException {
		String c_lastname = XLdata.getStringCellData(path, sheet1, 3, 7);
		sleep();
		driver.findElement(By.xpath("//img[@class='d-inline-block rounded-circle user-icon']")).click();// click profile
		driver.findElement(By.xpath("//span[text()='My Profile']")).click();// my profile
		sleep();
		String profilename = driver.findElement(By.xpath("//span[text()='Name']/following::td[1]")).getText();
		sleep();
		if (profilename.endsWith(c_lastname)) {
			System.out.println("user name properly showed in my profile");
			XLdata.pass(path, sheet2, 87, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("user name not showed in my profile");
			XLdata.fail(path, sheet2, 87, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag9
	@When("User update the email and save")
	public void user_update_the_email_and_save() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
		sleep();
		WebElement edit = driver
				.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]"));
		edit.click();// way to edit optin for profile
		sleep();
		WebElement e = driver.findElement(By.xpath("//label[text()='Email']/following::input[1]"));
		e.clear();
		sleep();
		e.sendKeys(c_mail);
		rp.getSave().click();
	}

	@Then("Delete the user after email change")
	public void delete_the_user_after_email_change() throws IOException, InterruptedException {
		String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
		refresh();
		sleep();
		try {
			rp.getMenuButton().click();
			rp.getUsersAndLicenseMangement().click();
			driver.findElement(By.xpath("//span[text()='" + c_mail + "']/preceding::div[2]")).click();
			sleep();
			rp.getDeleteButton().click();
			sleep();
			rp.getPopupWindowDeleteOption().click();
			sleep();
		} catch (Exception e) {
			System.out.println("User not available");
		}
	}

	// @Update_Repository_User @tag10

	@Then("Updated email should be visible in users list")
	public void updated_email_should_be_visible_in_users_list() throws IOException, InterruptedException {
		String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
		sleep();
		if (driver.getPageSource().contains(c_mail)) {
			System.out.println("UserMail updated Successfully in user List");
			XLdata.pass(path, sheet2, 89, 2);
			System.out.println("--TestCase pass--");

		} else {
			System.out.println("UserMail NOT updated  in user List");
			XLdata.fail(path, sheet2, 89, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag11

	@Then("User should be loginable")
	public void user_should_be_loginable() throws IOException, InterruptedException {
		try {
			sleep();
			String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
			String password = XLdata.getStringCellData(path, sheet1, 3, 2);
			rp.getLoginUserName().sendKeys(c_mail);
			rp.getLoginPassword().sendKeys(password);
			rp.getSignIn().click();
			// set password
			driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
			driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
			driver.findElement(By.xpath("//button[text()='Save Password']")).click();
			driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
			System.out.println("User is able to login with updated email");
			XLdata.pass(path, sheet2, 90, 2);
			System.out.println("--TestCase pass--");
		} catch (Exception e) {
			System.out.println("User is notable to login with updated email");
			XLdata.pass(path, sheet2, 90, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag12

	@When("Login the updated email user")
	public void login_the_updated_email_user() throws IOException, InterruptedException {
		sleep();
		String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
		String password = XLdata.getStringCellData(path, sheet1, 3, 2);
		rp.getLoginUserName().sendKeys(c_mail);
		rp.getLoginPassword().sendKeys(password);
		rp.getSignIn().click();
		// set password
		driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
		driver.findElement(By.xpath("//button[text()='Save Password']")).click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
	}

	@Then("Updated email should be visible in users profile")
	public void updated_email_should_be_visible_in_users_profile() throws IOException {
		String c_mail = XLdata.getStringCellData(path, sheet1, 3, 8);
		try {
			sleep();
			driver.findElement(By.xpath("//img[@class='d-inline-block rounded-circle user-icon']")).click();// click //
			// profile
			driver.findElement(By.xpath("//span[text()='My Profile']")).click();// my profile
			sleep();
			String usermail1 = driver.findElement(By.xpath("//span[text()='Email']/following::td[1]")).getText();
			sleep();
			if (usermail1.equals(c_mail)) {
				System.out.println("user mail properly showed in my profile");
				XLdata.pass(path, sheet2, 91, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("user mail not showed in my profile");
				XLdata.fail(path, sheet2, 91, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 91, 2);
			System.out.println("--TestCase fail--");
		}

	}

	// @Update_Repository_User @tag14

	@Then("User click the repositories")
	public void user_click_the_repositories() throws InterruptedException {
		sleep();
		rp.getRepositories().click();
	}

	@When("User update the default dashboard of the user and save")
	public void user_update_the_default_dashboard_of_the_user_and_save() throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		String dashboard = XLdata.getStringCellData(path, sheet1, 8, 1);
		sleep();
		// edit default dashboard
		driver.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]")).click();// edit
		driver.findElement(By.xpath("//label[text()='Default Dashboard']/following::div[1]")).click();// default
		// dashboard
		// change
		driver.findElement(By.xpath("//span[text()='" + dashboard + "']")).click();
		rp.getSave().click();
	}

	@Then("Updated dashboard should be shown for user {int}")
	public void updated_dashboard_should_be_shown_for_user(Integer row) throws IOException, InterruptedException {

		try {
			elementWait(driver.findElement(By.xpath("(//app-title//h3//span[text()])[1]")));
			String dashboard = XLdata.getStringCellData(path, sheet1, 8, 1);
			sleep();
			String dashboard_name = driver.findElement(By.xpath("(//app-title//h3//span[text()])[1]")).getText();
			if (dashboard_name.contains(dashboard)) {
				System.out.println("Updated dashboard is visible in user account");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Updated dashboard is not visible in user account");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag15

	@When("User click edit on actions respective ADuser")
	public void user_click_edit_on_actions_respective_ADuser() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("(//span[contains(text(),'AD1002')]/following::span[text()='Edit'])[1]")).click();// edit
		// option
	}

	@Then("User should not able to edit the name and email {int}")
	public void user_should_not_able_to_edit_the_name_and_email(Integer row) throws IOException, InterruptedException {
		sleep();
		boolean name_field = driver.findElement(By.xpath(
				"//label[contains(text(),'First Name')]/following::input[@class='form-control ng-untouched ng-pristine ng-valid']"))
				.isEnabled();
		boolean email_field = driver.findElement(By.xpath(
				"//label[contains(text(),'Email')]/following::input[@class='form-control ng-untouched ng-pristine ng-valid']"))
				.isEnabled();
		boolean lastname = driver.findElement(By.xpath(
				"//label[contains(text(),'Last Name')]/following::input[@class='form-control ng-untouched ng-pristine ng-valid' ]"))
				.isEnabled();
		if (!name_field && !email_field && !lastname) {
			System.out.println("Name,email field is disabled");
			XLdata.pass(path, sheet2, row, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println(" Name and Email  field is enabled");
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag16

	@When("User click edit on actions respective sso user")
	public void user_click_edit_on_actions_respective_sso_user() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("(//span[contains(text(),'kiran')]/following::span[text()='Edit'])[1]")).click();// edit
		// option
	}

	// @Update_Repository_User @tag17

	@When("User update the default dashboard of the ADuser and save")
	public void user_update_the_default_dashboard_of_the_ADuser_and_save() throws InterruptedException, IOException {
		String dashboard = XLdata.getStringCellData(path, sheet1, 8, 1);
		sleep();
		// edit default dashboard
		driver.findElement(By.xpath("//label[text()='Default Dashboard']/following::div[1]")).click();// default
		// dashboard
		// change
		driver.findElement(By.xpath("//span[text()='" + dashboard + "']")).click();
		rp.getSave().click();
	}

	@When("Login the added aduser")
	public void login_the_added_aduser() throws InterruptedException {
		try {
			sleep();
			rp.getLoginUserName().sendKeys("AD1002");
			rp.getLoginPassword().sendKeys("Welcome@123");
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'AD_User' Profile* \n");
		} catch (Exception e) {
			refresh();
			sleep();
		}
	}

	// @Update_Repository_User @tag18

	@When("User update the default dashboard of the sso user and save")
	public void user_update_the_default_dashboard_of_the_sso_user_and_save() throws IOException, InterruptedException {
		String dashboard = XLdata.getStringCellData(path, sheet1, 8, 1);
		sleep();
		// edit default dashboard
		rp.getDropDown1().click();// default dashboard change
		driver.findElement(By.xpath("//span[text()='" + dashboard + "']")).click();
		rp.getSave().click();
	}

	// @Update_Repository_User @tag32

	@When("User add the user group membership in repository membership edit page of the user and save")
	public void user_add_the_user_group_membership_in_repository_membership_edit_page_of_the_user_and_save()
			throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		// edit default dashboard
		driver.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]")).click();// edit
		sleep();
		driver.findElement(By.xpath("//span[text()='Edit']")).click();// repository membership edit
		sleep(1000);
		driver.findElement(By.xpath("(//ngb-modal-window//span[@class='ng-arrow-wrapper'])[1]")).click();
		sleep(1000);
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();
		driver.findElement(By.xpath("(//ngb-modal-window//span[@class='ng-arrow-wrapper'])[1]")).click();
		rp.getSave2().click();
		sleep();
		rp.getSave().click();
	}

	@Then("User should get all repository configuration features under the burger menu")
	public void user_should_get_all_repository_configuration_features_under_the_burger_menu() throws IOException {
		rp.getMenuButton().click();
		List<String> featuresNameActual = new ArrayList<>();
		List<String> featuresNameexpect = new ArrayList<>();
		featuresNameexpect.add("Access Permissions");
		featuresNameexpect.add("Dashboards");
		featuresNameexpect.add("Report Configurations");
		featuresNameexpect.add("Integrated Application Projects");
		featuresNameexpect.add("Modeling Languages");
		featuresNameexpect.add("Repository Settings");
		featuresNameexpect.add("Reviews");
		featuresNameexpect.add("Sections");
		featuresNameexpect.add("Users");
		featuresNameexpect.add("User Groups");
		List<WebElement> features = driver
				.findElements(By.xpath("//h4[text()='Repository Configuration']/following-sibling::div//a/div[1]"));
		for (int i = 0; i < features.size(); i++) {
			String text = features.get(i).getText().trim();
			featuresNameActual.add(text);
		}
		if (featuresNameActual.containsAll(featuresNameexpect) && featuresNameexpect.containsAll(featuresNameActual)) {
			System.out.println("User get all features based on group update");
			XLdata.pass(path, sheet2, 111, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("User not get all features based on group update");
			XLdata.fail(path, sheet2, 111, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Update_Repository_User @tag33

	@When("User remove the user group membership in repository membership edit page of the user and save")
	public void user_remove_the_user_group_membership_in_repository_membership_edit_page_of_the_user_and_save()
			throws IOException, InterruptedException {
		String mail = XLdata.getStringCellData(path, sheet1, 3, 1);
		sleep();
		// edit default dashboard
		driver.findElement(By.xpath("(//span[text()='" + mail + "']/following::span[text()='Edit'])[1]")).click();// edit
		sleep();
		driver.findElement(By.xpath("//span[text()='Edit']")).click();// repository membership edit
		sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Administrators'])/preceding::span[1]")).click();
		rp.getSave2().click();
		sleep();
		rp.getSave().click();
	}

	@Then("User should get reviews features under the burger menu")
	public void user_should_get_reviews_features_under_the_burger_menu() throws IOException, InterruptedException {
		sleep(1000);
		rp.getMenuButton().click();
		List<String> featuresNameActual = new ArrayList<>();
		List<String> featuresNameexpect = new ArrayList<>();
		featuresNameexpect.add("Reviews");
		List<WebElement> features = driver
				.findElements(By.xpath("//h4[text()='Repository Configuration']/following-sibling::div//a/div[1]"));
		for (int i = 0; i < features.size(); i++) {
			String text = features.get(i).getText().trim();
			featuresNameActual.add(text);
		}
		if (featuresNameActual.containsAll(featuresNameexpect) && featuresNameexpect.containsAll(featuresNameActual)) {
			System.out.println("User get features based on group update");
			XLdata.pass(path, sheet2, 112, 2);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("User not get features based on group update");
			XLdata.fail(path, sheet2, 112, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Add_ADusers_to_Repository @tag1

	@When("User click {string} under repository configuration")
	public void user_click_under_repository_configuration(String elementText) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//div[contains(text(),'"+elementText+"')]")).click();
	}

	@When("User click on {string}")
	public void user_click_on(String elementText) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[contains(text(),'"+elementText+"')]")).click();
	}
	@Then("User click on {string} \\(indexValue is {int})")
	public void user_click_on_indexValue_is(String elementText, Integer indexValue) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("(//span[contains(text(),'"+elementText+"')])["+indexValue+"]")).
				click();
	}
	@When("Select the active directory domain")

	public void select_the_active_directory_domain() throws InterruptedException {
		sleep();
		rp.getDropDown1().click();
		driver.findElement(By.xpath("//span[text()='AD test']")).click();
	}

	@When("User click on {string} under browser")
	public void user_click_on_under_browser(String elementText) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='" + elementText + "']")).click();// choose by user
	}

	@When("Select the user by search in advanced search \\({string})")
	public void selectTheUserBySearchInAdvancedSearch(String user) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Advanced Search']")).click();
		sleep();
		driver.findElement(By.xpath("//h4[text()='Advanced Search']//following::input[5]")).sendKeys(user);
		sleep();
		driver.findElement(By.id("FormSubmitAdFilter")).click();
		waits();
		driver.findElement(By.xpath("//span[text()='"+user+"']/preceding::div[1]")).click();// selecting user
	}

	@Then("User should see pb alert {string} message {int} {string}")
	public void user_should_see_pb_alert_message(String msg, Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		String messageShown = driver.findElement(By.xpath("//ngb-alert")).getText();
		System.out.println(testCase);
		System.out.println(messageShown);
		try {
			if (messageShown.contains(msg)) {
				System.out.println("Popup message is shown");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Popup message is not shown");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("PB alert message is not shown");
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}

	}

	@When("User click discard")
	public void user_click_discard() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Discard']")).click();
	}

	@Then("Added ADuser should be in repository user list {int} {string}")
	public void added_ADuser_should_be_in_repository_user_list(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean username = driver.findElement(By.xpath("//span[contains(text(),'AD1002')]")).isDisplayed();
			if (username) {
				System.out.println("AD user added in repository user list");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("AD user NOT added in repository user list");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("AD user NOT added in repository user list");
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User click {string} under portal settings")
	public void user_click_under_portal_settings(String elementText) {
		driver.findElement(By.xpath("//div[contains(text(),'" + elementText + "')]")).click();
	}

	@Then("Added ADuser should be in portal user list {int} {string}")
	public void added_ADuser_should_be_in_portal_user_list(Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			boolean username1 = driver.findElement(By.xpath("//span[contains(text(),'AD1002')]")).isDisplayed();
			if (username1) {
				System.out.println("AD user added in user management list");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("AD user NOT added in user management list");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("AD user NOT added in user management list");
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}

	}

	// @Add_ADusers_to_Repository @tag4

	@When("Select the user group membership {string}")
	public void select_the_user_group_membership(String element) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='User Group Membership']/following::span[2]")).click();// drop down
																											// // box
		sleep();
		driver.findElement(By.xpath("//span[text()='" + element + "']")).click();
	}

	@Then("Added ADuser should be added in the group {int} {string}")
	public void added_ADuser_should_be_added_in_the_group(Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		try {
			String checkbox = driver.findElement(By.xpath(
					"//span[contains(text(),'AD1002')]/following::button[@class='btn btn-clear text-success'][1]"))
					.getAttribute("class");
			if (checkbox.contains("success")) {
				System.out.println("the AD user is added to that group");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("the AD user is not added to that group");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}



	}

	// @Add_ADusers_to_Repository @tag5

	@When("Select the group by search in advanced search \\({string})")
	public void selectTheGroupBySearchInAdvancedSearch(String group) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Advanced Search']")).click();
		sleep();
		driver.findElement(By.xpath("//h4[text()='Advanced Search']//following::input[5]")).sendKeys(group);
		sleep();
		driver.findElement(By.id("FormSubmitAdFilter")).click();
		sleep(3000);
		driver.findElement(By.xpath("//span[text()='"+group+"']/preceding::div[1]")).click();// ad group select
	}

	@Then("User click on {string} in bread crumbs")
	public void user_click_on_in_bread_crumbs(String elementText) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'"+elementText+"')]")).click();
	}

	@Then("Added ADgroup should be added in the repository active directory groups list {int} {string}")
	public void added_ADgroup_should_be_added_in_the_repository_active_directory_groups_list(Integer row,
			String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean group = driver.findElement(By.xpath("//span[contains(text(),'shgroup')]")).isDisplayed();
			if (group) {
				System.out.println("AD group added successfully in repository");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");

			} else {
				System.out.println("AD group NOT added successfully in repository");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Added ADgroup should be added in the portal active directory groups list {int} {string}")
	public void added_ADgroup_should_be_added_in_the_portal_active_directory_groups_list(Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			boolean group1 = driver.findElement(By.xpath("//span[contains(text(),'shgroup')]")).isDisplayed();
			if (group1) {
				System.out.println("AD group added successfully in usermanagemnet");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");

			} else {
				System.out.println("AD group NOT added successfully in usermanagemnet");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}



	}

	// @Add_ADusers_to_Repository @tag8

	@Then("ADgroup user should be in repository user list {string}")
	public void adgroup_user_should_be_in_repository_user_list(String testCase)
			throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean group = driver.findElement(By.xpath("//span[contains(text(),'sh11')]")).isDisplayed();
			if (group) {
				System.out.println("AD group user added successfully in repository");
				XLdata.pass(path, sheet2, 130, 2);
				System.out.println("--TestCase pass--");

			} else {
				System.out.println("AD group user NOT added successfully in repository");
				XLdata.fail(path, sheet2, 130, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 130, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("ADgroup user should be in portal user list {string}")
	public void adgroup_user_should_be_in_portal_user_list(String testCase) throws IOException, InterruptedException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			boolean group1 = driver.findElement(By.xpath("//span[contains(text(),'sh11')]")).isDisplayed();
			if (group1) {
				System.out.println("AD group user added successfully in usermanagemnet");
				XLdata.pass(path, sheet2, 131, 2);
				System.out.println("--TestCase pass--");

			} else {
				System.out.println("AD group user NOT added successfully in usermanagemnet");
				XLdata.fail(path, sheet2, 131, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 131, 2);
			System.out.println("--TestCase fail--");
		}

	}

	// @Add_ADusers_to_Repository @tag10

	@Then("Added ADgroup should be added in the group {int} {string}")
	public void added_ADgroup_should_be_added_in_the_group(Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			String checkbox = driver.findElement(By.xpath("//span[contains(text(),'shgroup')]/following::button[1]"))
					.getAttribute("class");
			if (checkbox.contains("success")) {
				System.out.println("the AD group is added to that group");
				XLdata.pass(path, sheet2, row, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("the AD group is not added to that group");
				XLdata.fail(path, sheet2, row, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, row, 2);
			System.out.println("--TestCase fail--");
		}

	}

	// @Search_field_in_repository_user_list

	@Then("Search field should be available in repository users list page {string}")
	public void search_field_should_be_available_in_repository_users_list_page(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//input[contains(@class,'form-control form-search')]"))
					.isDisplayed();
			if (displayed) {
				System.out.println("Search option is available");
				XLdata.pass(path, sheet2, 141, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search option is unavailable");
				XLdata.fail(path, sheet2, 141, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search option is unavailable");
			XLdata.fail(path, sheet2, 141, 2);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Search the added user name in search field")
	public void search_the_added_user_name_in_search_field() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//input[contains(@class,'form-control form-search')]"))
				.sendKeys(userFirstName + " " + userLastName);
	}

	@Then("List will be shown based on search {string}")
	public void list_will_be_shown_based_on_search(String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {

			List<WebElement> Names = driver.findElements(By.xpath("//tr//td[2]"));
			for (int i = 0; i < Names.size(); i++) {
				boolean contains = Names.get(i).getText().contains(userFirstName + " " + userLastName);
				if (contains) {
					System.out.println("List is shown based on search");
					XLdata.pass(path, sheet2, 143, 2);
					System.out.println("--TestCase pass--");
				} else {
					System.out.println("List is not shown based on search");
					XLdata.fail(path, sheet2, 143, 2);
					System.out.println("--TestCase fail--");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 143, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User enter the valid user credentials {string} {string}")
	public void user_enter_the_valid_user_credentials(String specialcharactor1, String specialcharactor2)
			throws InterruptedException {
		userMail = userFirstName + userLastName;
		rp.getAddUserEmail().sendKeys(userMail + "@mail.com");
		rp.getAddUserFirstName().sendKeys(userFirstName + specialcharactor1);
		rp.getAddUserLastname().sendKeys(userLastName + specialcharactor2);
		rp.getAddUserPassword().sendKeys(password);
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='Administrators']")).click();// user group select
		driver.findElement(
				By.xpath("//label[text()='User Group Membership']/following::span[@class='ng-arrow-wrapper'][1]"))
				.click();
		driver.findElement(By.xpath("//label[text()='Default Dashboard']//following::div[1]")).click();// default
		// dashboard
		// dropdown
		driver.findElement(By.xpath("//span[text()='Prolaborate - Start Here']")).click();// default dashboard select
	}

	@Then("Search the added user name with special charactor in search field {string} {string}")
	public void search_the_added_user_name_with_special_charactor_in_search_field(String specialcharactor1,
			String specialcharactor2) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//input[contains(@class,'form-control form-search')]"))
				.sendKeys(userFirstName + specialcharactor1 + " " + userLastName + specialcharactor2);
	}

	@Then("List will be shown based on search with special charactor {string} {string} {string}")
	public void list_will_be_shown_based_on_search_with_special_charactor(String specialcharactor1,
			String specialcharactor2, String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			List<WebElement> Names = driver.findElements(By.xpath("//tr//td[2]"));
			for (int i = 0; i < Names.size(); i++) {
				boolean contains = Names.get(i).getText()
						.contains(userFirstName + specialcharactor1 + " " + userLastName + specialcharactor2);
				if (contains) {
					System.out.println("List is shown based on search");
					XLdata.pass(path, sheet2, 142, 2);
					System.out.println("--TestCase pass--");
				} else {
					System.out.println("List is not shown based on search");
					XLdata.fail(path, sheet2, 142, 2);
					System.out.println("--TestCase fail--");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 142, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Search the detail that is not in list")
	public void search_the_detail_that_is_not_in_list() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//input[contains(@class,'form-control form-search')]")).sendKeys("Error");
	}

	@Then("Error Message shown {int} {string} {string}")
	public void error_Message_shown(Integer row, String message, String testCase)
			throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			String text = driver.findElement(By.xpath("//tr//td")).getText();
			if (text.contains(message)) {
				System.out.println("Message is shown properly");
				XLdata.pass(path, sheet2, 144, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Message is not shown properly");
				XLdata.fail(path, sheet2, 142, 2);
				System.out.println("--TestCase fail--");
			}

		} catch (Exception e) {
			System.out.println("Message is not shown");
			XLdata.fail(path, sheet2, 144, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Repository_membership_in_repository_user_list

	@Then("Repository membership column should be shown {string}")
	public void repository_membership_column_should_be_shown(String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			String displayed = driver.findElement(By.xpath("//tr/th[5]")).getText();
			if (displayed.contains("Repository Membership")) {
				System.out.println("Repository Membership column is shown");
				XLdata.pass(path, sheet2, 165, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Repository Membership column is not shown");
				XLdata.fail(path, sheet2, 165, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Repository Membership column is not shown");
			XLdata.fail(path, sheet2, 165, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Edit option should be shown in under the repository membership column {string}")
	public void edit_option_should_be_shown_in_under_the_repository_membership_column(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			String displayed = driver.findElement(By.xpath("//tr//td[5]")).getText();
			if (displayed.contains("Edit")) {
				System.out.println("Edit option is shown in Repository Membership column");
				XLdata.pass(path, sheet2, 166, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Edit option is not shown in Repository Membership column");
				XLdata.fail(path, sheet2, 166, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Edit option is not shown in Repository Membership column");
			XLdata.fail(path, sheet2, 166, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User click on edit in repository membership column respective user {int}")
	public void user_click_on_edit_in_repository_membership_column_respective_user(Integer TCno)
			throws InterruptedException {
		sleep();
		String uName = userFirstName + " " + userLastName + TCno;
		System.out.println("Click user - "+uName);
		driver.findElement(By.xpath("//span[text()='" + uName + "']/following::a[1]")).click();
	}

	@Then("repository membership window shows repositories and group {string}")
	public void repository_membership_window_shows_repositories_and_group(String testCase)
			throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//label[text()='Test Repository']")).isDisplayed();
			boolean displayed2 = driver.findElement(By.xpath("//span[text()='Administrators']")).isDisplayed();
			if (displayed & displayed2) {
				System.out.println("Repository and Group is shown");
				XLdata.pass(path, sheet2, 167, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Repository and Group is not shown");
				XLdata.fail(path, sheet2, 167, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Repository and Group is not shown");
			XLdata.fail(path, sheet2, 167, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Remove and change the user group access")
	public void remove_and_change_the_user_group_access() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("(//span[text()='Administrators'])/preceding::span[1]")).click(); // remove group
		rp.getDropDown1().click();
		driver.findElement(By.xpath("(//span[text()='Default'])")).click();// select group
	}

	// @LicenseType_in_repository_user_list

	@Then("License type should be shown {int} {string} {string}")
	public void license_type_should_be_shown(Integer TCno, String type, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		String uName = userFirstName + " " + userLastName + TCno;
		System.out.println(uName);
		String text = driver.findElement(By.xpath("//span[text()='" + uName + "']/following::td[4]")).getText();
		try {
			if (text.contains(type)) {
				System.out.println("Type shown properly");
				XLdata.pass(path, sheet2, 160, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Type not shown properly");
				XLdata.fail(path, sheet2, 160, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 160, 2);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User click {string} under license configuration")
	public void user_click_under_license_configuration(String elementText) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//div[contains(text(),'" + elementText + "')]")).click();
	}

	@Then("User Uploaded read and regular license")
	public void user_Uploaded_read_and_regular_license() throws InterruptedException, IOException {
		sleep();
		FileInputStream fis = new FileInputStream("src/test/resources/extent.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String licePath = prop.getProperty("ReadRegularLicense");
		System.out.println(licePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(new File(licePath).getAbsolutePath());
	}

	@Then("User Open user edit page {int}")
	public void user_Open_user_edit_page(Integer TCno) throws InterruptedException {
		sleep();
		String uName = userFirstName + " " + userLastName + TCno;
		System.out.println(uName);
		driver.findElement(By.xpath("(//span[text()='" + uName + "']/following::span[text()='Edit'])[1]")).click();
	}

	@Then("The license type option shown {string}")
	public void the_license_type_option_shown(String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//label[text()='License Type']")).isDisplayed();
			boolean displayed2 = driver.findElement(By.xpath("//span[text()='Regular']")).isDisplayed();
			if (displayed & displayed2) {
				System.out.println("Liscense type option is shown");
				XLdata.pass(path, sheet2, 161, 2);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Liscense type option is not shown");
				XLdata.fail(path, sheet2, 161, 2);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Liscense type option is not shown");
			XLdata.fail(path, sheet2, 161, 2);
			System.out.println("--TestCase fail--");
		}
	}

	// @Pagination_in_repository_user_list

	@Then("Pagination option should be shown \\(rowNo {int}) {string}")
	public void pagination_option_should_be_shown_rowNo(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//p-dropdown")).isDisplayed();
			if (displayed) {
				System.out.println("Pagination option is shown");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Pagination option is not shown");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Pagination option is not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("The pagination should be by default {string} {string}")
	public void the_pagination_should_be_by_default(String pagination, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			String displayed = driver.findElement(By.xpath("//p-dropdown")).getText();
			if (displayed.contains(pagination)) {
				System.out.println("Pagination default value shown properly");
				XLdata.pass(path, sheet2, 148, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Pagination default value not shown properly");
				XLdata.fail(path, sheet2, 148, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Pagination default value not shown properly");
			XLdata.fail(path, sheet2, 148, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate the user can able to change pagination value \\(rowNo {int}) {string}")
	public void validate_the_user_can_able_to_change_pagination_value_rowNo(Integer row, String testCase)
			throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=20]")).click();
			String displayed = driver.findElement(By.xpath("//p-dropdown")).getText();
			if (displayed.contains("20")) {
				System.out.println("User can change the pagination value");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User can not change the pagination value");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("User can not change the pagination value");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Adding multiple number of users in repository for checking pagination option \\(i = {int})")
	public void adding_multiple_number_of_users_in_repository_for_checking_pagination_option_i(Integer numberOfUser)
			throws InterruptedException {
		refresh();
		sleep();
		userMail = userFirstName + userLastName;
		for (int i = 0; i < numberOfUser; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]")).click();
			sleep();
			userMail = userFirstName + userLastName;
			rp.getAddUserEmail().sendKeys(userMail + i + "@mail.com");
			rp.getAddUserFirstName().sendKeys(userFirstName);
			rp.getAddUserLastname().sendKeys(userLastName + i);
			rp.getAddUserPassword().sendKeys(password);
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]"));
		}

	}

	@Then("Validate the user limit is reached {int} then balance user is shown in next page \\(rowNo {int}) {string}")
	public void validate_the_user_limit_is_reached_then_balance_user_is_shown_in_next_page_rowNo(Integer numberOfUser,
			Integer row, String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		String dateParsed[] = driver.findElement(By.xpath("//p-paginator//span[1]")).getText().split(" ");
		int totalNumberOfUser = Integer.parseInt(dateParsed[5].trim());
		System.out.println("Total Number of users - " + totalNumberOfUser);
		int size = driver.findElements(By.xpath("//td[2]")).size();
		System.out.println("Number of user shown in page one - " + size);
		if (size == numberOfUser && totalNumberOfUser != size) {
			System.out.println("List is shown properly");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("List is not shown properly");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Validate if user select paginiation option {int},user list shown based on pagination TCno row {int} {string}")
	public void validate_if_user_select_paginiation_option_user_list_shown_based_on_pagination_TCno_row(
			Integer numberOfUser, Integer row, String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
		driver.findElement(By.xpath("//span[text()=" + numberOfUser + "]")).click();
		sleep(5000);
		String dateParsed[] = driver.findElement(By.xpath("//p-paginator//span[1]")).getText().split(" ");
		System.out.println(dateParsed[5].trim());
		int totalNumberOfUser = Integer.parseInt(dateParsed[5].trim());
		System.out.println("Total Number of users - " + totalNumberOfUser);
		int size = driver.findElements(By.xpath("//td[2]")).size();
		System.out.println("Number of user shown in page one - " + size);
		if (size == numberOfUser && totalNumberOfUser != size) {
			System.out.println("List is shown properly");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("List is not shown properly");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate the page switching button {string}")
	public void validate_the_page_switching_button(String string) throws InterruptedException, IOException {
		sleep();
		try {
			List<String> namesInFirstPage = new ArrayList<>();
			List<WebElement> findElements = driver.findElements(By.xpath("//td[2]"));
			for (int i = 0; i < findElements.size(); i++) {
				namesInFirstPage.add(findElements.get(i).getText().trim());
			}
			driver.findElement(By.xpath("//p-paginator//button[contains(@class,'next')]")).click();
			sleep();
			List<String> namesInSecondPage = new ArrayList<>();
			List<WebElement> findElements1 = driver.findElements(By.xpath("//td[2]"));
			for (int i = 0; i < findElements1.size(); i++) {
				namesInSecondPage.add(findElements1.get(i).getText().trim());
			}

			if (!namesInFirstPage.equals(namesInSecondPage)) {
				System.out.println("Page switching button is properly working");
				XLdata.pass(path, sheet2, 153, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Page switching button is properly not working");
				XLdata.fail(path, sheet2, 153, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 153, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	// @LastActivity_in_repository_user_list

	@When("Login the added user {int}")
	public void login_the_added_user(Integer TCno) throws InterruptedException {
		sleep();
		testCaseNo = "" + TCno;
		userMail = userFirstName + userLastName;
		rp.getLoginUserName().sendKeys(userMail + TCno + "@mail.com");
		rp.getLoginPassword().sendKeys(password);
		rp.getSignIn().click();
		// set password
		driver.findElement(By.id("Password")).sendKeys(password);// new passwaord
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);// confirm password
		driver.findElement(By.xpath("//button[text()='Save Password']")).click();
		driver.findElement(By.xpath("//a[text()='Click here']")).click();// set password
		sleep();
	}

	@When("Note the login time")
	public void note_the_login_time() throws InterruptedException {
		sleep();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		dateTime = dateFormat.format(date);
		// Print the Date
		System.out.println("login date and time is " + dateTime);
	}

	@Then("Validate the lastactivity column is shown login date and time")
	public void validate_the_lastactivity_column_is_shown_login_date_and_time()
			throws InterruptedException, IOException {
		sleep();
		try {
			String text = driver
					.findElement(By.xpath("//span[contains(text(),'" + userFirstName + "')]/following::td[6]//span[2]"))
					.getText();
			System.out.println("login date and time shown in column " + text);
			if (text.contains(dateTime)) {
				System.out.println("Lastactivity date and time is shown properly");
				XLdata.pass(path, sheet2, 154, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Lastactivity date and time is shown properly");
				XLdata.fail(path, sheet2, 154, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 154, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	// @Add_Existing_Users

	@Then("Add Existing User Tab option should be available near Add User Tab {string}")
	public void add_Existing_User_Tab_option_should_be_available_near_Add_User_Tab(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//span[text()='Add Existing Users']")).isDisplayed();
			if (displayed) {
				System.out.println("Add Exxisting User tab is shown");
				XLdata.pass(path, sheet2, 174, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Add Exxisting User tab is not shown");
				XLdata.fail(path, sheet2, 174, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Add Exxisting User tab is not shown");
			XLdata.fail(path, sheet2, 174, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Add Existing Users page should be shown {string}")
	public void add_Existing_Users_page_should_be_shown(String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//h3//span[text()='Add Existing Users']")).isDisplayed();
			if (displayed) {
				System.out.println("Add Exxisting User page is shown");
				XLdata.pass(path, sheet2, 175, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Add Exxisting User page is not shown");
				XLdata.fail(path, sheet2, 175, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Add Exxisting User page is not shown");
			XLdata.fail(path, sheet2, 175, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Search option should be shown {string}")
	public void search_option_should_be_shown(String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//input[contains(@class,'search')]")).isDisplayed();
			if (displayed) {
				System.out.println("Search option is available");
				XLdata.pass(path, sheet2, 176, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search option is not available");
				XLdata.fail(path, sheet2, 176, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search option is not available");
			XLdata.fail(path, sheet2, 176, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	// @Add_Existing_Users @tag2

	@When("User click Make user as a admin")
	public void user_click_Make_user_as_a_admin() throws InterruptedException {
		sleep();
		driver.findElement(By.id("userIsAdmin")).click();
	}
	

	@Then("Validating search results shown properly based on username \\(userNo {int}) {string}")
	public void validating_search_results_shown_properly_based_on_username_userNo(Integer userNo, String testCase)
			throws InterruptedException, IOException {
		sleep();
		WebElement s = driver.findElement(By.xpath("//input[contains(@class,'search')]"));
		s.clear();
		s.sendKeys(userFirstName + " " + userLastName + userNo);
		System.out.println(testCase);
		sleep(1000);
		try {
			String name = driver.findElement(By.xpath("//tr//td[2]")).getText();
			if (name.equals(userFirstName + " " + userLastName + userNo)) {
				System.out.println("Search result is shown properly");
				XLdata.pass(path, sheet2, 177, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search result is shown not properly");
				XLdata.fail(path, sheet2, 177, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, 177, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validating search results shown properly based on mail  \\(userNo {int}) {string}")
	public void validating_search_results_shown_properly_based_on_mail_userNo(Integer userNo, String testCase)
			throws InterruptedException, IOException {
		sleep();
		userMail = userFirstName + userLastName;
		WebElement s = driver.findElement(By.xpath("//input[contains(@class,'search')]"));
		s.clear();
		s.sendKeys(userMail + userNo + "@mail.com");
		System.out.println(testCase);
		sleep(1000);
		try {
			String name = driver.findElement(By.xpath("//tr//td[3]")).getText();
			if (name.equals(userMail + userNo + "@mail.com")) {
				System.out.println("Search result is shown properly");
				XLdata.pass(path, sheet2, 178, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search result is shown not properly");
				XLdata.fail(path, sheet2, 178, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, 178, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validating search results shown properly based on type {string}")
	public void validating_search_results_shown_properly_based_on_type(String testCase)
			throws InterruptedException, IOException {
		sleep();
		WebElement s = driver.findElement(By.xpath("//input[contains(@class,'search')]"));
		s.clear();
		s.sendKeys("Registered User");
		System.out.println(testCase);
		sleep(1000);
		try {
			String name = driver.findElement(By.xpath("//tr//td[4]")).getText();
			if (name.equals("Registered User")) {
				System.out.println("Search result is shown properly");
				XLdata.pass(path, sheet2, 179, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search result is shown not properly");
				XLdata.fail(path, sheet2, 179, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, 179, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validating search results shown based on search content contains {string}")
	public void validating_search_results_shown_based_on_search_content_contains(String testCase)
			throws InterruptedException, IOException {
		sleep();
		WebElement s = driver.findElement(By.xpath("//input[contains(@class,'search')]"));
		s.clear();
		s.sendKeys(userFirstName);
		System.out.println(testCase);
		sleep(1000);
		try {
			List<WebElement> name = driver.findElements(By.xpath("//tr//td[2]"));
			for (int i = 0; i < name.size(); i++) {
				String text = name.get(i).getText();
				if (text.contains(userFirstName)) {
					System.out.println("Search result is shown properly");
					XLdata.pass(path, sheet2, 180, columnNo);
					System.out.println("--TestCase pass--");
				} else {
					System.out.println("Search result is shown not properly");
					XLdata.fail(path, sheet2, 180, columnNo);
					System.out.println("--TestCase fail--");
				}
			}

		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, 180, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate username is not clickable {string}")
	public void validate_username_is_not_clickable(String string) throws InterruptedException, IOException {
		sleep();
		driver.findElement(By.xpath("(//tr//td[2]//span[1]//span)[1]")).click();
		try {
			boolean page = driver.findElement(By.xpath("//span[text()='Edit User']")).isDisplayed();
			if (page) {
				System.out.println("user name clickable");
				XLdata.fail(path, sheet2, 185, columnNo);
				System.out.println("--TestCase fail--");
			} else {
				System.out.println("user name not clickable");
				XLdata.pass(path, sheet2, 185, columnNo);
				System.out.println("--TestCase pass--");
			}
		} catch (Exception e) {
			System.out.println("user name not clickable");
			XLdata.pass(path, sheet2, 185, columnNo);
			System.out.println("--TestCase pass--");
		}
	}

	@Then("Validate column search results is shown properly based on search \\(column {int}) \\(seachContent {int}) \\(row {int}) {string}")
	public void validate_column_search_results_is_shown_properly_based_on_search_column_seachContent_row(Integer index,
			Integer userNo, Integer row, String testCase) throws InterruptedException, IOException {
		sleep();
		refresh();
		sleep();
		WebElement s = driver.findElement(By.xpath("//tr[2]//th[" + index + "]//input"));
		s.clear();
		if (index == 2) {
			s.sendKeys(userFirstName + " " + userLastName + userNo);
		} else if (index == 3) {
			s.sendKeys(userMail + userNo + "@mail.com");
		}
		System.out.println(testCase);
		sleep(1000);
		try {
			String name = driver.findElement(By.xpath("//tr//td[" + index + "]")).getText();
			if (index == 2) {
				boolean equals = name.equals(userFirstName + " " + userLastName + userNo);
				if (equals) {
					System.out.println("Search result is shown properly");
					XLdata.pass(path, sheet2, row, columnNo);
					System.out.println("--TestCase pass--");
				} else {
					System.out.println("Search result is shown not properly");
					XLdata.fail(path, sheet2, row, columnNo);
					System.out.println("--TestCase fail--");
				}
			} else if (index == 3) {
				boolean equals = name.equals(userMail + userNo + "@mail.com");
				if (equals) {
					System.out.println("Search result is shown properly");
					XLdata.pass(path, sheet2, row, columnNo);
					System.out.println("--TestCase pass--");
				} else {
					System.out.println("Search result is shown not properly");
					XLdata.fail(path, sheet2, row, columnNo);
					System.out.println("--TestCase fail--");
				}
			}

		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate type column search results is shown properly based on search \\(seachContent {string}) {string}")
	public void validate_type_column_search_results_is_shown_properly_based_on_search_seachContent(String searchContent,
			String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		refresh();
		sleep();
		WebElement s = driver.findElement(By.xpath("//tr[2]//th[4]//input"));
		s.clear();
		s.sendKeys(searchContent);
		System.out.println(testCase);
		sleep(1000);
		try {
			String name = driver.findElement(By.xpath("//tr//td[4]")).getText();
			if (name.equals(searchContent)) {
				System.out.println("Search result is shown properly");
				XLdata.pass(path, sheet2, 209, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Search result is shown not properly");
				XLdata.fail(path, sheet2, 209, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Search result is shown not properly");
			XLdata.fail(path, sheet2, 209, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	// @Add_Existing_Users @tag3

	@Then("Adding multiple number of users in portal for checking pagination option \\(i = {int})")
	public void adding_multiple_number_of_users_in_portal_for_checking_pagination_option_i(Integer numberOfUser)
			throws InterruptedException {
		sleep();
		userMail = userFirstName + userLastName;
		for (int i = 0; i < numberOfUser; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]")).click();
			sleep();
			userMail = userFirstName + userLastName;
			rp.getAddUserEmail().sendKeys(userMail + i + "@mail.com");
			rp.getAddUserFirstName().sendKeys(userFirstName);
			rp.getAddUserLastname().sendKeys(userLastName + i);
			rp.getAddUserPassword().sendKeys(password);
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]"));
		}
	}

	@Then("Validate Next and previous should be shown {string}")
	public void validate_Next_and_previous_should_be_shown(String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//p-paginator//button[contains(@class,'prev')]"))
					.isDisplayed();
			boolean displayed1 = driver.findElement(By.xpath("//p-paginator//button[contains(@class,'next')]"))
					.isDisplayed();
			if (displayed1 && displayed) {
				System.out.println("Next and previous button is shown");
				XLdata.pass(path, sheet2, 248, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Next and previous button is not shown");
				XLdata.fail(path, sheet2, 248, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Next and previous button is not shown");
			XLdata.fail(path, sheet2, 248, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Validate next and previous button redirect to respective page {string}")
	public void validate_next_and_previous_button_redirect_to_respective_page(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			driver.findElement(By.xpath("//p-paginator//button[contains(@class,'next')]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> secondPage = driver
					.findElements(By.xpath("//h3//span[text()='Add Existing Users']//following::tbody//td[2]"));
			for (int i = 0; i < secondPage.size(); i++) {
				u.add(secondPage.get(i).getText());
			}
			driver.findElement(By.xpath("//p-paginator//button[contains(@class,'prev')]")).click();
			sleep();
			List<String> u1 = new ArrayList<>();
			List<WebElement> firstPage = driver
					.findElements(By.xpath("//h3//span[text()='Add Existing Users']//following::tbody//td[2]"));
			for (int i = 0; i < firstPage.size(); i++) {
				u1.add(firstPage.get(i).getText());
			}
			if (!u.equals(u1)) {
				System.out.println("Next previous page is properly redirected");
				XLdata.pass(path, sheet2, 249, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Next previous page is properly not redirected");
				XLdata.fail(path, sheet2, 249, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Next previous page is properly not redirected");
			XLdata.fail(path, sheet2, 249, columnNo);
			System.out.println("--TestCase fail--");
		}
	}
	
	@Then("Validate FirstPage FinalPage Option is shown {string}")
	public void validate_First_Page_Final_Page_Option_is_shown(String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//p-paginator//button[contains(@class,'first')]"))
					.isDisplayed();
			boolean displayed1 = driver.findElement(By.xpath("//p-paginator//button[contains(@class,'last')]"))
					.isDisplayed();
			if (displayed1 && displayed) {
				System.out.println("first and last button is shown");
				XLdata.pass(path, sheet2, 250, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("first and last button is not shown");
				XLdata.fail(path, sheet2, 250, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("first and last button is not shown");
			XLdata.fail(path, sheet2, 250, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate FirstPage FinalPage directs respective page when clicked {string}")
	public void validate_First_Page_Final_Page_directs_respective_page_when_clicked(String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			driver.findElement(By.xpath("//p-paginator//button[contains(@class,'last')]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> secondPage = driver
					.findElements(By.xpath("//h3//span[text()='Add Existing Users']//following::tbody//td[2]"));
			for (int i = 0; i < secondPage.size(); i++) {
				u.add(secondPage.get(i).getText());
			}
			driver.findElement(By.xpath("//p-paginator//button[contains(@class,'first')]")).click();
			sleep();
			List<String> u1 = new ArrayList<>();
			List<WebElement> firstPage = driver
					.findElements(By.xpath("//h3//span[text()='Add Existing Users']//following::tbody//td[2]"));
			for (int i = 0; i < firstPage.size(); i++) {
				u1.add(firstPage.get(i).getText());
			}
			if (!u.equals(u1)) {
				System.out.println("Last First page is properly redirected");
				XLdata.pass(path, sheet2, 251, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Last First page is properly not redirected");
				XLdata.fail(path, sheet2, 251, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Last First page is properly not redirected");
			XLdata.fail(path, sheet2, 251, columnNo);
			System.out.println("--TestCase fail--");
		}

	}
	
	

	// @Add_Existing_Users @tag4

	@When("Adding multiple number of users in portal for checking sort option \\(i = {int})")
	public void adding_multiple_number_of_users_in_portal_for_checking_sort_option_i(Integer numberOfUser,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		sleep();
		userMail = userFirstName + userLastName;
		for (int i = 0; i <= numberOfUser; i++) {
			List<String> d = dataTable.asList();
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]")).click();
			sleep();
			userMail = userFirstName + userLastName;
			sleep();
			rp.getAddUserEmail().sendKeys(d.get(numberOfUser - i) + userMail + "@mail.com");
			sleep();
			rp.getAddUserFirstName().sendKeys(d.get(i) + userFirstName);
			rp.getAddUserLastname().sendKeys(userLastName + i);
			rp.getAddUserPassword().sendKeys(password);
			if (i % 2 == 0) {
				driver.findElement(By.id("userIsAdmin")).click();
			}
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]"));
		}
	}

	@Then("Validate sort option should be shown in username header {string}")
	public void validate_sort_option_should_be_shown_in_username_header(String string)
			throws IOException, InterruptedException {
		sleep();
		try {
			boolean displayed = driver.findElement(By.xpath("//th[2]//p-sorticon")).isDisplayed();
			if (displayed) {
				System.out.println("Sort option is shown");
				XLdata.pass(path, sheet2, 191, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Sort option is not shown");
				XLdata.fail(path, sheet2, 191, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Sort option is not shown");
			XLdata.fail(path, sheet2, 191, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@When("User click on username header")
	public void user_click_on_username_header() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//th[2]")).click();
	}

	@Then("Validate list should be in ascending order \\(rowNo {int}) \\(elementIndex {int}) {string}")
	public void validate_list_should_be_in_ascending_order_rowNo_elementIndex(Integer row, Integer index,
			String testCase, io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {
		sleep();
		try {
			List<String> d = dataTable.asList();
			System.out.println(testCase);
			String expectType[] = { "Prolaborate Admin", "Registered User" };
			List<String> actualType = new ArrayList<>();
			List<Boolean> list = new ArrayList<>();
			List<WebElement> nameList = driver.findElements(By.xpath("//tr//td[" + index + "]"));
			if (index == 2 || index == 3) {
				for (int i = 0; i < nameList.size(); i++) {
					boolean startsWith = nameList.get(i).getText().startsWith(d.get(i));
					list.add(startsWith);
				}
			} else if (index == 4) {
				for (int i = 0; i < nameList.size(); i++) {
					String startsWith = nameList.get(i).getText();
					actualType.add(startsWith);
				}
			}
			if (!list.contains(false) || actualType.equals(expectType)) {
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

	@Then("Validate list should be in descending order \\(rowNo {int}) \\(elementIndex {int}) {string}")
	public void
	validate_list_should_be_in_descending_order_rowNo_elementIndex(Integer row, Integer index,
			String testCase, io.cucumber.datatable.DataTable dataTable) throws IOException, InterruptedException, AWTException {
		sleep();
		try {
			List<String> d = dataTable.asList();
			System.out.println(testCase);
			String expectType[] = { "Registered User", "Prolaborate Admin" };
			List<String> actualType = new ArrayList<>();
			List<Boolean> list = new ArrayList<>();
			List<WebElement> nameList = driver.findElements(By.xpath("//tr//td[" + index + "]"));
			if (index == 2 || index == 3) {
				for (int i = 0; i < nameList.size(); i++) {
					boolean startsWith = nameList.get(i).getText().startsWith(d.get(i));
					list.add(startsWith);
				}
			} else if (index == 4) {
				for (int i = 0; i < nameList.size(); i++) {
					String startsWith = nameList.get(i).getText();
					actualType.add(startsWith);
				}
			}
			if (!list.contains(false) || actualType.equals(expectType)) {
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

	@Then("Validate sort option should be shown in mail header {string}")
	public void validate_sort_option_should_be_shown_in_mail_header(String testCase)
			throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//th[3]//p-sorticon")).isDisplayed();
			if (displayed) {
				System.out.println("Sort option is shown");
				XLdata.pass(path, sheet2, 197, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Sort option is not shown");
				XLdata.fail(path, sheet2, 197, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Sort option is not shown");
			XLdata.fail(path, sheet2, 197, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User click on email header")
	public void user_click_on_email_header() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//th[3]")).click();
	}

	@Then("Validate sort option should be shown in type header {string}")
	public void validate_sort_option_should_be_shown_in_type_header(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//th[4]//p-sorticon")).isDisplayed();
			if (displayed) {
				System.out.println("Sort option is shown");
				XLdata.pass(path, sheet2, 206, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Sort option is not shown");
				XLdata.fail(path, sheet2, 206, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Sort option is not shown");
			XLdata.fail(path, sheet2, 206, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("User click on type header")
	public void user_click_on_type_header() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//th[4]")).click();
	}

	// @Add_Existing_Users @tag5

	@When("Copy a repository")
	public void copy_a_repository() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Test Repository']//following::span[text()='More'][1]")).click();
		driver.findElement(By.xpath("//span[text()='Test Repository']//following::span[text()='Copy'][1]")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		driver.findElement(By.xpath("//span[text()='Configure Automatically']")).click();
		elementWait(driver.findElement(By.xpath("//span[text()='Close']")));
		driver.findElement(By.xpath("//span[text()='Close']")).click();
	}

	@When("User open copied repository")
	public void user_open_copied_repository() throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//span[text()='Test Repository-Copy']")).click();
	}

	@When("User choose {string} license type")
	public void user_choose_license_type(String licenseType) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//input[@id='" + licenseType + "']")).click();
	}

	@Then("Validate other repository users should be shown \\(row {int}) \\(userNo {int}) {string}")
	public void validate_other_repository_users_should_be_shown_row_userNo(Integer row, Integer userNo, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver
					.findElement(By.xpath("//span[text()='" + userFirstName + " " + userLastName + userNo + "']"))
					.isDisplayed();
			if (displayed) {
				System.out.println("Add Existing Users list is properly shown");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Add Existing Users list is properly not shown");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Add Existing Users list is properly not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Validate other repository \\(user {string}) should be shown \\(row {int}) {string}")
	public void validate_other_repository_user_should_be_shown_row(String userName, Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'" + userName + "'])"))
					.isDisplayed();
			if (displayed) {
				System.out.println("Add Existing Users list is properly shown");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Add Existing Users list is properly not shown");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println("Add Existing Users list is properly not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	// @Add_Existing_Users @tag6

	@Then("Validate select all chackbox should be shown \\(row {int}) {string}")
	public void validate_select_all_chackbox_should_be_shown_row(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		WebElement checkbox = driver.findElement(By.xpath("//th//p-tableheadercheckbox/div"));
		System.out.println("select all check box is shown - " + checkbox.isDisplayed());
		System.out.println("select all check box is enabled - " + !checkbox.getAttribute("class").contains("disable"));
		if (checkbox.isDisplayed() && !checkbox.getAttribute("class").contains("disable")) {
			System.out.println("check box is shown");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("check box is not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate individual checkbox should be shown for users \\(row {int}) {string}")
	public void validate_individual_checkbox_should_be_shown_for_users_row(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		List<Boolean> d = new ArrayList<>();
		List<Boolean> c = new ArrayList<>();
		List<WebElement> checkboxs = driver.findElements(By.xpath("//th//p-tableheadercheckbox/div"));
		for (int i = 0; i < checkboxs.size(); i++) {
			boolean displayed = checkboxs.get(i).isDisplayed();
			d.add(displayed);
			boolean contains = !checkboxs.get(i).getAttribute("class").contains("disable");
			c.add(contains);
		}
		System.out.println("Individual check box is shown - " + d);
		System.out.println("Individual check box is enabled - " + c);
		if (!d.contains(false) && !c.contains(false)) {
			System.out.println("check box is shown");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("check box is not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate all users should be selected when select all check box selected \\(row {int}) {string}")
	public void validate_all_users_should_be_selected_when_select_all_check_box_selected_row(Integer row,
			String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		driver.findElement(By.xpath("//th//p-tableheadercheckbox/div")).click();
		List<Boolean> d = new ArrayList<>();
		List<WebElement> checkboxs = driver.findElements(By.xpath("//tr//p-tablecheckbox/div//div[2]"));
		for (int i = 0; i < checkboxs.size(); i++) {
			boolean contains = checkboxs.get(i).getAttribute("class").contains("highlight");
			d.add(contains);
		}
		System.out.println("All user is selected-" + d);
		if (!d.contains(false)) {
			System.out.println("check boxs is selected");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("check boxs is not selected");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate all users should be unselected when select all check box unselected \\(row {int}) {string}")
	public void validate_all_users_should_be_unselected_when_select_all_check_box_unselected_row(Integer row,
			String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		driver.findElement(By.xpath("//th//p-tableheadercheckbox/div")).click();
		List<Boolean> d = new ArrayList<>();
		List<WebElement> checkboxs = driver.findElements(By.xpath("//tr//p-tablecheckbox/div//div[2]"));
		for (int i = 0; i < checkboxs.size(); i++) {
			boolean contains = checkboxs.get(i).getAttribute("class").contains("highlight");
			d.add(contains);
		}
		System.out.println("All user is unselected-" + d);
		if (!d.contains(true)) {
			System.out.println("check boxs is unselected");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("check boxs is selected");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate user should be able to select individual user \\(row {int}) {string}")
	public void validate_user_should_be_able_to_select_individual_user_row(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		driver.findElement(By.xpath("(//tr//p-tablecheckbox/div//div[2])[1]")).click();
		List<Boolean> d = new ArrayList<>();
		List<Boolean> e = new ArrayList<>();
		e.add(true);
		e.add(false);
		List<WebElement> checkboxs = driver.findElements(By.xpath("//tr//p-tablecheckbox/div//div[2]"));
		for (int i = 0; i < checkboxs.size(); i++) {
			boolean contains = checkboxs.get(i).getAttribute("class").contains("highlight");
			d.add(contains);
		}
		System.out.println("users select status -" + d);
		if (d.equals(e)) {
			System.out.println("Induvidual check box is selected");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("Induvidual check box is not selected");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate user should be able to unselect individual user \\(row {int}) {string}")
	public void validate_user_should_be_able_to_unselect_individual_user_row(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		driver.findElement(By.xpath("//th//p-tableheadercheckbox/div")).click();
		List<Boolean> d = new ArrayList<>();
		List<Boolean> e = new ArrayList<>();
		e.add(false);
		e.add(true);
		driver.findElement(By.xpath("(//tr//p-tablecheckbox/div//div[2])[1]")).click();
		List<WebElement> checkboxs = driver.findElements(By.xpath("//tr//p-tablecheckbox/div//div[2]"));
		for (int i = 0; i < checkboxs.size(); i++) {
			boolean contains = checkboxs.get(i).getAttribute("class").contains("highlight");
			d.add(contains);
		}
		System.out.println("users select status -" + d);
		if (d.equals(e)) {
			System.out.println("Induvidual check box is unselected");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("Induvidual check box is not unselected");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Validate selected user count option should be shown \\(row {int}) {string}")
	public void validate_selected_user_count_option_should_be_shown_row(Integer row, String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		WebElement option = driver.findElement(By.xpath("//span[text()='Selected users:']"));
		if (option.isDisplayed()) {
			System.out.println("selected user option is shown");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {
			System.out.println("selected user option is not shown");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate selected user count should be properly shown \\(row {int}) {string}")
	public void validate_selected_user_count_should_be_properly_shown_row(Integer row, String testCase)
			throws InterruptedException, IOException, AWTException {
		sleep();
		try {
			System.out.println(testCase);
			driver.findElement(By.xpath("(//tr//p-tablecheckbox/div//div[2])[1]")).click();
			sleep(1000);
			String text1 = driver.findElement(By.xpath("//span[text()='Selected users:']/following-sibling::strong"))
					.getText();
			driver.findElement(By.xpath("(//tr//p-tablecheckbox/div//div[2])[1]")).click();
			sleep(1000);
			String text2 = driver.findElement(By.xpath("//span[text()='Selected users:']/following-sibling::strong"))
					.getText();
			if (text1.contains("1") && text2.contains("2")) {
				System.out.println("selected user count is shown properly");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("selected user count is not shown properly");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
		}catch (Exception e){
			System.out.println(e);

		}


	}

	// @Add_Existing_Users @tag7

	@When("User enter a groupname {string}")
	public void user_enter_a_groupname(String groupName) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//label[text()='Name']//following::input[1]")).sendKeys(groupName);
	}

	@When("User click on {string} option")
	public void user_click_on_option(String Status) throws InterruptedException {
		sleep();
		driver.findElement(By.xpath("//label[text()='" + Status + "']//following::input[1]")).click();
	}

	@Then("Validate user group membership dropdown should be shown {string}")
	public void validate_user_group_membership_dropdown_should_be_shown(String testCase)
			throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		try {
			boolean displayed = rp.getDropDown1().isDisplayed();
			if (displayed) {
				System.out.println("User Group Membership dropdown is shown");
				XLdata.pass(path, sheet2, 228, columnNo);
				System.out.println("--TestCase pass--");
			}
		} catch (Exception e) {
			System.out.println("User Group Membership dropdown is not shown");
			XLdata.fail(path, sheet2, 228, columnNo);
			System.out.println("--TestCase fail--");
		}

	}

	@Then("Validate {string} and {string} group should be shown in user group membership dropdown {string}")
	public void validate_and_group_should_be_shown_in_user_group_membership_dropdown(String groupName1,
			String groupName2, String testCase) throws InterruptedException, IOException {
		sleep();
		System.out.println(testCase);
		rp.getDropDown1().click();
		List<String> g = new ArrayList<>();
		List<WebElement> groups = driver.findElements(By.xpath("//ng-dropdown-panel//span[text()]"));
		for (int i = 0; i < groups.size(); i++) {
			g.add(groups.get(i).getText());
		}
		if (g.contains(groupName1) || g.contains(groupName2)) {
			System.out.println("User Group Membership dropdown is shown properly");
			XLdata.pass(path, sheet2, 229, columnNo);
			System.out.println("--TestCase pass--");
		} else {

			System.out.println("User Group Membership dropdown is not shown properly");
			XLdata.fail(path, sheet2, 229, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate {string} group should be shown in user group membership dropdown \\(row {int}) {string}")
	public void validate_group_should_be_shown_in_user_group_membership_dropdown_row(String groupName, Integer row,
			String testCase) throws IOException, InterruptedException {
		sleep();
		System.out.println(testCase);
		List<String> g = new ArrayList<>();
		List<WebElement> groups = driver.findElements(By.xpath("//ng-dropdown-panel//span[text()]"));
		for (int i = 0; i < groups.size(); i++) {
			g.add(groups.get(i).getText());
		}
		if (g.contains(groupName)) {
			System.out.println("User Group Membership dropdown is shown properly");
			XLdata.pass(path, sheet2, row, columnNo);
			System.out.println("--TestCase pass--");
		} else {

			System.out.println("User Group Membership dropdown is not shown properly");
			XLdata.fail(path, sheet2, row, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate {string} group should not be shown in user group membership dropdown {string}")
	public void validate_group_should_not_be_shown_in_user_group_membership_dropdown(String groupName, String testCase)
			throws IOException, InterruptedException, AWTException {
		sleep();
		try {
			System.out.println(testCase);
			List<String> g = new ArrayList<>();
			List<WebElement> groups = driver.findElements(By.xpath("//ng-dropdown-panel//span[text()]"));
			for (int i = 0; i < groups.size(); i++) {
				g.add(groups.get(i).getText());
			}
			if (!g.contains(groupName)) {
				System.out.println("User Group Membership dropdown is shown properly");
				XLdata.pass(path, sheet2, 235, columnNo);
				System.out.println("--TestCase pass--");
			} else {

				System.out.println("User Group Membership dropdown is not shown properly");
				XLdata.fail(path, sheet2, 235, columnNo);
				System.out.println("--TestCase fail--");
			}
		}catch (Exception e) {
			System.out.println(e);
		}


	}

	// @Add_Existing_Users @tag8

	@Then("Validate add users button shoud be shown {string}")
	public void validate_add_users_button_shoud_be_shown(String string) throws InterruptedException, IOException {
		sleep();
		boolean displayed = driver.findElement(By.xpath("//button//span[text()='Add Users']")).isDisplayed();
		if (displayed) {
			System.out.println("Add Users button is shown");
			XLdata.pass(path, sheet2, 236, columnNo);
			System.out.println("--TestCase pass--");
		} else {

			System.out.println("Add Users button is not shown");
			XLdata.fail(path, sheet2, 236, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate user can able to add {string} to repository \\(user {string}) \\(userNo {int}) \\(row {int}) {string}")
	public void validate_user_can_able_to_add_to_repository_user_userNo_row(String userType, String user,
			Integer userNo, Integer row, String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		System.out.println(testCase);
		List<String> u = null;
		List<WebElement> name = null;
		String text = null;
		switch (userType) {
		case "RegularUser":
			driver.findElement(
					By.xpath("//span[text()='" + userFirstName + " " + userLastName + userNo + "']//preceding::div[1]"))
					.click();
			text = driver.findElement(By.xpath("//span[text()='"+userFirstName+" "+userLastName+userNo+"']//following::td[2]")).getText();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			u = new ArrayList<>();
			name = driver.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (int i = 0; i < name.size(); i++) {
				u.add(name.get(i).getText());
			}
			if (u.contains(userFirstName + " " + userLastName + userNo)) {
				System.out.println("Successfully added " + userType + "");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added " + userType + "");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
			
			if (text.contains("Registered User")) {
				System.out.println("User type is shown" + userType + "");
				XLdata.pass(path, sheet2, 202, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User type is shown " + userType + "");
				XLdata.fail(path, sheet2, 202, columnNo);
				System.out.println("--TestCase fail--");
			}
			break;

		case "ReadOnlyUser":

			driver.findElement(
					By.xpath("//span[text()='" + userFirstName + " " + userLastName + userNo + "']//preceding::div[1]"))
					.click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			u = new ArrayList<>();
			name = driver.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			if (u.contains(userFirstName + " " + userLastName + userNo)) {
				System.out.println("Successfully added " + userType + "");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added " + userType + "");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
			break;

		case "SMALUser":

			driver.findElement(By.xpath("//span[text()='" + user + "']//preceding::div[1]")).click();
			text = driver.findElement(By.xpath("//span[text()='" + user + "']//following::td[2]")).getText();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			u = new ArrayList<>();
			name = driver.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			if (u.contains(user)) {
				System.out.println("Successfully added " + userType + "");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added " + userType + "");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
			if (text.contains("Identity User")) {
				System.out.println("User type is shown properly");
				XLdata.pass(path, sheet2, 203, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User type is shown not properly");
				XLdata.fail(path, sheet2, 203, columnNo);
				System.out.println("--TestCase fail--");
			}
			
			break;

		case "ADuser":

			driver.findElement(By.xpath("//span[text()='"+"  "+user+"']//preceding::div[1]")).click();
			text = driver.findElement(By.xpath("//span[text()='"+"  "+user+"']//following::td[2]")).getText();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			u = new ArrayList<>();
			name = driver.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			if (u.contains(user)) {
				System.out.println("Successfully added " + userType + "");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added " + userType + "");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
			
			if (text.contains("Active Directory User")) {
				System.out.println("User type is shown properly");
				XLdata.pass(path, sheet2, 204, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User type is shown not properly");
				XLdata.fail(path, sheet2, 204, columnNo);
				System.out.println("--TestCase fail--");
			}
			break;

		case "ADGroup":

			driver.findElement(By.xpath("//span[text()='"+user+"']//preceding::div[1]")).click();
			text = driver.findElement(By.xpath("//span[text()='"+user+"']//following::td[2]")).getText();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("//span[text()='Active Directory Groups']")).click();
			sleep();
			u = new ArrayList<>();
			name = driver
					.findElements(By.xpath("//h3//span[text()='Active Directory Groups']//following::tbody//td[1]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			if (u.contains(user)) {
				System.out.println("Successfully added " + userType + "");
				XLdata.pass(path, sheet2, row, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added " + userType + "");
				XLdata.fail(path, sheet2, row, columnNo);
				System.out.println("--TestCase fail--");
			}
			
			if (text.contains("Active Directory Group")) {
				System.out.println("User type is shown properly");
				XLdata.pass(path, sheet2, 205, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("User type is shown not properly");
				XLdata.fail(path, sheet2, 205, columnNo);
				System.out.println("--TestCase fail--");
			}
			break;

		}

	}

	// @Add_Existing_Users @tag9

	@When("Adding multiple number of user group for checking user group membership option \\(i = {int})")
	public void adding_multiple_number_of_user_group_for_checking_user_group_membership_option_i(Integer numberOfGroup)
			throws InterruptedException {
		sleep();
		for (int i = 0; i < numberOfGroup; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Create User Group')]")).click();
			sleep();
			if (i % 2 == 0) {
				driver.findElement(By.xpath("//label[text()='Name']//following::input[1]")).sendKeys("ReadOnly"+i);
				driver.findElement(By.xpath("//input[@id='ReadOnly']")).click();
			} else {
				driver.findElement(By.xpath("//label[text()='Name']//following::input[1]")).sendKeys("Regular"+i);
			}
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'Create User Group')]"));
		}

	}

	@When("Adding multiple number of users in portal for checking user group membership option \\(i = {int})")
	public void adding_multiple_number_of_users_in_portal_for_checking_user_group_membership_option_i(
			Integer numberOfUser) throws InterruptedException {
		sleep();
		userMail = userFirstName + userLastName;
		for (int i = 0; i < numberOfUser; i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]")).click();
			sleep();
			userMail = userFirstName + userLastName;
			sleep();
			if (i % 2 == 0) {
				rp.getAddUserEmail().sendKeys("ReadOnly" + i + userMail + "@mail.com");
				sleep();
				rp.getAddUserFirstName().sendKeys("ReadOnly" + i + userFirstName);
				rp.getAddUserLastname().sendKeys(userLastName);
				rp.getAddUserPassword().sendKeys(password);
				driver.findElement(By.xpath("//input[@id='ReadOnly']")).click();
			} else {
				rp.getAddUserEmail().sendKeys("Regular" + i + userMail + "@mail.com");
				sleep();
				rp.getAddUserFirstName().sendKeys("Regular" + i + userFirstName);
				rp.getAddUserLastname().sendKeys(userLastName);
				rp.getAddUserPassword().sendKeys(password);
			}
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			sleep();
			driver.findElement(By.xpath("//span[contains(text(),'Add User')]"));
		}
	}

	@Then("Validate Regular users are added in Repository and selected Regular group \\(userType {string}) \\(userGroup {string}) {string}")
	public void validate_Regular_users_are_added_in_Repository_and_selected_Regular_group_userType_userGroup(
			String userType, String userGroup, String testCase) throws IOException, InterruptedException {
		sleep();
		try {
			System.out.println(testCase);
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			driver.findElement(
					By.xpath("//span[text()='" + userType + userMail + "@mail.com" + "']//preceding::div[2]")).click();
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> name = driver
					.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			rp.getMenuButton().click();
			driver.findElement(By.xpath("//div[contains(text(),'User Groups')]")).click();
			driver.findElement(By.xpath("//span[text()='" + userGroup + "']")).click();
			sleep();
			String attribute = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			System.out.println(attribute);
			if (u.contains(userType + userFirstName + " " + userLastName) && attribute.contains("success")) {
				System.out.println("Successfully added");
				XLdata.pass(path, sheet2, 242, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added");
				XLdata.fail(path, sheet2, 242, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 242, columnNo);
			System.out.println("--TestCase fail--");
		}
		refresh();
	}

	@Then("Validate proper PB Alert when Read Only users are added in Regular group \\(userType {string}) \\(userGroup {string}) {string}")
	public void validate_proper_PB_Alert_when_Read_Only_users_are_added_in_Regular_group_userType_userGroup(
			String userType, String userGroup, String testCase) throws IOException, InterruptedException {
		sleep();
		try {

			System.out.println(testCase);
			driver.findElement(By
					.xpath("//span[text()='"+userType+userFirstName+" "+userLastName+"']//preceding::div[1]"))
					.click();
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep(1000);
			WebElement text = driver.findElement(By.xpath("//ngb-alert"));
			System.out.println("Pb alert -" + text.getText() + "--" + text.isDisplayed());
			if (text.isDisplayed()) {
				System.out.println("Alert message is ahown");
				XLdata.pass(path, sheet2, 243, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Alert message is not shown");
				XLdata.fail(path, sheet2, 243, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 243, columnNo);
			System.out.println("--TestCase fail--");
		}
	}

	@Then("Validate Regular users are added in ReadOnly group \\(userType {string}) \\(userGroup {string}) {string}")
	public void validate_Regular_users_are_added_in_ReadOnly_group_userType_userGroup(String userType, String userGroup,
			String testCase) throws InterruptedException, IOException {
		sleep();
		try {
			refresh();
			sleep();
			System.out.println(testCase);
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			driver.findElement(By
					.xpath("//span[text()='" + userType + userFirstName + " " + userLastName + "']//preceding::div[1]"))
					.click();
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> name = driver
					.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			rp.getMenuButton().click();
			driver.findElement(By.xpath("//div[contains(text(),'User Groups')]")).click();
			driver.findElement(By.xpath("//span[text()='" + userGroup + "']")).click();
			sleep();
			String attribute = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			System.out.println(attribute);
			if (u.contains(userType + userFirstName + " " + userLastName) && attribute.contains("success")) {
				System.out.println("Successfully added");
				XLdata.pass(path, sheet2, 244, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added");
				XLdata.fail(path, sheet2, 244, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 244, columnNo);
			System.out.println("--TestCase fail--");
		}
		refresh();
	}

	@Then("Validate multiple Regular users are added in one Regular group \\(userType {string} {string}) \\(userGroup {string}) {string}")
	public void validate_multiple_Regular_users_are_added_in_one_Regular_group_userType_userGroup(String userType1,
			String userType2, String userGroup, String testCase) throws InterruptedException, IOException {
		sleep();
		try {

			System.out.println(testCase);
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			driver.findElement(
					By.xpath("//span[text()='" + userType1 + userMail + "@mail.com" + "']//preceding::div[2]")).click();
			driver.findElement(
					By.xpath("//span[text()='" + userType2 + userMail + "@mail.com" + "']//preceding::div[2]")).click();
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> name = driver
					.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			rp.getMenuButton().click();
			driver.findElement(By.xpath("//div[contains(text(),'User Groups')]")).click();
			driver.findElement(By.xpath("//span[text()='" + userGroup + "']")).click();
			sleep();
			String attribute1 = driver.findElement(By.xpath("//span[contains(text(),'" + userType1 + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			String attribute2 = driver.findElement(By.xpath("//span[contains(text(),'" + userType2 + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			System.out.println(attribute1 + "/" + attribute2);
			if (u.contains(userType1 + userFirstName + " " + userLastName) && attribute1.contains("success")
					&& u.contains(userType2 + userFirstName + " " + userLastName) && attribute2.contains("success")) {
				System.out.println("Successfully added");
				XLdata.pass(path, sheet2, 245, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added");
				XLdata.fail(path, sheet2, 245, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 245, columnNo);
			System.out.println("--TestCase fail--");
		}
		refresh();
	}
	
	@Then("Validate single  Regular user can be added in multiple  Regular group \\(userType {string}) \\(userGroup {string} {string}) {string}")
	public void validate_single_Regular_user_can_be_added_in_multiple_Regular_group_userType_userGroup(String userType, String userGroup1, String userGroup2, String testCase) throws IOException, InterruptedException {
		sleep();
		try {

			System.out.println(testCase);
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			driver.findElement(
					By.xpath("//span[text()='" + userType + userMail + "@mail.com" + "']//preceding::div[2]")).click();
			
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup1 + "']")).click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup2 + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> name = driver
					.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			rp.getMenuButton().click();
			driver.findElement(By.xpath("//div[contains(text(),'User Groups')]")).click();
			driver.findElement(By.xpath("//span[text()='" + userGroup1 + "']")).click();
			sleep();
			String attribute1 = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			refresh();
			sleep();
			backward();
			sleep();
			driver.findElement(By.xpath("//span[text()='" + userGroup1 + "']")).click();
			sleep();
			String attribute2 = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			System.out.println(attribute1 + "/" + attribute2);
			if (u.contains(userType + userFirstName + " " + userLastName) && attribute1.contains("success")
					&& u.contains(userType + userFirstName + " " + userLastName) && attribute2.contains("success")) {
				System.out.println("Successfully added");
				XLdata.pass(path, sheet2, 246, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added");
				XLdata.fail(path, sheet2, 246, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 246, columnNo);
			System.out.println("--TestCase fail--");
		}
		refresh();
	}
	
	@Then("Validate single  Regular user can be added in multiple  ReadOnly group \\(userType {string}) \\(userGroup {string} {string}) {string}")
	public void validate_single_Regular_user_can_be_added_in_multiple_ReadOnly_group_userType_userGroup(String userType, String userGroup1, String userGroup2, String testCase) throws InterruptedException, IOException, AWTException {
		sleep();
		try {

			System.out.println(testCase);
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			driver.findElement(
					By.xpath("//span[text()='" + userType + userMail + "@mail.com" + "']//preceding::div[2]")).click();
			
			rp.getDropDown1().click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup1 + "']")).click();
			driver.findElement(By.xpath("//ng-dropdown-panel//span[text()='" + userGroup2 + "']")).click();
			driver.findElement(By.xpath("//button//span[text()='Add Users']")).click();
			sleep();
			driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
			driver.findElement(By.xpath("//span[text()=30]")).click();
			sleep();
			List<String> u = new ArrayList<>();
			List<WebElement> name = driver
					.findElements(By.xpath("//h3//span[text()='Users']//following::tbody//td[2]"));
			for (WebElement webElement : name) {
				u.add(webElement.getText());
			}
			rp.getMenuButton().click();
			driver.findElement(By.xpath("//div[contains(text(),'User Groups')]")).click();
			driver.findElement(By.xpath("//span[text()='" + userGroup1 + "']")).click();
			sleep();
			String attribute1 = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			refresh();
			sleep();
			backward();
			sleep();
			driver.findElement(By.xpath("//span[text()='" + userGroup1 + "']")).click();
			sleep();
			String attribute2 = driver.findElement(By.xpath("//span[contains(text(),'" + userType + userFirstName + " "
					+ userLastName + "')]/following::button[1]")).getAttribute("class");
			System.out.println(attribute1 + "/" + attribute2);
			if (u.contains(userType + userFirstName + " " + userLastName) && attribute1.contains("success")
					&& u.contains(userType + userFirstName + " " + userLastName) && attribute2.contains("success")) {
				System.out.println("Successfully added");
				XLdata.pass(path, sheet2, 247, columnNo);
				System.out.println("--TestCase pass--");
			} else {
				System.out.println("Successfully not added");
				XLdata.fail(path, sheet2, 247, columnNo);
				System.out.println("--TestCase fail--");
			}
		} catch (Exception e) {
			System.out.println(e);
			XLdata.fail(path, sheet2, 247, columnNo);
			System.out.println("--TestCase fail--");
		}
		refresh();

	}


}
