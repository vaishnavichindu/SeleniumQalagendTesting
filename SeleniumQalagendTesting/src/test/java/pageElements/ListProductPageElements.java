package pageElements;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import Utilities.CommonAction;
import Utilities.ExcelReader;
import Utilities.JavascriptExecutors;
import Utilities.RandomGenerator;
import Utilities.SelectClass;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;
import listener.TestListener;

public class ListProductPageElements extends CommonAction {
WebDriver driver;
	
	WaitConditions wait=new WaitConditions();
	JavascriptExecutors script=new JavascriptExecutors();
	SelectClass select=new SelectClass();
	RandomGenerator random=new RandomGenerator();
	
	ExcelReader excel=new ExcelReader();
	public ListProductPageElements(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[1]/a/i")
	public WebElement listproduct;
	
	@FindBy(xpath="//*[@id=\"product_list_tab\"]/a/i")
	public WebElement productAdd;
	
	@FindBy(id="name")
	public WebElement productName;
	
	@FindBy(xpath="//*[@id=\"select2-unit_id-container\"]")
	public WebElement unit;
	
	@FindBy(xpath="//*[@id=\"unit_id\"]")
	public WebElement unitSelect;
	
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	public WebElement pleaseSelect;
	
	@FindBy(xpath="//span[@class='select2-results']/ul/li")
	public List<WebElement> unitSelection;
	
	@FindBy(xpath="//*[@id=\'brand_id\']")
	public WebElement brandSelect;
	
	@FindBy(xpath="//*[@id=\"category_id\"]")
	public WebElement categorySelect;
	
	@FindBy(xpath="//*[@id=\"barcode_type\"]")
	public WebElement barcodeSelect;
	
	@FindBy(xpath="//*[@id=\"alert_quantity\"]")
	public WebElement alertQuantity;
	
	@FindBy(xpath="//*[@id=\"tax_type\"]")
	public WebElement sellingTax;
	
	@FindBy(xpath="//*[@id=\"type\"]")
	public WebElement productType;
	
	@FindBy(xpath="//*[@id=\"tax\"]")
	public WebElement applicableTax;
	
	@FindBy(xpath="//*[@id=\"single_dpp\"]")
	public WebElement exc_Tax;
	
	@FindBy(xpath="//*[@id=\"single_dpp_inc_tax\"]")
	public WebElement inc_Tax;
	
	@FindBy(xpath="//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
	public WebElement save;
	
	
	
	
	
	

	public void login(String id,String key) throws IOException
	{

		sendKeys(username,id);
		sendKeys(password,key);
		click(login);
		
		click(endTour);
		
		
		
	}

private String product_name=excel.excelread()+String.valueOf(random.getRandomNumber());
	
	public String getProduct()
	{
		return product_name;
	}

	public void add_Details() throws InterruptedException {
		// TODO Auto-generated method stub
		click(listproduct);
		click(productAdd);
		sendKeys(productName, product_name);
		select.dropdownByVisibleText(unitSelect,"Vai-gram");
		select.dropdownByVisibleText(brandSelect, "Vai-Greenland");
		select.dropdownByVisibleText(categorySelect, "Vai-Grocery");
		select.dropdown(barcodeSelect, 3);
		sendKeys(alertQuantity, "30");
		select.dropdown(applicableTax, 4);
		select.dropdown(sellingTax, 1);
		select.dropdown(productType, 0);
		sendKeys(exc_Tax, "5");
		sendKeys(inc_Tax, "3");
		
		click(save);
		
		
		
	}

	
}
