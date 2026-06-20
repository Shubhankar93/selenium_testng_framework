package businessFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page {
	@FindBy(xpath = "//*[@name='username']")
	WebElement userName;
}
