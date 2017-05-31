package Day9.FD;

import java.io.File;
import java.io.IOException;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Ecommerce_TestNG {

	ChromeDriver driver = null;

	@Test
	public void Login_Validation() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

		// Set Logs
		Logger logger = Logger.getLogger(Ecommerce_TestNG.class);

		// Report
		ExtentReports report = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + "ECommRep_TestNG_" + getTimeStamp() + ".html");
		ExtentTest sT01 = report.startTest("TC01");

		// Launch Driver
		driver = new ChromeDriver();
		logger.info("Chrome driver launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/");
		logger.info("Application launched");
		driver.manage().window().maximize();
		sT01.log(LogStatus.PASS, "Application launched", "Passed"+sT01.addScreenCapture(getScreenShot()));
		
		// Find elements and perform actions
		driver.findElement(By.xpath("//div[@id = 'account']/a[1]/span")).click();
		sT01.log(LogStatus.PASS, "Navigation to Login Page successful",
				"Passed" + sT01.addScreenCapture(getScreenShot()));
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
			sT01.log(LogStatus.FAIL, "User login failed", "Failed" + sT01.addScreenCapture(getScreenShot()));
		} else {
			System.out.println("Login successful !");
			logger.info("Login validation successful");
			sT01.log(LogStatus.PASS, "User login successful",
					"Passed" + sT01.addScreenCapture(getScreenShot()));
		}
		logger.info("Validation performed");

		// Logout
		ele.click();
		logger.info("Logout action successful");
		sT01.log(LogStatus.PASS, "User logout successful", "Passed" + sT01.addScreenCapture(getScreenShot()));

		// End report
		report.endTest(sT01);
		report.flush();

		// Close driver
		driver.quit();
		logger.info("Driver closed");

	}

	public String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		String timeStamp = dateformat.format(date);
		return timeStamp;
	}

	public String getScreenShot() throws IOException {
		TakesScreenshot imgCapture = (TakesScreenshot) driver;
		File screen = imgCapture.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Reports" + "/EcommRep_TestNG_" + getTimeStamp() + ".png";
		FileUtils.copyFile(screen, new File(path));
		return path;
	}

}
