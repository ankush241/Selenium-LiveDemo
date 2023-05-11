import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Example_2 {

	Actions action ;
	
	public Example_2(WebDriver driver)
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
		js.executeScript("window.scrollBy(0,6000)", "");
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
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		Example_2 obj = new Example_2 (driver);

		driver.findElement(By.id("userEmail")).sendKeys("ankush@test.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hello@2023");
		WebElement button = driver.findElement(By.id("login"));
		obj.clickToEvenet(driver, button);
		
		System.out.println(driver.getTitle());
		Set <String> s =driver.getWindowHandles();
		 ArrayList<String> ar = new ArrayList<String>(s);
		//driver.switchTo().window((String) ar.get(1));
		Thread.sleep(1000);
		
		//System.out.println(ar.get(0));
		//System.out.println(ar.get(1));
		
	}

}
