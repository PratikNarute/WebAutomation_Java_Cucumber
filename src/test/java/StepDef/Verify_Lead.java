package StepDef;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
	String phone;

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
		}
		@When("Check lead personal data section")
		public void check_lead_personal_data_section() throws InterruptedException {
			A.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(2000);
			j.executeScript("arguments[0].click(true)", (ld.leadPersonalData_Box));
//			A.scrollToElement(ld.leadPersonalData_Box).pause(Duration.ofSeconds(2)).click(ld.leadPersonalData_Box).build().perform();
		//    ld.leadPersonalData_Box.click();
		    Thread.sleep(2000);
		    j.executeScript("window.scrollBy(0, 1000)");
		}
		@Then("Field of \\(Name, Phone, Alternative no, Select profession, Select living mode, Current address, Pin code, Area, city, District, State, Contry) should be displyed and enabled under leads personal data section")
		public void field_of_name_phone_alternative_no_select_profession_select_living_mode_current_address_pin_code_area_city_district_state_contry_should_be_displyed_under_leads_personal_data_section() throws InterruptedException {
		    Thread.sleep(2000);
		    boolean nameDiplayed=ld.name.isDisplayed();
		    boolean phoneDiplayed= ld.phone.isDisplayed();
		    boolean professionDropdownDiplayed= ld.professionDropdown.isDisplayed();
		    boolean addProfessionIconDisplayed=ld.addProfessionIcon.isDisplayed();
		    boolean livingModeDropdownDiplayed= ld.livingModeDropdown.isDisplayed();
		    boolean addressDisplayed=ld.address.isDisplayed();
		    boolean pinCodeDiplayed= ld.pinCode.isDisplayed();
		    boolean areaDisplayed=ld.areaDropdown.isDisplayed();
		    boolean cityDropdownDisplayed=ld.city.isDisplayed();
		    boolean districtDiplayed=ld.district.isDisplayed();
		    boolean stateDiplayed=ld.state.isDisplayed();
		    boolean countryDiplayed=ld.country.isDisplayed();   
		    
		    boolean nameEnabled=ld.name.isEnabled();
		    boolean phoneEnabled= ld.phone.isEnabled();
		    boolean professionDropdownEnabled= ld.professionDropdown.isEnabled();
		    boolean addProfessionIconEnabled=ld.addProfessionIcon.isEnabled();
		    boolean livingModeDropdownEnabled=ld.livingModeDropdown.isEnabled();
		    boolean addressEnabled=ld.address.isEnabled();
		    boolean pinCodeEnabled=ld.pinCode.isEnabled();
		    boolean areaEnabled=ld.areaDropdown.isEnabled();
		    boolean cityDropdownEnabled=ld.city.isEnabled();
		    boolean districtEnabled=ld.district.isEnabled();
		    boolean stateEnabled=ld.state.isEnabled();
		    boolean countryEnabled=ld.country.isEnabled(); 
		    
		    a.assertEquals(nameDiplayed, true);
		    a.assertEquals(phoneDiplayed, true);
		    a.assertEquals(professionDropdownDiplayed, true);
		    a.assertEquals(addProfessionIconDisplayed, true);
		    a.assertEquals(addProfessionIconDisplayed, true);
		    a.assertEquals(livingModeDropdownDiplayed, true);
		    a.assertEquals(addressDisplayed, true);
		    a.assertEquals(pinCodeDiplayed, true);
		    a.assertEquals(areaDisplayed, true);
		    a.assertEquals(cityDropdownDisplayed, true);
		    a.assertEquals(districtDiplayed, true);
		    a.assertEquals(stateDiplayed, true);
		    a.assertEquals(countryDiplayed, true);
		    
		    a.assertEquals(nameEnabled, true);
		    a.assertEquals(phoneEnabled, true);
		    a.assertEquals(professionDropdownEnabled, true);
		    a.assertEquals(addProfessionIconEnabled, true);
		    a.assertEquals(addProfessionIconEnabled, true);
		    a.assertEquals(livingModeDropdownEnabled, true);
		    a.assertEquals(addressEnabled, true);
		    a.assertEquals(pinCodeEnabled, true);
		    a.assertEquals(areaEnabled, true);
		    a.assertEquals(cityDropdownEnabled, true);
		    a.assertEquals(districtEnabled, true);
		    a.assertEquals(stateEnabled, true);
		    a.assertEquals(countryEnabled, true);
		    
		    a.assertAll();
			System.out.println("Pass");  
		    
		}
		@Then("Name and Phone no fields should be mandatory")
		public void name_and_phone_no_fields_should_be_mandatory() throws InterruptedException {
		   String name= ld.name.getAttribute("value");
		   
//		   ld.name.clear();
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
		@Then("Field of \\(Area of interest, Required Plot size, Budget) should be displayed and enabled under lead requirement section")
		public void field_of_area_of_interest_required_plot_size_budget_should_be_displayed_under_lead_requirement_section() {
		   boolean areaDisplay=ld.areaOfInterest.isDisplayed();
		   boolean plotSizeDisplay=ld. plotSizeDropdown.isDisplayed();
		   boolean budgetDisplay=ld.budgetDropdown.isDisplayed();
		   
		   boolean areaEnabled=ld.areaOfInterest.isEnabled();
		   System.out.println(areaEnabled);
		   boolean plotSizeEnabled=ld. plotSizeDropdown.isEnabled();
		   boolean budgetEnabled=ld.budgetDropdown.isEnabled();
		   
		   a.assertEquals(areaDisplay, true);
		   a.assertEquals(plotSizeDisplay, true);
		   a.assertEquals(budgetDisplay, true);
		   
		   a.assertEquals(areaEnabled, true);
		   a.assertEquals(plotSizeEnabled, true);
		   a.assertEquals(budgetDisplay, true);
		   
		   a.assertAll();
		 }
		@Then("Lead requirement data is coming as same whichever is select at the time of add lead")
		public void lead_requirement_data_is_coming_as_same_whichever_is_select_at_the_time_of_add_lead() {
		
		}
		
		/// Edit prebooked and booked lead /////////////////////////////////
		
	
		@Given("User should be on edit prebooked or booked lead page {string}")
		public void user_should_be_on_edit_prebooked_or_booked_lead_page(String Status) throws InterruptedException {
			Thread.sleep(2000);
			if (Status.equals("Prebook")) {
				driver.findElement(By.xpath("(//div[@routerlink='/lead/lead'])[4]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[@routerlink='/lead/lead'])[5]")).click();
			}
			
			Thread.sleep(2000);
			j.executeScript("arguments[0].click(true);", driver.findElement(By.xpath("(//button[@class='pushable close-btn ng-star-inserted'])[2]")));
		   
			String editLead=driver.findElement(By.xpath("//div[text()='Edit Lead']")).getText();
			a.assertEquals(editLead, "Edit Lead");
			a.assertAll();
		}
		@When("Check disable or not editable fields")
		public void check_disable_or_not_editable_fields() {
		    
		   
		}
		@Then("Contactibility field should be disabled")
		public void contactibility_field_should_be_disabled() {
		    
		   boolean contactability= ld.contactabilityDropdown.isDisplayed();
		   a.assertEquals(contactability, true);
		   a.assertAll();
		}
		@Then("Status field should be disabled")
		public void status_field_should_be_disabled() {
		    
		   boolean status= ld.statusDropdown.isDisplayed();
		   a.assertEquals(status, true);
		   a.assertAll();
		}
		@Then("Mobile no field should be disabled")
		public void mobile_no_field_should_be_disabled() throws InterruptedException {   
			Thread.sleep(1000);
			j.executeScript("arguments[0].click(true)", ld.leadPersonalData_Box);
			Wait.explicitWait(ld.phone, 5, driver);
		    ld.phone.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		    this.phone= ld.phone.getAttribute("value");
		    System.out.println(phone);
		    a.assertNotEquals(phone, "");
		    a.assertAll();
		}
		@When("Check mode of interested field")
		public void check_mode_of_interested_field() {
		    
		    
		}
		@Then("Checkbox of interest should be come as selected by default")
		public void checkbox_of_interest_should_be_come_as_selected_by_default() throws InterruptedException {
			 Thread.sleep(2000); j.executeScript("window.scrollBy(0,-1000)");
			 Thread.sleep(2000);
			 String checkboxInterest=driver.findElement(By.xpath("//mat-checkbox//input[@type='checkbox']")).getAttribute("aria-checked");
			 a.assertEquals(checkboxInterest, "true");
			 a.assertAll();
		}
		@When("User deselect the checkbox of interested")
		public void user_deselect_the_checkbox_of_interested() throws InterruptedException {  
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@formcontrolname='mode_of_interest'] / parent :: div // mat-checkbox // input /parent :: span / parent :: label / parent :: mat-checkbox")).click();
		}
		@Then("Open property details pop up and show disclaimer message \\(Property already prebook or book, firstly release all properties)")
		public void open_property_details_pop_up_and_show_disclaimer_message_property_already_prebook_or_book_firstly_release_all_properties() {
		    
		    
		}
		@Then("After release all properties, then user will able to convert into not interested lead")
		public void after_release_all_properties_then_user_will_able_to_convert_into_not_interested_lead() {
		    
		    
		}
		@Then("Category field hide")
		public void category_field_hide() {
		   boolean displayed= driver.findElement(By.xpath("//mat-select[@formcontrolname='category']")).isDisplayed();
		   a.assertEquals(displayed, false);
		   a.assertAll();
		    
		}
		@Then("Next followup date field come as non mandatory")
		public void next_followup_date_field_come_as_non_mandatory() {
			String mandatory=ld.Calender_follow_up_date.getAttribute("aria-invalid");
			a.assertEquals(mandatory, "false");
			a.assertAll();
		    
		}
		@When("Check category field dropdown")
		public void check_category_field_dropdown() throws InterruptedException {
		    
		    driver.navigate().refresh();
		    Thread.sleep(2000);
		}
		@When("Check select status field")
		public void check_select_status_field() {
		    
		    
		}
		@Then("It should be disabled")
		public void it_should_be_disabled() {
		   String disable= driver.findElement(By.xpath("//mat-select[@formcontrolname='status']")).getAttribute("aria-disabled");
		    a.assertEquals(disable, "true");
		    a.assertAll();    
		}
		
		@When("Check next followup date field")
		public void check_next_followup_date_field() throws InterruptedException {
		    Thread.sleep(1000);
		    j.executeScript("window.scrollBy(0, 1000)");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
			 
		}
		@Then("It come as mandatory by default")
		public void it_come_as_mandatory_by_default() throws InterruptedException {
			Thread.sleep(500);
			String errorMessage= driver.findElement(By.xpath("//mat-error")).getText();
			a.assertEquals(errorMessage, "Follow-up date is required !");
			a.assertAll();
		}
			
}
