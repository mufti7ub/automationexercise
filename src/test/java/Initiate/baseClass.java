package Initiate;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v135.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.AccountCreatedPO;
import PageObjects.DashboardPO;
import PageObjects.HomePagePO;
import PageObjects.SignUpPagePO;
import PageObjects.UserLoginPO;

public class baseClass {
	// make these static so EVERY subclass / hook sees the same instance
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static HomePagePO homepagepo;
	protected static UserLoginPO userloginpo;
	protected static SignUpPagePO signuppo;
	protected static AccountCreatedPO accountcreatedpo;
	protected static DashboardPO dashboardpo;
	protected static EmailHelper emailhelper;

	protected void browserSetup() {
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false); // Disable password manager
		prefs.put("profile.password_manager_enabled", false); // Disable password prompts
		prefs.put("autofill.profile_enabled", false); // Disable autofill of addresses
		prefs.put("autofill.credit_card_enabled", false); // Disable credit card save prompts
		
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-blink-features=AutomationControlled"); // optional: reduce detection
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("disable-infobars");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		DevTools devTools = ((ChromeDriver) driver).getDevTools(); // To block ads on the used url using devtools
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(
				Arrays.asList("*.doubleclick.net/*", "*.googlesyndication.com/*", "*://*adservice.google.com/*")));

		driver.get("https://www.automationexercise.com/");

		// only now create your page object, passing in the ready driver
		homepagepo = new HomePagePO();
		userloginpo = new UserLoginPO();
		signuppo = new SignUpPagePO();
		accountcreatedpo = new AccountCreatedPO();
		dashboardpo = new DashboardPO();
		emailhelper = new EmailHelper();
	}

	protected void browserQuit() {
		driver.quit();
	}

	protected void presenceOfElement(By locator) {
		try {
			highlightElement(driver, locator, "blue");
		} catch (Exception e) {
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected void visibilityOfElement(By locator) {
		try {
			highlightElement(driver, locator, "blue");
		} catch (Exception e) {
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void elementToBeClickable(By locator) {
		try {
			highlightElement(driver, locator, "blue");
		} catch (Exception e) {
		}
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void clickOn(By locator) {
		scrollTo(locator);
		presenceOfElement(locator);
		highlightElement(driver, locator, "red");
		driver.findElement(locator).click();
		waitForPageLoad();
	}

	public void highlightElement(WebDriver driver, By element, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// set a 3px solid red border
		js.executeScript("arguments[0].style.border='3px solid " + color + "'", driver.findElement(element));
	}

	protected void entryValue(By locator, String value) {
		scrollTo(locator);
		highlightElement(driver, locator, "green");
		visibilityOfElement(locator);
		driver.findElement(locator).sendKeys(value);
	}

	protected String getPageURL() {
		return driver.getCurrentUrl();

	}

	protected void waitForPageLoad() {
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	protected void selectDropdownvalue(By locator, String value) {
		scrollTo(locator);
		Select select = new Select(driver.findElement(locator));
		highlightElement(driver, locator, "red");
		select.selectByValue(value);
	}

	protected void scrollTo(By element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", driver.findElement(element));
	}
	
	public  String captureScreenshot(WebDriver driver, String scenarioName) {
        String screenshotPath = "target/screenshots/" + scenarioName + "_" + System.currentTimeMillis() + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

}
