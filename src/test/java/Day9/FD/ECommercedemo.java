package Day9.FD;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ECommercedemo {

	 static ChromeDriver driver = null;
	 

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

		// Logs
		Logger logger = Logger.getLogger(ECommercedemo.class);

		// Report
		ExtentReports Report = new ExtentReports(System.getProperty("user.dir")+"/Reports"+"/EcommerceReports_"+getTimeStamp()+".html");
		ExtentTest startTest = Report.startTest("TC01");
		
		// Launch Driver
		driver = new ChromeDriver();
		logger.info("Chrome driver launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/");
		logger.info("Application launched");
		driver.manage().window().maximize();
		
		startTest.log(LogStatus.PASS, "Application launched", "Passed"+startTest.addScreenCapture(getScreenShot()));

		// Find elements and perform actions
		driver.findElement(By.xpath("//div[@id = 'account']/a[1]/span")).click();
		startTest.log(LogStatus.PASS, "Navigation to Login Page successful", "Passed"+startTest.addScreenCapture(getScreenShot()));
		driver.findElement(By.id("log")).sendKeys("gsingh");
		driver.findElement(By.id("pwd")).sendKeys("Gsingh@123");
		logger.info("Actions performed on webelements");
		driver.findElement(By.id("login")).click();
		logger.info("Login action successful");
		
		// Perform validation on login
		WebElement ele = driver.findElement(By.xpath("//div[@id='account_logout']/a"));
		if (ele.equals(null)) {
			System.out.println("Login failed !");
			logger.info("Login validation failed");
			startTest.log(LogStatus.FAIL, "User login failed", "Failed"+startTest.addScreenCapture(getScreenShot()));
		} else {
			System.out.println("Login successful !");
			logger.info("Login validation successful");
			startTest.log(LogStatus.PASS, "User login successful", "Passed"+startTest.addScreenCapture(getScreenShot()));
		}
		logger.info("Validation performed");

		// Logout
		ele.click();
		logger.info("Logout action successful");
		startTest.log(LogStatus.PASS, "User logout successful", "Passed"+startTest.addScreenCapture(getScreenShot()));
		
		//End report
		Report.endTest(startTest);
		Report.flush();
		
		// Close driver
		driver.quit();
		logger.info("Driver closed");

		
	}
	
	public static String getTimeStamp(){
		
		Date date = new Date();
		SimpleDateFormat Imprformat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss ");
		String timestamp = Imprformat.format(date);
		return timestamp;
	}
	
	public static String getScreenShot() throws IOException{
		TakesScreenshot imgcapture = (TakesScreenshot)driver;
		File screen = imgcapture.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir"+"/Reports"+"EcommerceReport_"+getTimeStamp()+".png");
		FileUtils.copyFile(screen, new File(path));
		return path;
		
	}

}
