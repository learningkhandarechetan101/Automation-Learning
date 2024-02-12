package BajajFin.TestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	Logger log = LogManager.getLogger("BaseTest");
	public WebDriver driver;
	
	@BeforeMethod
	public WebDriver intializeDriver() throws IOException, InterruptedException {
		// Properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resource//GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String Link=prop.getProperty("Link");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(Link);
			Thread.sleep(5000);
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	
	}
	
	public void Artifacts(WebElement header) throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		//TakesScreenshot screenshot= ((TakesScreenshot)driver);
		//File src=screenshot.getScreenshotAs(OutputType.FILE);
		File src=header.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Chetan_imp\\Eclipsworkspace\\BajajFin\\src\\Screenshots\\FullScreenshot7.png");
		FileUtils.copyFile(src, dest);
		log.info("Screenshot Capture");
	}

	
}



