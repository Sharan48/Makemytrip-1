package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	@BeforeSuite
	public void congifBS(){
		System.out.println("DB starts");
	}
	
	@BeforeClass
	public void configBC(){
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.makemytrip.com/");
	}
	
//	@BeforeMethod
//	public void configBM(){
//		
//	}
//	
//	@AfterMethod
//	public void configAM(){
//		System.out.println("Logout");
//	}
	
	@AfterClass
	public void configAC(){
		driver.close();
	}
	@AfterSuite
	public void configAS(){
		System.out.println("DB closes");
	}

}
