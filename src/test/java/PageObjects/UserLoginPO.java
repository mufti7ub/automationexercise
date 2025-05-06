package PageObjects;

import org.openqa.selenium.By;

public class UserLoginPO {

	public By loginemail = By.xpath("//input[@data-qa='login-email']");
	public By password = By.xpath("//input[@data-qa='login-password']");
	public By loginButton = By.xpath("//button[@data-qa='login-button']");
	public By signupname = By.xpath("//input[@data-qa='signup-name']");
	public By signupmail = By.xpath("//input[@data-qa='signup-email']");
	public By signupbutton = By.xpath("//button[@data-qa='signup-button']");

}
