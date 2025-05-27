package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlerts3 {

	WebDriver driver;

	@BeforeMethod
	public void initialise() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

	}

	@AfterMethod
	public void endTest() {

		driver.quit();

	}

	@Test
	public void handlejsAlerts() {

//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlert = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
		jsAlert.click();

		// switching screen for web page to alert pop up

		Alert alert = driver.switchTo().alert();

		// we have accept method to click okay in alert

		alert.accept();

		WebElement message = driver.findElement(By.id("result"));
		String messageText = message.getText();

		Assert.assertEquals(messageText, "You successfully clicked an alert");
		//driver.quit();

	}

	@Test
	public void handlejsConfirm() {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
		alert.accept();

		String messageText = driver.findElement(By.id("result")).getText();

		Assert.assertEquals(messageText, "You clicked: Ok");
		driver.quit();

	}

	@Test
	public void handlejsPrompt() {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("June");
		alert.accept();

		String messageText = driver.findElement(By.id("result")).getText();

		Assert.assertEquals(messageText, "You entered: June");
		driver.quit();

	}

}
