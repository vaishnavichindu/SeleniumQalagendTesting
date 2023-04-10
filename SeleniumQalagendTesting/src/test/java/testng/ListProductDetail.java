package testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import pageElements.ListProductPageElements;
//@Listeners(Utilities.TestListener.class)
public class ListProductDetail extends WebDriverManager{
	String expectedUrl="https://qalegend.com/billing/public/login";
	public static WebDriver driver;
	ListProductPageElements elements;
	WaitConditions wait=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins",groups = {"smoke"})
  public void   t001_login(String id,String password) throws IOException  {
	  elements.login(id,password);
	  Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
	  
	//  test.log(LogStatus.PASS, "passed");
  }
  
  @Test(priority =1,enabled = true,groups = {"smoke","sanity"})
  public void   t002_addProductDetails() throws InterruptedException  {
	  
	 elements.add_Details();
	  Assert.assertEquals(driver.getCurrentUrl(),"https://qalegend.com/billing/public/products");
	//  test.log(LogStatus.PASS, "passed");

	  

	
  }
  @Test(priority =2,enabled = true,groups = {"Regression"})
  public void   t003_addProductFail() throws InterruptedException  {
	  
	  Assert.assertEquals(driver.getCurrentUrl(),"https://qalegend.com/billing/public/product");
	//  test.log(LogStatus.PASS, "passed");

	  

	
  }
  @Test(priority =3,enabled = true,groups = {"sanity"})
  public void   t004_addProductskip() throws InterruptedException  {
	  
	throw new SkipException("Test case skipped");

	  

	
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
