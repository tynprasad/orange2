package ABC_Demo5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC01_Login_Static_DataProvider4 {
	
	static WebDriver driver;
	
	//step1
	//String UserName="Admin",Password="admin123";
	//String Nationality_text="Indian899";
	//String URL="https://opensource-demo.orangehrmlive.com/";
	
	
	
	//step1
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality3.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	
	@Test(dataProvider="TC01_Add_Nationality")//Step3
	public void loginTest(String Browser,String URL,String UserName,String Password,String Nationality_text ) throws Exception //Step2
	{
		
		TC01_Login_Static_DataProvider4 T1=new TC01_Login_Static_DataProvider4();
		
		if(Browser.equalsIgnoreCase("Chrome"))
		T1.OpenChromeBroswer();
		
		if(Browser.equalsIgnoreCase("FireFox"))
			T1.FireFoxBrowser();
		
		//T1.OpenChromeBroswer();
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
	
	
	public  void FireFoxBrowser() throws Exception
	{
		 System.setProperty("webdriver.gecko.driver","C:\\FireFoxDriver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 Thread.sleep(6000);
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
