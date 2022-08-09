package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmaHomePageHeader {


	@FindBy(xpath = "(//a[@class='nav-a  '])[1]")
	private WebElement todaysDeal;

	@FindBy(xpath = "(//a[@class='nav-a  '])[2]")
	private WebElement homeAndKitchen;

	@FindBy(xpath = "(//a[@class='nav-a  '])[3]")
	private WebElement coupens;

	@FindBy(xpath = "(//a[@class='nav-a  '])[4]")
	private WebElement giftCard;

	@FindBy(xpath = "(//a[@class='nav-a  '])[5]")
	private WebElement amazonPay;

	@FindBy(xpath = "(//a[@class='nav-a  '])[6]")
	private WebElement petSupplies;

	@FindBy(xpath = "(//a[@class='nav-a  '])[7]")
	private WebElement buyAgain;

	@FindBy(xpath = "(//a[@class='nav-a  '])[8]")
	private WebElement sportFitnessOutdor;

	@FindBy(xpath = "(//a[@class='nav-a  '])[9]")
	private WebElement kindleEbook;

	@FindBy(xpath = "(//a[@class='nav-a  '])[10]")
	private WebElement browsingHistry;

	@FindBy(xpath = "(//a[@class='nav-a  '])[11]")
	private WebElement homeImprovement;
	
	public AmaHomePageHeader(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnTodaysDeal() {
		
		String acturl=todaysDeal.getAttribute("href");
		todaysDeal.click();
		return acturl;
	}
	public String clickOnHomeAndKitchen() {
		
		homeAndKitchen.click();
		String acturl=homeAndKitchen.getAttribute("href");
		return acturl;
	
	}
	public void clickOnCoupens() {
		coupens.click();
	}
	public void clickOnGiftCard() {
		giftCard.click();
	}
	public void clickOnAmazonPay() {
		amazonPay.click();
	}
	public void clickOnPetSupplies() {
		petSupplies.click();
	}
	public void clickOnBuyAgain() {
		buyAgain.click();
	}
	public void clickOnSportFitnessOutdor() {
		sportFitnessOutdor.click();
	}
	public void clickOnKindleEbook() {
		kindleEbook.click();
	}
	public void clickOnBrowsingHistry() {
		browsingHistry.click();
	}
	public void clickOnHomeImprovement() {
		homeImprovement.click();
	}

}
