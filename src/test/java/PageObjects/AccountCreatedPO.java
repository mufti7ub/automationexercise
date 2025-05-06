package PageObjects;

import org.openqa.selenium.By;

public class AccountCreatedPO {
		public By accountcreatedpageheader = By.xpath("//h2[@data-qa='account-created']");
		public By accountcreatedsuccesstext = By.xpath("//p[contains (text(),'Congratulations!')]");
		public By continuedashboardbutton = By.xpath("//a[@data-qa='continue-button']");
}
