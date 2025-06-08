package winhandles;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesEx {

	@Test
	public void WindowHandles() {

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

		String parentWindow = driver.getWindowHandle();
//		
//		System.out.println(parentWindow);
//		
		driver.findElement(By.id("tabButton")).click();

		// getWindowHandle is a unique id given to each window that driver has opened

		Set<String> winset = driver.getWindowHandles();
		String headingText;

		for (String handle : winset) {
			System.out.println(handle);

			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);

				headingText = driver.findElement(By.id("sampleHeading")).getText();
				Assert.assertEquals(headingText, "This is a sample page");
			}

		}

		driver.switchTo().window(parentWindow);

		driver.quit();

	}

}
