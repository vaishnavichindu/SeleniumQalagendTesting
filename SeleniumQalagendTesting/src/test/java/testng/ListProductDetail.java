package testng;

import org.testng.annotations.Test;

import Utilities.ExcelDataProvider;
import Utilities.Retry;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import listener.TestListener;
import pageElements.BrandPageElements;
import pageElements.ListProductPageElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
@Listeners(Utilities.TestListener.class)
public class ListProductDetail extends WebDriverManager{
	String expectedUrl="https://qalegend.com/billing/public/login";
	public static WebDriver driver;
	ListProductPageElements elements;
	WaitConditions wait=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins")
  public void   t001_login(String id,String password) throws IOException  {
	  elements.login(id,password);
	  Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
  }
  @Test(priority =1,enabled = true)
  public void   t002_addProductDetails() throws InterruptedException  {
	  
	  elements.add_Details();
	  Assert.assertEquals(driver.getCurrentUrl(),"https://qalegend.com/billing/public/products");

	  

	
  }
  @BeforeTest
  public void beforeTest() { 
	  driver=launchBrowser("chrome",expectedUrl);
	  elements = new ListProductPageElements(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @DataProvider(name="logins")
  public Object[][] getDataFromDataprovider(){
	  return new Object[][] 
	  	{
	          { "admin", "123456" }
	      
	      };

	}

}
