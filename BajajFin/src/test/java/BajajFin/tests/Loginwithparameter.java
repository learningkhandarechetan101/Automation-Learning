package BajajFin.tests;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BajajFin.TestComponents.BaseTest;

public class Loginwithparameter extends BaseTest {

	Logger log = LogManager.getLogger("Locators");

	@Parameters({ "Username", "Password" })

	// Test case to Take Screenshot of Full Page.
	@Test
	public void submit(String name, String pwd) throws InterruptedException, IOException {
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		log.info("UserName Entered " + name);
		Thread.sleep(5000);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		log.info("Password Entered " + pwd);
	//	super.Artifacts();
	}

	// Test case to Take Screenshot of Perticular Element or Crop image.
	@Test
	public void TocaptureHeader(WebElement header) throws IOException, InterruptedException  {
		
		header=driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']"));
		boolean headerDispaly=header.isDisplayed();

		if (headerDispaly == true) {
			log.info("Header Screenshot captured as Expected");
			super.Artifacts(header);
		} else {
			log.info("Header Screenshot is not Captured");
		
		}
	}

	}
