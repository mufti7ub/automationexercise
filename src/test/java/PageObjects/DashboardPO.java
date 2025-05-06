package PageObjects;

import org.openqa.selenium.By;

public class DashboardPO {
	public By loggedinname = By.xpath("//a[contains (text(),' Logged in as ')]"); //a[contains (text(),'Logg')]
	public By loggedout =  By.xpath("//a[text() =' Logout']");
	public By deleteaccount = By.xpath("//a[text() =' Delete Account']");
}
