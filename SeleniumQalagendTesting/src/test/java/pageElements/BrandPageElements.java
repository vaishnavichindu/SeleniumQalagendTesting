package pageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.CommonAction;
import Utilities.JavascriptExecutors;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;

public class BrandPageElements extends CommonAction{
WebDriver driver;
	
	WaitConditions wait=new WaitConditions();
	JavascriptExecutors script=new JavascriptExecutors();
	public BrandPageElements(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	
	
	} 
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement Add;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
	public WebElement login;
	
	@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
	public WebElement endTour;
	
	@FindBy(xpath="//*[@id=\"tour_step5_menu\"]/span[1]")
	public WebElement products;
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[8]/a/span")
	public WebElement units;
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[10]/a/span")
	public WebElement brands;
	
	
	@FindBy(xpath="//table[contains(@id,'brands_table')]/tbody/tr/td[1]")
	public WebElement brandWebTableRowName;
	
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement brandName;
	
	@FindBy(xpath="//*[@id=\"description\"]")
	public WebElement brandDescription;

	
	@FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[1]")
	public WebElement brandSave;
	
	@FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[2]")
	public WebElement brandClose;
	
	@FindBy(xpath="//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement brandSearch;
	
	
	
	@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr[1]/td[3]/button[2]")
	public WebElement branchDelete;
	

	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	public WebElement Ok;
	
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[1]/button")
	public WebElement Cancel;
	
	@FindBy(xpath="//*[@id=\"brands_table\"]/tbody/tr[1]/td[3]/button[1]")
	public WebElement brandEdit;
	
	@FindBy(xpath="//form/div[3]/button[1]")
	public WebElement brandUpdate;
	
	@FindBy(xpath="//*[@id=\"brands_table_length\"]/label/select")
	public WebElement brandSelect;
	
	@FindBy(xpath="//*[@id=\"brands_table_next\"]/a")
	public WebElement brandNexts;
	
	
	//*[@id="brands_table_next"]/a
	
	By bdel=By.xpath("//*[@id=\"brands_table\"]/tbody/tr[1]/td[3]/button[2]");
	
	
	By no_match=By.xpath("//table[contains(@id,'unit_table')]/tbody/tr/td[1]");
	By del=By.xpath("//table[contains(@id,'unit_table')]/tbody/tr/td[4]/button");
	By next=By.xpath("//*[@id=\"brands_table_paginate\"]/ul/li[2]/a");
	By brandNext=By.xpath("//*[@id=\"brands_table_next\"]/a");
	By updt=By.xpath("//form/div[3]/button[1]");

	public void login(String id,String key)
	{

		sendKeys(username,id);
		sendKeys(password,key);
		click(login);
		click(endTour);
		
		
		
	}
	private String brandNames="Vai-Greenland";
	
	public String getSearchText() {
		return brandNames;
	}
	public void brand_add()
	{
		click(products);
		click(brands);
		click(Add);
		sendKeys(brandName, brandNames);
		sendKeys(brandDescription, "gl");
		click(brandSave);
		
		
		
	}
	public String brand_search(String name)
	{
		click(brands);
		sendKeys(brandSearch,name);
		wait.explicitWait_Seconds(driver,brandNext,20);
		return getText(brandWebTableRowName);
		
	}
	
	public void brand_delete()
	{
		wait.explicitWait_Seconds(driver,bdel,20);
		click(branchDelete);
		click(Ok);
	}
	public void brand_cancel() {
		// TODO Auto-generated method stub
		wait.explicitWait_Seconds(driver,bdel,20);
		click(branchDelete);
		click(Cancel);
		
	}
	public void brand_edit(String editName)
	{
		wait.explicitWait_Seconds(driver,bdel,20);
		click(brandEdit);
		wait.explicitWait_Seconds(driver,updt,20);
		brandName.clear();
		sendKeys(brandName,editName);
		click(brandUpdate);
		
		
		
	}
	public void brand_entries(String value)
	{
		Select obj=new Select(brandSelect);
		obj.selectByValue(value);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wait.explicitWait_Seconds(driver,next,20);
		script.scrollToElement(brandNexts, driver);
		
		
		
	

	}


}
