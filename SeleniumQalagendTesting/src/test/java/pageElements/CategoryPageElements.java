package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.JavascriptExecutors;
import Utilities.WaitConditions;

public class CategoryPageElements extends CommonAction{
	WebDriver driver;
	
	WaitConditions wait=new WaitConditions();
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

	public void login(String id, String key) {
		// TODO Auto-generated method stub
		sendKeys(username,id);
		sendKeys(password,key);
		click(login);
		click(endTour);
		
	}

	private String category="Vai-Greenland";
	
	public String getSearchText() {
		return category;
	}
	public void category_add()
	{
//		click(products);
//		click(brands);
//		click(Add);
//		sendKeys(brandName, category);
//		sendKeys(brandDescription, "gl");
//		click(brandSave);
//		
		
		
	}

}
