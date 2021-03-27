package TestModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageModel.SignInPage;

import PageModel.SignInformPage;
import PagefactoryModel.SignINForm;
import PagefactoryModel.SignUPForm;


public class SignupTestcase {
	
	WebDriver driver;

	SignInPage objLogin;

    SignInformPage objHomePage;
    
    SignUPForm SignInForm;
    SignINForm Login;
    
	@BeforeTest

    public void setup() {

	  // System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

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
