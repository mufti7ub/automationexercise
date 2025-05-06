package PageObjects;

import org.openqa.selenium.By;

public class SignUpPagePO {

	public By signupform = By.xpath("//div [@class='login-form']//b[text()='Enter Account Information']");
	public By titlemr = By.xpath("//input[@id=\'id_gender1\']");
	public By password = By.xpath("//input[@id=\'password\']");
	public By day = By.xpath("//*[@id='days']");
	public By month = By.xpath("//*[@id='months']");
	public By year = By.xpath("//select[@id='years']");
	public By newsletter = By.xpath("//*[@id='newsletter']");
	public By offers = By.xpath("//*[@id='optin']");
	public By firstname = By.xpath("//*[@id='first_name']");
	public By lastname = By.xpath("//*[@id='last_name']");
	public By company = By.xpath("//*[@id='company']");
	public By address = By.xpath("//*[@id='address1']");
	public By address2 = By.xpath("//*[@id='address2']");
	public By country = By.xpath("//select[@id='country']");
	public By state = By.xpath("//*[@id='state']");
	public By city = By.xpath("//*[@id='city']");
	public By zip = By.xpath("//*[@id='zipcode']");
	public By mobile = By.xpath("//*[@id='mobile_number']");
	public By createbutton = By.xpath("//*[@data-qa='create-account']");
	
}
