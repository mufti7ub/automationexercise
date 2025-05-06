package StepDefinitions;

import org.junit.Assert;

import Initiate.baseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserRegistration extends baseClass {
	

	


	@When("User enters Name <{string}>")
	public void user_enters_name(String string) {
		entryValue(userloginpo.signupname, string);
	    
	}

	@When("User enters email")
	public void user_enters_email() {
		String email= emailhelper.getUniqueEmail();
		System.out.println("signup: "+email);

		entryValue(userloginpo.signupmail, email);
	    
	}

	@When("User clicks on Sign Up button")
	public void user_clicks_on_sign_up_button() {
		clickOn(userloginpo.signupbutton);
		System.out.println("Sign Up 1st step working.");
	    
	}

	@When("User should be redirected to next page of registration")
	public void user_should_be_redirected_to_next_page_of_registration() {
		visibilityOfElement(signuppo.signupform);
		//System.out.println("https://www.automationexercise.com/signup" +" and "+getPageURL());
		Assert.assertEquals(getPageURL(), "https://www.automationexercise.com/signup");
	}

	@When("able to see other fields to be required to complete sign up")
	public void able_to_see_other_fields_to_be_required_to_complete_sign_up() {
		visibilityOfElement(signuppo.signupform);
	}

	@When("User selects radio button Mr.")
	public void user_selects_radio_button_mr() {
		clickOn(signuppo.titlemr);
	    
	}

	@When("User enters password <{string}>")
	public void user_enters_password(String string) {
	    entryValue(signuppo.password, string);
	}

	@When("User selcts DOB")
	public void user_selcts_dob() {
	   selectDropdownvalue(signuppo.day,"20");
	   selectDropdownvalue(signuppo.month,"7");
	   selectDropdownvalue(signuppo.year,"1997");
	}

	@When("Tick marked on newsletter")
	public void tick_marked_on_newsletter() {
		clickOn(signuppo.newsletter);
	    
	}

	@When("tick marked on offers subscrption")
	public void tick_marked_on_offers_subscrption() {
		clickOn(signuppo.offers);
	}


	@When("User enter first name <{string}>")
	public void user_enter_first_name(String string) {
		entryValue(signuppo.firstname, string);
	}

	@When("User enters last name <{string}>")
	public void user_enters_last_name(String string) {
	    entryValue(signuppo.lastname, string);
	}

	@When("User enters Company <{string}>")
	public void user_enters_company(String string) {
		entryValue(signuppo.lastname, string);
	}

	@When("User enters address <{string}>")
	public void user_enters_address(String string) {
		entryValue(signuppo.address, string);
	}

	@When("User enters address2 <{string}>")
	public void user_enters_address2(String string) {
		entryValue(signuppo.address2, string);
	}

	@When("Country is selected as India")
	public void country_is_selected_as_india() {
	    selectDropdownvalue(signuppo.country, "India");
	}

	@When("User enters State <{string}>")
	public void user_enters_state(String string) {
		entryValue(signuppo.state, string);
	}

	@When("User enters city <{string}>")
	public void user_enters_city(String string) {
		entryValue(signuppo.city, string);
	}

	@When("User enters zipcode <{string}>")
	public void user_enters_zipcode(String string) {
		entryValue(signuppo.zip, string); 
	}

	@When("User enters mobile <{string}>")
	public void user_enters_mobile(String string) {
		entryValue(signuppo.mobile, string); 
	}

	@When("User clicked on Create Account button")
	public void user_clicked_on_create_account_button() {
	    clickOn(signuppo.createbutton);
	}

	@When("User should be redirected to Account Created page")
	public void user_should_be_redirected_to_account_created_page() {
		visibilityOfElement(accountcreatedpo.accountcreatedpageheader);
		//System.out.println("https://www.automationexercise.com/signup" +" and "+getPageURL());
		Assert.assertEquals(getPageURL(), "https://www.automationexercise.com/account_created");
		//https://www.automationexercise.com/account_created
	}

	@When("Able to see the confirmation page with texts")
	public void able_to_see_the_confirmation_page_with_texts() {
	    presenceOfElement(accountcreatedpo.accountcreatedsuccesstext);
	}

	

	@When("User clicked on Continue button")
	public void user_clicked_on_continue_button() {
	   clickOn(accountcreatedpo.continuedashboardbutton);
	}

	@Then("User should be redirected to dashboard")
	public void user_should_be_redirected_to_dashboard() {
	    visibilityOfElement(dashboardpo.loggedinname);
	}

	@Then("Able to see Log Out in header menu")
	public void able_to_see_log_out_in_header_menu() {
		visibilityOfElement(dashboardpo.loggedout);
	   
	}

	@Then("Able to see Delete Acount in header menu")
	public void able_to_see_delete_acount_in_header_menu() {
	    visibilityOfElement(dashboardpo.deleteaccount);
	}

	@Then("Login\\/Sign Up is not there")
	public void login_sign_up_is_not_there() {
		
		try {
			visibilityOfElement(homepagepo.loginSignButton);
			Assert.fail("Login button is showing after successful Login");
			} catch (Exception e){System.out.println("Login Button is not showing");}
	   
	}
	
	
	

	
	

}
