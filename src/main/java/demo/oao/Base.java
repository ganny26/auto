package demo.oao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver=null;
	public WebDriver getWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		return driver;
	}

}
