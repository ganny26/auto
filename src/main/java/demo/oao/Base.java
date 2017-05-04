package demo.oao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver=null;
	public WebDriver getWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "/var/lib/tools/2.7/chromedriver");
		  driver=new ChromeDriver();
		return driver;
	}

}
