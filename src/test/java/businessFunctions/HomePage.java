package businessFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	Logger logger = LogManager.getLogger(HomePage.class.getName());

	WebDriver driver;

	@FindBy(xpath = "//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/span")
	WebElement assignLeave;

	@FindBy(xpath = "//*[@id='assignleave_txtEmployee_empName']")
	WebElement employeeName;

	@FindBy(xpath = "//*[@id='assignleave_txtLeaveType']")
	WebElement leaveType;

	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, class.);
	}

	public void assignLeave() {
		assignLeave.click();
		logger.info("Clicked on Assign Leave link");
		employeeName.sendKeys("Robert Ferry");
		logger.info("Name entered as Robert Ferry");
	}

}
