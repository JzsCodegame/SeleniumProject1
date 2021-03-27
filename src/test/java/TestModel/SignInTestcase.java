package TestModel;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

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
    

   @BeforeTest

    public void setup() {

	  // System.setProperty("webdriver.chrome.driver", "chromedriver");
	
WebDriverManager.getInstance(CHROME).setup();
	  //  ChromeOptions ChromeOptions = new ChromeOptions();
//ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
//driver = new ChromeDriver(ChromeOptions);
        
     driver = new ChromeDriver();

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
