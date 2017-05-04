package demo.oao;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Mytest {
	
	public  void Test1(){
		Base b= new Base();
		WebDriver driver= b.getWebDriver();
		Business SamplePage = PageFactory.initElements(driver, Business.class);
		String URL="https://www.google.co.in/";
		
		driver.get(URL);
		SamplePage.FillSearch("latitudefintech.com");
	}

}
