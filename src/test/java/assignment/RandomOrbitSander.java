package assignment;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomOrbitSander {

	@Test
	public void OrbitSander() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com");

		WebElement categories = driver.findElement(By.linkText("Categories"));
		// categories.click();

		WebElement target = driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[2]/ul/li[2]/a"));

		Actions myKey = new Actions(driver);

		Action myAction = myKey.click(categories).moveToElement(target).click().build();

		myAction.perform();

		WebElement sanderCheckbox = driver.findElement(By.xpath("//*[@id='filters']/div[1]/ul/div[2]/label/input"));
		sanderCheckbox.click();
		
		
		WebElement randomOrbitSander = driver
				.findElement(By.xpath("/html/body/app-root/div/app-category/div[2]/div[2]/div[1]/a[4]"));
		randomOrbitSander.click();

		String headingText = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/h1"))
				.getText();

		Assert.assertEquals(headingText, "Random Orbit Sander");
		driver.quit();

	}

}
