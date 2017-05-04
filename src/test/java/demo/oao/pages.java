package demo.oao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pages extends Base{
	
	public WebDriver driver;
	
	
	public pages(WebDriver driver){
		this.driver	=	driver;
	}
	
	public By SearchVal = By.id("lst-ib");
	
	public WebElement getSKey(){
		return driver.findElement(SearchVal);
	}

}
