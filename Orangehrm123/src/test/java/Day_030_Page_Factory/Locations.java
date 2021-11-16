package  Day_030_Page_Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
    WebElement Admin;  

    @FindBy(id="menu_admin_Organization")
    WebElement Organization;  
	
    @FindBy(id="menu_admin_viewLocations")
    WebElement Locations;  
	
    @FindBy(id="btnAdd")
    WebElement AddButton;  
    
    @FindBy(id="location_name")
    WebElement Name;  
    
    
    
   
    
    
    @FindBy(id="location_province")
    WebElement Province;  
    
    @FindBy(id="location_city")
    WebElement city;  
    
    @FindBy(id="location_address")
    WebElement Address;  
    
    @FindBy(id="location_zipCode")
    WebElement Zip;  
    
    @FindBy(id="location_phone")
    WebElement Phone;  
    
    @FindBy(id="location_fax")
    WebElement Fax;  
    
    @FindBy(id="location_notes")
    WebElement Notes;  
    
 
    
    
    @FindBy(id="btnSave")
    WebElement Save;  
    
    
    
   
	
	public  void AddLocation() throws Exception
	{
		/*findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Mexican89");
		findElement(By.id("btnSave")).click();*/
		
		Admin.click();
		Organization.click();
		Locations.click();
		AddButton.click();
		Name.sendKeys("CMR");
		Select dropdown1 = new Select(driver.findElement(By.id("location_country")));
		 dropdown1.selectByValue("AT");
		Province.sendKeys("hyd");
		city.sendKeys("hyd");
		Address.sendKeys("kotti");
		Zip.sendKeys("500055");
		Phone.sendKeys("9897985963");
		Fax.sendKeys("+5855467215");
		Notes.sendKeys("employeeee details");
		Save.click();
	
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












