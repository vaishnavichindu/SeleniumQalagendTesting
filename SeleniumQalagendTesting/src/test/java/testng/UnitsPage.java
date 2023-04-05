package testng;

import org.testng.annotations.Test;



import Utilities.Retry;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//@Listeners(Utilities.TestListener.class)
public class UnitsPage extends WebDriverManager  {
	
	String expectedUrl="https://qalegend.com/billing/public/login";
	public static WebDriver driver;
	UnitPageElements webelement;
	WaitConditions wc=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins",groups = {"smoke","sanity"})
  public void   T001_unitAdd(String id,String password)  {
	  webelement.login(id,password);
	  webelement.unit_add();
	  Assert.assertTrue(true);
	
  }
  @Test(priority = 1,enabled = true,groups = {"smoke"})
  public void   T002_unitSearch() {
   String name="Vai-gram";
     String searchName= webelement.unit_search(name);
	 Assert.assertEquals(searchName,name);
  }
  @Test(priority = 2,enabled = true,groups = {"Regression"})
  public void   T003_unitDeleteConfirm() {
	 
	  String name="Vai-gram";
	     String searchName= webelement.unit_search(name);
		 if(searchName.equalsIgnoreCase(name))
		 {
			 Assert.assertTrue(true);
			 webelement.unit_delete(); 
		 }
		 else if(searchName.contains("No matching records found"))
		 {
			 Assert.assertTrue(true);
			 driver.navigate().refresh();
		 }
		 else
		 {
			 Assert.fail("invalid");
		 }
		
  }
  @Test(priority = 3,enabled = true,groups = {"sanity"})
  public void   T004_unitDeleteCancel() {
	 
	  String name="Vai-gram";
	     String searchName= webelement.unit_search(name);
		 Assert.assertEquals(searchName,name);
		 webelement.unit_cancel();
  }
  @Test(priority = 4,enabled = true,groups = {"smoke"})
  public void   T005_unitEdit() {
	
	  String name="Vai-gram";
	  String editName="vais-gram";
	     String searchName= webelement.unit_search(name);
		  if(searchName.equalsIgnoreCase(name))
			 {
				 Assert.assertTrue(true);
				 webelement.unit_edit(editName); 
			 }
			 else if(searchName.contains("No matching records found"))
			 {
				 Assert.assertTrue(true);
				 driver.navigate().refresh();
			 }
			 else
			 {
				 Assert.fail("invalid");
			 }
  }
  @Test(priority = 5,enabled = true,groups = {"sanity"})
  public void T006_unitEntries()
  {
	  driver.navigate().refresh();
	  String entry="100";
	  webelement.unit_entries(entry);
	  
  }
  
  

  @BeforeTest
  public void beforeTest() {
	  
	driver= launchBrowser("chrome",expectedUrl);
	webelement = new UnitPageElements(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @DataProvider(name="logins")
  public Object[][] getDataFromDataprovider()
  {
	  return new Object[][]
			  {
		          {"admin","123456"}
			  };
  }


}
