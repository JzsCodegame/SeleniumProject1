package TestModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

@Test
public class TesthomeBase {

	
	public static WebDriver driver = null; 
	  
    @Test
    public void initialize() throws IOException { 
    	WebDriver driver;
  
       // System.setProperty("webdriver.chrome.driver", "chromedriver"); 
    
        driver = new ChromeDriver(); 
    
        // To maximize browser 
        driver.manage().window().maximize(); 
    
        // Implicit wait 
        driver.manage().timeouts().implicitlyWait( 
             10, TimeUnit.SECONDS); 
    
        // To open Gmail site 
        driver.get("http://automationpractice.com/index.php"); 
        
       
    } 
  
    @AfterSuite
     //Test cleanup 
    public void TeardownTest() { 
    	TesthomeBase.driver.quit(); 
    } 

}	

