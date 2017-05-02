package com.TestNG.firstTestCase;

import static org.testng.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import au.com.bytecode.opencsv.CSVReader;

//ReadProperties readProperties;

public class FirstTestCase {
	Properties prop = new Properties();
	ReadProperties readProperties = new ReadProperties();
	
	InputStream input = null;
	
	//readProperties.getPropertyFromConfig();
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		 new DesiredCapabilities();
         URL serverurl = new URL("http://localhost:9515");
         DesiredCapabilities capabilities = DesiredCapabilities.chrome();
          
         driver = new RemoteWebDriver(serverurl,capabilities);
//		 System.setProperty("webdriver.chrome.driver", readProperties.getPropertyFromConfig("driverpath"));
//		  driver=new ChromeDriver();
	}
	
	// @AfterTest
	// public void QuitTest(){
	// 	driver.quit();
	// }
	
  @Test(dataProvider="getData")
  public void test(String title,String fname,String lname,String mname,String email,String mobile,String address,String ftn,String excemption_Reason) throws InterruptedException {
	  driver.get("http://compressedapp.herokuapp.com/home");
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
		driver.findElement(By.name("apply_EVR")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("aus_citizen")).click();
		driver.findElement(By.id("age_test")).click();
		driver.findElement(By.name("single")).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("title")).click();
		driver.findElement(By.cssSelector("option[value='"+title+"']")).click();
		driver.findElement(By.name("fname")).sendKeys(fname);
		assertFalse(false, "fail to test message");
		driver.findElement(By.name("mname")).sendKeys(mname);
		driver.findElement(By.name("lname")).sendKeys(lname);
//		Thread.sleep(3000);
		driver.findElement(By.className("md2-datepicker-placeholder")).click();
		Thread.sleep(1000);
//		driver.findElement(By.className("md2-calendar-day today focus curr-month")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]")).click();
//		Thread.sleep(3000);

		driver.findElement(By.name("personal_btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.name("mobile")).sendKeys(mobile);

		driver.findElement(By.name("contact_btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("appn_saved")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("address")).sendKeys(address);
		// this.driver.sleep(1000);
		driver.findElement(By.name("address")).sendKeys(Keys.DOWN);
		Thread.sleep(2000);

		driver.findElement(By.className("form-heading")).click();
		driver.findElement(By.name("postal_home_address_flag")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("contact_btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("tfn")).sendKeys(ftn);
		driver.findElement(By.name("tfn_btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("skip_tfn_id_check")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("tfn_home")).click();
	  
	  
  }
  
  @DataProvider
  public Object[][] getData(){
	  Object[][] data=new Object[2][9];
	  
	  try {
		CSVReader reader = new CSVReader(new FileReader(readProperties.getPropertyFromConfig("filepath")));
		
		String [] csvCell;
		int i=0;
		  //while loop will be executed till the last line In CSV.
		  try {
			while ((csvCell = reader.readNext()) != null) {
				
				  data[i][0]=csvCell[0];
				  data[i][1]=csvCell[1];
				  data[i][2]=csvCell[2];
				  data[i][3]=csvCell[3];
				  data[i][4]=csvCell[4];
				  data[i][5]=csvCell[5];
				  data[i][6]=csvCell[6];
				  data[i][7]=csvCell[7];
				  data[i][8]=csvCell[8];
				  
				  i++;
				  			
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  return data;
  }
}
