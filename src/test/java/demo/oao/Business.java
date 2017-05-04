package demo.oao;

import org.openqa.selenium.WebDriver;

public class Business extends pages {

	public Business(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void FillSearch(String searchKey){
		getSKey().clear();
		getSKey().sendKeys(searchKey);
	}

}
