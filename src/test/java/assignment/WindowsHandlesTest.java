package assignment;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlesTest {

	@Test
	public void WindowHandles() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://playwright.dev/docs/getting-started-vscode");

		String parentWindow = driver.getWindowHandle();
		// System.out.println(parentWindow);
		for (int i = 0; i < 2; i++) {

			driver.findElement(By.xpath(
					"//*[@id='__docusaurus_skipToContent_fallback']/div/div/main/div/div/div[1]/div/article/div[2]/p[3]/a"))
					.click();

			Set<String> windowHandles = driver.getWindowHandles();
			String headingText;

			for (String handle : windowHandles) {
				// System.out.println(handle);

				if (!handle.equals(parentWindow)) {
//					System.out.println(handle);

					driver.switchTo().window(handle);

					headingText = driver.findElement(By.id("playwright-test-for-vs-code")).getText();
					Assert.assertEquals(headingText, "Playwright Test for VS Code");
					// System.out.println(headingText);
				}

			}
			driver.switchTo().window(parentWindow);
		}

		driver.findElement(By.xpath(
				"//*[@id='__docusaurus_skipToContent_fallback']/div/div/main/div/div/div[1]/div/article/div[2]/p[40]/a"))
				.click();

		Set<String> updatedWindowHandles = driver.getWindowHandles();
		System.out.println(updatedWindowHandles);

		String[] array = updatedWindowHandles.toArray(new String[0]);
		
//		new String[0] tells Java to create an array of the correct type. 
//		Java internally allocates the right size.
		
		System.out.println(array[3]);

		String debugBodyText;

		driver.switchTo().window(array[3]);
		
		debugBodyText = driver.findElement(By.xpath("//*[@id='main-content']/div/div/main/h1")).getText();
		
		Assert.assertEquals(debugBodyText, "Debug code with Visual Studio Code");
		System.out.println(debugBodyText);

//		for(String h : updatedWindowHandles) {
//			System.out.println(h);
//			
//			if(!h.equals(parentWindow)) {
//				
//				driver.switchTo().window(h);
//				
//				debugBodyText = driver.findElement(By.xpath("//*[@id='main-content']/div/div/main/h1")).getText();
//				Assert.assertEquals(debugBodyText, "Debug code with Visual Studio Code");
//			}
//		}

	}

}
