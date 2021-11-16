package  Day_029_PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage
{
	
	WebDriver driver;
	
	public static String uname="txtUsername";
	public static String pwd="txtPassword";
	public static String LoginButton="btnLogin";
	
	public void LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	
	public void Login() throws Exception {
		
		findElement(By.name(uname)).sendKeys("Admin");
		findElement(By.name(pwd)).sendKeys("admin123");
		findElement(By.id(LoginButton)).click();
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















