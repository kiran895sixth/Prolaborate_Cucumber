/**
 * 
 */
package org.test.prolaborate.baseclass;

import java.io.IOException;

/**
 * @author Shaik Mujahid
 *
 */
public class LoginPage extends BaseClass {

	public static PojoClass rp;

	public static String xlfile = "TestData\\Test_Data.xlsx";
	public static String xlsheet = "LoginCredentials";

	public static void login(String user) throws InterruptedException, IOException {

		rp = new PojoClass();
		
		switch (user) {
		case "Admin":
			refresh();
			rp.getLoginUserName().clear();rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 1, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 1, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Admin' Profile* \n");

			break;

		case "Moderator":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 2, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 2, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Moderator' Profile* \n");

			break;

		case "Approver":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 3, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 3, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Approver' Profile* \n");
			break;

		case "Reviewer":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 4, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 4, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Reviewer' Profile* \n");
			break;
		case "InviteContributor":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 5, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 5, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Reviewer' Profile* \n");
			break;

		case "ADuser":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 6, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 6, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'AD_User' Profile* \n");
			break;

		case "ADgroupUser":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 7, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 7, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'AD_Group_User' Profile* \n");
			break;

		case "shgroupUser":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 7, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 7, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'SH_Group_User' Profile* \n");
			break;
			
		case "sampleAdmin":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 8, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 8, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'sample Admin_User' Profile* \n");
			break;
			
		case "SAML_User":
			rp.getSso().click();
			rp.getOktaUsername().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 9, 3));
			rp.getOktaPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 9, 4));
			rp.getOktaNext().click(); //sign in button
			System.out.println("\n *Successfully Login the 'SAML_User' Profile* \n");
			break;
			
		case "readOnly_User":

			rp.getLoginUserName().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 10, 3));
			rp.getLoginPassword().sendKeys(XLdata.getStringCellData(xlfile, xlsheet, 10, 4));
			rp.getSignIn().click();
			System.out.println("\n *Successfully Login the 'Read Only_User' Profile* \n");
			break;
			
		default:
			System.out.println("\n *Failed To Login the Profile* \n");

			break;
		}

	}

	public static void logOut() throws InterruptedException {
		sleep(500);
		rp.getProfile().click();
		sleep(500);
		rp.getSignout().click();
		System.out.println("\n *Successfully LogOut the Profile* \n");

	}

}
