package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.testng.asserts.SoftAssert;

public class Dashboard {
	public static WebDriver driver;
	WebDriverWait w;
	SoftAssert a;
	Actions A;
	JavascriptExecutor j ;
	String callCount;
	String meetCount;
	String visitCount;
	String prebookedCount;
	public static String leadPhoneNo;
	String oldArray [] = new String [16];
	String updateArray [] = new String [16];
	int sum=0;
	
	public Dashboard(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
		this.driver = driver;
		w = new  WebDriverWait(driver, Duration.ofSeconds(30));
		a = new SoftAssert();
		A = new Actions(driver);
		j =  (JavascriptExecutor)driver;
	
	}
	@FindBy (xpath ="//div[text()='Dashboard'] / parent :: div / parent :: a / parent :: li")public static WebElement dashbord_ICon;
	@FindBy (xpath = "//button[text()='Refresh']") WebElement refreash_Button;
	@FindBy (xpath = "//div[text()='Analysis Report']") WebElement analysisReport_TextButton;
	@FindBy (xpath = "//div[text()='Effort Report']") public static WebElement effortReport_TextButton;
	@FindBy (xpath = "(//u[text()='New']/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@Class='newCLs'])[1]") WebElement count_Call_New;
	@FindBy (xpath = "(//u[text()='New']/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@Class='newCLs'])[2]") WebElement count_Meet_New;
	@FindBy (xpath = "(//u[text()='New']/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@Class='newCLs'])[3]") WebElement count_Visit_New;
	@FindBy (xpath = "(//u[text()='New']/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@Class='newCLs'])[4]") WebElement count_Prebooked_New;
	@FindBy (xpath = "//span[text()='Active Lead ']//div") WebElement activeLead_Toggle;
	@FindBy (xpath = "//div[text()=' Leads ']") WebElement leadIcon;
	@FindBy (xpath = "//a[@href='/lead/lead?isActiveLeads=true&notConnected=true']") WebElement activeLeadIcon;
	@FindBy (xpath = "//table//tr//td/following-sibling::td//div//button") WebElement editLead_Button;
	@FindBy (xpath = "//div[contains(text(), ' Items per page: ')] / parent :: div / following-sibling :: div//div") WebElement contOfLeadOnPage;
	@FindBy (xpath = "//span[contains(text(), 'Go Back To Dashboard')]/parent::button") public static WebElement goToDashboardButton;
	@FindBy (xpath = "//b[text()='Data Not Found']") WebElement noDataFound_Text;
	@FindBy (xpath = "//mat-select[@formcontrolname='status']") WebElement status_Dropdown;
	@FindBy (xpath = "//mat-option//span[text()='Meet']") WebElement status_Dropdown_Meet;
	@FindBy (xpath = "//mat-option//span[text()='Visit']") WebElement status_Dropdown_Visit;
	@FindBy (xpath = "//input[@formcontrolname='follow_up_date']") WebElement nextFollowUpDate_Calender;
	@FindBy (xpath = "//span[contains(text(),'2023')]") WebElement selectYearMonthDate_Button;
	@FindBy (xpath = "//textarea[@formcontrolname='remark']") WebElement remark;
	@FindBy (xpath = "//span[text()=' Update ']/parent::button") WebElement update_Button;
	@FindBy (xpath = "(//mat-expansion-panel-header)[2]") private WebElement leadPersonalData_Box;
	@FindBy (xpath = "//input[@formcontrolname='phone']") private static WebElement phone;
	@FindBy (xpath = "//input[@data-placeholder='Search']") public static WebElement searchLead_tab;
	@FindBy (xpath = "//input[@formcontrolname='search']") WebElement propertyNo_Search;
	@FindBy (xpath = "//ul//li[@class='nav-item exist-token-list showProperty list']") WebElement selectEnableProperty;
	@FindBy (xpath = "//div[text()='One Time Payment Detail'] / parent :: div") WebElement oneTimePaymentDetails_Text;
	@FindBy (xpath = "//mat-select[@formcontrolname='paymentType']") WebElement paymentTypeOnLeadClosure_Dropdown;
	@FindBy (xpath = "//mat-option//span[text()='Full']") WebElement paymentType_Dropdown_Full;
	@FindBy (xpath = "//mat-option//span[text()='Installment']") WebElement paymentType_Dropdown_Installment;

	@FindBy (xpath = "//button[text()=' Save Prebooking ']") WebElement savePrebooking_Button;
	@FindBy (xpath = "//button[text()=' Proceed to Booking ']")WebElement proceedToBooking_Button;
	@FindBy (xpath = "//span[text()='ADD LEAD']/parent::span/parent::button") public static WebElement addLead_Button;
	
	@FindBy (xpath = "//input[@placeholder='Search Lead']") public static WebElement leadDashboardSearch_Tab;
	@FindBy (xpath = "//button[@class='btn seach_btn']") public static WebElement searchLead_Button;
	@FindBy (xpath = "//span[text()=' Proceed to Pre-Booking ']/parent::button") WebElement proceedToPrebooking_Button;
	
	//Lead closure form/////////////
	@FindBy (xpath = "//div[text()=' Offer Details '] / parent :: div")private WebElement OfferDetails_text;
	@FindBy (xpath = "//label[contains(text(), 'Area wise')]") private WebElement OfferType_AreaWise;
	@FindBy (xpath = "//input[@formcontrolname='total_amount']") private WebElement totalAmount;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div")private WebElement paymentDetails_Text;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div //input [@formcontrolname='amount']") private WebElement tokenAmount;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div // mat-select") private WebElement paymentMode_dropdown;
	@FindBy (xpath = "//mat-option//span[text()='Bank']") private WebElement paymentMode_dropdown_Bank;
	@FindBy (xpath = "//mat-option//span[text()='Cash']") private WebElement paymentMode_dropdown_Cash;
	@FindBy (xpath = "//mat-option//span[text()=' Cheque']") private WebElement paymentMode_dropdown_Cheque;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div // input[@formcontrolname='bankTransictionId']") private WebElement bankTransactionID;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div // input[@formcontrolname='remainingAmount']") private WebElement remainingAmount;
	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div //mat-select[@formcontrolname='checkType']") private WebElement chequeType_Dropdown;
	@FindBy (xpath = "//mat-option//span[text()='Post ']") private WebElement chequeType_Dropdown_Post;
	@FindBy (xpath = "//mat-option//span[text()='Current ']") private WebElement chequeType_Dropdown_Current;

	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div // input[@formcontrolname='checkNo']") private WebElement chequeNo;

	@FindBy (xpath = "//input[@formcontrolname='checkClearDate']") private WebElement calender_SubmissionDate;

	@FindBy (xpath = "//mat-option//span[text()='One Time Payment']") private WebElement paymentType_Dropdown_OneTimePayment;
	@FindBy (xpath = "//mat-option//span[text()='Emi']") private WebElement paymentType_Dropdown_EMI;
	@FindBy (xpath = "//mat-option//span[text()='Other Ways ']") private WebElement paymentType_Dropdown_OtherWays;
	
	//calender
	@FindBy (xpath = "//div[text()='One Time Payment Detail'] / parent :: div / following-sibling :: div // input[@formcontrolname='payment_schedule']") WebElement selectDate_OneTimePayment_Calender;
	@FindBy (xpath = "//span[contains(text(),'2023')] / parent :: span / parent :: button") WebElement selectYearMonthDate_Calender;
	
	
	@FindBy (xpath = "//div[text()=' Terms and Conditions ']") WebElement TermAndConditions_Text;
	@FindBy (xpath = "//div[text()=' Terms and Conditions ']  / parent :: div /following-sibling :: div //  cdk-accordion-item") WebElement drag;
	@FindBy (xpath = "//h2[text()='Selected Term and Condition'] /parent :: div//div[@class='cdk-drop-list example-list']") WebElement drop;
	@FindBy (xpath = "//button[text()=' Submit ']") WebElement submit_Button;
	@FindBy (xpath ="//div[@class='existing-token-dropdown ng-star-inserted']")WebElement dialogBox;
	@FindBy (xpath = "//mat-select[@formcontrolname='Payment_Type']") WebElement paymentType_Dropdown;
	@FindBy (xpath = "//button[text()=' Expand Me ']")public static WebElement expandMe_Button;
	public void refreash_Button()
	{
		refreash_Button.click();
		
	}
	public void analysisReport_TextButton() throws InterruptedException
	{
		analysisReport_TextButton.click();
	}
	public void user_click_on_lead_icon()
	{
		A.moveToElement(leadIcon).click().build().perform();
	}
	public void cick_on_active_lead_sub_menu_option()
	{
		A.moveToElement(activeLeadIcon).click().build().perform();
	}

	public void all_status_and_stages_should_be_visible_with_sequencial_order()
	{

		String order [] = new String[4];
		order[0]= "Call";
		order[1]= "Meet";
		order[2]= "Visit";
		order[3]= "Pre-Booked";
		
		int sequence=0;
		
		for (int i=1; i<=4; i++)
		{
		    String expected=order[sequence];
		    sequence++;
           String actual=driver.findElement(By.xpath("(//div[@Class='d-flex flex-column'])[2]//div[@Class='labelCLs']["+i+"]")).getText();
           a.assertEquals(actual, expected);
          
		}
		
		 a.assertAll();
	}
	public void active_lead_count_should_be_equal_to_total_analysis_report_count()
	{
		String totalActiceCount=activeLead_Toggle.getText();
		int sum =0;
		
		for (int i=1; i<=16; i++)
		{
			String count=driver.findElement(By.xpath("(//u/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@routerlink='/lead/lead'])["+i+"]")).getText();
			 	
			int countINT=Integer.parseInt(count);
			sum = sum+countINT;
		}
		String totalLeadCountOnDashbord=String.valueOf(sum);
		
//		a.assertEquals(totalActiceCount, totalLeadCountOnDashbord);
		a.assertAll();	
	}
	public void user_should_be_redirect_on_those_specific_lead_page_by_click_on_button_and_check_count_of_lead_on_page_is_same_as_showing_on_dashboard() throws InterruptedException
	{
		for (int i=1; i<=16; i++)
		{	
			Thread.sleep(1000);
			WebElement countButton=driver.findElement(By.xpath("(//u/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@routerlink='/lead/lead'])["+i+"]"));
		    String noOnDashboard=countButton.getText(); 	
			
		    if (noOnDashboard.equals("0"))
		    {
		    	countButton.click();
		    	boolean result=noDataFound_Text.isDisplayed();
		    	Thread.sleep(1000);
			    goToDashboardButton.click();
			    a.assertEquals(result, true);
		    }
		    else
		    {
		    	countButton.click();
			    Thread.sleep(1000);
			    String countText=contOfLeadOnPage.getText();
			    String splitedCountArray []=countText.split(" ");
			    String noOnLeadPage=splitedCountArray[4];
			    Thread.sleep(1000);
			    goToDashboardButton.click();
			    
			    a.assertEquals(noOnDashboard, noOnLeadPage);
		    }   
		}
		
		a.assertAll();
	}
	public void user_change_or_convert_the_lead_into_perticular_status(String Status) throws InterruptedException
	{
		Thread.sleep(2000);j.executeScript("arguments[0].click();", editLead_Button);
		Thread.sleep(2000);
		
		nextFollowUpDate_Calender.click();
		selectYearMonthDate_Button.click();
		utility.Calender.currentCalenderYear(driver);
		utility.Calender.currentCalenderMonth(driver);
		utility.Calender.currentCalenderDate(driver);
		
		
		if (Status.equals("Meet"))
		{
			status_Dropdown.click();
			Thread.sleep(1000);status_Dropdown_Meet.click();
			remark.sendKeys("Convert from call to meet");
			j.executeScript("arguments[0].scrollIntoView(true);", update_Button);
			Thread.sleep(1000); update_Button.click();
		}
		else if (Status.equals("Visit"))
		{
			status_Dropdown.click();
			Thread.sleep(1000);status_Dropdown_Visit.click();
			remark.sendKeys("Convert from meet to vist");
			j.executeScript("arguments[0].scrollIntoView(true);", update_Button);
			Thread.sleep(1000); update_Button.click();
		}
		else if (Status.equals("Prebooked"))
		{
			status_Dropdown.click();
			Thread.sleep(1000);status_Dropdown_Visit.click();
			remark.sendKeys("Convert from visit to prebooked");
			
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", proceedToPrebooking_Button);
			Thread.sleep(2000);proceedToPrebooking_Button.click();
			
			Thread.sleep(2000);propertyNo_Search.sendKeys("104");
			Thread.sleep(2000);
			A.moveToElement(selectEnableProperty).click().build().perform();
			
			Thread.sleep(1000);paymentType_Dropdown.click();
			Thread.sleep(1000);paymentType_Dropdown_Full.click();
			Thread.sleep(1000);savePrebooking_Button.click();
	
		}
		else if (Status.equals("booked"))
		{
			status_Dropdown.click();
			Thread.sleep(1000);status_Dropdown_Visit.click();
			remark.sendKeys("Convert from visit to prebooked");
			
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", proceedToPrebooking_Button);
			Thread.sleep(2000);proceedToPrebooking_Button.click();
			
			Thread.sleep(2000);propertyNo_Search.sendKeys("104");
			Thread.sleep(2000);
		
			A.scrollToElement(selectEnableProperty).perform();
			Thread.sleep(2000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li[@class='nav-item exist-token-list showProperty list']")));
			A.moveToElement(selectEnableProperty).click().build().perform();
			
			Thread.sleep(1000);paymentType_Dropdown.click();
			Thread.sleep(1000);paymentType_Dropdown_Full.click();
			Thread.sleep(1000);proceedToBooking_Button.click();
		
			Thread.sleep(2000);
			j.executeScript("arguments[0].scrollIntoView()", OfferDetails_text);
			Thread.sleep(2000);
			OfferType_AreaWise.click();
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView()", paymentDetails_Text);
			Thread.sleep(2000);
			tokenAmount.sendKeys("1000");
				
			paymentMode_dropdown.click();
			Thread.sleep(1000);
			paymentMode_dropdown_Bank.click();
			
			bankTransactionID.sendKeys(utility.UtilityClass.getRandomIntegers(7));
			
			paymentTypeOnLeadClosure_Dropdown.click();
			Thread.sleep(1000);
			paymentType_Dropdown_OneTimePayment.click();
			
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView()", oneTimePaymentDetails_Text);
			Thread.sleep(2000);
			selectDate_OneTimePayment_Calender.click();
			selectYearMonthDate_Calender.click();
			utility.Calender.currentCalenderYear(driver);
			utility.Calender.currentCalenderMonth(driver);
			utility.Calender.currentCalenderDate(driver);

			j.executeScript("arguments[0].scrollIntoView()", TermAndConditions_Text);
			Thread.sleep(2000);
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Terms and Conditions ']  / parent :: div /following-sibling :: div //  cdk-accordion-item")));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Selected Term and Condition'] /parent :: div//div[@class='cdk-drop-list example-list']")));
	
			A.clickAndHold(drag)
			.moveToElement(drop)
			.release(drop)
			.build().perform();
				
			j.executeScript("arguments[0].scrollIntoView()", submit_Button);
			Thread.sleep(1000);
			submit_Button.click();
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			
		}
			
	
	    Thread.sleep(2000); j.executeScript("window.scrollBy(1000,-1000)", "");
	    Thread.sleep(2000); goToDashboardButton.click();
	    
	   
	}


	public void impact_of_changing_status_should_be_show_on_the_dashboard_of_analysis_report(String Status) throws InterruptedException
	{
		if (Status.equals("Meet"))
		{
			 for (int i=0; i<=15; i++)
			    {
			    	if (i==0 || i==4) 
			    	{
			    		int actualCallCount=Integer.valueOf(oldArray[0])-1;
			    		int ExpectedCallCount=Integer.valueOf(updateArray[0]);
			    		a.assertEquals(actualCallCount, ExpectedCallCount);
			    		
			    		int actualMeetCount=Integer.valueOf(oldArray[4])+1;
			    		int ExpectedMeetCount=Integer.valueOf(updateArray[4]);
			    		a.assertEquals(actualMeetCount, ExpectedMeetCount);
			    	}
			    	else
			    	{
			    		a.assertEquals(oldArray[i], updateArray[i]);
			    	}
			    }
		}
		else if (Status.equals("Visit"))
		{
			 for (int i=0; i<=15; i++)
			    {
			    	if (i==0 || i==8) 
			    	{
			    		int actualMeetCount=Integer.valueOf(oldArray[0])-1;
			    		int ExpectedMeetCount=Integer.valueOf(updateArray[0]);
			    		a.assertEquals(actualMeetCount, ExpectedMeetCount);
			    		
			    		int actualVisitCount=Integer.valueOf(oldArray[8])+1;
			    		int ExpectedVisitCount=Integer.valueOf(updateArray[8]);
			    		a.assertEquals(actualVisitCount, ExpectedVisitCount);
			    	}
			    	else
			    	{
			    		a.assertEquals(oldArray[i], updateArray[i]);
			    	}
			    }
		}
		else if (Status.equals("Prebooked"))
		{
			 for (int i=0; i<=15; i++)
			    {
			    	if (i==0 || i==12) 
			    	{
			    		int actualVisitCount=Integer.valueOf(oldArray[0])-1;
			    		int ExpectedVisitCount=Integer.valueOf(updateArray[0]);
			    		a.assertEquals(actualVisitCount, ExpectedVisitCount);
			    		
			    		int actualPrebookedCount=Integer.valueOf(oldArray[12])+1;
			    		int ExpectedPrebookedCount=Integer.valueOf(updateArray[12]);
			    		a.assertEquals(actualPrebookedCount, ExpectedPrebookedCount);
			    	}
			    	else
			    	{
			    		a.assertEquals(oldArray[i], updateArray[i]);
			    	}
			    }
		}
		a.assertAll();
				
	}
	
	public void getAllOldDataFromDashboard() throws InterruptedException
	{

		Thread.sleep(1000); refreash_Button.click();
		Thread.sleep(2000);
		int index=0;
		System.out.print("Old Arrays:  ");
		for (int i=1; i<=16; i++)
		{
			oldArray[index]=driver.findElement(By.xpath("(//u/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@routerlink='/lead/lead'])["+i+"]")).getText();
			System.out.print(index+"] "+oldArray[index]+"   ");
			
			index++;	
		}
		System.out.println();
	}
	public void getAllUpdateDataFromDashboard() throws InterruptedException
	{
		Thread.sleep(1000); refreash_Button.click();
		Thread.sleep(2000);
		int index=0;
		System.out.print("New Arrays:  ");
		for (int i=1; i<=16; i++)
		{
			updateArray[index]=driver.findElement(By.xpath("(//u/parent::div/parent::div/parent:: div/parent::div/parent::div/following::div//div[@routerlink='/lead/lead'])["+i+"]")).getText();
			System.out.print(index+"] "+updateArray[index]+"   ");
			index++;	
		}
		System.out.println();
	}
	public void first_call_considerd_as_new_statge()
	{
	
			int actual=Integer.valueOf(oldArray[0])+1;
			int expected=Integer.valueOf(updateArray[0]);
			a.assertEquals(actual, expected);
		
		    a.assertAll();
	}
	public void this_lead_considered_as_perticular_stage(Integer i)
	{
		if (i==2)
		{
			for (int j=0; j<=15; j++)
			{
				if (j==1 || j==0)
				{	
					int actualNew=Integer.valueOf(oldArray[0])-1;   // for primary statge
					int expectedNew=Integer.valueOf(updateArray[0]);
					a.assertEquals(actualNew, expectedNew);
					
					int actualPrimary=Integer.valueOf(oldArray[1])+1;   // for primary statge
					int expectedPrimary=Integer.valueOf(updateArray[1]);
					a.assertEquals(actualPrimary, expectedPrimary);
				}
				else
				{
					int actualPrimary=Integer.valueOf(oldArray[j]);   // for primary statge
					int expectedPrimary=Integer.valueOf(updateArray[j]);
					a.assertEquals(actualPrimary, expectedPrimary);
				}
		
			}
			
		}
		else if (i==3  || i==4 || i==5) 
		{
			
			for (int j=0; j<=15; j++)
			{
						
				a.assertEquals(oldArray[j], updateArray[j]);	
		
			}
		}

		else if (i==6) 
		{	
			for (int j=0; j<=15; j++)
		
		
			if (j==1 || j==2)
			{	
				int actualPrimary=Integer.valueOf(oldArray[1])-1;   // for primary statge
				int expectedPrimary=Integer.valueOf(updateArray[1]);
				a.assertEquals(actualPrimary, expectedPrimary);
				
				int actualSecondary=Integer.valueOf(oldArray[2])+1;   // for primary statge
				int expectSecondary=Integer.valueOf(updateArray[2]);
				a.assertEquals(actualSecondary, expectSecondary);
			}
			else
			{
				a.assertEquals(oldArray[j], updateArray[j]);
			}
		
		}
		else if (i==7 || i==8 || i==9 || i==10) 
		{
			for (int j=0; j<=15; j++)
			{				
				a.assertEquals(oldArray[j], updateArray[j]);			
			}
		}
		else if (i==11)
		{
			for (int j=0; j<=15; j++)
				
				
				if (j==2 || j==3)
				{	
					int actualSecondary=Integer.valueOf(oldArray[2])-1;   // for primary statge
					int expectSecondary=Integer.valueOf(updateArray[2]);
					a.assertEquals(actualSecondary, expectSecondary);
					
					int actualTertiary=Integer.valueOf(oldArray[3])+1;   // for primary statge
					int expectTertiary=Integer.valueOf(updateArray[3]);
					a.assertEquals(actualTertiary, expectTertiary);
				}
				else
				{
					a.assertEquals(oldArray[j], updateArray[j]);
				}
		}
		else if (i>=12)
		{
			for (int j=0; j<=15; j++)
			{				
				a.assertEquals(oldArray[j], updateArray[j]);			
			}
		}
		
	
	    a.assertAll();
		
	}
	public void this_lead_considered_as_new_stage_for_perticular_status(String Status)
	{
		if (Status.equals("Meet"))
		{
			for (int i=0; i<=15; i++)
			{
				if (i==1 || i==4)
				{
					int actualCall=Integer.valueOf(oldArray[1])-1;
					int expectedCall=Integer.valueOf(updateArray[1]);
					a.assertEquals(actualCall, expectedCall);
					
					int actualMeet=Integer.valueOf(oldArray[4])+1;
					int expectedMeet=Integer.valueOf(updateArray[4]);
					a.assertEquals(actualMeet, expectedMeet);		
				}
				else
				{
					a.assertEquals(oldArray[i], updateArray[i]);
				}
			}
		}
		
		else if (Status.equals("Visit"))
		{
			for (int i=0; i<=15; i++)
			{
				if (i==1 || i==8)
				{
					int actualCall=Integer.valueOf(oldArray[1])-1;
					int expectedCall=Integer.valueOf(updateArray[1]);
					a.assertEquals(actualCall, expectedCall);
					
					int actualMeet=Integer.valueOf(oldArray[8])+1;
					int expectedMeet=Integer.valueOf(updateArray[8]);
					a.assertEquals(actualMeet, expectedMeet);		
				}
				else
				{
					a.assertEquals(oldArray[i], updateArray[i]);
				}
			}
		}
		
		else if (Status.equals("Prebooked"))
		{
			for (int i=0; i<=15; i++)
			{
				if (i==1 || i==8)
				{
					int actualCall=Integer.valueOf(oldArray[1])-1;
					int expectedCall=Integer.valueOf(updateArray[1]);
					a.assertEquals(actualCall, expectedCall);
					
					int actualMeet=Integer.valueOf(oldArray[12])+1;
					int expectedMeet=Integer.valueOf(updateArray[12]);
					a.assertEquals(actualMeet, expectedMeet);		
				}
				else
				{
					a.assertEquals(oldArray[i], updateArray[i]);
				}
			}
		}
		
		a.assertAll();
	
	}
	public void this_lead_should_not_considered_in_analysis_report(String Status)
	{
		if (Status.equals("Prebooked"))
		{
			for (int i=0; i<=15; i++)
			{
				if (i==12)
				{
					int actualPrebooked=Integer.valueOf(oldArray[12])-1;
					int expectedPrebooked=Integer.valueOf(updateArray[12]);
					a.assertEquals(actualPrebooked, expectedPrebooked);
							
				}
				else
				{
					a.assertEquals(oldArray[i], updateArray[i]);
				}
			}
			a.assertAll();
			
		}
	}
	public void Redirect_On_active_log_pop_up() throws InterruptedException
	{
		for (int i=1; i<=4;i++)
		{
			for (int j=1; j<=4; j++)
			{
				 System.out.println("Row no: "+i+", And Column no: "+j);
				String count=driver.findElement(By.xpath("(//div[@class='mydiv1'])["+i+"]//div["+j+"]")).getText();
				driver.findElement(By.xpath("(//div[@class='mydiv1'])["+i+"]//div["+j+"]")).click();
				
				// verify active log pop up open or not
				Thread.sleep(1000);
				boolean activeLog=driver.findElement(By.xpath("//div[text()='Activity Log']")).isDisplayed();
				a.assertEquals(activeLog, true);
				
				// Verify Sum of Count for all active log should be equal to the count on buttons of effort report
				for (int c=0; c<=10;c++)  // To down page for detect all elements whichever is present on page
				{
					Thread.sleep(1000);
					A.sendKeys(Keys.ARROW_DOWN).perform();
				}
				List<WebElement> matchingElements = driver.findElements(By.xpath("//mat-panel-title")); //Store all elements into List of webelement interface
				Thread.sleep(4000);
			   int NumOfMatchingElements =matchingElements.size(); // Get size from  List of webelement interface
			 
				try
				{
					for (int k=1; k<=NumOfMatchingElements; k++) // To get Sum of all lead 
					{
						
						String leadName=driver.findElement(By.xpath("(//mat-panel-title)["+k+"]")).getText();
						String arrayLeadName[]=leadName.split(" ");
						int length=arrayLeadName.length;
						String reamrkCount=arrayLeadName[length-1];
						String replace1=reamrkCount.replace("(", "");
						reamrkCount=replace1.replace(")", "");	
						int count1=Integer.valueOf(reamrkCount);
					    sum=sum+count1; 
					    
					    
					    
					}
				}
				catch (NoSuchElementException e)
				{
					a.assertTrue(true);
					break;
				}
				
				 String TotalSum=String.valueOf(sum);
				 System.out.println("Actual count on report: "+count+", Expected count of active log: "+TotalSum);
				 System.out.println("===============================================");
				 a.assertEquals(count, TotalSum);
				 sum=0;
				 Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
			
		}
		
		a.assertAll();
	}
	public void remark_should_be_display_against_particular_call_times() throws InterruptedException
	{for (int i=1; i<=4;i++)
	{
		for (int j=1; j<=4; j++)
		{
			 System.out.println("Row no: "+i+", And Column no: "+j);
			String count=driver.findElement(By.xpath("(//div[@class='mydiv1'])["+i+"]//div["+j+"]")).getText();
			driver.findElement(By.xpath("(//div[@class='mydiv1'])["+i+"]//div["+j+"]")).click();
			
			
			// Remark should be display against particular call times
			
			// Verify Sum of Count for all active log should be equal to the count on buttons of effort report
			for (int c=0; c<=10;c++)  // To down page for detect all elements whichever is present on page
			{
				Thread.sleep(1000);
				A.sendKeys(Keys.ARROW_DOWN).perform();
			}
			List<WebElement> matchingElements = driver.findElements(By.xpath("//mat-panel-title")); //Store all elements into List of webelement interface
			Thread.sleep(4000);
		   int NumOfMatchingElements =matchingElements.size(); // Get size from  List of webelement interface
		   Thread.sleep(1000); expandMe_Button.click();
			try
			{
				for (int k=1; k<=NumOfMatchingElements; k++) // To get Sum of all lead 
				{
					
					List<WebElement> remarkcount=driver.findElement(By.xpath("(//mat-panel-title)["+k+"]/parent::span/parent::mat-expansion-panel-header/following-sibling::div//b[text()='Remark :']"));
 
				    
				    
				    
				}
			}
			catch (NoSuchElementException e)
			{
				a.assertTrue(true);
				break;
			}
			
			 String TotalSum=String.valueOf(sum);
			 System.out.println("Actual count on report: "+count+", Expected count of active log: "+TotalSum);
			 System.out.println("===============================================");
			 a.assertEquals(count, TotalSum);
			 sum=0;
			 Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		
	}
	
	a.assertAll();
		
	}
	
  	
	

	




}
