package StepDef;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Properties_PropertyPriceAndStatus extends BaseClass
{
	String type;

	
	@When("User Click on Propertis icon")
	public void user_click_on_propertis_icon()
	{
	     p.propertiesIcon();
	}
	@When("Click on Property Unit Details menu option")
	public void click_on_property_unit_details_menu_option() throws InterruptedException 
	{
	   	 Thread.sleep(2000);
		 p.propertyPriceAndStatusIcon();
	}
	@Then("User landing on Veiw Properties page {string}")
	public void user_landing_on_veiw_properties_page(String url) throws InterruptedException
	{
		Thread.sleep(3000);
		String actualURL=driver.getCurrentUrl();
		a.assertEquals(actualURL, url);
		a.assertAll();
	}
	@When("User select checkbox for all properties")
	public void user_select_checkbox_for_all_properties() throws InterruptedException
	{
		Thread.sleep(1000);
		p.selectAllCheckBox();
	}
	@Then("Checkbox for all properties should be selected")
	public void checkbox_for_all_properties_should_be_selected() throws InterruptedException 
	{
		Thread.sleep(3000);
		p.toCheckthatSlectAllPropertiesOrNot();	
		driver.navigate().refresh();
		Thread.sleep(2000);
		p.toGetAllOldPrice();
	}

	@When("User Select type {string} as a change rate")
	public void user_select_type_as_a_change_rate(String type) throws InterruptedException 
	{
		Thread.sleep(1000);
		p.selectAllCheckBox();
		Thread.sleep(1000);
		
		p.changeRate_Dropdown.click();	
		Thread.sleep(1000);
		
		if (type.equals("Direct Amount"))
		{
			p.changeRate_Dropdown_DirectAmount.click();
			
		}
		else if (type.equals("RatePerSqFt"))
		{
			p.changeRate_Dropdown_RatePerSqFt.click();
			
		}
		else if (type.equals("RateInPercent"))
		{
			p.changeRate_Dropdown_RateInPercent.click();
		}
	}
	@When("Enter price {string}")
	public void enter_price(String price) 
	{
	  p.enterPrice_input(price);
	}
	@When("Click on update button")
	public void click_on_update_button() throws InterruptedException 
	{
		p.update_Button();
	}
	@Then("Price of all properties should be change by {string}")
	public void price_of_all_properties_should_be_change_by(String price) throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		if (price.equals("100"))
		{
			p.price_of_all_properties_should_be_change_or_not();
			p.ChangePrice_DirectAmount(price);
		}
		else if (price.equals("1"))
		{
			p.price_of_all_properties_should_be_change_or_not();
			p.ChangePrice_RatePerSqFt(price);
		}
		else if (price.equals("10"))
		{
			p.price_of_all_properties_should_be_change_or_not();
			p.ChangePrice_RateInPercent(price);
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
