package pageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.JavascriptExecutors;
import Utilities.SelectClass;
import Utilities.WaitConditions;

public class CategoryPageElements extends CommonAction{
	WebDriver driver;
	
	WaitConditions wait=new WaitConditions();
	SelectClass select=new SelectClass();
	JavascriptExecutors script=new JavascriptExecutors();
	public CategoryPageElements(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[9]/a/span")
	public WebElement categories;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button/i")
	public WebElement categoriesAdd;
	
	@FindBy(id="name")
	public WebElement categoryName;
	
	@FindBy(id="short_code")
	public WebElement categoryCode;
	
	@FindBy(xpath="	//*[@id=\"category_add_form\"]/div[3]/button[1]")
	public WebElement categorySave;
	
	@FindBy(xpath="//*[@id=\"category_table_filter\"]/label/input")
	public WebElement categorySearch;
	
	@FindBy(xpath="//table[contains(@id,'category_table')]/tbody/tr/td[1]")
	public WebElement categoryWebTableRowName;
	

	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[2]")
	public WebElement categoryDelete;
	
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
	public WebElement categoryOk;
	
	@FindBy(xpath="//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[1]")
	public WebElement categoryEdit;
	
	
	@FindBy(xpath="//*[@id=\"category_edit_form\"]/div[3]/button[1]")
	public WebElement categoryUpdate;
	
	@FindBy(xpath="//div[@class='swal-footer']/div/button")
	public WebElement categoryCancel;
	
	@FindBy(xpath="//*[@id=\"category_table_length\"]/label/select")
	public WebElement categorySelect;
	
	
	@FindBy(xpath="//*[@id=\"category_table_next\"]/a")
	public WebElement categoryNext;
	
	
	
	By categoryCancl=By.xpath("//div[@class='swal-footer']/div/button");
	By categoryNxt=By.xpath("//*[@id=\"category_table_next\"]/a");
	By categoryok=By.xpath("//*[@id=\"category_edit_form\"]/div[3]/button[2]");
	By categoryDel=By.xpath("//*[@id=\"category_table\"]/tbody/tr[1]/td[3]/button[2]");
	By categoryOK=By.xpath("/html/body/div[4]/div/div[4]/div[2]/button");
	By categorySaves=By.xpath("//*[@id=\"category_add_form\"]/div[3]/button[1]");
	By one=By.xpath("//*[@id=\"category_table_paginate\"]/ul/li[2]/a");
	
	

	public void login(String id, String key) {
		// TODO Auto-generated method stub
		sendKeys(username,id);
		sendKeys(password,key);
		click(login);
		click(endTour);
		
	}

	private String category="Vai-Grocery";
	
	public String getSearchText() {
		return category;
	}
private String categorys="Vais-Grocery";
	
	public String getSearchTexts() {
		return categorys;
	}
	public void category_add()
	{
		click(products);
		click(categories);
		click(categoriesAdd);
		sendKeys(categoryName, category);
		sendKeys(categoryCode, "12345");
		wait.explicitWait_Seconds(driver,categorySaves, 20);
		click(categorySave);
		
	}
	public String category_search(String name)
	{
		click(categories);
		sendKeys(categorySearch,name);
		wait.explicitWait_Seconds(driver,one,20);
		return getText(categoryWebTableRowName);
		
	}
	public void category_delete() {
		// TODO Auto-generated method stub
		click(categoryDelete);
		wait.explicitWait_Seconds(driver,categoryOK, 20);
		click(categoryOk);
		
	}
	
	public void category_edit(String editName) {
		// TODO Auto-generated method stub
		wait.explicitWait_Seconds(driver, categoryDel, 20);
		click(categoryEdit);
		wait.explicitWait_Seconds(driver, categoryok, 20);
		categoryName.clear();
		sendKeys(categoryName, editName);
		click(categoryUpdate);
		
		
		
	}
	public void category_cancel() {
		// TODO Auto-generated method stub
		wait.explicitWait_Seconds(driver, categoryDel, 20);
		click(categoryDelete);
		wait.explicitWait_Seconds(driver, categoryCancl, 20);
		click(categoryCancel);
		
	}
	public void category_entries(String entry) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		select.dropdown(categorySelect, entry);
		wait.explicitWait_Seconds(driver, categoryDel, 20);
		script.scrollToElement(categoryNext, driver);
		
	}

}
