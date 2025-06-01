package assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistration {

	@Test
	public void CustomerRegister() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
		
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		WebElement registerAccount = driver.findElement(By.linkText("Register your account"));
		registerAccount.click();
		
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys("Sandy");
		
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys("Gill");
		
		WebElement birthDate = driver.findElement(By.id("dob"));
		birthDate.sendKeys("1994-06-11");
		
		WebElement street = driver.findElement(By.id("street"));
		street.sendKeys("120 Harrison Garden Blvd");
		
		WebElement postalCode = driver.findElement(By.id("postal_code"));
		postalCode.sendKeys("M2N0H1");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("North York");
		
		
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("Ontario");
		
		WebElement country = driver.findElement(By.id("country"));
		
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("Canada");
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("4379827999");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("test@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Super@12345");
		
		String headingText = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/h3")).getText();
		
		Assert.assertEquals(headingText, "Customer registration");
		
		driver.quit();
		
	}
	
	
}
