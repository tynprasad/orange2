package  Day_030_Page_Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Skills
{
	
	WebDriver driver;
	
	public void Skills(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
    WebElement Admin;  

	@FindBy(id="menu_admin_Qualifications")
    WebElement Qualifi;  
	
	
    @FindBy(id="menu_admin_viewSkills")
    WebElement Skills;  
	
    @FindBy(id="btnAdd")
    WebElement AddButton;  
    
    @FindBy(id="skill_name")
    WebElement Skill_name;  
    
    @FindBy(id="skill_description")
    WebElement Skill_descr;  
    
    @FindBy(id="btnSave")
    WebElement Save_button;  
	
	public  void AddSkills() throws Exception
	{
		/*findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Mexican89");
		findElement(By.id("btnSave")).click();*/
		
		Admin.click();
		Qualifi.click();
		Skills.click();
		AddButton.click();
		Skill_name.sendKeys("Malasiya935");
		Skill_descr.sendKeys("java3.0");
		Save_button.click();
	
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












