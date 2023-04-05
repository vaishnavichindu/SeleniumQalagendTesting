package pageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonAction;
import Utilities.ExcelReader;
import Utilities.JavascriptExecutors;
import Utilities.RandomGenerator;
import Utilities.SelectClass;
import Utilities.WaitConditions;
import Utilities.WebDriverManager;

public class AddProductPageElements extends CommonAction{
	WaitConditions wait=new WaitConditions();
	JavascriptExecutors script=new JavascriptExecutors();
	SelectClass select=new SelectClass();
	ExcelReader excel=new ExcelReader();
	RandomGenerator random=new RandomGenerator();
	WebDriver driver;
	public AddProductPageElements(WebDriver driver) {
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
	
	@FindBy(xpath="//li[@id='tour_step5']/a/span")
	public WebElement products;
	
	@FindBy(xpath="//li[@id='tour_step5']/ul/li[2]/a")
	public WebElement add_Product;
	
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
	
	@FindBy(id="upload_image")
	public WebElement uploadImage;
	
	@FindBy(xpath="//*[@id=\"product_table_filter\"]/label/input")
	public WebElement productSearch;
	
	@FindBy(xpath="//*[@id=\"product_table\"]/tbody/tr[1]/td[3]")
	public WebElement productTableData;
	
	@FindBy(xpath="//*[@id='product_table']/tbody/tr[1]/td[1]/input")
	public WebElement checkBox;
	
	@FindBy(xpath="//input[@id='delete-selected']")
	public WebElement deleteSelected;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/div[2]/button")
	public WebElement deleteOk;
	
	@FindBy(xpath="//*[@id='deactivate-selected']")
	public WebElement deactivate;
	
	
	@FindBy(xpath="//*[@id=\"product_table\"]/tbody/tr[9]/td[3]/span")
	public WebElement inactiveGetText;
	
	@FindBy(xpath="//*[@id=\"product_table\"]/thead/tr/th[3]")
	public WebElement productSort;
	
	
	
	@FindBy(xpath="//*[@id=\"name-error\"]")
	public WebElement productFieldRequired;
	
	
	
	
	

	
	
	
	
	
	
	
	
	public void login(String id,String key)
	{

		sendKeys(username,id);
		sendKeys(password,key);
		click(login);
		click(endTour);
		
		
		
	}
	private String product_name=excel.excelread()+String.valueOf(RandomGenerator.getRandomNumber());
	
	public String getProduct()
	{
		return product_name;
	}
	public void add_Details() throws InterruptedException {
		// TODO Auto-generated method stub
		click(products);
		click(add_Product);
		sendKeys(productName, product_name);
		select.dropdownByVisibleText(unitSelect,"Vai-gram");
//		System.out.println(unitSelection.size());
//		click(unit);
//		sendKeys(pleaseSelect,"Vai-");
//		System.out.println(unitSelection.size());
//		for(WebElement el:unitSelection)
//		{
//			
//				if((el.getText()).contains("Vai-gram"))
//				{
//					click(el);
//				}
//	
//		}
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
	public void display()
	{
		
	}
	public void add_image() throws InterruptedException {
		// TODO Auto-generated method stub
		click(products);
		click(add_Product);
		sendKeys(productName, product_name);
		select.dropdownByVisibleText(unitSelect,"Vai-gram");
		select.dropdownByVisibleText(brandSelect, "Vai-Greenland");
		select.dropdownByVisibleText(categorySelect, "Vai-Grocery");
		select.dropdown(barcodeSelect, 3);
		sendKeys(alertQuantity, "30");
		sendKeys(uploadImage,"C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\test\\resources\\images\\chickpea-.jpg");
		select.dropdown(applicableTax, 4);
		select.dropdown(sellingTax, 1);
		select.dropdown(productType, 0);
		sendKeys(exc_Tax, "5");
		sendKeys(inc_Tax, "3");
		click(save);
		
	}
	public String product_search(String name) {
		sendKeys(productSearch, name);
		String getTableText=getText(productTableData);
		return getTableText;
		
	}
	public void delete_selected() {
		// TODO Auto-generated method stub
		click(checkBox);
		click(deleteSelected);
		click(deleteOk);
		
	}
	public void deactivate() {
		// TODO Auto-generated method stub
		click(checkBox);
		click(deactivate);
		click(deleteOk);
		
	}
	public void sort() {
		// TODO Auto-generated method stub
		click(productSort);
		
	}
	public String requiredFieldValidating() throws InterruptedException {
		// TODO Auto-generated method stub
		click(products);
		click(add_Product);
		sendKeys(productName,"");
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
		String getText=getText(productFieldRequired);
		return getText;
		
		
	}
	

}
