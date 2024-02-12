package Bajaj.BajajFin;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctComponents {

	WebDriver driver;
	
	public AbstarctComponents() {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	public void Artifacts() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Chetan_imp\\Eclipsworkspace\\BajajFin\\src\\Screenshots\\fullScreenshot.png");
		FileUtils.copyFile(src, dest);
		
	}
	
	
	
}
