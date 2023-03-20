package testng;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import pageElements.CategoryPageElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CategoryPage  {
	String expectedUrl="https://qalegend.com/billing/public/login";
	WebDriver driver;
	CategoryPageElements element;
	WaitConditions wc=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins")
  public void   t001_categoryAdd(String id,String password)  {
	  element.login(id,password);
	  element.category_add();
	
	
  }
  @Test(priority = 1,enabled =false)
  public void   t002_categorySearch() {
     String name=element.getSearchText();
     String searchName= element.category_search(name);
	 System.out.println(searchName);
	 Assert.assertEquals(searchName,name);
  }
  @Test(priority = 2,enabled =false)
  public void   t003_categoryDeleteConfirm() {
	 
	     String name=element.getSearchText();
	     String searchName= element.category_search(name);
		  System.out.println(searchName);
		 if(searchName.equalsIgnoreCase(name))
		 {
			 Assert.assertTrue(true);
			 element.category_delete(); 
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
  @Test(priority = 3,enabled =true)
  public void   t004_categoryDeleteCancel() {
	 
	  String name=element.getSearchText();
	     String searchName=element.category_search(name);
		  System.out.println(searchName);
		 Assert.assertEquals(searchName,name);
		 element.category_cancel();
  }
  @Test(priority = 4,enabled = false)
  public void   t005_categoryEdit() {
	
	  String name=element.getSearchText();;
	  String editName="Vais-Grocery";
	     String searchName= element.category_search(name);
		  System.out.println(searchName);
		  if(searchName.equalsIgnoreCase(name))
			 {
				 Assert.assertTrue(true);
				 element.category_edit(editName); 
				 String searchFind= element.category_search(editName);
				 if(searchFind.equalsIgnoreCase(editName))
				 {
					 Assert.assertTrue(true);
				 }
				 else
				 {
					 Assert.fail("Not found");
				 }
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
  @Test(priority = 5,enabled = false)
  public void t006_categoryEntries() throws InterruptedException
  {
	  driver.navigate().refresh();
	  String entry="100";
	 element.category_entries(entry);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager webDriver=new WebDriverManager();
	  driver=webDriver.launchBrowser("chrome",expectedUrl);
	  element = new CategoryPageElements(driver);
  }

  @AfterTest
  public void afterTest() {
  }
  
  @DataProvider(name="logins")
  public Object[][] getDataFromDataprovider(){
	  return new Object[][] 
	  	{
	          { "admin", "123456" }
	      
	      };

	}

}
