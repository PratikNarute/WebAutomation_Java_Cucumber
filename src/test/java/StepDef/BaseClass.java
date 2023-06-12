package StepDef;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class BaseClass 
{
	public static WebDriver driver ;
	public static ChromeOptions options;
	public static POM.LoginPage l;
	public static POM.Booking b;

	public static POM.Properties_PropertyPriceAndStatus p;
	public static SoftAssert a;	
	public static Actions A;
	public static POM.Dashboard db;
	public static POM.Lead ld;
	public static JavascriptExecutor j;
	
	
	
}
