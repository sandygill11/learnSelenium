package assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandlesAssi {

	@Test
	public void WindowHandles() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		String parentWindow = driver.getWindowHandle();

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//*[@id='windowButton']")).click();

			Set<String> windowHandles = driver.getWindowHandles();
			String headingText;

			for (String handle : windowHandles) {
				System.out.println(handle);

				if (!handle.equals(parentWindow)) {
					
					driver.switchTo().window(handle);

					headingText = driver.findElement(By.id("sampleHeading")).getText();
					Assert.assertEquals(headingText, "This is a sample page");
				
				}
				
			}
			

			driver.switchTo().window(parentWindow);
		}


		driver.findElement(By.id("messageWindowButton")).click();

		Set<String> otherWindowHandles = driver.getWindowHandles();
		String bodyText;
		String myDesiredText;

		for (String msgHandle : otherWindowHandles) {
			System.out.println(msgHandle);

			if (!msgHandle.equals(parentWindow)) {
				driver.switchTo().window(msgHandle);

				bodyText = driver.findElement(By.xpath("/html/body")).getText();
				myDesiredText = "sharing but not by saving";

				if (bodyText.contains(myDesiredText)) {
					Assert.assertEquals(myDesiredText, "to the-internet");
					System.out.println("Desired Text FOUND!!!");
				} else {
					System.out.println("Desired Text not found");
				}

			}

		}

		driver.switchTo().window(parentWindow);

		driver.quit();

	}

}
