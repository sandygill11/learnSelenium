package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	@Test
	public void testDragAndDrop() {
		
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get("https://the-internet.herokuapp.com/");
	driver.findElement(By.linkText("Drag and Drop")).click();
	
	Actions myAction = new Actions(driver);
	
	WebElement source = driver.findElement(By.id("column-a"));
	WebElement target = driver.findElement(By.id("column-b"));
	
	myAction.dragAndDrop(source, target).build().perform();
	
	String draggedHeading = driver.findElement(By.xpath("//*[@id='column-a']/header")).getText();
	
	Assert.assertEquals(draggedHeading, "B");
	
	//driver.quit();
		
	}
	
}
