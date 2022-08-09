package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.bcel.internal.classfile.Utility;

public class LoginPage {
	private FileInputStream excle;
	private Sheet dataSheet;
	private WebDriver driver;
	
	@FindBy(xpath ="//a[@id='nav-link-accountList']")
	private WebElement signUp;

	@FindBy(id = "ap_email")
	private WebElement mobileNo;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(id = "ap_password")
	private WebElement passWord;

	@FindBy(id = "signInSubmit")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void clickOnSignUp() {
		signUp.click();
	}

	public void enterMobileNo(String mobileNumber) throws EncryptedDocumentException, IOException {
//		excle = new FileInputStream("C:/Users/hp/OneDrive/Desktop/Amazon_id.XLSX");
//		dataSheet = WorkbookFactory.create(excle).getSheet("sheet1");
//		double mobileNumber=dataSheet.getRow(4).getCell(0).getNumericCellValue();
		
		mobileNo.sendKeys(mobileNumber);
		
		
		
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public void enterPassword(String pass) {
//		String pass=dataSheet.getRow(5).getCell(0).getStringCellValue();
		passWord.sendKeys(pass);
	}
	public void clickSignInButton() {
		signInButton.click();
	}

}
