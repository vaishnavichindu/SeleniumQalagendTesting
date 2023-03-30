package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class WebDriverManager {
	WebDriver driver;
	WaitConditions wc = new WaitConditions();
//	public static ExtentTest test;
//	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	public WebDriver launchBrowser(String browser, String url) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chorme.driver",
					"C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);

		}
		if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		wc.implicitWait_Seconds(driver, 20);
		driver.get(url);

		driver.manage().window().maximize();
		return driver;

	}

	public void Screenshot(String getMethodName, WebDriver driver1) throws IOException {
		System.out.println("scrshot");
		TakesScreenshot scrShot = ((TakesScreenshot) driver1);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyyMMddhhmmssms'.txt'").format(new Date());
		File DestFile = new File(
				"C:\\Users\\user\\git\\SeleniumQalagendTesting\\SeleniumQalagendTesting\\src\\test\\resources\\screenshot\\"
						+ getMethodName + filename + ".png");
		// Copy file at destination

		FileUtils.copyFile(scrFile, DestFile);

	}

	@BeforeSuite
	public static void startTest() {

		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//TestReport//ExtentReportResults.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// htmlReporter.config().setTestViewChartLocation();
		// htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Qalagend Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@AfterSuite
	public static void endTest() {

		extent.flush();

	}

//	@AfterMethod
//	 public void afterMethod(ITestResult result)
//	 {
//		
//		 int SUCCESS = 1;
//		  int FAILURE = 2;
//		 if(result.getStatus() == 2) {
//		 test.log(LogStatus.FAIL,result.getMethod().getMethodName() + "Failed!" );
//		 }
//		 if(result.getStatus() == 1) {
//			 test.log(LogStatus.PASS,result.getMethod().getMethodName() + "passed!" );
//			 }
//		 
//	 }
	@BeforeSuite(alwaysRun = true)
	public void setupSuite(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzerClass(Retry.class);
		}
	}

}
