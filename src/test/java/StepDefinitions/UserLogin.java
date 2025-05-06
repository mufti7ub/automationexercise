package StepDefinitions;

import Initiate.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLogin extends baseClass {

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		visibilityOfElement(homepagepo.homePageBanner);
		visibilityOfElement(homepagepo.logo);
	}

	@When("User click on Sign Up & Login from header")
	public void user_click_on_sign_up_login_from_header() {
		clickOn(homepagepo.loginSignButton);
	}

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		visibilityOfElement(userloginpo.loginButton);
		System.out.println("Redirected to Login Page.");
	}

	@When("User enters valid credentials email")
	public void user_enters_valid_credentials_email() {
		String email = emailhelper.getUniqueEmail();  // returns the same one
		System.out.println("login: "+email);
		entryValue(userloginpo.loginemail, email);

	}

	@When("User enters valid credentials password <{string}>")
	public void user_enters_valid_credentials_password(String string) {
		entryValue(userloginpo.password, string);

	}
	
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		clickOn(userloginpo.loginButton);
		
	}

	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		visibilityOfElement(dashboardpo.loggedinname);
		presenceOfElement(dashboardpo.loggedout);
		
		System.out.println("Login worked");
		clickOn(dashboardpo.loggedout);
	}

	@When("User enters invalid Password")
	public void user_enters_invalid_password() {
	}

	@Then("User should not be redirected to the homepage")
	public void user_should_not_be_redirected_to_the_homepage() {
	}

	@Then("Error message should be dispalyed")
	public void error_message_should_be_dispalyed() {
	}

	@Then("A failure toast message will be appeared")
	public void a_failure_toast_message_will_be_appeared() {
	}

	@When("User enters invalid Email")
	public void user_enters_invalid_email() {
	}

	@When("User not entered any credentials")
	public void user_not_entered_any_credentials() {
	}

	@Then("Error message should be displayed on Email field in a Tool tip")
	public void error_message_should_be_displayed_on_email_field_in_a_tool_tip() {
	}

	@When("User not entered password credentials")
	public void user_not_entered_password_credentials() {
	}

	@When("User enters valid email")
	public void user_enters_valid_email() {
	}

	@Then("Error message should be displayed on Password field in a Tool tip")
	public void error_message_should_be_displayed_on_password_field_in_a_tool_tip() {
	}

	@When("User entered email {string}")
	public void user_entered_email(String string) {
	}

}
