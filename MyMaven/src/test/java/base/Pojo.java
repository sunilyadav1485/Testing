package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D://Software//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		return driver;

	}

	public static WebDriver openMicrosoftEdgeBrowser() {

		System.setProperty("webdriver.edge.driver", "D:/Java/msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		return driver;

	}

	public static WebDriver openFireFoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:/Java/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
