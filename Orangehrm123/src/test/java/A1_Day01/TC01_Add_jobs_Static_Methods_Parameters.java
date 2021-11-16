package A1_Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_jobs_Static_Methods_Parameters {
	
	static WebDriver driver;
	
	//Step1 - Global Variables declaration
	static String TestURL="https://opensource-demo.orangehrmlive.com/";
	static String username="Admin",password="admin123";
	static String JobTitle="Sales8",JobDescr="Sales8 descr",JobNote="Sales8 Note";
	
	
	  @Test
	  public void Add_jobs_Test() throws Exception  {
		  
		 
		  
		  TC01_Add_jobs_Static_Methods_Parameters.openChromeBrowser();
		  TC01_Add_jobs_Static_Methods_Parameters.OpenOrgangeHRM(TestURL); //Step2
		  TC01_Add_jobs_Static_Methods_Parameters.Login(username,password);//Step2
		  TC01_Add_jobs_Static_Methods_Parameters.Add_Jobs(JobTitle,JobDescr,JobNote);//Step2
		  TC01_Add_jobs_Static_Methods_Parameters.CloseBrowser();
			
	  }
	  
	
	
	
	
	
	
	
	
	
	
	 public  static WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}
	 
	 
	 public static void openChromeBrowser()throws Exception
	 {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
		 
	 }
	 
	 public static void OpenOrgangeHRM(String TestURL1)throws Exception
	 {
			driver.get(TestURL1);
	 }
	 
	 public static void Login(String username1,String password1)throws Exception
	 {
			findElement(By.id("txtUsername")).sendKeys(username1);
			findElement(By.id("txtPassword")).sendKeys(password1);
			findElement(By.id("btnLogin")).click();
		 
	 }
	 
	 public static void Add_Jobs(String JobTitle,String JobDescr,String JobNote)throws Exception
	 {
			findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Job")).click();
			findElement(By.id("menu_admin_viewJobTitleList")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
			findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
			findElement(By.id("jobTitle_note")).sendKeys(JobNote);
			findElement(By.id("btnSave")).click();
	 }
	 
	 public static void CloseBrowser()throws Exception
	 {
		 driver.quit();
	 }
	 
	 
	 
	
  
  
  
}
