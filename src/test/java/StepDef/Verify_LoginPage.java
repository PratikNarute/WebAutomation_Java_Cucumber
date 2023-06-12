package StepDef;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Scenario;

public class Verify_LoginPage extends BaseClass
{
	@Before
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();	
	    options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");  
		driver = new ChromeDriver(options);		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		l= new POM.LoginPage(driver);
		b=new POM.Booking(driver);
		p= new POM.Properties_PropertyPriceAndStatus (driver);
		a=new SoftAssert();
		A=new Actions(driver);
		db=new POM.Dashboard(driver);
		ld= new POM.Lead(driver);
		j =  (JavascriptExecutor)driver;
	}
//	@After
//	public void closeBrowser(Scenario sc)
//	{
//		if (sc.isFailed()==true)
//		{
//			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			File destination = new File("");
//		}
//		driver.close();
//	}
	
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("Start.........");
		
		
	}
	@AfterStep
	public void afterStep()
	{
		System.out.println("**********************Finish************************************");
	}
		

	@Given("User should be on Login page of CRM {string}")
	public void user_should_be_on_login_page_of_crm(String url) throws InterruptedException 
	{
		if (url.equals("http://devdreamcity.kolonizer.in/login"))
		{
			driver.get("http://devdreamcity.kolonizer.in/login");
		}
		else if (url.equals("http://uatdreamcity.kolonizer.in/login"))
		{
			driver.get("http://uatdreamcity.kolonizer.in/login");
		}
	
		Thread.sleep(3000);
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);	
	}
	
	@When("Enter username and password")
	public void enter_username_and_password()
	{
		l.username();
		l.password();	
	}	
	
	@When("Enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String username, String pass) 
	{
	  l.username(username);
	  l.password(pass);
	}
	@When("Click on Login button")
	public void click_on_login_button() 
	{	
		l.loginbutton();	  
	}
	
	@Then("User should be navigate to Home Page {string}")
	public void user_should_be_navigate_to_home_page(String url) throws InterruptedException
	{
		Thread.sleep(3000);
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);

	}

}
