package Day9.FD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_Ecommerce{

	@FindBy(xpath="//div[@id = 'account']/a[1]/span")
	public WebElement lnk_MyAccount;
	
	@FindBy(id="log")
	public WebElement txt_Username;
	
	@FindBy(id="pwd")
	public WebElement txt_Password;
	
	@FindBy(id="login")
	public WebElement btn_Login;
	
	@FindBy(xpath="//div[@id='account_logout']/a")
	public WebElement lnk_LogOut;
	
	public PageFactory_Ecommerce(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterDetails(String username, String password){
		lnk_MyAccount.click();
		txt_Username.sendKeys(username);
		txt_Password.sendKeys(password);
		btn_Login.click();
		
	}
	public void logout(){
		
		lnk_LogOut.click();
	}
	
}
