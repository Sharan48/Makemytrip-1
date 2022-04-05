package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitforElement(WebDriver driver,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitAndClick(WebElement element) throws InterruptedException{
		int i=0;
		while(i<20)
		{
			try{
				element.click();
				break;
			}catch (Exception e) {
				Thread.sleep(2000);
				i++;
			}
		}
	}

}
