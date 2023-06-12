package POM;

import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import utility.UtilityClass;
import java.time.Duration;







public class Booking
{
	
		WebDriver driver;
		WebDriverWait w;
		SoftAssert a;
		Actions A;
		JavascriptExecutor j ;
		String phoneNo_BookedLead;
		public static String name_bookedLead;
		String alternatePhone_BookedLead;
		
		//===============================================================================================================================================================

		// Project dropdown
		@FindBy (xpath = "//mat-select[@formcontrolname='project_id']") private WebElement projectDropdown;
		@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-One 104')]") private WebElement ProjectDropdown_AutomationProject1;
		@FindBy (xpath = "//mat-option//span[contains(text(),'Automation Project-Two 104')]") private WebElement ProjectDropdown_AutomationProject2;
	//===============================================================================================================================================================

		//property 
		@FindBy (xpath = "//mat-option// span[contains(text(), 'Automation 1BHK property 104')]") private WebElement areaOfInterest_Automation_1BHK_Property;
		@FindBy (xpath = "//mat-option// span[contains(text(), 'Automation 2BHK property 104')]") private WebElement areaOfInterest_Automation_2BHK_Property;
	//===============================================================================================================================================================

		//
		@FindBy (xpath = "//mat-icon[text()='add_circle']") private WebElement addProfessionIcon;
		@FindBy (xpath = "//mat-select[@formcontrolname='profession_id']") private WebElement professionDropdown;
		@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //input[@formcontrolname='name']")private WebElement professionName;
		@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //textarea[@formcontrolname='description']")private WebElement professionDescription;
		@FindBy (xpath = "//mat-option//span [contains (text(),'AutomationProfession Doctor' )]") private WebElement professionDropdown_Doctor;
		@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div  //mat-icon[text()='close']")WebElement professionCloseIcon;
		@FindBy (xpath = "//div[text()=' Add Profession '] /parent :: div / parent :: div / following-sibling :: div //button[text()=' Submit ']")private WebElement professionSubmitButton;
	//===============================================================================================================================================================

		//
		@FindBy (xpath = "(//td[contains(text(),'Automation PrebookingLead ab')] / parent :: tr //div //button) [2]") private WebElement editButton_AutomationPrebookingLead;
		@FindBy (xpath = "(//td[contains(text(),'Automation PrebookingLead ab')] / parent :: tr //div //button) [1]") private WebElement editDirect_AutomationPrebookingLead;
		@FindBy (xpath = "(//td[contains(text(),'Automation PrebookedLead ab')] / parent :: tr // div //button) [1]") private WebElement editDirectPrebookingButton_AutomationPrebookedLead;

	//===============================================================================================================================================================

		//
		@FindBy (xpath = "//input[@formcontrolname='search']") private WebElement propertyNo;
		@FindBy (xpath = "//li[contains(text(),'Automation 2BHK property NO -1 104')]")private WebElement propertyNo_2BHK_1;
		@FindBy (xpath = "//li[contains(text(),'Automation 2BHK property NO -2 104')]") private WebElement propertyNo_2BHK_2;
		@FindBy (xpath = "//li[contains(text(),'Automation 1BHK property NO -1 104')]") private WebElement propertyNo_1BHK_1;
		@FindBy (xpath = "//li[contains(text(),'Automation 1BHK property NO -2 104')]") private WebElement propertyNo_1BHK_2;
	//===============================================================================================================================================================

		//
		@FindBy (xpath = "//label[contains(text(),'Automation Offer: Area wise 104')]") private WebElement checkBox_AutomationOffer_AreaWise;
	//===============================================================================================================================================================

		//Lead closure form
		@FindBy (xpath = "//div[text()=' Offer Details ']")private WebElement OfferDetails_text;
		@FindBy (xpath = "//div[text()=' Offer Details '] / parent :: div / following-sibling :: div // mat-panel-title[text()=' Area Wise '] / parent :: span")private WebElement offerDetails_AreaWise_Box;
		@FindBy (xpath = "//mat-panel-title[text()=' Area Wise '] /parent ::span /parent :: mat-expansion-panel-header / following-sibling :: div //div //input [@formcontrolname='type']") private WebElement OfferType_AreaWise;
		@FindBy (xpath = "//mat-panel-title[text()=' Area Wise '] /parent ::span /parent :: mat-expansion-panel-header / following-sibling :: div //div //input [@formcontrolname='name']") private WebElement OfferName_AutomationOffer_Areawise;
		@FindBy (xpath = "//mat-panel-title[text()=' Area Wise '] /parent ::span /parent :: mat-expansion-panel-header / following-sibling :: div //div //input [@formcontrolname='amount']") private WebElement OfferAmount_AreaWise;
	//===============================================================================================================================================================

		//customer icon
		@FindBy (xpath = "//mat-icon[text()='person_off']/ parent :: span/ parent :: button")private WebElement deactivePropertyIcon;
		@FindBy (xpath = "//td[contains(text(), 'Automation BookedLead ab')] / parent :: tr // button")private WebElement veiwIcon_PropertyNo_AutomationBooked;
		@FindBy (xpath = "//div[text()=' Project Details '] / parent :: span")private WebElement Box_ProertyDetails;
		@FindBy (xpath = "//span[contains(text(),'Automation 2BHK property NO -1 104')] / parent :: div / parent :: mat-panel-title / parent :: div / parent :: span")private WebElement Box_Automation_1BHK_PropertyNo1;
	//==========================================================================================================================================================================================================================================================================================================================================================================================
			// Primary contact information
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname= 'lead_id']") private WebElement primaryContact_leadRefrenceName;
			@FindBy (xpath ="//li[contains(text(), ' ')]")private WebElement primaryContact_leadRefrenceName_AtomationBookedLead; 
			@FindBy(xpath="(//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname = 'temp_name'] ) [1]") private WebElement primaryContact_Name;
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//mat-select[@formcontrolname = 'gender']") private WebElement primaryContactGender_Dropdown;
			@FindBy(xpath="//mat-option//span[text()= 'Male'] ") private WebElement primaryContactGender_Male ;
			@FindBy(xpath="//mat-option[@value= 'Female'] ") private WebElement primaryContactGender_Female ;
			@FindBy(xpath="//span[text()= 'Others'] ") private WebElement primaryContactGender_Other ;	
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname= 'email'] ") private WebElement primaryContact_Email;	
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname= 'father_name'] ") private WebElement primaryContact_FatherName;	
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname= 'phone'] ") private WebElement primarycontact_PhoneNo;
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname= 'alternate_phone']") private WebElement primaryContact_AlternateN0 ;
			
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] /parent :: span / parent :: mat-expansion-panel-header") private WebElement primaryContact_CurrentAddress_Box ;
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // textarea[@formcontrolname='address']") private WebElement primaryContact_CurrentAddress ;	
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname='postal_code']") private WebElement primaryContact_CurrentAddress_pinCode ;
			@FindBy(xpath="//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div //mat-select[@formcontrolname='area']") private WebElement primaryContact_CurrentAddress_AreaDropdown;
			@FindBy (xpath = "//mat-option//span[text()=' K.V.Nagar Barshi S.O ']")private WebElement primaryContact_CurrentAddress_AreaDropdown_KV_Nagar;
			@FindBy (xpath = "//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // mat-icon[text()='add']/parent :: span/parent :: button")private WebElement primaryContact_AddIcon;
			@FindBy (xpath = "//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // mat-icon[text()='clear']/parent :: span/parent :: button")private WebElement primaryContact_CloseIcon;
				
			@FindBy (xpath = "//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / parent :: mat-expansion-panel // span[text()='Same as current address '] / parent :: label / parent :: mat-checkbox") private WebElement primaryContact_checkbox_SameAsCurrentAddress;
		    @FindBy (xpath = "//mat-panel-title[text()=' Primary Contact '] / parent :: span / parent :: mat-expansion-panel-header / parent :: mat-expansion-panel // mat-panel-title[text()=' Documents '] / parent :: span")private WebElement primaryContact_PermanentAddressDocument_box;


		  //=========================================================================================================================================================================================================
		 
		    // Secondary contact information
			@FindBy(xpath="(//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname = 'temp_name'] ) [1]") private WebElement secondaryContact_Name;
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//mat-select[@formcontrolname = 'gender']") private WebElement secondaryContactGender_Dropdown;	
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div//input[@formcontrolname= 'email'] ") private WebElement secondaryContact_Email;	
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname= 'Secfather_name'] ") private WebElement secondaryContact_FatherName;	
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div  // input[@formcontrolname='phone']") private WebElement secondarycontact_PhoneNo;
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname= 'alternate_phone']") private WebElement secondaryContact_AlternateN0 ;
			
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] /parent :: span / parent :: mat-expansion-panel-header") private WebElement secondaryContact_CurrentAddress_Box ;
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // textarea[@formcontrolname='address']") private WebElement secondaryContact_CurrentAddress ;	
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div //input[@formcontrolname='postal_code']") private WebElement secondaryContact_CurrentAddress_pinCode ;
			@FindBy(xpath="//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div //mat-select[@formcontrolname='area']") private WebElement secondaryContact_CurrentAddress_AreaDropdown;
			@FindBy (xpath = "//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // mat-icon[text()='add']/parent :: span/parent :: button")private WebElement secondaryContact_AddIcon;
			@FindBy (xpath = "//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / following-sibling :: div //mat-panel-title[text()= ' Current Address '] / parent :: span /parent :: mat-expansion-panel-header / following-sibling :: div // mat-icon[text()='clear']/parent :: span/parent :: button")private WebElement secondaryContact_CloseIcon;
				
			@FindBy (xpath = "//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / parent :: mat-expansion-panel // span[text()='Same as current address '] / parent :: label / parent :: mat-checkbox") private WebElement secondaryContact_checkbox_SameAsCurrentAddress;
		    @FindBy (xpath = "//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / parent :: mat-expansion-panel // mat-panel-title[text()=' Documents '] / parent :: span")private WebElement secondaryContact_PermanentAddress_box;
		    @FindBy (xpath= "//mat-panel-title[text()=' Secondary Contact Information '] / parent :: span / parent :: mat-expansion-panel-header / parent :: mat-expansion-panel // input[@formcontrolname='relation_with_customer']")private WebElement secondaryContact_RelationWithCustomer;
	//==========================================================================================================================================================================================================================================================================================================================================================================================

		    // Property details
		    @FindBy (xpath= "//mat-panel-title[text()=' Property Details * '] / parent :: span")private WebElement propertyDetails_Box;
		    @FindBy (xpath = "//p[text()='  Now Booking ']")private WebElement nowBooking;

	//===========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================

		    //search tab of customer
		    @FindBy (xpath = "//input[@data-placeholder='Search']")private  WebElement searchTab_Customer;
	//===============================================================================================================================================================
		    //
		  	@FindBy (xpath = "//span[contains(text(), 'Automation Project-Two 104')] / parent :: li[contains(text(),'Automation 2BHK property NO -1 104')]")private WebElement automationProjectTwo_propertyNo_2BHK_1;
		  	@FindBy (xpath = "//span[contains(text(), 'Automation Project-Two 104')] / parent :: li[contains(text(),'Automation 2BHK property NO -2 104')]") private WebElement automationProjectTwo_propertyNo_2BHK_2;
		  	@FindBy (xpath = "//span[contains(text(), 'Automation Project-Two 104')] / parent :: li[contains(text(),'Automation 1BHK property NO -1 104')]") private WebElement automationProjectTwo_propertyNo_1BHK_1;
		  	@FindBy (xpath = "//span[contains(text(), 'Automation Project-Two 104')] / parent :: li[contains(text(),'Automation 1BHK property NO')]") private WebElement automationProjectTwo_propertyNo_1BHK_2;
	//===============================================================================================================================================================
			
		@FindBy (xpath = "//div[text()=' Leads ']") private WebElement leadsIcon;
		@FindBy (xpath = "//a[text()='Active Leads'] / parent :: li") private WebElement activeLeadIcon;
		@FindBy (xpath = "//a[text()=' A+(Hot) ']") private WebElement AHot_Icon;
		@FindBy (xpath = "//button[text()=' New Lead ']") private WebElement newLeadButton;
		@FindBy (xpath = "//mat-select[@formcontrolname='category']") private WebElement categoryDropdown;
		@FindBy (xpath = "//mat-option//*[text()='A+(Hot)']") private WebElement category_Hot_A;
		@FindBy (xpath = "//mat-option//*[text()='A(Warm)']") private WebElement category_warm_A;
		@FindBy (xpath = "//mat-option//*[text()='B+(Cold)']") private WebElement category_cold_B;
		
		@FindBy (xpath = "//button[text()=' Prebooking ']") private WebElement prebookingButton;
		@FindBy (xpath = "//span[text()=' Proceed to Pre-Booking '] / parent :: button") private WebElement proceedToPreBookingButton;
		@FindBy (xpath = "//span[text()='Update'] / parent :: button") private WebElement updateButton;
		@FindBy (xpath = "//mat-icon[text()='add']") private WebElement addIcon;
		
		@FindBy (xpath = "//input[@formcontrolname='lead_id']") public static WebElement searchCustomer_Tab;

		@FindBy (xpath = "//mat-select[@formcontrolname='Payment_Type']") private WebElement paymentTypeDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Full']") private WebElement paymentTypeDropdown_Full;
		@FindBy (xpath = "//mat-option//span[text()='Installment']") private WebElement paymentTypeDropdown_Installment;
		
		@FindBy (xpath = "//table//td[text()=' 1 BHK']") private WebElement selectedProperty;
		@FindBy (xpath = "//span[text()=' attach_file '] / preceding-sibling :: textarea") private WebElement comments;
		
		@FindBy (xpath = "//button[text()=' Show Property Details ']") private WebElement showPropertyDetailsButton;
		@FindBy (xpath = "//label[text()='Feb'] / parent :: td // preceding-sibling :: td // input") private WebElement SpecialOffer_Feb;
		
		@FindBy (xpath = "//span[text()=' View Offers '] / parent :: button") private WebElement veiwOffersButton;
		@FindBy (xpath = "//button[text()=' Add Special Offer ']") private WebElement addSpecialOfferButton;
		@FindBy (xpath = "(//button[text()=' Proceed to Booking '])[2]") private WebElement proceedToPrebooking;
		@FindBy (xpath = "//mat-icon[text()='close']") private WebElement closeIcon;
		
		@FindBy (xpath = "//input[@formcontrolname='follow_up_date']") private WebElement Calender_follow_up_date;
		@FindBy (xpath = "//input[@formcontrolname='follow_up_date']") private WebElement calender_expetedVisitDate;
		@FindBy (xpath = "//span[contains(text(),'2023')] / parent :: span / parent :: button") private WebElement calenderButton;
		@FindBy (xpath = "//table//div[text()=' 2023 ']") private WebElement calender_Year_2023;
		@FindBy (xpath = "//table//div[text()=' MAR ']") private WebElement calender_Month_MAR;
		@FindBy (xpath = "//table//div[text()=' 28 ']") private WebElement calender_Date_28;
		
		@FindBy (xpath = "//textarea[@formcontrolname='remark']") private WebElement remark;
		@FindBy (xpath = "//button//span[text()=' Submit ']") private WebElement submitButton;
		 
		@FindBy (xpath = "//a[@href='/lead/lead?todayfollowup=2023-01-27']") private WebElement todaysFollowUp_Icon;
		@FindBy (xpath = "//a[text()=' Other Lead ']") private WebElement otherLead_Icon;
		
		@FindBy (xpath = "//a[text()='Deactive Leads']") private WebElement deactiveLead_Icon;
		@FindBy (xpath = "//a[text()=' Deactive By Employee ']") private WebElement deactiveByEmployee_Icon;
		@FindBy (xpath = "//a[text()=' Not Interested ']") private WebElement notInterested_Icon;
		
		@FindBy (xpath = "//a[text()='Booked Leads']") private WebElement bookedLead_Icon;
		@FindBy (xpath = "//a[text()='PreBooking Pending']") private WebElement prebookingPending_Icon;
			
		@FindBy (xpath = "//input[@formcontrolname='cre_user_name']") private WebElement assignUserName;
		@FindBy (xpath = "(//mat-radio-button)[1]") private WebElement selfAssignedCheckbox;
		@FindBy (xpath = "//button[@class='mat-focus-indicator mat-button mat-button-base ng-star-inserted']") private WebElement submitButton_PopUp;
		
		@FindBy (xpath = "//input[@formcontrolname='temp_name']") private WebElement name;
		@FindBy (xpath = "//input[@formcontrolname='phone']") private  WebElement phone;
		@FindBy (xpath = "//input[@formcontrolname='alternate_contact_no']") private WebElement alternatePhone;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='contactability']") private WebElement contactabilityDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Conversation ']") private WebElement contactabilityDropdown_Conversion;
		@FindBy (xpath = "//mat-option//span[text()='Not Connected']") private WebElement contactabilityDropdown_NotConnected;
		@FindBy (xpath = "//mat-option//span[text()='Not Matched']") private WebElement contactabilityDropdown_NotMatched;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='mode_of_interest']") private WebElement modeOfInterestDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Interested']") private WebElement modeOfInterestDropdown_Interested;
		@FindBy (xpath = "//mat-option//span[text()='Not Interested']") private WebElement modeOfInterestDropdown_NotInterested;
		

		@FindBy (xpath = "//textarea[@formcontrolname='address']") private WebElement address;
		@FindBy (xpath = "//input[@formcontrolname='postal_code']") private WebElement pinCode;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='area']") private WebElement areaDropdown;
		@FindBy (xpath = "//mat-option//span[text()=' K.V.Nagar Barshi S.O ']") private WebElement areaDropdown_KV_Nagar;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='city']") private WebElement cityDropdown;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='living_mode']") private WebElement livingModeDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Own House']") private WebElement livingModeDropdown_OwnHouse;
		@FindBy (xpath = "//mat-option//span[text()='Rented']") private WebElement livingModeDropdown_Rented;
		@FindBy (xpath = "//mat-option//span[text()='Family Property']") private WebElement livingModeDropdown_FamilyProperty;

		@FindBy (xpath = "//mat-select[@formcontrolname='status']") private WebElement statusDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Lead ']") private WebElement statusDropdown_Lead;
		@FindBy (xpath = "//mat-option//span[text()='Call ']") private WebElement statusDropdown_Call;
		@FindBy (xpath = "//mat-option//span[text()='Meet ']") private WebElement statusDropdown_Meet;
		@FindBy (xpath = "//mat-option//span[text()='Visit ']") private WebElement statusDropdown_Visit;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='area_of_interest']") private WebElement areaOfInterest;
		@FindBy (xpath = "//mat-option//span[text()=' 1 BHK']") private WebElement areaOfInterest_1BHK;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='buying_purpose']") private WebElement buyingPurposeDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Personal']") private WebElement buyingPurposeDropdown_Personal;
		@FindBy (xpath = "//mat-option//span[text()='Investment']") private WebElement buyingPurposeDropdown_Investment;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='required_plot_size']") private WebElement plotSizeDropdown;
		@FindBy (xpath = "//mat-option//span[text()='Below 600 sqft']") private WebElement plotSizeDropdown_Below_600_sqft;
		@FindBy (xpath = "//mat-option//span[text()='600-800 sqft']") private WebElement plotSizeDropdown_600_800_sqft;
		@FindBy (xpath = "//mat-option//span[text()='800-1000 sqft']") private WebElement plotSizeDropdown_800_1000_sqft;
		@FindBy (xpath = "//mat-option//span[text()='1000-1250 sqft']") private WebElement plotSizeDropdown_1000_1200_sqft;
		@FindBy (xpath = "//mat-option//span[text()='1250-1500 sqft']") private WebElement plotSizeDropdown_1250_1500_sqft;
		
		@FindBy (xpath = "//mat-select[@formcontrolname='budget']") private WebElement budgetDropdown;
		@FindBy (xpath = "//mat-option//span[text()='under 5 lakh']") private WebElement budgetDropdown_Under_5_Lakh;
		@FindBy (xpath = "//mat-option//span[text()='5-7 lakh']") private WebElement budgetDropdown_5_7_Lakh;
		@FindBy (xpath = "//mat-option//span[text()='7-10 lakh']") private WebElement budgetDropdown_7_10_Lakh;
		@FindBy (xpath = "//mat-option//span[text()='10-12 lakh']") private WebElement budgetDropdown_10_12_Lakh;
		@FindBy (xpath = "//mat-option//span[text()='12-15 lakh']") private WebElement budgetDropdown_12_15_Lakh;

		@FindBy (xpath = "//mat-select[@formcontrolname='lead_source']") private WebElement leadSource_Dropdown;
		@FindBy (xpath = "(//span [contains (text(),'Automation_Reference' )])") private WebElement leadSource_Dropdown_Automation_Reference;
		@FindBy (xpath = "//mat-option//span[text()='Website']") private WebElement leadSource_Dropdown_Website;
		@FindBy (xpath = "//mat-option//span[text()='Walkin']") private WebElement leadSource_Dropdown_Walkin;
		@FindBy (xpath = "//mat-option//span[text()='Print Media']") private WebElement leadSource_Dropdown_PrintMedia;
		@FindBy (xpath = "//mat-option//span[text()='Social Media']") private WebElement leadSource_Dropdown_SocialMedia;
		@FindBy (xpath = "//mat-option//span[text()='Others']") private WebElement leadSource_Dropdown_Others;

		
		@FindBy (xpath = "//button[text()=' Submit ']") private WebElement submitButton_LeadClosure;
		@FindBy (xpath = "//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input") private WebElement modeOfInterestCheckbox;
		@FindBy (xpath = "//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input /parent :: span / parent :: label / parent :: mat-checkbox")private WebElement selectModeOfInterestCheckbox;


		@FindBy (xpath = "//td[text()=' ₹ 25 ']") private WebElement offerDiscountPrice_25rs;
		@FindBy (xpath = "(//mat-icon[text()='delete'])[1]") private WebElement deletePrebooking_PropertyNo_2BHK_1;
		@FindBy (xpath = "(//mat-icon[text()='delete'])[2]") private WebElement deletePrebooking_PropertyNo_2BHK_2;
		@FindBy (xpath = "//span[text()=' New Prebooking '] / parent :: button") private WebElement newPrebookingButton;
		@FindBy (xpath = "//textarea[contains(@data-placeholder,' Remark is required !')]") private WebElement remark_releaseProperty;
		@FindBy (xpath = "//button[text()=' Yes ']") private WebElement releaseProperty_Yes;
		@FindBy (xpath = "//button[text()=' cancel ']") private WebElement releaseProperty_No;


	@FindBy (xpath = "//a[text()=' A(Warm) ']") private WebElement AWarm_Icon;
	@FindBy (xpath = "//a[text()=' B+(Cold) ']") private WebElement BCold_Icon;

	@FindBy (xpath = "(//td[contains(text(),'Automation BookedLead ab')] // following-sibling :: td // div //button) [1]") private WebElement editdirect_AutomationBookedLead;

	@FindBy (xpath = "//button[text()=' Property Number - I-1BHK-1 ']") private WebElement  addLeadClosureButton_I_1BHK_1;



	@FindBy (xpath = "//input[@formcontrolname='total_amount']") private WebElement totalAmount;
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

	@FindBy (xpath = "//div[text()=' Payment Details '] / parent :: div // following-sibling :: div // mat-select[@formcontrolname='paymentType']") private WebElement paymentType_Dropdown;
	@FindBy (xpath = "//mat-option//span[text()='One Time Payment']") private WebElement paymentType_Dropdown_OneTimePayment;
	@FindBy (xpath = "//mat-option//span[text()='Installment ']") private WebElement paymentType_Dropdown_Installment;
	@FindBy (xpath = "//mat-option//span[text()='Emi']") private WebElement paymentType_Dropdown_EMI;
	@FindBy (xpath = "//mat-option//span[text()='Other Ways ']") private WebElement paymentType_Dropdown_OtherWays;

	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div //input[@formcontrolname='installment']) [1]") private WebElement remainingInstallment_1;
	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div //mat-select[@formcontrolname='mode']) [1]") private WebElement remainingInstallment_ModeOfPayment_1;
	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div // input[@formcontrolname='payment_schedule']) [1]") private WebElement remainingInstallment_CalenderDate_1;

	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div //input[@formcontrolname='installment']) [2]") private WebElement remainingInstallment_2;
	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div //mat-select[@formcontrolname='mode']) [2]") private WebElement remainingInstallment_ModeOfPayment_2;
	@FindBy (xpath = "(//div[text()='Installment Details'] / parent :: div / following-sibling :: div // input[@formcontrolname='payment_schedule']) [2]") private WebElement remainingInstallment_CalenderDate_2;

	@FindBy (xpath = "//b[text()='EMI Type:'] / parent :: div //input[@formcontrolname='insatllmentType']") private WebElement remainingEMI_NoOfMonths;
	@FindBy (xpath = "//b[text()='Interest Rate in %:'] / parent :: div //input[@formcontrolname='rate_of_intrest']") private WebElement remainingEMI_InterestRate;
	@FindBy (xpath = "//b[text()='Payment Schedule:'] / parent :: div //input[@formcontrolname='payment_schedule']") private WebElement remainingEMI_CalenderDate;
	@FindBy (xpath = "//div[text()=' Details ']") private WebElement detailsButton;

	@FindBy (xpath = "(//input [@formcontrolname='task_name']) [1]") private WebElement remainingOtherWays_TaskName_1;
	@FindBy (xpath = "(//mat-select[@formcontrolname='paymentVia']) [1]") private WebElement remainingOtherWays_PaymentVia_Dropdown_1;
	@FindBy (xpath = "(//input [@formcontrolname='receiving_amount']) [1]") private WebElement remainingOtherWays_Amount_1;
	@FindBy (xpath = "(//input [@formcontrolname='receiving_date']) [1]") private WebElement remainingOtherWays_CalenderDate_1;

	@FindBy (xpath = "(//input [@formcontrolname='task_name']) [2]") private WebElement remainingOtherWays_TaskName_2;
	@FindBy (xpath = "(//mat-select[@formcontrolname='paymentVia']) [2]") private WebElement remainingOtherWays_PaymentVia_Dropdown_2;
	@FindBy (xpath = "(//input [@formcontrolname='receiving_amount']) [2]") private WebElement remainingOtherWays_Amount_2;
	@FindBy (xpath = "(//input [@formcontrolname='receiving_date']) [2]") private WebElement remainingOtherWays_CalenderDate_2;

	@FindBy (xpath = "//label[contains(text(),'Automation_Term and Conditions 104')]") private WebElement cheackBox_AutomationTermCondition;

	@FindBy (xpath = "//input[@id='madsfasdfasd']")private WebElement searchTab;
	@FindBy (xpath ="//div[text()=' Customers ']") public static WebElement customerIcon;
	@FindBy ( xpath ="//button[@routerlink= 'add-customer']") public static  WebElement addCustomerButton;
	@FindBy (xpath = "//mat-panel-title[text()=' Primary Contact '] / parent :: span/ parent :: mat-expansion-panel-header")private WebElement primaryContactBox;
	@FindBy (xpath = "//p[text()=' View Prebookings ']")private WebElement veiwPrebookingsButton;
	@FindBy (xpath= "//button[text()=' click here ']")private WebElement clickHereButton;
	@FindBy (xpath = "//mat-panel-title[text()=' Lead Closure Details '] / parent :: span / parent :: mat-expansion-panel-header")private WebElement leadClosureDetailsBox;
	@FindBy (xpath = "//button[text()=' Submit ']")private WebElement submitButton_Customer;
	
	@FindBy (xpath = "//mat-panel-title[text()=' Lead Closure Details ']")private WebElement headingOfLeadClosureForm;
	@FindBy (xpath = "(//div[contains(text(),'Automation_Term and Conditions 104')] / parent :: div )[1]")private WebElement termCondition_drag;
	@FindBy (xpath = "//h2[text()='Selected']/parent :: div //div[@style='margin-top: 20px; height: 350px; overflow-y: scroll;']")private WebElement termCondition_drop;
    @FindBy (xpath = "//button[text()=' Submit ']")private WebElement submitBooking_Button;
    @FindBy (xpath = "//li[contains(text(), ' ')] / parent :: ul")public static WebElement customerList;
    @FindBy (xpath = "//button[text()=' Submit ']")public static WebElement submit_Button;

		
		public Booking(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
//			w = new  WebDriverWait(driver, Duration.ofSeconds(30));
			a = new SoftAssert();
			A = new Actions(driver);
			j =  (JavascriptExecutor)driver;
		}
		public void searchTab_Customer() throws InterruptedException
		{
			searchTab_Customer.sendKeys(this.name_bookedLead);
			Thread.sleep(1000); searchTab_Customer.sendKeys(Keys.ENTER);
		}
		public void veiwIcon_PropertyNo_AutomationBooked()
		{
			veiwIcon_PropertyNo_AutomationBooked.click();
		}
		public void Box_Automation_1BHK_PropertyNo1()
		{
			Box_Automation_1BHK_PropertyNo1.click();
		}
		public void Box_ProertyDetails() throws InterruptedException
		{
			j.executeScript("arguments[0].scrollIntoView();", Box_ProertyDetails);
			Thread.sleep(2000);	Box_ProertyDetails.click();
		}
		public void deactivePropertyIcon() throws InterruptedException
		{
			j.executeScript("arguments[0].scrollIntoVeiw(true);", deactivePropertyIcon);
			Thread.sleep(2000); deactivePropertyIcon.click();
		}
		public void leadClosureDetailsBox()
		{
			leadClosureDetailsBox.click();
		}
		public void clickHereButton()
		{
			clickHereButton.click();
		}
		public void leadsIcon()
		{
			leadsIcon.click();
		}
		public void activeLeadIcon()
		{
			activeLeadIcon.click();
		}
		public void AHot_Icon()
		{
			A.moveToElement(AHot_Icon).click().build().perform();
		}
		public void newLeadButton() throws InterruptedException
		{
			j.executeScript("window.scrollBy(1000,-1000)", "");
			Thread.sleep(2000);
			newLeadButton.click();
		}
		public void submitButton()
		{
			submitButton.click();		
		}
		public  void submit_Button() throws InterruptedException
		{
			Thread.sleep(2000);
			j.executeScript("window.scrollBy(1000,10000)", "");
			Thread.sleep(6000);
			submit_Button.click();
		}
		public void editButton_AutomationbookedLead() throws InterruptedException
		{	
			j.executeScript("window.scrollBy(1000,-1000)", "");
			Thread.sleep(2000);
	    	j.executeScript("arguments[0].click()", editdirect_AutomationBookedLead);
		}
		public void addLeadClosureButton_Infrastructure_1BHK_1()
		{
			addLeadClosureButton_I_1BHK_1.click();
		}
		public void submitButton_Customer() throws InterruptedException
		{
			j.executeScript("window.scrollBy(1000,1000)", "");		
			Thread.sleep(2000); submitButton_Customer.click();
		}

		public void remark_releaseProperty() throws InterruptedException
		{
			remark_releaseProperty.sendKeys(utility.UtilityClass.getRandomString(30));
			Thread.sleep(1000);releaseProperty_Yes.click();		
		}
		public void book_propertyNo_2BHK_1() throws InterruptedException
		{
					propertyNo.sendKeys("2BHK");
					Thread.sleep(1000);propertyNo_2BHK_1.click();
					
					paymentTypeDropdown.click();
					Thread.sleep(1000); paymentTypeDropdown_Full.click();
					
					showPropertyDetailsButton.click();
					comments.sendKeys(UtilityClass.getRandomString(30));
					Thread.sleep(2000); showPropertyDetailsButton.click();
					
					Thread.sleep(1000); veiwOffersButton.click();
					Thread.sleep(2000);	A.moveToElement(checkBox_AutomationOffer_AreaWise).click().build().perform();
					//Thread.sleep(2000); checkBox_AutomationOffer_AreaWise.click();
					
					A.sendKeys(Keys.PAGE_DOWN);
					Thread.sleep(2000); String OfferDiscountPrice_25rs = offerDiscountPrice_25rs.getText();
					a.assertEquals(OfferDiscountPrice_25rs, "₹ 25");
					
					Thread.sleep(1000);
					//A.moveToElement(proceedToPrebooking).click().build().perform();
					//j.executeScript("arguments[0].click()",nowBooking );
					j.executeScript("arguments[0].click()",proceedToPrebooking );
		
			        a.assertAll();	
		}
		public void book_propertyNo_2BHK_2() throws InterruptedException
		{
				boolean delete=deletePrebooking_PropertyNo_2BHK_1.isEnabled();
				a.assertEquals(delete, true);
				
				newPrebookingButton.click();
				propertyNo.sendKeys("2BHK");
				Thread.sleep(1000);propertyNo_2BHK_2.click();
				
				paymentTypeDropdown.click();
				Thread.sleep(1000);
				paymentTypeDropdown_Full.click();
				

				Thread.sleep(1000); showPropertyDetailsButton.click();
				comments.sendKeys(UtilityClass.getRandomString(30));
				Thread.sleep(3000); showPropertyDetailsButton.click();
					
				Thread.sleep(1000); veiwOffersButton.click();
				Thread.sleep(1000); checkBox_AutomationOffer_AreaWise.click();
				
				Thread.sleep(2000); String OfferDiscountPrice_25rs = offerDiscountPrice_25rs.getText();
				a.assertEquals(OfferDiscountPrice_25rs, "₹ 25");
				
				//proceedToPrebooking.click();	
				nowBooking.click();
		}
		public void FillLeadClosureForm_PaymentTypeIsOneTimePayment() throws InterruptedException
		{
			j.executeScript("arguments[0].scrollIntoView()", OfferDetails_text);
			A.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);	offerDetails_AreaWise_Box.click();
			boolean OfferType =OfferType_AreaWise.isEnabled();
			a.assertEquals(OfferType, true);
			
			boolean OfferName =OfferName_AutomationOffer_Areawise.isEnabled();
			a.assertEquals(OfferName, true);
			
			boolean OfferAmount =OfferAmount_AreaWise.isEnabled();
			a.assertEquals(OfferAmount, true);
//					
//			String TotalAmount=totalAmount.getAttribute("value");
//			a.assertEquals(TotalAmount, "3435535290.000");
//			
//			j.executeScript("arguments[0].scrollIntoView()", totalAmount);
//			Thread.sleep(2000);
//			tokenAmount.sendKeys("343553529");
//			
//			paymentMode_dropdown.click();
//			Thread.sleep(1000);
//			paymentMode_dropdown_Bank.click();
//			
//			bankTransactionID.sendKeys("jfjd7876fdjhf");
//			
//			String RemainingValue=remainingAmount.getAttribute("value");
//			a.assertEquals(RemainingValue, "3091981761.000");
//			
//			paymentMode_dropdown.click();
//			Thread.sleep(1000);
//			paymentMode_dropdown_Bank.click();
//			
//			paymentType_Dropdown.click();
//			Thread.sleep(1000);
//			paymentType_Dropdown_OneTimePayment.click();
//			
//			remainingEMI_NoOfMonths.sendKeys("2");
//			remainingEMI_InterestRate.sendKeys("5");
//			remainingEMI_CalenderDate.click();
//			calenderButton.click();
//			calender_Year_2023.click();
//			calender_Month_MAR.click();
//			calender_Date_28.click();
//			
//			detailsButton.click();
//			
//			Thread.sleep(1000);
//			j.executeScript("arguments[0].scrollIntoView()", cheackBox_TermConditions);
//			Thread.sleep(1000);
//			cheackBox_TermConditions.click();
//			
//			j.executeScript("arguments[0].scrollIntoView()", submitButton);
//			Thread.sleep(1000);
//			boolean SubmitButton=submitButton.isEnabled();
//			a.assertEquals(SubmitButton, true);

			a.assertAll();			
		}
		public void addLeadWith_statusIsVisit() throws InterruptedException
		{
			addProfessionIcon.click();
			professionName.sendKeys("AutomationProfession Doctor "+UtilityClass.getRandomString(2));
			professionDescription.sendKeys("Someone who has worked hard in the same type of job for a long time and has become skilled at dealing with any problem that might happen:");
			professionSubmitButton.click();
			
			Thread.sleep(2000);projectDropdown.click(); 
			Thread.sleep(1000);	ProjectDropdown_AutomationProject1.click();
			
			selfAssignedCheckbox.click();
			submitButton_PopUp.click();
			
			name.sendKeys("Automation BookedLead "+UtilityClass.getRandomString(2));
			phone.sendKeys(UtilityClass.getRandomIntegers(7));
			alternatePhone.sendKeys(UtilityClass.getRandomIntegers(7));
			String phoneNo_BookedLead = phone.getAttribute("value");
			String name_bookedLead=name.getAttribute("value");
			String alternatePhone_BookedLead=alternatePhone.getAttribute("value");
			this.phoneNo_BookedLead=phoneNo_BookedLead;
			this.name_bookedLead=name_bookedLead;
			this.alternatePhone_BookedLead=alternatePhone_BookedLead;
			
			String conversion=contactabilityDropdown.getAttribute("aria-disabled");
			a.assertEquals(conversion, "false");
			
			boolean intrest=modeOfInterestCheckbox.isSelected();
			a.assertEquals(intrest, true);
				
			Thread.sleep(2000); professionDropdown.click();
			professionDropdown_Doctor.click();
			
			pinCode.sendKeys("413411");
			
			address.sendKeys("Solapur, Maharashtra");
			
			areaDropdown.click();
			Thread.sleep(1000); areaDropdown_KV_Nagar.click();		
			
			Thread.sleep(2000); j.executeScript("window.scrollBy(1000,1000)", "");	 
			Thread.sleep(2000);livingModeDropdown.click(); 
			Thread.sleep(1000); livingModeDropdown_OwnHouse.click();
			
			statusDropdown.click(); 
			Thread.sleep(1000); statusDropdown_Visit.click();
			
			areaOfInterest.click();
			Thread.sleep(1000);
			areaOfInterest_Automation_1BHK_Property.click();
			
			A.moveToElement(buyingPurposeDropdown).click().build().perform();
			
			buyingPurposeDropdown.click();
			Thread.sleep(1000);
			buyingPurposeDropdown_Personal.click();
			
			j.executeScript("arguments[0].scrollIntoView(true)", submitButton);
			
			Thread.sleep(2000);
			plotSizeDropdown.click();
			Thread.sleep(1000);
			plotSizeDropdown_Below_600_sqft.click();
			
			budgetDropdown.click();
			Thread.sleep(1000);
			budgetDropdown_7_10_Lakh.click();
			
			categoryDropdown.click();
			Thread.sleep(1000);
			category_Hot_A.click();
			
			Calender_follow_up_date.click();
			calenderButton.click();
			calender_Year_2023.click();
			calender_Month_MAR.click();
			calender_Date_28.click();
			
			leadSource_Dropdown.click();
			Thread.sleep(1000);
			leadSource_Dropdown_Automation_Reference.click();
			
			remark.sendKeys(UtilityClass.getRandomString(30));
			
			a.assertAll();
			
		}
		public void FillLeadClosureForm_PaymentTypeIsInstallatione() throws InterruptedException
		{
//			j.executeScript("arguments[0].scrollIntoView(true);",OfferDetails_text);
//			Thread.sleep(2000);	offerDetails_AreaWise_Box.click();	
//			Thread.sleep(2000);
//			boolean OfferType =OfferType_AreaWise.isEnabled(); a.assertEquals(OfferType, true);	
//			boolean OfferName =OfferName_AutomationOffer_Areawise.isEnabled(); a.assertEquals(OfferName, true);	
////			String amount=OfferAmount_AreaWise.getAttribute("value"); a.assertEquals(amount, "25");
//					
//			String TotalAmount=totalAmount.getAttribute("value"); a.assertEquals(TotalAmount, "2575.000");
			
//			A.sendKeys(Keys.PAGE_DOWN).build().perform();
			j.executeScript("arguments[0].scrollIntoView(true);",totalAmount);
			Thread.sleep(2000); tokenAmount.sendKeys("1000");
			
			paymentMode_dropdown.click();
			Thread.sleep(1000); paymentMode_dropdown_Bank.click();	
			bankTransactionID.sendKeys(UtilityClass.getRandomIntegers(9));
			
//			String RemainingValue=remainingAmount.getAttribute("value"); a.assertEquals(RemainingValue, "1575.000");
			String RemainingValue=remainingAmount.getAttribute("value"); a.assertEquals(RemainingValue, "1600.000");
			
			paymentMode_dropdown.click();
	        Thread.sleep(1000); paymentMode_dropdown_Bank.click();
			
			paymentType_Dropdown.click();
			Thread.sleep(1000); paymentType_Dropdown_Installment.click();
			
//			A.sendKeys(Keys.PAGE_DOWN).build().perform();
//			remainingInstallment_1.sendKeys("1000");
			remainingInstallment_1.sendKeys("1000");
			
			remainingInstallment_ModeOfPayment_1.click();
			Thread.sleep(1000); paymentMode_dropdown_Bank.click();
			
			remainingInstallment_CalenderDate_1.click();
			calenderButton.click();
			utility.Calender.currentCalenderYear(driver);
			utility.Calender.currentCalenderMonth(driver);
			utility.Calender.currentCalenderDate(driver);
			
		//	A.sendKeys(Keys.PAGE_DOWN).build().perform();
			String RemainingInstallment_2=remainingInstallment_2.getAttribute("value"); a.assertEquals(RemainingInstallment_2, "600");
			
			remainingInstallment_ModeOfPayment_2.click();
			Thread.sleep(1000); paymentMode_dropdown_Bank.click();
			
			remainingInstallment_CalenderDate_2.click();
			calenderButton.click();
			utility.Calender.currentCalenderYear(driver);
			utility.Calender.currentCalenderMonth(driver);
			utility.Calender.currentCalenderDate(driver);
			
			A.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			A.moveToElement(termCondition_drag).clickAndHold(termCondition_drag).pause(Duration.ofSeconds(3)).moveToElement(termCondition_drop).pause(Duration.ofSeconds(1)).release(termCondition_drop).build().perform();

			a.assertAll();		
		}

		public void submitBooking_Button() throws InterruptedException
		{
			Thread.sleep(2000); j.executeScript("window.scrollBy(1000,5000)");
			Thread.sleep(2000); submitBooking_Button.click();
		}
		public void releasePrebookingProperty() throws InterruptedException
		{
			Thread.sleep(2000); searchTab.sendKeys(this.phoneNo_BookedLead);
		}
		
		public void customerIcon()
		{
			customerIcon.click();
		}
		public void addCustomerButton() throws InterruptedException
		{
			 j.executeScript("window.scrollBy(1000,-1000)");
			Thread.sleep(2000);addCustomerButton.click();
		}
		public void primaryContactBox()
		{
			primaryContactBox.click();
		}

		public void book_AutomationProjectTwo_propertyNo_1BHK_2() throws InterruptedException
		{	
				propertyNo.sendKeys("104");
				Thread.sleep(2000);	A.moveToElement(automationProjectTwo_propertyNo_1BHK_2).click().build().perform();
				
				paymentTypeDropdown.click();
				Thread.sleep(1000); paymentTypeDropdown_Full.click();
				
//				Thread.sleep(1000); showPropertyDetailsButton.click();
//				comments.sendKeys(UtilityClass.getRandomString(30));
//				Thread.sleep(3000); showPropertyDetailsButton.click();
					
//				Thread.sleep(1000); veiwOffersButton.click();
//				Thread.sleep(1000); checkBox_AutomationOffer_AreaWise.click();
//				
//				Thread.sleep(2000); String OfferDiscountPrice_25rs = offerDiscountPrice_25rs.getText();
//				a.assertEquals(OfferDiscountPrice_25rs, "₹ 25");
//				
				Thread.sleep(2000);
				j.executeScript("arguments[0].click();", proceedToPrebooking);

		}
		public void primaryContactInformation_bookingPropertyThroughLead(String phone) throws InterruptedException
		{
			Thread.sleep(2000);searchCustomer_Tab.sendKeys(phone);
			Thread.sleep(1000); customerList.click();
			
			Thread.sleep(2000);primaryContactGender_Dropdown.click();
			Thread.sleep(1000); primaryContactGender_Male.click();
			
			primaryContact_Email.sendKeys("customer"+UtilityClass.getRandomString(0)+"@kolonizer.com");
			primaryContact_FatherName.sendKeys("Automation Father "+UtilityClass.getRandomString(2));
			
			primaryContact_CurrentAddress_Box.click();
			A.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000); primaryContact_AddIcon.click();
			Thread.sleep(1000); primaryContact_CloseIcon.click();
			
			Thread.sleep(2000); primaryContact_checkbox_SameAsCurrentAddress.click();
		}
		public void secondaryContactInformation_bookingPropertyThroughLead() throws InterruptedException
		{
			j.executeScript("arguments[0].scrollIntoView(true);", secondaryContact_Name);
			Thread.sleep(2000);secondaryContact_Name.sendKeys("Automation CustomerBrother "+UtilityClass.getRandomString(2));
			
			secondaryContactGender_Dropdown.click();
			Thread.sleep(1000); primaryContactGender_Male.click();
			secondaryContact_RelationWithCustomer.sendKeys("Brother");
			
			secondaryContact_Email.sendKeys("customer"+UtilityClass.getRandomString(0)+"@kolonizer.com");
			secondaryContact_FatherName.sendKeys("Automation Father "+UtilityClass.getRandomString(2));
			secondarycontact_PhoneNo.sendKeys(UtilityClass.getRandomIntegers(7));
			secondaryContact_AlternateN0.sendKeys(UtilityClass.getRandomIntegers(7));
			
			secondaryContact_CurrentAddress_Box.click();
			secondaryContact_CurrentAddress.sendKeys("Solapur, Maharashtra");
			secondaryContact_CurrentAddress_pinCode.sendKeys("413411");
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", secondaryContact_CurrentAddress_pinCode);
			Thread.sleep(2000); secondaryContact_CurrentAddress_AreaDropdown.click();
			Thread.sleep(1000);primaryContact_CurrentAddress_AreaDropdown_KV_Nagar.click();		
			
			Thread.sleep(1000); secondaryContact_AddIcon.click();
			Thread.sleep(1000); secondaryContact_CloseIcon.click();
			Thread.sleep(1000); secondaryContact_checkbox_SameAsCurrentAddress.click();
			Thread.sleep(1000); secondaryContact_PermanentAddress_box.click();
		}
		public void primaryContactInformation_bookingPropertyThroughCustomer() throws InterruptedException
		{
			primaryContact_Name.sendKeys("Automation Customer "+UtilityClass.getRandomString(2));
			
			primaryContactGender_Dropdown.click();
			Thread.sleep(1000);
			primaryContactGender_Male.click();
			
			primaryContact_Email.sendKeys("customer"+UtilityClass.getRandomString(0)+"@kolonizer.com");
			primaryContact_FatherName.sendKeys("Automation Father "+UtilityClass.getRandomString(2));
//			primarycontact_PhoneNo.sendKeys(UtilityClass.getRandomIntegers(7));
			primaryContact_AlternateN0.sendKeys(UtilityClass.getRandomIntegers(7));
			
			primaryContact_CurrentAddress_Box.click();
			primaryContact_CurrentAddress.sendKeys("Solapur, Maharashtra");
			primaryContact_CurrentAddress_pinCode.sendKeys("413411");
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", primaryContact_CurrentAddress_pinCode);
			Thread.sleep(2000); primaryContact_CurrentAddress_AreaDropdown.click();
			Thread.sleep(1000);primaryContact_CurrentAddress_AreaDropdown_KV_Nagar.click();		
			
			Thread.sleep(1000); primaryContact_AddIcon.click();
			Thread.sleep(1000); primaryContact_CloseIcon.click();
			Thread.sleep(1000); primaryContact_checkbox_SameAsCurrentAddress.click();
			Thread.sleep(1000); primaryContact_PermanentAddressDocument_box.click();
		}
		public void secondaryContactInformation_bookingPropertyThroughCustomer() throws InterruptedException
		{
			j.executeScript("arguments[0].scrollIntoView(true);", secondaryContact_Name);
			Thread.sleep(2000);secondaryContact_Name.sendKeys("Automation CustomerBrother "+UtilityClass.getRandomString(2));
			
			secondaryContactGender_Dropdown.click();
			Thread.sleep(1000);
			primaryContactGender_Male.click();
			secondaryContact_RelationWithCustomer.sendKeys("Brother");
			
			secondaryContact_Email.sendKeys("customer"+UtilityClass.getRandomString(0)+"@kolonizer.com");
			secondaryContact_FatherName.sendKeys("Automation Father "+UtilityClass.getRandomString(2));
			secondarycontact_PhoneNo.sendKeys(UtilityClass.getRandomIntegers(7));
			secondaryContact_AlternateN0.sendKeys(UtilityClass.getRandomIntegers(7));
			
			secondaryContact_CurrentAddress_Box.click();
			secondaryContact_CurrentAddress.sendKeys("Solapur, Maharashtra");
			secondaryContact_CurrentAddress_pinCode.sendKeys("413411");
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", secondaryContact_CurrentAddress_pinCode);
			Thread.sleep(2000); secondaryContact_CurrentAddress_AreaDropdown.click();
			Thread.sleep(1000);primaryContact_CurrentAddress_AreaDropdown_KV_Nagar.click();		
			
//			Thread.sleep(1000); secondaryContact_AddIcon.click();
//			Thread.sleep(1000); secondaryContact_CloseIcon.click();
			Thread.sleep(1000); secondaryContact_checkbox_SameAsCurrentAddress.click();
//			Thread.sleep(1000); secondaryContact_PermanentAddress_box.click();
		}
		public void PropertyDetails() throws InterruptedException
		{
			Thread.sleep(2000);j.executeScript("arguments[0].scrollIntoView(true);", propertyDetails_Box);
			Thread.sleep(2000); propertyDetails_Box.click();
		}
		public void nowBooking()
		{
			nowBooking.click();
		}
		public void veiwPrebookingsButton() throws InterruptedException
		{
			veiwPrebookingsButton.click();
			Thread.sleep(2000);
			clickHereButton.click();
		}
		public void headingOfLeadClosureForm()
		{
			boolean display=headingOfLeadClosureForm.isDisplayed();
			a.assertEquals(display, true);
			a.assertAll();
		}
		



	}



