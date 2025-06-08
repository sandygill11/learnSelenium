package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadingCheck {

	@Test
	public void headingCheck() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");

		String headingCheck = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		String myDesiredString = "to the-internet";

		if (headingCheck.contains(myDesiredString)) {
			Assert.assertEquals(myDesiredString, "to the-internet");
			System.out.println("Desired Text FOUND!!!");
		} else {
			System.out.println("Desired Text not found");
		}

		// Assert.assertEquals(headingCheck, "Welcome to the-internet");

		driver.quit();
	}
}
