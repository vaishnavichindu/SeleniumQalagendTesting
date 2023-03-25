package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WebDriverManager {
	WebDriver driver;
	WaitConditions wc=new WaitConditions();
	public static ExtentTest test;
	public static ExtentReports report;


	public WebDriver launchBrowser(String browser, String url)
	{
		
		if(browser.equals("chrome"))
		{
		 System.setProperty("webdriver.chorme.driver", "C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver =new ChromeDriver(option);
			
		
		}
		if(browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\msedgedriver.exe");
			driver =new EdgeDriver();
				
		}
		if(browser.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\geckodriver.exe");
	        driver = new FirefoxDriver();
	       
	          
	     }
		
	    wc.implicitWait_Seconds(driver, 20);
        driver.get(url);
		
		driver.manage().window().maximize();
		return driver;
		

}
	public void Screenshot(String getMethodName,WebDriver driver1) throws IOException
	{
		System.out.println("scrshot");
		TakesScreenshot scrShot=((TakesScreenshot)driver1);
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		 String filename=new SimpleDateFormat("yyyyMMddhhmmssms'.txt'").format(new Date());
         File DestFile=new File("C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\test\\resources\\screenshot\\"+getMethodName+filename+".png");
               //Copy file at destination

          FileUtils.copyFile(scrFile, DestFile);
		
		
	}
	
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"//TestReport//ExtentReportResults.html");
	test = report.startTest("ExtentDemo");
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	@BeforeSuite(alwaysRun = true)
	public void setupSuite(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzerClass(Retry.class);
		}
	}

	

	


}
