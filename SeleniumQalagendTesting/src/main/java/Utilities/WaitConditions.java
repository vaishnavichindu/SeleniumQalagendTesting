package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConditions {
	
	public void implicitWait_Seconds(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	public void implicitWait_Minutes(WebDriver driver,int minutes)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(minutes));
	}
	public WebElement explicitWait_Minutes(WebDriver driver,By value,int minutes)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(minutes));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(value));
	}
	public WebElement explicitWait_Seconds(WebDriver driver,By value,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(value));
		
		
	
	}
	
	
	

}
