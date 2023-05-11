import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Example_3 {

Actions action ;
	
	public Example_3(WebDriver driver)
	{
		action = new Actions(driver);
	}
	public void MouseHover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}
	public void ScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}
	public void clickToEvenet(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		Example_3 obj = new Example_3(driver);
		
		obj.ScrollDown(driver);
		
		WebElement hotels = driver.findElement(By.xpath("//span[@class='allcircle circletwo']"));
		hotels.click();
		
		// window handling code
		
		Set <String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentID = it.next();
		String childID = it.next();
		
		driver.switchTo().window(childID);
		
		obj.ScrollDown(driver);
		
		//WebElement link1 = driver.findElement(By.linkText("About Us"));
		//link1.click();
		
		driver.findElement(By.linkText("About Us")).click();

	}

}
