package Day9.FD;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import java.util.Map;

public class Ecommerce_TestNG02 extends BaseClass_TestNG02 {
	
	@Test(dataProvider = "dp_Ecomm", dataProviderClass = dp_EcomTestNG.class )
	public void Login_Validation(Map<String,String> mp) throws IOException, InterruptedException {
		
		String uName = mp.get("Username");
		String uPass = mp.get("Password");
		
		//Create object of page factory
		PageFactory_Ecommerce ecomPf = new PageFactory_Ecommerce(driver);
		
		// Find elements and perform actions
		ecomPf.enterDetails(uName, uPass);
		Thread.sleep(15000);
		testRep.log(LogStatus.PASS, "Navigation to Login Page successful",
				"Passed" + testRep.addScreenCapture(getScreenShot()));
	
		logger.info("Login attempt done");
		
		// Perform validation on login
		List<WebElement> eles = driver.findElements(By.xpath("//div[@id='account_logout']/a"));
		
		if (eles.size() == 0 ) {
			System.out.println("Login failed !");
			logger.info("Login validation failed");
			Thread.sleep(5000);
			testRep.log(LogStatus.FAIL, "User login failed", "Failed" + testRep.addScreenCapture(getScreenShot()));
			
		
		} else {
			logger.info("Login validation successful");
			testRep.log(LogStatus.PASS, "User login successful",
					"Passed" + testRep.addScreenCapture(getScreenShot()));
			// Logout
			ecomPf.logout();
			logger.info("Logout action successful");
			testRep.log(LogStatus.PASS, "User logout successful", "Passed" + testRep.addScreenCapture(getScreenShot()));
			
		}
		
		logger.info("Validation performed");


		

	}

	

}
