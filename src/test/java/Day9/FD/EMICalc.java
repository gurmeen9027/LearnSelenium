package Day9.FD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EMICalc {

	
	public static void main(String[] args) {
		
		//Reporting
		ExtentReports eReports = new ExtentReports(System.getProperty("user.dir")+"/Reports/"+ "EMIReport"+ getdtime()+".html");
		 ExtentTest startTest = eReports.startTest("TC01");
		
		
		//Add log
		Logger EMIlog = Logger.getLogger(EMICalc.class);
		//DOMConfigurator.configure("log4j.xml");
		
		EMIlog.info("Started Execution");
		startTest.log(LogStatus.PASS, "Validation for execution", "Passed");
		//setting up driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resources/geckodriver.exe");

		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		EMIlog.info("Launch application");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		driver.manage().window().maximize();
		
		//Finding Web Elements and performing action
		EMIlog.info("Started Execution");
		String exp_output  = "1234";
		
		EMIlog.info("Enter the values");
		driver.findElement(By.id("one")).sendKeys("100000");
		driver.findElement(By.id("two")).sendKeys("10");
		driver.findElement(By.id("three")).sendKeys("24");
		driver.findElement(By.name("B1")).click();
		
		EMIlog.info("Extract value");
		String act_output = driver.findElementByXPath("//input[@id='four']").getAttribute("value");

		System.out.println("Actual output is - " +act_output);
		
		//Verify EMI
		if(act_output.equals(exp_output)){
			System.out.println("Validation is successful");
			EMIlog.info("Validation successful");
			startTest.log(LogStatus.PASS, "Validation for execution", "Passed");
		}else{
			System.out.println("Validation failed");
			EMIlog.error("Validation failed");
			startTest.log(LogStatus.FAIL, "Validation for EMI", "Failed");
		}
		

		
		eReports.endTest(startTest);
		eReports.flush();
		
		//Close driver
		driver.quit();
		EMIlog.info("Close application");
		
		

		
	}
	
	
	//Get Time stamp
	 public static String getdtime(){
		 Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String dte = dformat.format(date);
		return dte;
	 }
	
}
