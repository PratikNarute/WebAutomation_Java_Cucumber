package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait w;
	SoftAssert a;
	Actions A;
	JavascriptExecutor j ;
	
	 @FindBy (xpath= "//input [@formcontrolname='username']") private WebElement username;
	 @FindBy (xpath= "//input [@formcontrolname='password']") private WebElement loginPassword;
	 @FindBy (xpath= "//span[text()='login'] /parent :: button") private WebElement loginbutton;
	 
	 public LoginPage (WebDriver driver)
	 {
			PageFactory.initElements(driver, this);
			this.driver = driver;
			a = new SoftAssert();
			A = new Actions(driver);
			j =  (JavascriptExecutor)driver;
	 }

	 public void username()
	 {
		 
		 username.sendKeys("pratik@kolonizer.com");
	 }
	 
	 public void password()
	 {
		 loginPassword.sendKeys("Pratik@123");	 


	 }
	 public void loginbutton()
	 {
		 loginbutton.click();
	 }
	 public void loginWithSuperAdmin()
	 {
		 username.sendKeys("superadmin@kolonizer.com");
		 loginPassword.sendKeys("Superadmin360@SA");
		 loginbutton.click();
	 }
	 public void navigateToHomePageOfCRM() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 String url = driver.getCurrentUrl();
		 a.assertEquals(url, "http://devdreamcity.kolonizer.in/dashboard");
		 a.assertAll();
	 }
	 public void username(String mail)
	 {	 
		 username.sendKeys(mail);
	 }
	 
	 public void password(String password)
	 {
		 loginPassword.sendKeys(password);	 
	 }

}



