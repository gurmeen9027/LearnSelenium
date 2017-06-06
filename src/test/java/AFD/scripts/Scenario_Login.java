package AFD.scripts;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario_Login {

	@Test(dataProvider = "Valid_Login",dataProviderClass = AFD.dataProvider.Dp_Login.class)
	public void Login_ValidLogin(Map <String,String> map){
	
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

		// Launch Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@name='logid']")).sendKeys(map.get("Username"));
		driver.findElement(By.xpath("//input[@name='pswd']")).sendKeys(map.get("Password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String exp = map.get("Expectedmsg");
		String act = driver.findElement(By.id("username")).getText();
		if(act.equals(exp)){
			System.out.println("Login successful - ");
		}
		
	}

	@Test(dataProvider = "InValid_Login",dataProviderClass = AFD.dataProvider.Dp_Login.class, enabled=false)
	public void Login_InValidLogin(Map <String, String> map){
	
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

		// Launch Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@name='logid']")).sendKeys(map.get("Username"));
		driver.findElement(By.xpath("//input[@name='pswd']")).sendKeys(map.get("Password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String exp = map.get("Expectedmsg");
		String act = driver.findElement(By.xpath("//b[contains(text(),'Sorry we']")).getText();
		if(act.equals(exp)){
			System.out.println("Login un-successful - ");
		}
	}
	
}
