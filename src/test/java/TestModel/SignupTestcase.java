package TestModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
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

    public void setup() {
    	
    	/*chrome_options = Options()
    	chrome_options.add_argument('--headless')
    	chrome_options.add_argument('--no-sandbox')
    	chrome_options.add_argument('--disable-dev-shm-usage')*/
	 // System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
	//ChromeOptions ChromeOptions = new ChromeOptions();
	//ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
    	/*ChromeOptions opt = new ChromeOptions();
    	opt.setBinary("/usr/bin/google-chrome");  //chrome binary location specified here
    	opt.addArguments("start-maximized");
    	opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	opt.setExperimentalOption("useAutomationExtension", false);*/
    	//driver = new RemoteWebDriver(new URL("http://192.168.1.114:4444/wd/hub"), ChromeOptions);
    	
    	ChromeOptions options = new ChromeOptions();
    	options.setBinary("/usr/bin/google-chrome");
    	options.addArguments("--headless", "window-size=1024,768");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-setuid-sandbox");
    	options.addArguments("--remote-debugging-port=9222");
    	options.addArguments("--disable-dev-shm-usage");
    	options.addArguments("--disable-extensions");
    	options.addArguments("--disable-gpu");
    	options.addArguments("disable-infobars");
    	options.addArguments("start-maximized"); 
    	options.addArguments("enable-automation"); 
    	
    	
    	
    	
    	options.addArguments("--disable-browser-side-navigation"); 
    	options.addArguments("--user-data-dir=/home/ubuntu/.config/google-chrome/Default");
    
    	
    	WebDriverManager.chromedriver().setup();
    	
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
