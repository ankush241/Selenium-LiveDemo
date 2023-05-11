import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class Example_1 {

	Actions action ;
	
	public Example_1(WebDriver driver)
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
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		Example_1 obj = new Example_1 (driver);
		
		WebElement cross = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		obj.clickToEvenet(driver, cross);
		
		WebElement search = driver.findElement(By.className("_3704LK"));
		search.sendKeys("IPHONE");
		
		WebElement searchbox = driver.findElement(By.className("L0Z3Pu"));
		obj.clickToEvenet(driver, searchbox);
		Thread.sleep(1000);
		obj.ScrollDown(driver);
		
		WebElement clickLink = driver.findElement(By.className("_1fQZEK"));
		obj.clickToEvenet(driver, clickLink);
		
		Set <String> s =driver.getWindowHandles();
		 ArrayList<String> ar = new ArrayList<String>(s);
		driver.switchTo().window((String) ar.get(1));
		Thread.sleep(1000);
		
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		
		//WebElement option = driver.findElement(By.xpath("//li[@id='swatch-2-storage']/a"));
		//obj.clickToEvenet(driver, option);
		
		WebElement AddTOCart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button"));
		obj.clickToEvenet(driver, AddTOCart);
		
	}

}
