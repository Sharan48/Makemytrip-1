package flightsBooking;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.Baseclass;

public class FlightBook extends Baseclass {
	ExtentTest test;
	@Test(dataProvider="readingData")
	public void bookFlightForDiffLoc(String src,String dstn) throws Throwable{
		
		test = reports.createTest("Creating contact").assignAuthor("Murgesh NB");
		 test.log(Status.INFO, "Click on Contact and create contact");
		
		driver.findElement(By.xpath("//body[@class='desktop in webp']")).click();
//		WebElement loginele = driver.findElement(By.xpath("//span[@class='landingSprite myIconWhite']"));
//		wLib.waitAndClick(loginele);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[.='From']"));
		wLib.waitAndClick(ele);
//		wLib.waitforElement(driver, ele);
//		driver.findElement(By.xpath("//span[.='From']")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'"+src+"')]")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//p[contains(text(),'"+dstn+"')]")).click();
		driver.findElement(By.xpath("//div[.='April 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='8']")).click();
		WebElement search = driver.findElement(By.xpath("//a[.='Search']"));
		wLib.waitAndClick(search);
		Thread.sleep(3000);
		try{
			driver.findElement(By.xpath("//button[.='OKAY, GOT IT!']")).click();
		}catch (Exception e) {
			System.out.println("Exception handled");
		}
		List<WebElement> flightList = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		int count=0;
		for (WebElement indi : flightList) {
			count++;
			System.out.println(indi.getText());
		}
		System.out.println(count);
		eLib.setData(count);
		
	}
	
	@DataProvider
	public Object[][] readingData() throws Throwable{
		
		
		FileInputStream fis=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet("Sheet1");
		int lr = sht.getLastRowNum();
		int lc = sht.getRow(1).getLastCellNum();
		System.out.println(lc+" "+lr);
		Object[][] objarr=new Object[lr][lc];
		for (int i = 0; i <lr; i++) {
			for (int j = 0; j < lc; j++) {
				objarr[i][j] =sht.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return objarr;
		
		
		
//		objarr[0][0]="Bangalore, India";
//		objarr[0][1]="Mumbai, India";
//		
//		objarr[1][0]="Bangalore, India";
//		objarr[1][1]="New York, US";
//		
//		objarr[2][0]="Bangalore, India";
//		objarr[2][1]="Pune, India";
//		
//		return objarr;
	}
	

}
