package StepDef;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Wait;

public class Verify_Lead extends BaseClass
{

	String errorMessage="jd";

		@Given("User should be on add lead page")
		public void user_should_be_on_add_lead_page() throws InterruptedException 
		{
			ld.navigate_on_Lead_page();	   
		}
		@When("Create lead by Filling all necessary required information {string} and {string} and {string} and {string}")
		public void create_lead_by_filling_all_necessary_required_information_and_and_and(String Contactibility, String Mode_of_Interest, String Category, String Status) throws EncryptedDocumentException, InterruptedException, IOException
		{
			System.out.println("Start to create lead: Contactibility is "+Contactibility+" | Mode_of_Interest is "+Mode_of_Interest+" | Category is "+Category+" | Status is "+Status);
			ld.createLeads(Contactibility, Mode_of_Interest, Category, Status);
			  
		}
		@Then("Lead should be created")
		public void lead_should_be_created() throws InterruptedException 
		{
			Thread.sleep(700);
			String succefullMessage=driver.findElement(By.xpath("//div[@role='alert']")).getText();
			System.out.println(succefullMessage);
			a.assertEquals(succefullMessage, "Lead created successfully");
			a.assertAll();  
		}
		@Then("This lead considered in particular section according to the whether is it active or deactive lead")
		public void this_lead_considered_in_particular_section_according_to_the_whether_is_it_active_or_deactive_lead()
		{
		   
		}
		
		////// Edit lead scenarios (contactibility is conversion and mode is interested)/////////
		

		@Given("User should be on edit lead page")
		public void user_should_be_on_edit_lead_page() throws InterruptedException {
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(//div[text()='Call'])[2]/parent::div/parent::div")).click();
//		   driver.findElement(By.xpath("//input[@placeholder='Search Lead']")).sendKeys("Call");
//		   driver.findElement(By.xpath("//button[@class='btn seach_btn']")).click();
		   Thread.sleep(2000);
		   j.executeScript("arguments[0].click(true);", driver.findElement(By.xpath("//button[@class='pushable close-btn ng-star-inserted']")));
		}
		@When("Check all contactability field scenarios")
		public void check_all_contactability_field_scenarios() {
		   
		}
		@Then("Contactability field should be disable")
		public void contactability_field_should_be_disable() throws InterruptedException {
		   Thread.sleep(1000);
		   String disable= driver.findElement(By.xpath("//mat-select[@formcontrolname='contactability']")).getAttribute("aria-disabled");
		   a.assertEquals(disable, "true");
		   a.assertAll();
		   System.out.println("Pass");
		}
		@Then("Contactability is conversion coming by defualt")
		public void contactability_is_conversion_coming_by_defualt() throws InterruptedException {
		   Thread.sleep(1000);
		   String ContactibilityIsConversion = driver.findElement(By.xpath("//mat-select[@formcontrolname='contactability']//span//span")).getText();
		   a.assertEquals(ContactibilityIsConversion, "Conversation");
		   a.assertAll();
		   System.out.println("Pass");
		}
		@Then("Mode of interested checkbox should be  selected by default")
		public void mode_of_interested_checkbox_should_be_selected_by_default() throws InterruptedException {
		   
			    Thread.sleep(2000);
			//    boolean checkbox=driver.findElement(By.xpath("//mat-checkbox")).isSelected();
			//    System.out.println(checkbox);
			    
			    String checkboxInterest=driver.findElement(By.xpath("//mat-checkbox//input[@type='checkbox']")).getAttribute("aria-checked");
			    a.assertEquals(checkboxInterest, "true");
			    a.assertAll();
			    System.out.println("Pass");
		
		}
		@Then("Category drop-down will displayed \\(Mandatory) and category coming by default whichever is select at time of add lead")
		public void category_drop_down_will_displayed_mandatory_and_category_coming_by_default_whichever_is_select_at_time_of_add_lead() throws InterruptedException {
		   
			   boolean displayed= driver.findElement(By.xpath("//mat-select[@formcontrolname='category']")).isDisplayed();
			   a.assertEquals(displayed, true);
			   a.assertAll();
			   System.out.println("Pass");   
		}
		@Then("Next follow up date field coming as Mandatory")
		public void next_follow_up_date_field_coming_as_mandatory() throws InterruptedException {	 
			 j.executeScript("window.scrollBy(0, 1000)");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
			 
			String errorMessage= driver.findElement(By.xpath("//mat-error")).getText();
			a.assertEquals(errorMessage, "Follow-up date is required !");
			a.assertAll();
			System.out.println("Pass");
		}
		@When("Deselect the checkbox of interested field")
		public void deselect_the_checkbox_of_interested_field() throws InterruptedException {
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input /parent :: span / parent :: label / parent :: mat-checkbox")).click();
		}
		@Then("Hide Category drop-down")
		public void hide_category_drop_down() throws InterruptedException {
		   Thread.sleep(1000);
		   boolean displayed= driver.findElement(By.xpath("//mat-select[@formcontrolname='category']")).isDisplayed();
		   a.assertEquals(displayed, false);
		   a.assertAll();
		   System.out.println("Pass");   
		    
		}
		@Then("Next follow up field coming as Non-Mandatory")
		public void next_follow_up_field_coming_as_non_mandatory() {
		   
			String mandatory=ld.Calender_follow_up_date.getAttribute("aria-invalid");
			a.assertEquals(mandatory, "false");
			a.assertAll();
			System.out.println("Pass");
		}
		@When("Check all status field scenarios")
		public void check_all_status_field_scenarios() throws InterruptedException {    
			driver.navigate().refresh();
		    
		}
		@Then("Status should be come as same by default, whichever is select at the time of add lead")
		public void status_should_be_come_as_same_by_default_whichever_is_select_at_the_time_of_add_lead() {
		    
		    String status = driver.findElement(By.xpath("//mat-select[@formcontrolname='status']//span//span")).getText();		    
		    a.assertNotEquals(status, "null");
		    a.assertAll();    
		    System.out.println("Pass");
		}
		@Then("Lead status option should be disabled, if status selected as call at the time of add lead")
		public void lead_status_option_should_be_disabled_if_status_selected_as_call_at_the_time_of_add_lead() {  
		    ld.statusDropdown.click();
		    String leadStatus=driver.findElement(By.xpath("//span[text()='Lead']/parent::mat-option")).getAttribute("aria-disabled");
		    a.assertEquals(leadStatus, "true");
		    a.assertAll();
		    System.out.println("Pass");
		}
		@When("User change status to Meet")
		public void user_change_status_to_meet() throws InterruptedException {
		    Thread.sleep(1000);
		   driver.findElement(By.xpath("//mat-option//span[text()='Meet']")).click();
		   System.out.println("Pass");
		}
		@Then("Mode of interest field  become selected by default")
		public void mode_of_interest_field_become_selected_by_default() {	    
			String checkboxInterest=driver.findElement(By.xpath("//mat-checkbox//input[@type='checkbox']")).getAttribute("aria-checked");
		    a.assertEquals(checkboxInterest, "true");
		    a.assertAll();
		    System.out.println("Pass");
		}
		@Then("Expected visit date field will open")
		public void expected_visit_date_field_will_open() {
		  boolean display=  driver.findElement(By.xpath("//input[@formcontrolname='expected_visit_date']")).isDisplayed();
		  a.assertEquals(display, true);
		  a.assertAll();
		  System.out.println("Pass");
		    
		}
		@Then("Meet status option should be disabled, if status selected as Visit at the time of add lead")
		public void meet_status_option_should_be_disabled_if_status_selected_as_visit_at_the_time_of_add_lead() {
		    
			 
		}
		@When("User change status to Visit")
		public void user_change_status_to_visit() throws InterruptedException {
		    ld.statusDropdown.click();
		    Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-option//span[text()='Visit']")).click();
		}
		@Then("Proceed to pre-booking and pre-booking button is open")
		public void proceed_to_pre_booking_and_pre_booking_button_is_open() throws InterruptedException {
		   boolean prebooking_Button=  driver.findElement(By.xpath("//button[text()=' Prebooking ']")).isDisplayed();
		   j.executeScript("window.scrollBy(0, 1000)"); Thread.sleep(2000);
		   boolean proceedToPrebooking_Button=  driver.findElement(By.xpath("//button//span[text()=' Proceed to Pre-Booking ']")).isDisplayed();
		   a.assertEquals(prebooking_Button, true);
		   a.assertEquals(proceedToPrebooking_Button, true);
		   a.assertAll();
		   System.out.println("Pass");
		}
		@When("Check remark field")
		public void check_remark_field() {
		    
		    
		}
		@Then("Remark field should be enable to take user input")
		public void remark_field_should_be_enable_to_take_user_input() throws InterruptedException {
			driver.findElement(By.xpath("//textarea[@formcontrolname='remark']")).sendKeys("Remark");
			Thread.sleep(1000);
			String remark=driver.findElement(By.xpath("//textarea[@formcontrolname='remark']")).getAttribute("value");
			a.assertEquals(remark, "Remark");
			a.assertAll();
			System.out.println("Pass");
		}
		@Then("It is non mandatory field")
		public void it_is_non_mandatory_field() {
			String mandatory=driver.findElement(By.xpath("//textarea[@formcontrolname='remark']")).getAttribute("aria-invalid");
			a.assertEquals(mandatory, "false");
			a.assertAll();
			System.out.println("Pass");
		}
		@When("Check company data section")
		public void check_company_data_section() throws InterruptedException {
//			Thread.sleep(1000);
//			 ld.companyData_Box.click(); 
		}
		@Then("Field of \\(Project, Select user to assign lead and Lead source) should be display under company data section")
		public void field_of_project_select_user_to_assign_lead_and_lead_source_should_be_display_under_company_data_section() {
		    
		   boolean project=ld.projectDropdown.isDisplayed();
		   boolean userAssign=ld.userAssign.isDisplayed();
		   boolean leadSource = ld.leadSource_Dropdown.isDisplayed();
		   a.assertEquals(project, true);
		   a.assertEquals(userAssign, true);
		   a.assertEquals(leadSource, true);
		   a.assertAll();
		   System.out.println("Pass");
		}
		@Then("All field should be enabled")
		public void all_field_should_be_enabled() {
			   String project=ld.projectDropdown.getAttribute("aria-invalid");
			   String userAssign=ld.userAssign.getAttribute("aria-invalid");
			   String leadSource = ld.leadSource_Dropdown.getAttribute("aria-invalid");
			   a.assertEquals(project, "false");
			   a.assertEquals(userAssign, "false");
			   a.assertEquals(leadSource, "false");
			   a.assertAll();
			   System.out.println("Pass");
		    
		}
		@Then("Project and select user to assign lead should be come as mandatory")
		public void project_and_select_user_to_assign_lead_should_be_come_as_mandatory() {
			   
		}
		@Then("Data is coming as same whichever is select at the time of add lead")
		public void data_is_coming_as_same_whichever_is_select_at_the_time_of_add_lead() {
			String project=driver.findElement(By.xpath("//mat-select[@formcontrolname='project_id']//span//span")).getText(); 
			//String lead_source=driver.findElement(By.xpath("//mat-select[@formcontrolname='lead_source']//span//span")).getText(); 
			String userAssign=ld.userAssign.getAttribute("value");
			a.assertNotEquals(project, "");
		//	a.assertNotEquals(lead_source, "null");
			a.assertNotEquals(userAssign, "");
			a.assertAll();
			System.out.println("Pass");    
		}
		@When("Check lead personal data section")
		public void check_lead_personal_data_section() throws InterruptedException {
		    
		    ld.leadPersonalData_Box.click();
		    Thread.sleep(1000);
		    j.executeScript("window.scrollBy(0, 1000)");
			System.out.println("Pass");  
		}
		@Then("Field of \\(Name, Phone, Alternative no, Select profession, Select living mode, Current address, Pin code, Area, city, District, State, Contry) should be displyed under leads personal data section")
		public void field_of_name_phone_alternative_no_select_profession_select_living_mode_current_address_pin_code_area_city_district_state_contry_should_be_displyed_under_leads_personal_data_section() throws InterruptedException {
		    Thread.sleep(2000);
		    boolean name=ld.name.isDisplayed();
		    boolean phone= ld.phone.isDisplayed();
		    boolean professionDropdown= ld.professionDropdown.isDisplayed();
		    boolean addProfessionIcon=ld.addProfessionIcon.isDisplayed();
		    boolean livingModeDropdown= ld.livingModeDropdown.isDisplayed();
		    boolean address=ld.address.isDisplayed();
		    boolean pinCode= ld.pinCode.isDisplayed();
		    boolean areaDropdown=ld.areaDropdown.isDisplayed();
		    boolean cityDropdown=ld.city.isDisplayed();
		    boolean district=ld.district.isDisplayed();
		    boolean state=ld.state.isDisplayed();
		    boolean country=ld.country.isDisplayed();   
		    
		    a.assertEquals(name, true);
		    a.assertEquals(phone, true);
		    a.assertEquals(professionDropdown, true);
		    a.assertEquals(addProfessionIcon, true);
		    a.assertEquals(livingModeDropdown, true);
		    a.assertEquals(address, true);
		    a.assertEquals(pinCode, true);
		    a.assertEquals(areaDropdown, true);
		    a.assertEquals(cityDropdown, true);
		    a.assertEquals(district, true);
		    a.assertEquals(state, true);
		    a.assertEquals(country, true);
		    
		    a.assertAll();
			System.out.println("Pass");  
		    
		}
		@Then("Name and Phone no fields should be mandatory")
		public void name_and_phone_no_fields_should_be_mandatory() throws InterruptedException {
		   String name= ld.name.getAttribute("value");
		   
		   ld.name.clear();
		   ld.name.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		 
		   Thread.sleep(1000);
		   j.executeScript("window.scrollBy(0,-1000)");
		   Thread.sleep(2000);		   
		   ld.Calender_follow_up_date.click();
		   ld.calenderButton.click();
		   utility.Calender.CustomizeCalenderYear(driver, "2023");
		   utility.Calender.CustomizeCalenderMonth(driver, "DEC");
		   utility.Calender.CustomizeCalenderDay(driver, "30");
		   
		   Thread.sleep(1000);
		   j.executeScript("window.scrollBy(0, 1000)"); 
		   Thread.sleep(2000);
		   ld.updateButton.click();
		   
		   String errorMessage= driver.findElement(By.xpath("//mat-error//div")).getText();
		   a.assertEquals(errorMessage, "Name With LAST Name is required !");
		   ld.name.sendKeys(name);
		   a.assertAll();   
		   System.out.println("Pass");
		}
		@Then("Phone no field should be disable")
		public void phone_no_field_should_be_disable() throws InterruptedException {
			String phone=ld.phone.getAttribute("value");
			a.assertNotEquals(phone, "");
			a.assertAll();
			System.out.println("Pass");
		}
		@Then("Address and relevent address fields should be come as mandatory, when enter address")
		public void address_and_relevent_address_fields_should_be_come_as_mandatory_when_enter_address() throws InterruptedException {
		  String address= ld.address.getAttribute("value");
		  if (address.contains("")) 
		  {
			  ld.address.sendKeys("kslfjkdslfjdsklfjd");
			  ld.pinCode.sendKeys("413411");
		  }
		    Wait.explicitWait(ld.pinCode, 5, driver);
			ld.pinCode.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
			Wait.explicitWait(ld.updateButton, 5, driver);
			ld.updateButton.click();
			Thread.sleep(200);
			
			try {this.errorMessage= driver.findElement(By.xpath("//mat-error//div")).getText();}
			catch(NoSuchElementException e) {a.assertTrue(true);}
			a.assertEquals(errorMessage, "Pincode is required");
			 
			ld.pinCode.sendKeys("413411");
			Wait.explicitWait(ld.updateButton, 5, driver);
			ld.updateButton.click();
			try {errorMessage= driver.findElement(By.xpath("//mat-error//div")).getText();}
			catch(NoSuchElementException e) {a.assertTrue(true);}
			a.assertEquals(errorMessage, "Area is required");
			a.assertAll();    
		}
		@Then("Data of fields \\(District, City, State and Contry) should be come automatically, when enter pin code and select area")
		public void data_of_fields_district_city_state_and_contry_should_be_come_automatically_when_enter_pin_code_and_select_area() throws InterruptedException {
			ld.pinCode.sendKeys("413411");
			ld.areaDropdown.click();
			Thread.sleep(1000);
			ld.areaDropdown_KV_Nagar.click();
			String district=driver.findElement(By.xpath("//input[@formcontrolname='district']")).getAttribute("value");
			String city=driver.findElement(By.xpath("//input[@formcontrolname='city']")).getAttribute("value");
			String state=driver.findElement(By.xpath("//input[@formcontrolname='state']")).getAttribute("value");
			String contry=driver.findElement(By.xpath("//input[@formcontrolname='country']")).getAttribute("value");
		
			a.assertEquals(district, "Solapur");
			a.assertEquals(city, "Barshi");
			a.assertEquals(state, "MAHARASHTRA");
			a.assertEquals(contry, "India");
			a.assertAll();
		}
		@Then("Data of fields \\(Area, District, City, State and Contry) should be erase automatically, when delete pincode")
		public void data_of_fields_area_district_city_state_and_contry_should_be_erase_automatically_when_delete_pincode() throws InterruptedException {
			Wait.explicitWait(ld.pinCode, 5, driver);
			ld.pinCode.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
			
			String area=driver.findElement(By.xpath("//mat-select[@formcontrolname='area']")).getAttribute("aria-disabled");
			String district=driver.findElement(By.xpath("//input[@formcontrolname='district']")).getAttribute("value");
			String city=driver.findElement(By.xpath("//input[@formcontrolname='city']")).getAttribute("value");
			String state=driver.findElement(By.xpath("//input[@formcontrolname='state']")).getAttribute("value");
			String contry=driver.findElement(By.xpath("//input[@formcontrolname='country']")).getAttribute("value");
			
			a.assertEquals(area, "true");
			a.assertEquals(district, "");
			a.assertEquals(city, "");
			a.assertEquals(state, "");
			a.assertEquals(contry, "");
			a.assertAll();
		}
		@Then("Address data is coming as same whichever is select at the time of add lead")
		public void address_data_is_coming_as_same_whichever_is_select_at_the_time_of_add_lead() {
			
	
		}
		@When("Check lead requirement section")
		public void check_lead_requirement_section() throws InterruptedException {
			Thread.sleep(2000);
		    ld.leadRequirement_Box.click();
		    
		}
		@Then("This section will displayed, when contactibility is conversion")
		public void this_section_will_displayed_when_contactibility_is_conversion() {
		   boolean contactibilityDisplay= ld.contactabilityDropdown.isDisplayed();
		   if (contactibilityDisplay==true)
		   {
			   boolean leadPersonalData_Display=ld.leadPersonalData_Box.isDisplayed();
			   a.assertEquals(leadPersonalData_Display, true);
		   }
		   else
		   {
			   boolean leadPersonalData_Display=ld.leadPersonalData_Box.isDisplayed();
			   a.assertEquals(leadPersonalData_Display, false);
		   }
		   a.assertAll(); 
		}
		@Then("Field of \\(Area of interest, Required Plot size, Budget) should be displayed under lead requirement section")
		public void field_of_area_of_interest_required_plot_size_budget_should_be_displayed_under_lead_requirement_section() {
		   boolean areaDisplay=ld.areaOfInterest.isDisplayed();
		   boolean plotSizeDisplay=ld. plotSizeDropdown.isDisplayed();
		   boolean budgetDisplay=ld.budgetDropdown.isDisplayed();
		   
		   a.assertEquals(areaDisplay, true);
		   a.assertEquals(plotSizeDisplay, true);
		   a.assertEquals(budgetDisplay, true);
		   
		   a.assertAll();
		 }
		@Then("Lead requirement Data is coming as same whichever is select at the time of add lead")
		public void lead_requirement_data_is_coming_as_same_whichever_is_select_at_the_time_of_add_lead() {
			
		}
			
}
