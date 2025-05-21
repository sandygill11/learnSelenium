package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {
	public static void main(String[] args) {

		// Launch Chrome
		WebDriver driver = new ChromeDriver();

		// go to url https://the-internet.herokuapp.com/
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// click on checkboxes
		WebElement checkboxes = driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a"));
		checkboxes.click();

		// check heading- Checkboxes is written
		WebElement checkboxesHeading = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		String headingText = checkboxesHeading.getText();

		if (headingText.equals("Checkboxes")) {
			System.out.println("Heading PASSED");
		} else {
			System.out.println("Heading Failed");
		}

		// clicking checkbox 1
		WebElement checkboxOne = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		checkboxOne.click();

		// clicking checkbox 2
		WebElement checkboxTwo = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
		checkboxTwo.click();

		// check Powered by elemental selenium is written
		WebElement elementalSelenium = driver.findElement(By.xpath("//*[@id='page-footer']/div/div"));
		String footerText = elementalSelenium.getText();

		if (footerText.equals("Powered by Elemental Selenium")) {
			System.out.println("Footer PASSED");
		} else {
			System.out.println("Footer Failed");
		}

		//driver.quit();

	}
}
