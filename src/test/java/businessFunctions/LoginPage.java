package businessFunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import testBase.TestBase;

public class LoginPage extends Page {
	Logger logger = LogManager.getLogger(LoginPage.class.getName());
	WebDriver driver;
	HomePage homepage;
	ExtentTest report;

	
	//WebElement userName;
	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement login;

	public LoginPage(WebDriver driver, ExtentTest report) {
		//this.driver = driver;
		this.driver = TestBase.getDriver();
		this.report = report;
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, class.);
	}

	public void launchAPP() {
//		String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
//		System.out.println(driverPath);
//		System.setProperty("webdriver.chrome.driver", driverPath);
//		WebDriver driver = new ChromeDriver();
		String appURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(appURL);
	}

	public void Login(String uid, String pass) throws InterruptedException {
		userName.sendKeys(uid);
		report.pass("UserName Entered");
		logger.info("Username entered");
		password.sendKeys(pass);
		report.pass("Password Entered");
		logger.info("Password entered");
		login.click();
		logger.info("Clicked on Login Button");
	
		

	}
}
