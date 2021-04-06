package TestModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import static io.github.bonigarcia.wdm.DriverManagerType;
import PageModel.SignInPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageModel.SignInformPage;
import PagefactoryModel.SignINForm;
import PagefactoryModel.SignUPForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;


import org.testng.annotations.BeforeClass;  

public class SignupTestcase {
	
	 WebDriver driver;

	SignInPage objLogin;

    SignInformPage objHomePage;
    
    SignUPForm SignInForm;
    SignINForm Login;
   
	
    @BeforeTest

    public void setup() throws WebDriverException {
    
System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	
    	//opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	//opt.setExperimentalOption("useAutomationExtension", false);
    	//driver = new RemoteWebDriver(new URL("http://192.168.1.114:4444/wd/hub"), ChromeOptions);
    	
    	ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
    	options.setBinary("/usr/bin/google-chrome");
    	
    	options.addArguments("--no-sandbox");
    	options.addArguments("--headless", "window-size=1024,768");
    	options.addArguments("--disable-setuid-sandbox");
    	options.addArguments("--remote-debugging-port=9222");
    	options.addArguments("--disable-dev-shm-usage");
    	options.addArguments("--disable-extensions");
    	options.addArguments("--disable-gpu");
    	options.addArguments("disable-infobars");
    	options.addArguments("start-maximized"); 
    	options.addArguments("enable-automation"); 
    	options.addArguments("--disable-browser-side-navigation"); 
	    options.setExperimentalOption("useAutomationExtension", false);
    	//options.addArguments("--user-data-dir=/home/ubuntu/.config/google-chrome");
	    
    	options.addArguments("--user-data-dir=/home/ubuntu/.config/google-chrome/profile1");
    	options.addArguments("--profile-directory=profile1");
    	
    	//DriverManagerType chrome = DriverManagerType.CHROME;
    	//WebDriverManager.getInstance(chrome).setup();
    	
    	//WebDriverManager.chromedriver().setup();
    	
	     driver = new ChromeDriver(options);
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");

        } 
  
       
	

	@Test(priority=0)

    public void Test_SignUp_Appears() {

        //Create Login Page object

		
		Login = new SignINForm(driver);
		SignInForm = new SignUPForm(driver);
		//Verify login page title
		
		//Login.openSignup();
		Login.clickSignIn();
		
		
		String signuppageTitle = Login.getFormpageTitle();
		    
		Assert.assertTrue(signuppageTitle.contains("Login -"));
		
	}

	@Test(priority=1)
	public void Fill_SignUp_Form() {
		SignInForm.fillSignup("xel@gmail.com" , "Jimmy", "Randall", "Randall2020"/*,"sinputDays"*/);//Positive testing 
		
		//public void Fill_SignUp_Form1() 2nd Attempt with Information
		//SignInForm.fillSignup("xel@gmail.comm" , "Jimmy20", "Randall20", "Randall2020"/*,"sinputDays"*/); //Negative Testing
}
	@Test(priority=2)
	public void Fill_SignUp_Form1() {
		
		SignInForm.selectDays("15");
	}
	

}
