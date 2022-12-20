package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	private static final String loginXpath= "//a[@href='/login']";
	private WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnFormAuthentication() {
		WebElement loginForm = driver.findElement(By.xpath(loginXpath));
		loginForm.click();
	}
}