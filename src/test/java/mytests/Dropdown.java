package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	@Test
	public void DropDown() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement dropdownEle = driver.findElement(By.xpath("//*[@id='dropdown']"));
		
		//drop down expect web element
		
		Select dropdown = new Select(dropdownEle);
		
		
		// different way to select from drop down
		dropdown.selectByVisibleText("Option 1");
		dropdown.selectByValue("2");
		dropdown.selectByIndex(1);
		
		// option 1 is selected 
		WebElement option1 = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]")); 
		
		//"selected is the attribute not the value selected='selected' "
		
		String attributeValue =option1.getDomAttribute("selected");
		
		Assert.assertEquals(attributeValue, "true");
		
		driver.quit();
		
		
		
	
		
	}
}
