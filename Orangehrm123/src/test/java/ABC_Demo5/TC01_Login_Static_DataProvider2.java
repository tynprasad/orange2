package ABC_Demo5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Login_Static_DataProvider2 {
	
	static WebDriver driver;
	
	//step1
	//String UserName="Admin",Password="admin123";
	//String Nationality_text="Indian899";
	//String URL="https://opensource-demo.orangehrmlive.com/";
	
	
	
	//step1
	@DataProvider(name="Orange1")
	 public Object[] myDataProvider() {
	      
	     Object data[][]=  new Object[3][4];
	     
	       
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Indians131";
	      

	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Indians132";
	     
	     
	     data[2][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[2][1]= "Admin";
	     data[2][2]= "admin123";
	     data[2][3]= "Indians133";
	     
	     return data;
	      
	      
	 }
		 
	
	
	
	
	
	
	@Test(dataProvider="Orange1")//Step3
	public void loginTest(String URL,String UserName,String Password,String Nationality_text ) throws Exception //Step2
	{
		
		TC01_Login_Static_DataProvider2 T1=new TC01_Login_Static_DataProvider2();
		T1.OpenChromeBroswer(URL);
		
		T1.Login(UserName,Password); //step2
		T1.AddNationalities(Nationality_text);//stp2
		T1.CloseBrowser();
	
	
	
	
	
	

}
   void Login(String UserName1,String Password1) throws Exception //step3
	{
		findElement(By.id("txtUsername")).sendKeys(UserName1);  //step4
		findElement(By.id("txtPassword")).sendKeys(Password1);  //step4
		findElement(By.id("btnLogin")).click();
	}
	

	public  void OpenChromeBroswer(String URL) throws Exception
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get(URL);
	}
	
	public void AddNationalities(String Nationality_text1)throws Exception
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
