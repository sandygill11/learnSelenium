package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {

		// Launch Chrome
		WebDriver driver = new ChromeDriver();

		// go to url https://the-internet.herokuapp.com/
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// click on form authenticaion
		WebElement formAuthentication = driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a"));
		formAuthentication.click();

		// enter username
		WebElement usernameField = driver.findElement(By.xpath("//*[@id='username']"));
		usernameField.sendKeys("tomsmith");

		// enter password
		WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
		passwordField.sendKeys("SuperSecretPassword!");

		// click login button
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button/i"));
		loginButton.click();

		// secure heading
		WebElement secureAreaHeading = driver.findElement(By.xpath("//*[@id='content']/div/h2"));
		String headingText = secureAreaHeading.getText();

		if (headingText.equals("Secure Area")) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}

		driver.quit();
	}
}
