//import MercuryDemoTours;

package Day_028_WebTable_Examples;

import CommonUtil.*;
import ExcelUtil.ExcelApiTest3;

import org.testng.annotations.Test;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

/*
1. Open Chrome browser
2. open Orange Application urL
3. login
4. Navigate to employee screen
5. Export Employees to Excel sheet
5. logout and Quit
*/
 
public class Joblist
{
	public String UserName,Password;

	
	
	public  int iRow;
	
	WebDriver driver;


	public void ExportJoblist(WebDriver driver )throws Exception
	{  
		this.driver=driver;
		
	}
	
	// Draws a red border around the found element. Does not set it back anyhow.
		public WebElement findElement(By by)throws Exception {
		    WebElement elem = driver.findElement(by);
		 
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		    } 
		    Thread.sleep(10);
		    
		    return elem;
		}
		
		
	
	
	
	
	@Test
	public  void ExportAllJoblist( )throws Exception
	{  
		

	    driver=TestBrowser.OpenChromeBrowser();
			
		
			
				// driver.quit();
				 call_allmethods(1);
				 
	}
	
				 
				 
				 public void call_allmethods(int iRow )throws Exception
					{  
						
					 
					String str=String.valueOf(iRow);
					
						Login l1=new Login();
						l1.Login(driver);
						l1.openOrangeHRM();
						l1.OrangeHRMlogin("Admin","admin123");
						l1.OrangeHRMSigninClick();
						
						
						 Actions actions = new Actions(driver);
						 WebElement ele=findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
				         
						 WebElement ele1=findElement(By.xpath("//*[@id='menu_admin_Job']"));
						 WebElement ele2=findElement(By.xpath("//*[@id='menu_admin_viewJobTitleList']"));
				         
						 
						 actions.moveToElement(ele).moveToElement(ele1).moveToElement(ele2).click().build().perform();
						 
						
						 Joblist Ae=new  Joblist();		
						 Ae.ExportJoblist(driver);
						
						
						
						
						Ae.ExportJoblist();
				
						System.gc();
						
						
					}
					
				 

					public  void ExportJoblist()throws Exception  
					{ 
						 
				        //No. of columns
						 String Jobcoloums="//*[@id=\'resultTable\']/thead/tr/th";
						 List<WebElement>  columns = driver.findElements(By.xpath(Jobcoloums)); 
					     // System.out.println("No of columns in WebTable : " + columns.size());

						//*[@id="resultTable"]/tbody/tr[1]/td[2]/a
						 
						 
				        //No.of rows 
						 String JobRows="//*[@id=\'resultTable\']/tbody/tr/td[2]";
				        List<WebElement>   rows = driver.findElements(By.xpath(JobRows)); 
				       // System.out.println("No of rows in WebTable : " + rows.size());
				        
				        
	
				        			ExcelApiTest3 eat = new ExcelApiTest3();
				        			
				         		    for ( int i=1 ; i<=rows.size() ;i++)  								    {
								    	  for ( int j=2 ,k=0; j<=columns.size() ;j++,k++) 
								    	   {
								      		   String str1="//*[@id=\"resultTable\"]/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
								      		   
								    
								      		   
								      		//*[@id="resultTable"]/tbody/tr[1]/td[2] 
								      		   
								      		   //*[@id="resultTable"]/tbody/tr[1]/td[2]
								      		   
								      		    //*[@id="resultTable"]/tbody/tr[1]/td[2]
								    		    WebElement Ele=findElement(By.xpath(str1));
								    		   
								    	        String WebElementText = Ele.getText();
								    	       //System.out.println("Get Text Value is from the WebElement: " + valueIneed1);
								    	        
								    	        if (WebElementText !=null)
								    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport.xls","Sheet4",i,k,WebElementText);
								    	        else
								    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport.xls","Sheet4",i,k,"Blank Data");
								    	        	
								    	   }
								    }
				         		    
				   
					
					}
					
					
					

}
				        
					
					
				
					
					
					
					
						
		





















						
						


	