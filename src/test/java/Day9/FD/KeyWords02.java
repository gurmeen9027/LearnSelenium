package Day9.FD;

import org.openqa.selenium.WebElement;

public class KeyWords02 {
	
	public void enterValue(WebElement ele, String val){
		
		ele.sendKeys(val);
	}
	
	public void clickEvent(WebElement ele){
		
		ele.click();
		
	}

}
