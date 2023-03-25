package testng;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelDataProvider;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import pageElements.BrandPageElements;




public class BrandPage{
	String expectedUrl="https://qalegend.com/billing/public/login";
	WebDriver driver;
	WebDriverManager webDriver;
	BrandPageElements elements;
	WaitConditions wait=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="excelData",dataProviderClass =ExcelDataProvider.class)
  public void   t001_brandsAdd(String id,String password)  {
	  elements.login(id,password);
	  elements.brand_add();
	
  }
  @Test(priority = 1,enabled =true)
  public void   t002_brandSearch() {
   String name=elements.getSearchText();
     String searchName= elements.brand_search(name);
	 Assert.assertEquals(searchName,name);
  }
  @Test(priority = 2,enabled =true)
  public void   t003_brandDeleteConfirm() {
	 
	  String name=elements.getSearchText();
	     String searchName= elements.brand_search(name);
		 if(searchName.equalsIgnoreCase(name))
		 {
			 Assert.assertTrue(true);
			 elements.brand_delete(); 
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
  public void   t004_brandDeleteCancel() {
	 
	  String name=elements.getSearchText();
	     String searchName=elements.brand_search(name);
		 Assert.assertEquals(searchName,name);
		 elements.brand_cancel();
  }
  @Test(priority = 4,enabled = true)
  public void   t005_brandEdit() {
	
	  String name=elements.getSearchText();;
	  String editName="Vais-Greenland";
	     String searchName= elements.brand_search(name);
		  if(searchName.equalsIgnoreCase(name))
			 {
				 Assert.assertTrue(true);
				 elements.brand_edit(editName); 
				 String searchFind= elements.brand_search(editName);
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
  @Test(priority = 5,enabled = true)
  public void t006_brandEntries() throws InterruptedException
  {
	  driver.navigate().refresh();
	  String entry="100";
	 elements.brand_entries(entry);
	  
  }
  
  

  @BeforeTest
  public void beforeTest() {
	  webDriver=new WebDriverManager();
	  driver= webDriver.launchBrowser("chrome",expectedUrl);
	  elements = new BrandPageElements(driver);
  }

  @AfterTest
  public void afterTest() {
	driver.close();
  }
//  @DataProvider(name="logins")
//  public Object[][] getDataFromDataprovider()
//  {
//	  return new Object[][]
//			  {
//		          {"admin","123456"}
//			  };
//  }

}
