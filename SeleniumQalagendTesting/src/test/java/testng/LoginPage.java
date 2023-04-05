package testng;

import org.testng.annotations.Test;


import Utilities.ReadConfigProperty;
import Utilities.Retry;
import Utilities.WebDriverManager;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
@Listeners(Utilities.TestListener.class)
public class LoginPage extends WebDriverManager{
	String expectedUrl="https://qalegend.com/billing/public/login";
	public static WebDriver driver;
	UnitPageElements webelement;
  @Test(priority = 0,enabled =true,dataProvider ="logins")
  public void loginSite(String id,String password) {
	  webelement.login(id,password);
	  Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
	 
	  }
  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(@Optional String browser) {
	 
	  driver=launchBrowser(browser,expectedUrl);
	  webelement = new UnitPageElements(driver);
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
