package BajajFin.tests;
import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import BajajFin.TestComponents.BaseTest;

public class PractisePage extends BaseTest  {


	Logger log= LogManager.getLogger("Locators");
	
	
	@Test(priority = 1)
	public void Link() throws InterruptedException {
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		log.info("Clicked on Link");
		driver.navigate().back();	
		Thread.sleep(5000);
		log.info("Navigated back on Practise page");
	
		
	}

	@Test(priority = 2)
	public void Button() throws InterruptedException {
		Boolean Home = driver.findElement(By.xpath("//button[contains(text(),'Home')]")).isDisplayed();
		log.info(Home);
		Thread.sleep(2000);

		Boolean Practice = driver.findElement(By.xpath("//button[contains(text(),'Practice')]")).isDisplayed();
		log.info(Practice);

		Boolean Login = driver.findElement(By.xpath("//button[contains(text(),'Login')]")).isDisplayed();
		log.info(Login);

		Boolean SignUp = driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).isDisplayed();
		log.info(SignUp);

		if (Home = true && Practice == true && Login == true && SignUp == true) {
			log.info("All the button is displayed as Expected");

		} else {
			log.info("button is not displayed.");

		}
	}

	@Test(priority = 3)
	public void DropDowns() throws InterruptedException {
		WebElement dropDownfield = driver.findElement(By.id("dropdown-class-example"));
		dropDownfield.click();
		Select d = new Select(dropDownfield);
		log.info("DropDown Field Selected");
		d.selectByVisibleText("Option2");
		log.info("Option2 Selected from DropDown");
	}

	@Test(priority = 4)
	public void SwitchWindow() throws InterruptedException {
		driver.findElement(By.id("openwindow")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentwindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		log.info("Driver moved on Child window Succesfully");

	}

	@Test(priority = 5)
	public void MouseHover() throws InterruptedException {

		Actions a = new Actions(driver);
		WebElement button = driver.findElement(By.id("mousehover"));
		log.info("Mouse hover on Expected button");
		Thread.sleep(2000);

	}
	
	
	


}
