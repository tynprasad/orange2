package  Day_029_PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Locations
{
	
	WebDriver driver;
	
	public void Locations(WebDriver driver)
	{
		this.driver = driver;
	}
	public void AddLocations1()  throws Exception 
	{
		
		findElement(By.linkText("Admin")).click();
		findElement(By.linkText("Organization")).click();
		findElement(By.linkText("Locations")).click();
		findElement(By.id("btnAdd")).click();
		
		findElement(By.name("location[name]")).sendKeys("EVV");
		findElement(By.name("location[province]")).sendKeys("TS");
		findElement(By.name("location[city]")).sendKeys("HYD");
		
		
		findElement(By.name("location[address]")).sendKeys("HYD");
		findElement(By.name("location[zipCode]")).sendKeys("500055");
		findElement(By.name("location[phone]")).sendKeys("9666138854");
		
		findElement(By.name("location[fax]")).sendKeys("6987589");
		findElement(By.name("location[notes]")).sendKeys("EMPLOYEE INFORMATION");
		
		

		
		
		Select dropdown1 = new Select(driver.findElement(By.id("location_country")));
		 dropdown1.selectByValue("AS");
		 
		 List<WebElement> elements=dropdown1.getOptions();
		 
		 for(WebElement element:elements)
		 {
			 System.out.println(element.getText());
		 }
		
		 findElement(By.id("btnSave")).click();
		
	}
	
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
	
	
	
}















