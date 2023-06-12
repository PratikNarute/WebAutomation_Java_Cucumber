package utility;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class UtilityClass 
{
	public static WebDriver driver;
	public static ChromeOptions options;

	
	public static WebDriver openChromeBrowser(WebDriver driver)
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KOLONIZERDELL\\Desktop\\kolonizer\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();	
	    options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");  
//		options.addArguments("--disable-notifications");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--disable-extensions");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
		
		driver = new ChromeDriver(options);
		return driver;
	}

	public static WebDriver openEgeBrowser(WebDriver driver)
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		return driver;
	}
	public static String  screenshot(WebDriver driver) throws IOException
	{
		
		String path = "C:\\Users\\KOLONIZERDELL\\Pictures\\Screenshots\\failed"+ System.currentTimeMillis()+".png";
		File drag=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dropPath = new File(path);	
		FileHandler.copy(drag, dropPath);
		
		return path;
	}
	public static String getRandomIntegers(int digit)
	{
		//   return "" + Math.round((Math.random()*999));	
//  =====================================================================================================
//		   Random rand = new Random();
//	       int randomNumber = rand.nextInt(1001);    	    // generate a random integer between 0 and 1000
//	       System.out.println(randomNumber);
//	=====================================================================================================
	   	String randomNumber=RandomStringUtils.randomNumeric(digit);  // generate a random integer of 3 digits
	
	       return "91"+randomNumber;
//    =====================================================================================================
	}
	public static String getRandomString(int digit)
	{
		String randomString=RandomStringUtils.randomAlphabetic(digit); // generate a random Strings of 3 digits
		return "ab"+randomString;
		

	}





	
 


}
