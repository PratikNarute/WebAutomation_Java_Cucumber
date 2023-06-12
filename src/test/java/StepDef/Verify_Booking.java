		package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Booking extends BaseClass
	{	

			
			@When("Click on Customer Icon")
			public void click_on_customer_icon() throws InterruptedException 
			{	
				
				Thread.sleep(2000);
				b.customerIcon();	
			}
			
			@When("Click on Add customer button")
			public void click_on_add_customer_button() throws InterruptedException 
			{		
				b.addCustomerButton();
			}
			
			@Then("User should be navigate on Add customer page {string}")
			public void user_should_be_navigate_on_add_customer_page(String url) throws InterruptedException
			{
				Thread.sleep(3000);
				String actualUrl=driver.getCurrentUrl();
				Assert.assertEquals(actualUrl, url);
		
			}
			
			@When("Fill all Primary contact information")
			public void fill_all_primary_contact_information() throws InterruptedException
			{	
				b.primaryContactInformation_bookingPropertyThroughCustomer();
			
			}
			
			@When("Fill all Secondary contact information")
			public void fill_all_secondary_contact_information() throws InterruptedException
			{
				b.secondaryContactInformation_bookingPropertyThroughCustomer();
			}
			
			@When("click on Property details box")
			public void click_on_property_details_box() throws InterruptedException
			{
				b.PropertyDetails();	
			}
			
			@When("Click on Now Booking button")
			public void click_on_now_booking_button() 
			{
				b.nowBooking();  
			}
			
			@When("Select Property and fill all info for Prebooking and click on Proceed to Booking button")
			public void select_property_and_fill_all_info_for_prebooking_and_click_on_proceed_to_booking_button() throws InterruptedException 
			{
				b.book_AutomationProjectTwo_propertyNo_1BHK_2();
			}
			
			@Then("User should be navigate to lead closure form")
			public void user_should_be_navigate_to_lead_closure_form() throws InterruptedException 
			{
				Thread.sleep(2000);
				b.headingOfLeadClosureForm();	   
			}
			
			@When("User fill lead closure form")
			public void user_fill_lead_closure_form() throws InterruptedException 
			{
				b.FillLeadClosureForm_PaymentTypeIsInstallatione();
			   
			}
			
			@When("Click on Submit button")
			public void click_on_submit_button() throws InterruptedException 
			{
				b.submitBooking_Button();
			}
			
			@Then("Finally property should be Booked {string}")
			public void finally_property_should_be_booked(String url) throws InterruptedException 
			{
			   Thread.sleep(2000);
			  String Actualurl = driver.getCurrentUrl();
			  Assert.assertEquals(Actualurl, url);
			}
			
	   }
