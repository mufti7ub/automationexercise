package PageObjects;

import org.openqa.selenium.By;

public class HomePagePO {
	public By homePageBanner =By.xpath("//div[@class='col-sm-12']");
	public By logo = By.xpath("//div[@class='logo pull-left']");
	public By loginSignButton = By.xpath("//a[@href='/login']");
	
}
