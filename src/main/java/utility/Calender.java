package utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calender 
{
	public static WebDriver driver;
	public static void currentCalenderDate(WebDriver driver)
	{
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("d");
		
		String currentDay = dateFormat.format(currentDate);
		WebElement Day = driver.findElement(By.xpath("//table//div[text()=' "+currentDay+" ']"));
		Day.click();
	}
	public static void currentCalenderMonth(WebDriver driver)
	{
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
		
		String currentMonth = dateFormat.format(currentDate).toUpperCase();
	
		WebElement month = driver.findElement(By.xpath("//table//div[text()=' "+currentMonth+" ']"));
		month.click();
	}
	public static void currentCalenderYear(WebDriver driver)
	{
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
		
		String currentYear = dateFormat.format(currentDate);
	
		WebElement year = driver.findElement(By.xpath("//table//div[text()=' "+currentYear+" ']"));
		year.click();
	}
	public static String Year()
	{
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
		
		String currentYear = dateFormat.format(currentDate);
	
		return currentYear;

	}
	public static void CustomizeCalenderDay(WebDriver driver, String day)
	{
	
		WebElement Day = driver.findElement(By.xpath("//table//div[text()=' "+day+" ']"));
		Day.click();
	}
	public static void CustomizeCalenderMonth(WebDriver driver, String month)
	{
	
		WebElement Month = driver.findElement(By.xpath("//table//div[text()=' "+month+" ']"));
		Month.click();
	}
	public static void CustomizeCalenderYear (WebDriver driver, String year)
	{
	
		WebElement Year = driver.findElement(By.xpath("//table//div[text()=' "+year+" ']"));
		Year.click();
	}





}
