package TestModel;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
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

    public void setup() throws TimeoutException, MalformedURLException {

	  //System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
	  ChromeOptions ChromeOptions = new ChromeOptions();
		ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
	  
	//driver = new ChromeDriver(ChromeOptions);
		driver = new RemoteWebDriver(new URL("http://192.168.1.114:4444/wd/hub"), ChromeOptions);
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
