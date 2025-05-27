package alerts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleAlerts2 {

	@Test	
	public void testNavigation() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement formAuthentication = driver.findElement(By.linkText("Form Authentication"));
		formAuthentication.click();
		driver.navigate().back();

		WebElement draganddropLink = driver.findElement(By.linkText("Drag and Drop"));
		draganddropLink.click();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();

	}
}
