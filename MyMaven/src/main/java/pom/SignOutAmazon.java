package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutAmazon {
	
	private WebDriver driver;
	
	@FindBy(xpath="//a[@id=\"nav-link-accountList\"]")
	private WebElement moveToSignOutEle;
	
	@FindBy(xpath="//a[@id='nav-item-signout']")
	private WebElement signOut;
	
	public SignOutAmazon( WebDriver  driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void moveToSignOutEle() {
		Actions act=new Actions (driver);
		act.moveToElement(moveToSignOutEle).build().perform();
	}
	
	public void clickOnSignOut() {
		signOut.click();
		
	}
}
