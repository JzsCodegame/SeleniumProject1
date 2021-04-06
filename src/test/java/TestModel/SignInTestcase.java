package TestModel;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
//import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;  
import PageModel.SignInPage;

import PageModel.SignInformPage;
import PagefactoryModel.SignINForm;
import PagefactoryModel.SignUPForm;


public class SignInTestcase {

    //String driverPath = "C:\\geckodriver.exe";
    
     WebDriver driver;

    SignInPage objLogin;

    SignInformPage objHomePage;
    
    
    //2nd Method
    SignUPForm SignInForm;
    SignINForm Login;
    
	
	/*@BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        
	}*/
	   

    @BeforeTest

    public void setup() throws WebDriverException {

	// System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	  //ChromeOptions ChromeOptions = new ChromeOptions();
	  //ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
    	/*ChromeOptions opt = new ChromeOptions();
    	opt.setBinary("/usr/bin/google-chrome");  //chrome binary location specified here
    	opt.addArguments("start-maximized");
    	opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	opt.setExperimentalOption("useAutomationExtension", false);*/
    	/*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("test-type");
    	capabilities.setCapability("chrome.binary", "/usr/bin/google-chrome");
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/
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
    	//options.addArguments("--profile-directory=Default");
	   // options.addArguments("--user-data-dir=/home/ubuntu/.config/google-chrome/default");
    	//options.addArguments("profile-directory=Profile 2");
	    //options.addArguments("--profile-directory=default");
	    
	    DriverManagerType chrome = DriverManagerType.CHROME;
    	WebDriverManager.getInstance(chrome).setup();
	    
	    //WebDriverManager.chromedriver().setup();
    	
	    driver = new ChromeDriver(options);
	     
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        
 
    }
      
        
   

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

@Test(priority=0)

    public void test_Page_Appear_Correct() {

        //Create Login Page object

	Login = new SignINForm(driver);

    //Verify login page title

    String loginPageTitle = Login.getmainpageTitle();

    Assert.assertTrue(loginPageTitle.contains("My Store"));

    //login to application

    Login.openSignup();
    
    String signuppageTitle = Login.getFormpageTitle();
    
    Assert.assertTrue(signuppageTitle.contains("Login - My Store"));
    
}
    // go the next page
   




/*public void test_Form_Page_Appear_Correct() {
    
    	objHomePage = new SignInformPage(driver);
    	
    	Assert.assertTrue(objHomePage.getSignInTitle().toLowerCase().contains(""));
    //Verify home page
    	
    }*/

}
