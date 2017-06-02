package Day9.FD;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass_TestNG02 {

	ChromeDriver driver = null;
	ExtentReports report;
	Logger logger;
	ExtentTest testRep;
	static int testCaseNo = 1;
	@BeforeSuite
	public void preRequisite() {

		// Report
		report = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + "ECommRep_TestNG_" + getTimeStamp() + ".html");

	}

	@BeforeMethod
	public void launchApp() throws IOException {

		// Report
		testRep = report.startTest("TC0"+testCaseNo);
		// Set Logs
		logger = Logger.getLogger(Ecommerce_TestNG.class);
		// Launch Driver
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Chrome driver launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/");
		logger.info("Application launched");
		driver.manage().window().maximize();
		testRep.log(LogStatus.PASS, "Application launched", "Passed" + testRep.addScreenCapture(getScreenShot()));
	}

	@AfterMethod
	public void tearDown() {

		// End report
		report.endTest(testRep);
		report.flush();
		testCaseNo ++;
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
