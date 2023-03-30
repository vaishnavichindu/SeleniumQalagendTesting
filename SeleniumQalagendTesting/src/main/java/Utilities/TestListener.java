package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;





//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends WebDriverManager implements ITestListener{
	
	    

	
WebDriver driver;
@Override
public synchronized void onTestStart(ITestResult result) {
    System.out.println((result.getMethod().getMethodName() + " started!"));
    test = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
    
}


      @Override
	    public synchronized void onTestFailure(ITestResult result) {
		String name=result.getName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			System.out.println(driver);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				System.out.println(name);
				Screenshot(name,driver);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//test.log(LogStatus.FAIL,result.getMethod().getMethodName() + "Failed!" );
			 System.out.println((result.getMethod().getMethodName() + " failed!"));
		        test.fail(result.getThrowable());
		
	  } 
	   @Override
	    public synchronized void onTestSuccess(ITestResult result) {
	    
		 //  test.log(LogStatus.PASS,result.getMethod().getMethodName() + "passed!" );
		   System.out.println((result.getMethod().getMethodName() + " passed!"));
	        test.pass("Test passed");
	    }

	   

	    @Override
	    public synchronized void onTestSkipped(ITestResult result) {
	    	
	    	//test.log(LogStatus.SKIP,result.getMethod().getMethodName() + "skipped!" );
	    	  System.out.println((result.getMethod().getMethodName() + " skipped!"));
	          test.skip(result.getThrowable());
	     
	    }
	 @Override
	    public synchronized void onFinish(ITestContext context) {
		 
	        
	    }
	 
	 

	

}
