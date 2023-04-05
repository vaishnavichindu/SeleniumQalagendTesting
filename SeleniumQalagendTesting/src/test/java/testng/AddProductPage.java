package testng;

import org.testng.annotations.Test;

import Utilities.ExcelDataProvider;
import Utilities.ReadConfigProperty;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import pageElements.AddProductPageElements;
import pageElements.BrandPageElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//@Listeners(Utilities.TestListener.class)
public class AddProductPage extends WebDriverManager{
	
	String expectedUrl="https://qalegend.com/billing/public/login";
	public static WebDriver driver;
	AddProductPageElements elements;
	WaitConditions wait=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins",groups= {"smoke"})
  public void   t001_addProductLogin(String id,String password)  {
	  elements.login(id,password);
	  Assert.assertEquals(driver.getTitle(),"Home - QAlegend");
	  

	
  }
  @Test(priority =1,enabled = true,groups= {"smoke"})
  public void   t002_addProductDetails() throws InterruptedException  {
	  
	  elements.add_Details();
	  Assert.assertEquals(driver.getCurrentUrl(),"https://qalegend.com/billing/public/products");

	  

	
  }
  @Test(priority =2,enabled = true,groups= {"sanity"})
  public void   t003_addProductImage() throws InterruptedException  {
	  
	  		elements.add_image();

	  

	
  }
  
  @Test(priority =3,enabled = true,groups= {"Regression"})
  public void   t004_addProductSearch()  {
	  
	  		String name=elements.getProduct();
	  		String searchName= elements.product_search(name);
	  		System.out.println(searchName);
	  		Assert.assertEquals(searchName,name);

		 	

	
  }
  @Test(priority =4,enabled =true,groups= {"Regression"})
  public void   t005_deleteSelected()  {
	  
	     String name="vai";
	     String searchName= elements.product_search(name);
		 System.out.println(searchName);
		 if(searchName.contains(name))
		 {
			 Assert.assertTrue(true);
			 elements.delete_selected();
			 
		 }
		 else
		 {
			 Assert.fail();
		 }
 }
  @Test(priority =5,enabled =true,groups= {"Regression"})
  public void   t006_deactivateSelected() {
	  
	     String name="vai-chickpea";
	     String searchName= elements.product_search(name);
		 System.out.println(searchName);
		 if(searchName.contains(name))
		 {
			 Assert.assertTrue(true);
			 elements.deactivate();
			 
		 }
		 else
		 {
			 Assert.fail();
		 }
 }
  @Test(priority =6,enabled = true,groups= {"Regression"})
  public void   t007_productSort() {
	  String name="vai";
	     String searchName= elements.product_search(name);
		 System.out.println(searchName);
		 if(searchName.contains(name))
		 {
			 Assert.assertTrue(true);
	         elements.sort();
		 }
		 else
		 {
			 Assert.fail();
		 }
 }
  @Test(priority =7,enabled = true,groups= {"Regression"})
  public void   t008_requiredField() throws InterruptedException {
	  String requiredField=elements.requiredFieldValidating();
	  if(requiredField.contains("This field is required"))
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.fail("failed");
	  }
	 
 }
  
  
  
  
  @BeforeTest
  public void beforeTest() {
	  ReadConfigProperty objRead = new ReadConfigProperty();
	  driver=launchBrowser(objRead.browser,objRead.url);
	  elements = new AddProductPageElements(driver);
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
