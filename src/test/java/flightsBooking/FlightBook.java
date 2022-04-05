package flightsBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtility.Baseclass;

public class FlightBook extends Baseclass {
	@Test
	public void bookFlightForDiffLoc() throws Throwable{
		WebElement loginele = driver.findElement(By.xpath("//span[@class='landingSprite myIconWhite']"));
		wLib.waitAndClick(loginele);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[.='From']"));
		wLib.waitAndClick(ele);
//		wLib.waitforElement(driver, ele);
//		driver.findElement(By.xpath("//span[.='From']")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore, India')]")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//p[.='Delhi, India']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		
	}

}
