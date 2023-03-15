package testng;

import org.testng.annotations.Test;

import Utilities.WaitConditions;
import pageElements.CategoryPageElements;
import pageElements.UnitPageElements;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class CategoryPage {
	String expectedUrl="https://qalegend.com/billing/public/login";
	WebDriver driver;
	CategoryPageElements element;
	WaitConditions wc=new WaitConditions();
  @Test(priority = 0,enabled = true,dataProvider ="logins")
  public void   T001_unitAdd(String id,String password)  {
	  element.login(id,password);
	  element.category_add();
	
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
