package ABC_Demo5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Login_Static_DataProvider1 {
	
	static WebDriver driver;
	
	//step1
	//String UserName="Admin",Password="admin123";
	//String Nationality_text="Indian899";
	//String URL="https://opensource-demo.orangehrmlive.com/";
	
	
	
	//step1
		 @DataProvider(name = "Orange1")
		  public static Object[][] Test1() throws Exception {
		 
		        return new Object[][] { 
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians127" },
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians128" },
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians129" },
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians130" }
		        	};
		  }
		 
	

	@Test(dataProvider="Orange1")//Step3
	public void loginTest(String URL,String UserName,String Password,String Nationality_text ) throws Exception //Step2
	{
		
		TC01_Login_Static_DataProvider1 T1=new TC01_Login_Static_DataProvider1();
		T1.OpenChromeBroswer();
		T1.OpenOrangeHRM(URL);
		T1.Login(UserName,Password); //step2
		T1.AddNationalities(Nationality_text);//stp2
		T1.CloseBrowser();
	}
	
	
	public  void OpenChromeBroswer() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
	}
	
	public void OpenOrangeHRM(String URL)throws Exception
	{
		driver.get(URL);
	}
	

	public   void Login(String UserName1,String Password1) throws Exception //step3
	{
		findElement(By.id("txtUsername")).sendKeys(UserName1);  //step4
		findElement(By.id("txtPassword")).sendKeys(Password1);  //step4
		findElement(By.id("btnLogin")).click();
	}
	

	public  void AddNationalities(String Nationality_text1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality_text1);//step4
		findElement(By.id("btnSave")).click();
	}
	

	public  void CloseBrowser() throws Exception
	{
		driver.quit();
	}
	

	
	
	
	
	public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

	

}
