package POM;

import java.time.Duration;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utility.UtilityClass;

public class Properties_PropertyPriceAndStatus 
{
	WebDriver driver;
	WebDriverWait w;
	public static SoftAssert a;
	Actions A;
	JavascriptExecutor j ;
	String oldArray [] = new String[40];
	String newArray [] = new String[40];
	String toalArea [] = new String[40];
	int oldPrice=0;
	int newPrice=0;
	int areaIndex=0;

	
	public Properties_PropertyPriceAndStatus(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
		this.driver = driver;
		w = new  WebDriverWait(driver, Duration.ofSeconds(30));
		a = new SoftAssert();
		A = new Actions(driver);
		j =  (JavascriptExecutor)driver;
		
	}
	
	@FindBy (xpath = "//mat-select[@formcontrolname='project_id']") private WebElement projectDropdown;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-One 104')]") private WebElement selectProjectDropdown_AutomationProject1;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-Two 104')]") private WebElement selectProjectDropdown_AutomationProject2;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='refrence_property_name']") private WebElement propertyTypeDropdown;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation 1BHK property 104')]") private WebElement propertyTypeDropdown_Automation_1BHK_Property;
	@FindBy (xpath = "//mat-option//span[contains(text(),'Automation 2BHK property 104')]") private WebElement propertyTypeDropdown_Automation_2BHK_Property;
	
	@FindBy (xpath = "//mat-select[@formcontrolname='project_property_type_id']")private WebElement projectBlocks_Dropdown;
	@FindBy (xpath = "//mat-option//span[contains(text(), ' Automation P1 Block-1 104')]")private WebElement projectBlocks_Dropdown_P1_B1;
	@FindBy (xpath = "//mat-option//span[contains(text(), ' Automation P1 Block-2 104')]")private WebElement projectBlocks_Dropdown_P1_B2;
	@FindBy (xpath = "//mat-option//span[contains(text(), ' Automation P2 Block-1 104')]")private WebElement projectBlocks_Dropdown_P2_B1;
	@FindBy (xpath = "//mat-option//span[contains(text(), ' Automation P2 Block-2 104')]")private WebElement projectBlocks_Dropdown_P2_B2;
	
	
	@FindBy (xpath = "//input[@formcontrolname='total_amount_property_and_property_feature']") private WebElement totalPropertyPrice;
	
	@FindBy (xpath = "//div[@formarrayname='property_feature'] //div//label[contains(text(),'Automation feature 104')]") private WebElement propertyFeatures_AutomationFeature;
	
	@FindBy (xpath = "//div [text()='Properties']") private WebElement propertiesIcon;
	@FindBy (xpath = "//a[@href='/master/property'] / parent :: li") private WebElement propertyPriceAndStatusIcon ;
	@FindBy (xpath = "//button[text()=' Add Properties ']") private WebElement addPropertiesButton;
	
	@FindBy (xpath = "//td[contains(text(),'Automation 1BHK property NO -2 104')] / parent :: tr // td // button")private WebElement editButtonOf_Automation_1BHK_propertyNO_2;

	@FindBy (xpath = "//input[@formcontrolname='number']") private WebElement propertyNumber;
	@FindBy (xpath = "//input[@formcontrolname='length']") private WebElement length;
	@FindBy (xpath = "//input[@formcontrolname='breadth']") private WebElement breadth;
	@FindBy (xpath = "//input[@formcontrolname='property_size']") private WebElement totalArea;
	@FindBy (xpath = "//input[@formcontrolname='rate_per_sq_ft']") private WebElement rate;
	@FindBy (xpath = "//input[@formcontrolname='price']") private WebElement totalAmount;
	@FindBy (xpath = "//mat-panel-title[text()='Property Feature ']") private WebElement propertyFeaturesButton;
	@FindBy (xpath = "//mat-select[@formcontrolname='status']") private WebElement statusDropdown;
	@FindBy (xpath = "//mat-option//span[text()='Registered']") private WebElement statusDropdown_Registered;
	@FindBy (xpath = "//mat-option//span[text()='Booked']") private WebElement statusDropdown_booked;
	@FindBy (xpath = "//mat-option//span[text()='Pre Booked']") private WebElement statusDropdown_preBooked;
	
	@FindBy (xpath = "//textarea[@formcontrolname='description']") private WebElement description;
	@FindBy (xpath = "//button[text()=' Submit ']") private WebElement submitButton;
	@FindBy (xpath = "//mat-icon[text()='edit']") private WebElement editIcon;
	

	@FindBy (xpath = "//mat-icon[text()='close']") private WebElement closeIcon;
	
	@FindBy (xpath = "//div[text()=' Message:  ']")private WebElement errorMessageDuplicatePropertyNo;
    @FindBy (xpath = "//button[text()=' Add Property Unit Details ']")private WebElement addPropertyUnit_Button;
    @FindBy (xpath = "//input[@Type='checkbox'] / parent :: span ")private WebElement selectAll_Checkbox;
    @FindBy (xpath = "//table//tr")private WebElement rowSize;
    @FindBy (xpath = "//div[text()=' Items per page: '] / parent :: div / following-sibling :: div // div")WebElement totalNoOfProperties;
	@FindBy (xpath = "//button[@aria-label='Next page']")private WebElement nextPage_Button;
	@FindBy (xpath = "//div[text()='Update Property Price']")private WebElement updateProperty_TextField;
	@FindBy (xpath = "//div[text()='Update Property Price'] / following-sibling :: form // mat-form-field")public WebElement changeRate_Dropdown;
	@FindBy (xpath = "//mat-option//span[text()='Direct Amount']")public WebElement changeRate_Dropdown_DirectAmount;
	@FindBy (xpath = "//mat-option//span[text()='Rate per Sqft']")public WebElement changeRate_Dropdown_RatePerSqFt;
	@FindBy (xpath = "//mat-option//span[text()='Rate In Persent']")public WebElement changeRate_Dropdown_RateInPercent;
	@FindBy (xpath = "//input[@formcontrolname='changePrice']") public WebElement enterPrice_input;
	@FindBy (xpath = "//button[text()=' Update ']") WebElement update_Button;
	@FindBy (xpath = "//button[contains(text(),'Yes')]") WebElement changeRate_Yes_Button;
	
	
	public void propertiesIcon()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [text()='Properties']")));
		propertiesIcon.click();
	}
	public void propertyPriceAndStatusIcon()
	{
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [text()='Properties']")));
		propertyPriceAndStatusIcon.click();
	}
	public void addPropertiesButton()
	{
		j.executeScript("arguments[0].click()",addPropertyUnit_Button);
	
	}

	public void selectAllCheckBox()
	{
		selectAll_Checkbox.click();
	
	}
	public void toCheckthatSlectAllPropertiesOrNot() throws InterruptedException
	{
		String TotalNoOfProperties=totalNoOfProperties.getText();
		String[] index=TotalNoOfProperties.split(" ");
		String TotalProperies = index [4];
		int d =Integer.valueOf(TotalProperies); //31
		int b= (d/10)+1; //4
		int c = d%10;  //1
		
		
		for (int i=1; i<=b; i++)
		{		
			if (i!=b) 
			{
				for (int j=1; j<=10; j++)
				{
					try
					{
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{
							boolean result=driver.findElement(By.xpath("(//table//tr//td//mat-checkbox//label//span//input)["+j+"]")).isSelected();				
							a.assertEquals(result, true); 
								
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				
				}
				
			}
			
			Thread.sleep(1000);
			nextPage_Button.click(); //1,2
			Thread.sleep(3000);	
			
			if (i==b)
			{
				for (int k=1; k<=c; k++)
				{
					try
					{
			
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{	
							boolean result=driver.findElement(By.xpath("(//table//tr//td//mat-checkbox//label//span//input)["+k+"]")).isSelected();				
							a.assertEquals(result, true);//System.out.println("if "+result);
							
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				}
			
				break;
			}
			
		}

		a.assertAll();
	}
	public void toGetAllOldPrice() throws InterruptedException
	{
		String TotalNoOfProperties=totalNoOfProperties.getText();
		String[] index=TotalNoOfProperties.split(" ");
		String TotalProperies = index [4];
		int d =Integer.valueOf(TotalProperies); //31
		int b= (d/10)+1; //4
		int c = d%10;  //1
		
		
		for (int i=1; i<=b; i++)
		{		
			if (i!=b) 
			{
				for (int j=1; j<=10; j++)
				{
					try
					{
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{
							Thread.sleep(1000); 
							oldArray[oldPrice] =driver.findElement(By.xpath("//table//tr["+j+"]//td[8]")).getText();	
							toalArea [areaIndex] = driver.findElement(By.xpath("//table//tr["+j+"]//td[6]")).getText();
							this.oldPrice++;	
							this.areaIndex++;
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				
				}
				
			}
			
			Thread.sleep(1000);
			nextPage_Button.click(); //1,2
			Thread.sleep(3000);	
			
			if (i==b)
			{
				for (int k=1; k<=c; k++)
				{
					try
					{
			
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{	
							Thread.sleep(1000);	
							oldArray[oldPrice] =driver.findElement(By.xpath("//table//tr["+k+"]//td[8]")).getText();	
							toalArea [areaIndex] = driver.findElement(By.xpath("//table//tr["+j+"]//td[6]")).getText();
							this.oldPrice++;		
							this.areaIndex++;
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				}
			
				break;
			}
		
	
			
		}
		a.assertAll();
	}
	
	public void toCheckThatOpenUpdatePropertyFieldOrNot()
	{
		boolean result=updateProperty_TextField.isDisplayed();
		a.assertEquals(result, true);
		a.assertAll();
	}
	public void user_select_type_as_a_change_rate() throws InterruptedException
	{
		changeRate_Dropdown.click();
		Thread.sleep(1000);
		changeRate_Dropdown_DirectAmount.click();
	}

	public void enterPrice_input(String price)
	{
		enterPrice_input.sendKeys(price);
	}
	public void update_Button() throws InterruptedException
	{
		update_Button.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes')]")));
		changeRate_Yes_Button.click();
	}
	public void price_of_all_properties_should_be_change_or_not() throws InterruptedException
	{
	
		String TotalNoOfProperties=totalNoOfProperties.getText();
		String[] index=TotalNoOfProperties.split(" ");
		String TotalProperies = index [4];
		int d =Integer.valueOf(TotalProperies); //31
		int b= (d/10)+1; //4
		int c = (d%10)+1;  //2
		

		for (int i=1; i<=b; i++)
		{		
			if (i!=b) 
			{
				for (int j=1; j<=10; j++)
				{
					try
					{
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{	
							Thread.sleep(1000);
							newArray[newPrice] =driver.findElement(By.xpath("//table//tr["+j+"]//td[8]")).getText();	
						
							this.newPrice++;		
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				
				}
				
			}
			
			Thread.sleep(1000);
			nextPage_Button.click(); //1,2
			Thread.sleep(3000);	
			
			if (i==b)
			{
				for (int k=1; k<=c; k++)
				{
					try
					{
			
						String status=driver.findElement(By.xpath("(//table//tr//td[10])["+j+"]")).getText();
						if (status.equals("Stock"))
						{	
							Thread.sleep(1000);
							newArray[newPrice] =driver.findElement(By.xpath("//table//tr["+k+"]//td[8]")).getText();	
							this.newPrice++;		
						}
					}
					catch (NoSuchElementException e)
					{
						a.assertTrue(true);
					}
				}
			
				break;
			}
			a.assertAll();		
		}	
			
	}
	public  void ChangePrice_DirectAmount(String price) throws InterruptedException
	{
		for (int x=0; x<oldPrice; x++)
		{
			Thread.sleep(1000);
			
			String NewPrice [] = newArray[x].split(" ");
			String OldPrice []= oldArray[x].split(" ");
			
			String n =NewPrice[1];
			String o = OldPrice[1];
			
			float N =Float.parseFloat(n);
			float O =Float.parseFloat(o);
			float P= Float.parseFloat(price);
	
			float changedPrice =O+P;
			String New= String.valueOf(changedPrice);
			a.assertEquals(n, New);
		}
		a.assertAll();		
	}
	
	public  void ChangePrice_RatePerSqFt(String price) throws InterruptedException
	{
		for (int x=0; x<oldPrice; x++)
		{
			Thread.sleep(1000);
			
			String NewPrice [] = newArray[x].split(" ");
			String OldPrice []= oldArray[x].split(" ");
			String n =NewPrice[1];
			String o = OldPrice[1];
			
			String area=toalArea [x];
			
			float N =Float.parseFloat(n);
			float O =Float.parseFloat(o);
			float P= Float.parseFloat(price);
			float ara =Float.parseFloat(area);
			
			float changedPrice =O+P;
			float changedPrice_sqft= (ara*P)+O;
			
			String New= String.valueOf(changedPrice_sqft);
			
			a.assertEquals(n, New);
		}
		a.assertAll();		
	}
	
	public  void ChangePrice_RateInPercent(String price) throws InterruptedException
	{
		for (int x=0; x<oldPrice; x++)
		{
			Thread.sleep(1000);
			
			String NewPrice [] = newArray[x].split(" ");
			String OldPrice []= oldArray[x].split(" ");
			String n = NewPrice[1];
			String o = OldPrice[1];
			
			float N =Float.parseFloat(n);
			float O =Float.parseFloat(o);      // For arithmetical calculation convert data from string into float
			float P= Float.parseFloat(price);
			
			float changedPrice_percent = (P/100)*(O)+(O);
			
			String New= String.valueOf(changedPrice_percent);
			
			a.assertEquals(n, New);
		}
		a.assertAll();		
	}
		
	


}
