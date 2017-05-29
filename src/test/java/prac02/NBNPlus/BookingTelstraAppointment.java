package prac02.NBNPlus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BookingTelstraAppointment {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://nbnplustest.service-now.com/login.do");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user_name")).sendKeys("d722860");
		driver.findElement(By.id("user_password")).sendKeys("d722860");
		driver.findElement(By.id("sysverb_login")).click();
		
		Keys.chord(Keys.CONTROL,"t");
		
		
//		Actions newTab = new Actions(getMyDriver());
//		newTab.keyDown(Keys.CONTROL).keyDown(Keys.INSERT.T).click().keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
//		
//		driver.findElement(By.linkText("Search")).click();
		
		
	}
	
	

}
