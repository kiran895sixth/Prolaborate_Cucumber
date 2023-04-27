package org.test.prolaborate.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	public static WebDriver driver;
	public static PojoClass p;

	// mujahid-Base Class

	public static String url = "https://localhost/Account/Login?";
	
	// @BeforeMethod
	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("\n *Successfully Launch the ChromeBrowser* \n");
	}

	public static void launchFirefoxBrowser() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("\n *Successfully Launch the FirefoxBrowser* \n");
	}

	public static void launchEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("\n *Successfully Launch the EdgeBrowser* \n");
	}

	
public static void  validatePdf(String fileName) throws IOException, InterruptedException {
		
		URL url=new URL("file:///C:/Users/IdeapadG3-03/Downloads/"+fileName+".pdf");
		InputStream openStream = url.openStream();
		sleep();
		BufferedInputStream bis=new BufferedInputStream(openStream);
		PDDocument doc=PDDocument.load(bis);
		sleep();
		String pdfContent=new PDFTextStripper().getText(doc);
		sleep(1000);
		System.out.println(pdfContent);
		sleep(1000);
		doc.close();
		sleep();
//		try 
//		{
//		if ((new File("file:///C:/Users/IdeapadG3-03/Downloads/"+fileName+".pdf")).delete()) {
//		                System.out.println("Pass");     
//		            } else {
//		                System.out.println("Failed");
//		            }
//
//		          } catch (Exception ex) {
//		            ex.printStackTrace();
//		          }
	    
	}



	public static void  validateFiles(String fileName,String fileFormat) throws IOException, InterruptedException {

		URL url=new URL("file:///C:/Users/IdeapadG3-03/Downloads/"+fileName+"."+fileFormat);
		InputStream openStream = url.openStream();
		sleep();
		BufferedInputStream bis=new BufferedInputStream(openStream);
		PDDocument doc=PDDocument.load(bis);
		sleep();
		String pdfContent=new PDFTextStripper().getText(doc);
		sleep(1000);
		System.out.println(pdfContent);
		sleep(1000);
		doc.close();
		sleep();
	}
	// Gopi-Base class
	
	public static String path = "TestData\\Test_Data.xlsx";
	public static String sheet1 = "Login";
	public static String sheet2 = "Global_Variable";
	public static String host = "https://localhost/Account/Login";
	public static Robot r ;
	
	// @BeforeMethod
	public static void startTime() {
		System.out.println("Browser Opened");
		java.util.Date d = new java.util.Date();
		System.out.println(d);

	}


	public static void launchURL(String url) {
		driver.get(url);

	}

	public static void maxWindows() {
		driver.manage().window().maximize();

	}

	public static void close() {
		driver.close();

	}


	public static void waits() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void elementWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void sleep(int time) throws InterruptedException {
		Thread.sleep(time);

	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(2000);

	}

	public static void textFill(WebElement element, String input) {
		element.sendKeys(input);

	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	public static String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URl : " + currentUrl);
		return currentUrl;

	}

	public static void getTitle() {
		String currentTitle = driver.getTitle();
		System.out.println("Page Title : " + currentTitle);

	}

	public static void getValue(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}

	public static void click(WebElement element) {
		element.click();

	}

	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File theDir = new File("ScreenShots");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		File destination = new File("ScreenShots\\" + filename + ".png");
		FileUtils.copyFile(source, destination);
	}
	
	
	
	public boolean validateDownloadFiles(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				System.out.println("File is found and its deleted");
				return true;
			}
		}
		System.out.println("File is not found");
		return false;
	}
	
	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void forward() {
		driver.navigate().forward();

	}

	public static void backward() {
		driver.navigate().back();

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void blank() {
		System.out.println("");

	}

	public static void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	public static void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public static void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static void delete() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);

	}

	public static void tab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	public static void space() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);

	}

	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void backspace() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);

	}

	public static void selectAll() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void msg(String text) {
		System.out.println(text);

	}

	public static void openHTTPS() {
		driver.findElement(By.id("details-button")).click();// clicking advanced button in not secure pageproceed-link
		driver.findElement(By.id("proceed-link")).click();// clicking proceed to localhost in not secure page
		waits();
		driver.findElement(By.xpath("//img[@alt='Prolaborate-logo']")).click();
	}

	public static void openHTTPS2() {
		driver.findElement(By.id("details-button")).click();// clicking advanced button in not secure pageproceed-link
		driver.findElement(By.id("proceed-link")).click();// clicking proceed to localhost in not secure page
		waits();

	}
	
	public static void widgetHoverViewButton() throws InterruptedException{
		
		WebElement widget =  driver.findElement(By.xpath("//gridster-item"));
		Actions act = new Actions(driver);
		act.moveToElement(widget);
		WebElement view =  driver.findElement(By.xpath("//app-button[2]/a"));
		act.moveToElement(view);
		act.click().build().perform();
		sleep();
		
		
	}
	// Kiran

	public static void AdWaits() {
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}


	public static void Waits(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
	
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				System.out.println("File is found and its deleted");
				return true;
			}
		}
		System.out.println("File is not found");
		return false;
	}
	
	public static void selectYear() {
		WebElement Year = driver.findElement(By.xpath("//select[@title='Select year']"));
		String year_value = Year.getAttribute("value");
		int i=Integer.parseInt(year_value);  
		int j = i+1;
		System.out.println(j);
		String Y = Integer.toString(j);
		Select year = new Select(Year);
		year.selectByVisibleText(Y);// year
	}
	
	public static boolean comparScreenshot(WebElement element,String expectedfilename,String actualfilename) throws IOException {
		File shot = element.getScreenshotAs(OutputType.FILE);
		File actualFile = new File("ScreenShots\\"+actualfilename+".png");
		FileUtils.copyFile(shot, actualFile);
		File expectfile = new File("ScreenShots\\"+expectedfilename+".png");
		BufferedImage expectedImg = ImageIO.read(expectfile);
		BufferedImage actualImg = ImageIO.read(actualFile);
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
		boolean hasDiff = dif.hasDiff();
		String same = new Boolean(hasDiff).toString();
		System.out.println(same);
		switch (same) {
		case "false":
			System.out.println("Image are same");
			return true;
		default:
			return false;
		}
		
	}
	
	public static void cucumberReportFile(String fileName) throws IOException, ConfigurationException {
		PropertiesConfiguration conf = new PropertiesConfiguration("src\\test\\resources\\extent.properties");
		conf.setProperty("extent.reporter.spark.out", "report/UserInPortal/"+fileName+".html");
		conf.save();
	}
	

	public static String dynamicChange_StringValue(String Name) throws InterruptedException, IOException {

		java.util.Date d = new java.util.Date();
		System.out.println(d);
		@SuppressWarnings("deprecation")
		String localeString = d.toLocaleString();
		System.out.println(localeString);
		String[] split = localeString.split(" ");
		String[] split2 = split[3].split(":");
		String min = split2[1];
		String sec = split2[2];
		String time = Name + min + sec;

		System.out.println(time);
		return time;

	}


}
