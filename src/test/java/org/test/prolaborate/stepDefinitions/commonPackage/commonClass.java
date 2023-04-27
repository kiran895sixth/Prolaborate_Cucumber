package org.test.prolaborate.stepDefinitions.commonPackage;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.prolaborate.baseclass.LoginPage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class commonClass extends LoginPage{

    @After
    public  static void createUser() throws InterruptedException, AWTException {
//        rp.getMenuButton().click();
//        rp.getRepositories().click();
//        driver.findElement(By.xpath("//span[text()='Test Repository']")).click();
//        sleep();
//        rp.getMenuButton().click();
//        sleep(1000);
//        rp.getUserGroups().click();
//        sleep();
//        List<WebElement> elements = driver.findElements(By.xpath("//td[1]//a//span"));
//        if (elements.size() > 2) {
//            List<WebElement> groups = driver.findElements(By.xpath("//span[text()='More']"));
//            for (int i = 0; i < groups.size(); i++) {
//                driver.findElement(By.xpath("(//span[text()='More'])[1]")).click();
//                driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
//                sleep(1000);
//                driver.findElement(By.xpath("//ngb-modal-window//span[text()='Delete'] ")).click();
//                sleep();
//            }
//        }
//        rp.getMenuButton().click();
//        rp.getMenuDashboard().click();
//        sleep();
//        List<String> Dashboard = new ArrayList<String>();
//        List<WebElement> Dashboards = driver.findElements(By.xpath("//td[1]//a//span"));
//        for (int i = 0; i < Dashboards.size(); i++) {
//            if (Dashboards.get(i).getText().contains("testDashboard")) {
//                Dashboard.add(Dashboards.get(i).getText());
//            }
//        }
//
//        if (Dashboard.size() > 0) {
//            sleep(1000);
//            for (int i = 0; i < Dashboard.size(); i++) {
//                sleep(1000);
//                driver.findElement(By.xpath("(//span[contains(text(),'"+Dashboard.get(i)+"')]/following::span[text()='More'])[1]")).click();
//                driver.findElement(By.xpath("(//span[contains(text(),'"+Dashboard.get(i)+"')]/following::span[text()='Delete'])[1]")).click();
//                rp.getPopupWindowDeleteOption().click();
//            }
//        }
        try {
            rp.getMenuButton().click();
            driver.findElement(By.xpath("//div[contains(text(),'User and License Management')]")).click();
            sleep();
            driver.findElement(By.xpath("(//p-dropdown//span)[2]")).click();
            driver.findElement(By.xpath("//span[text()=100]")).click();
            sleep();
            List<String> UserNames = new ArrayList<String>();
            List<WebElement> usernames = driver.findElements(By.xpath("//td[2]//a//span"));
            if (usernames.size() > 1) {
                driver.findElement(By.xpath("//p-tableheadercheckbox")).click();
                sleep();
                rp.getDeleteButton().click();
                sleep();
                rp.getPopupWindowDeleteOption().click();
            }
        }catch (Exception e) {

        }
//        try {
//            driver.findElement(By.xpath("//span[text()='Active Directory Groups']")).click();
//            driver.findElement(By.xpath("//span[contains(text(),'shgroup')]/following::span[text()='Delete'][1]")).click();// delete
//            // option
//            driver.findElement(By.xpath("//span[contains(text(),'Remove Anyway')]")).click();// delete button
//        } catch (Exception e) {
//
//        }


    }

//    @After(order = 1)
//    public  void deleteADGroup() throws InterruptedException, AWTException {
//        sleep();
//        try {
//            rp.getMenuButton().click();
//            driver.findElement(By.xpath("//div[contains(text(),'User and License Management')]")).click();
//            sleep();
//            driver.findElement(By.xpath("//span[text()='Active Directory Groups']")).click();
//            driver.findElement(By.xpath("//span[contains(text(),'shgroup')]/following::span[text()='Delete'][1]")).click();// delete
//            // option
//            driver.findElement(By.xpath("//span[contains(text(),'Remove Anyway')]")).click();// delete button
//        } catch (Exception e) {
//
//        }
//    }
   /* @Before("@Get_Portal_User_Details")
    public static void before() throws IOException, ConfigurationException {
        System.out.println("Before runner class Runned");
        PropertiesConfiguration conf = new PropertiesConfiguration("src\\test\\resources\\extent.properties");
        conf.setProperty("extent.reporter.spark.out", "report/UserInPortal/Get_Portal_User_Details.html");
        conf.save();
    }

    @Before("@Delete_Portal_User")
    public static void before1() throws IOException, ConfigurationException {
        System.out.println("Before runner class Runned");
        PropertiesConfiguration conf = new PropertiesConfiguration("src\\test\\resources\\extent.properties");
        conf.setProperty("extent.reporter.spark.out", "report/UserInPortal/Delete_Portal_User.html");
        conf.save();

    }
    @Before("@List_All_User")
    public static void before2() throws IOException, ConfigurationException {
        System.out.println("Before runner class Runned 2");
        PropertiesConfiguration conf = new PropertiesConfiguration("src\\test\\resources\\extent.properties");
        conf.setProperty("extent.reporter.spark.out", "report/UserInPortal/List_All_User.html");
        conf.save();

    }*/
    @Before("@Repository_membership_in_portal_user_list")
    public static void before3() throws IOException, ConfigurationException, ConfigurationException {
        System.out.println("Before runner class Runned 2");
        PropertiesConfiguration conf = new PropertiesConfiguration("src\\test\\resources\\extent.properties");
        conf.setProperty("extent.reporter.spark.out", "report/UserInPortal/Repository_membership_in_portal_user_list.html");
        conf.save();

    }

    public static boolean access_verification(String options ) throws InterruptedException {

        switch (options) {
            case "Read":
                try {
                    boolean read = driver.findElement(By.xpath("//div[text()='Actork']")).isDisplayed();
                    System.out.println("read operation on accessed--" + read);
                    return true;
                } catch (Exception e) {
                    return false;
                }


            case "Write":
                try {
                    boolean write = driver.findElement(By.xpath("(//label[contains(text(),'Name')])[2]//following::input[1]")).isDisplayed();
                    System.out.println("write operation on accessed--" + write);
                    driver.findElement(By.xpath("(//label[contains(text(),'Name')])[2]//following::input[1]")).sendKeys("test");
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case "Collaborate":
                try {
                    driver.findElement(
                            By.xpath("(//app-property-window//app-button-theme//button)[1]")).click();
                    sleep();
                    driver.findElement(By.xpath("//app-property-window-discussion//app-input//input")).click();
                    sleep();
                    driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test");
                    return true;
                } catch (Exception e) {
                    return false;
                }

            default:
                break;
        }
        return false;
    }

}