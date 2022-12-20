package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {
	private static final String successXpath = "//div[contains(text(), 'You logged into a secure area!')]";
	private static final String logoutXpath = "//a[@href='/logout']";
	private WebDriver driver;
	
	public LoggedInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSuccessText() {
		WebElement successText = driver.findElement(By.xpath(successXpath));
		return successText;
	}
	
	public void clickLogout() {
		WebElement logoutBtn = driver.findElement(By.xpath(logoutXpath));
		logoutBtn.click();
	}
	
}