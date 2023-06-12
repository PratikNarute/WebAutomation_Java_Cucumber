package StepDef;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Verify_AnalysisReport extends BaseClass
{
	String Phone;
	
	/////////////////////// Status Wise /////////////////////////////////////
	@When("User click on refresh button")
	public void user_click_on_refresh_button() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(2000);  db.refreash_Button(); 
				
	}
	@When("Click on Analysis Report text button")
	public void click_on_analysis_report_text_button() throws InterruptedException 
	{	    
	    Thread.sleep(1000); db.analysisReport_TextButton();
	}
	@Then("All status and stages should be visible with sequencial order")
	public void all_status_and_stages_should_be_visible_with_sequencial_order() throws InterruptedException 
	{	    
	    Thread.sleep(1000); db.all_status_and_stages_should_be_visible_with_sequencial_order();
	}
	@Then("Active lead count should be equal to total analysis report count")
	public void active_lead_count_should_be_equal_to_total_analysis_report_count() throws InterruptedException 
	{
	    Thread.sleep(1000); db.active_lead_count_should_be_equal_to_total_analysis_report_count();    
	    
	}
	@Then("User should be redirect on those specific lead page by click on button and Check count of lead on page is same as showing on Dashboard")
	public void user_should_be_redirect_on_those_specific_lead_page_by_click_on_button_and_check_count_of_lead_on_page_is_same_as_showing_on_dashboard() throws InterruptedException
	{
		
	   Thread.sleep(3000);db.user_should_be_redirect_on_those_specific_lead_page_by_click_on_button_and_check_count_of_lead_on_page_is_same_as_showing_on_dashboard();
	}

	@When("User change or convert the lead into perticular status {string}")
	public void user_change_or_convert_the_lead_into_perticular_status(String Status) throws InterruptedException 
	{
		System.out.println("Create New Lead");
		db.getAllOldDataFromDashboard();	    
		Thread.sleep(2000); db.addLead_Button.click();
		Thread.sleep(1000); this.Phone=ld.createLeadWith_Category_Is_Hot();
		Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
		
		System.out.println("Change the status of lead into: "+Status);
		db.getAllOldDataFromDashboard();
		Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
		db.searchLead_Button.click();
		db.user_change_or_convert_the_lead_into_perticular_status(Status);
		Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
		
	}

	@Then("Impact of changing status should be show on the Dashboard of analysis report {string}")
	public void impact_of_changing_status_should_be_show_on_the_dashboard_of_analysis_report(String Status) throws InterruptedException 
	{
		db.impact_of_changing_status_should_be_show_on_the_dashboard_of_analysis_report(Status); 
	}
	
	
	/////////////////////// Stage Wise /////////////////////////////////////
	
	@When("User call first time as per current status")
	public void user_call_first_time_as_per_current_status() throws InterruptedException
	{
		
		db.getAllOldDataFromDashboard();	    
		Thread.sleep(2000); driver.navigate().refresh();
		
		Thread.sleep(2000); db.addLead_Button.click();
		Thread.sleep(1000); this.Phone=ld.createLeadWith_Category_Is_Hot();
		
	}

	@Then("First call considerd as New statge")
	public void first_call_considerd_as_new_statge() throws InterruptedException 
	{
	    db.getAllUpdateDataFromDashboard();
	    Thread.sleep(1000);
	    db.first_call_considerd_as_new_statge();	    
	}
	@When("User call {int}-{int} times to perticular lead")
	public void user_call_times_to_perticular_lead(Integer min, Integer max) throws InterruptedException 
	{
		System.out.println("Min: "+min+"   Max: "+max);

		if (min==2)
		{
			for (int i=min; i<=max; i++)
			{
				System.out.println("Call "+i+" times");
				db.getAllOldDataFromDashboard();
				Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
				db.searchLead_Button.click();
				Thread.sleep(2000);ld.editButton_HotLead();
				Thread.sleep(1000); ld.editLead();
				Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
				Thread.sleep(1000); db.this_lead_considered_as_perticular_stage(i); 
			}
		}
		else if (min==6)
		{
			for (int i=min; i<=max; i++)
			{
				System.out.println("Call "+i+" times");
				db.getAllOldDataFromDashboard();
				Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
				db.searchLead_Button.click();
				Thread.sleep(2000);ld.editButton_HotLead();
				Thread.sleep(1000); ld.editLead();
				Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
				Thread.sleep(1000); db.this_lead_considered_as_perticular_stage(i); 
			}
		}
	
		
	 
	}
	@Then("This lead considered as Primary stage")
	public void this_lead_considered_as_primary_stage() throws InterruptedException 
	{
		 
	}
	@Then("This lead considered as Secondary statge")
	public void this_lead_considered_as_secondary_statge() 
	{
	    	    
	}
	@When("User call more than {int} times to perticular lead")
	public void user_call_more_than_times_to_perticular_lead(Integer min) throws InterruptedException 
	{
		System.out.println("More than 10 times: "+min);

		
			for (int i=min+1; i<=12; i++)
			{
				System.out.println("Call "+i+" times");
				db.getAllOldDataFromDashboard();
				Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
				db.searchLead_Button.click();
				Thread.sleep(2000);ld.editButton_HotLead();
				Thread.sleep(1000); ld.editLead();
				Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
				Thread.sleep(1000); db.this_lead_considered_as_perticular_stage(i); 
			}
	    
	}
	@Then("This lead considered as Tertiary statge")
	public void this_lead_considered_as_tertiary_statge() throws InterruptedException 
	{
		
	}

	@When("User change status of lead into perticular status at any stage {string}")
	public void user_change_status_of_lead_into_perticular_status_at_any_stage(String Status) throws InterruptedException 
	{
		System.out.println("User change status into: "+Status);
		Thread.sleep(2000); db.addLead_Button.click();
		Thread.sleep(1000); this.Phone=ld.createLeadWith_Category_Is_Hot();
		for (int i=2; i<=2; i++)
		{
			System.out.println("Call "+i+" times");
			Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
			db.searchLead_Button.click();
			Thread.sleep(2000);ld.editButton_HotLead();
			Thread.sleep(1000); ld.editLead();
		}
		db.getAllOldDataFromDashboard(); 
		Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
		db.searchLead_Button.click();
		db.user_change_or_convert_the_lead_into_perticular_status(Status);
		Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
		
	}
	@Then("This lead considered as new stage for perticular status {string}")
	public void this_lead_considered_as_new_stage_for_perticular_status(String status)
	{
		db.this_lead_considered_as_new_stage_for_perticular_status(status);
	
	}

	@When("User convert lead into Booked status")
	public void user_convert_lead_into_booked_status() throws InterruptedException 
	{
		System.out.println("User convert lead into Booked status");
		
		Thread.sleep(2000); db.leadDashboardSearch_Tab.sendKeys(this.Phone);
		db.searchLead_Button.click();
		db.user_change_or_convert_the_lead_into_perticular_status("booked");
		db.getAllOldDataFromDashboard();		
		Thread.sleep(1000);b.customerIcon.click();
		Thread.sleep(1000);b.addCustomerButton();
		Thread.sleep(2000);b.searchCustomer_Tab.sendKeys(this.Phone);
		Thread.sleep(3000); b.customerList.click();	
		System.out.println(this.Phone);
		b.primaryContactInformation_bookingPropertyThroughCustomer();
		b.secondaryContactInformation_bookingPropertyThroughCustomer();
		b.PropertyDetails();
		Thread.sleep(1000);b.veiwPrebookingsButton();
		b.submit_Button();
		Thread.sleep(2000);
		db.dashbord_ICon.click();
		Thread.sleep(1000); db.getAllUpdateDataFromDashboard();
	}
	@Then("This lead should not considerd in analysis report {string}")
	public void this_lead_should_not_considered_in_analysis_report(String Status)
	{
		db.this_lead_should_not_considered_in_analysis_report("Prebooked");
	    
	}
	
	////////////Effort Report//////////////////////////////////////////////////
	
	@Given("User should be on dashboart of effort report")
	public void user_should_be_on_dashboart_of_effort_report() throws InterruptedException 
	{
		Thread.sleep(2000);  db.refreash_Button(); 
		Thread.sleep(1000); db.effortReport_TextButton.click();  
		Thread.sleep(1000); db.Redirect_On_active_log_pop_up();
	}
	@When("User click count button")
	public void user_click_count_button() 
	{
	    
	    
	}
	@Then("Active log Pop-Up should be open")
	public void active_log_pop_up_should_be_open() {
	    
	    
	}
	@Then("Sum of Count for all active log should be equal to the count on buttons of effort report")
	public void sum_of_count_for_all_active_log_should_be_equal_to_the_count_on_buttons_of_effort_report() {
	    
	    
	}
	@When("User click on Expand button")
	public void user_click_on_expand_button() {
	    
	    
	}
	@Then("Expand the remarks of all lead")
	public void expand_remarks_of_all_lead() {
	    
	    
	}
	@Then("Count of expanded remarks against lead should be equal to the count which is displayed next to the lead name")
	public void count_of_expanded_remarks_against_lead_should_be_equal_to_the_count_which_is_displayed_next_to_the_lead_name() {
	    
	    
	}
	@Then("Remark should be display against particular call times")
	public void remark_should_be_display_against_particular_call_times() {
	    
	    
	}
	@Then("First call considerd as New statge {string}")
	public void first_call_considerd_as_new_statge(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Those call considered as Primary stage {string}")
	public void those_call_considered_as_primary_stage(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Those call considered as Secondary statge {string}")
	public void those_call_considered_as_secondary_statge(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Those call considered as Tertiary statge {string}")
	public void those_call_considered_as_tertiary_statge(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Those call considered as new stage for perticular status {string}")
	public void those_call_considered_as_new_stage_for_perticular_status(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Previous call records should not be erase against lead")
	public void previous_call_records_should_not_be_erase_against_lead() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
