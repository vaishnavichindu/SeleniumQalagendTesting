package pageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import Utilities.CommonAction;
import Utilities.JavascriptExecutors;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;

public class UnitPageElements extends CommonAction {
	WebDriver driver;
	
	WaitConditions wait=new WaitConditions();
	JavascriptExecutors script=new JavascriptExecutors();
	public UnitPageElements(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	
	
	} 
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
	
	@FindBy(xpath="//*[@id=\"unit_table_filter\"]/label/input")
	public WebElement search;
	
	@FindBy(xpath="//table[contains(@id,'unit_table')]/tbody/tr/td[1]")
	public WebElement webTableRowName;
	@FindBy(id="actual_name")
	public WebElement Name;
	
	@FindBy(id="short_name")
	public WebElement Shortname;
	
	
	@FindBy(id="allow_decimal")
	public WebElement Allow_decimal;
	
	@FindBy(xpath="//*[@id=\"unit_add_form\"]/div[3]/button[1]")
	public WebElement Save;
	
	@FindBy(xpath="//*[@id=\"unit_table\"]/tbody/tr[1]/td[4]/button[2]")
	public WebElement Delete;
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	public WebElement Ok;
	
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[1]/button")
	public WebElement Cancel;
	
	
	@FindBy(xpath="//table[contains(@id,'unit_table')]/tbody/tr/td[4]/button[1]")
	public WebElement edit;
	
	
	@FindBy(xpath="//form/div[3]/button[1]")
	public WebElement update;
	
	
	@FindBy(xpath="//*[@id=\"unit_table_length\"]/label/select")
	public WebElement select;
	
	
	@FindBy(xpath="//div[contains(@id,'unit_table_info')]")
	public WebElement show_entries;
	
	@FindBy(xpath="//*[@id=\"unit_table_paginate\"]/ul/li[2]/a")
	public WebElement nexts;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement Add;
	

	
	
	By no_match=By.xpath("//table[contains(@id,'unit_table')]/tbody/tr/td[1]");
	By del=By.xpath("//table[contains(@id,'unit_table')]/tbody/tr/td[4]/button");
	By next=By.xpath("//*[@id=\"unit_table_next\"]/a");
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
	public void setSearchText(String brandNames) {
		this.brandNames=brandNames;
	}
	public String unit_search(String name)
	{
		click(units);
		sendKeys(search,name);
		wait.explicitWait_Seconds(driver,next,20);
		return getText(webTableRowName);
		
	}
	public void unit_delete()
	{
		wait.explicitWait_Seconds(driver,del,20);
		click(Delete);
		click(Ok);
	}

	
	public void unit_add()
	{
		click(products);
		click(units);
		click(Add);
		sendKeys(Name, "Vai-gram");
		sendKeys(Shortname, "gram");
		Select obj=new Select(Allow_decimal);
		obj.selectByIndex(2);
		click(Save);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
	}
	public void unit_cancel()
	{
		wait.explicitWait_Seconds(driver,del,20);
		click(Delete);
		click(Cancel);
		
	}
	public void unit_edit(String editName)
	{
		wait.explicitWait_Seconds(driver,del,20);
		click(edit);
		wait.explicitWait_Seconds(driver,updt,20);
		Name.clear();
		sendKeys(Name,editName);
		click(update);
		
		
		
	}
	public void unit_entries(String value)
	{
		Select obj=new Select(select);
		obj.selectByValue(value);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		wait.explicitWait_Seconds(driver,next,20);
		script.scrollToElement(nexts, driver);
		
		
		
	

	}

	

}
