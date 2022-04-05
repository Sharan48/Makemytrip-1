package pomRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[@class='landingSprite myIconWhite']")
	private WebElement google;
	
	@FindBy(xpath="//span[@class='langCardClose']")
	private WebElement langClose;
	
	@FindBy(xpath="//span[.='From']")
	private WebElement fromTF;

}
