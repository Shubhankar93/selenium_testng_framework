package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReportHandler;





public class TestBase {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public ExtentReports extentsReport;
	
	public String projectPath = System.getProperty("user.dir");
	
	@BeforeSuite (alwaysRun = true)
	public void startSuite() throws IOException{
		 extentsReport=ReportHandler.extentsReport();
	
	}
	@AfterSuite (alwaysRun = true)
	public void endSuite() throws IOException{
		extentsReport.flush();
	
	}
	
	
	
	/*@AfterMethod
	public void EndOfSuite(){
		extentsReport.flush();
	}*/
	
	
	public void init() throws IOException {
	
		loadData();
		//String log4jConfPath = "log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		
		
	}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void getUrl(String url) {
		//log.info("navigating to :-" + url);
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir")
				+ "/src/test/java/com/test/automation/uiAutomation/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));

		/*ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("-incognito");
		chromeOptions.addArguments("--test-type");
		//chromeOptions.addArguments("--headless");
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));*/
		//Here I am tetsing something // changed again

		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				//System.setProperty("webdriver.chrome.driver",
					//	System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				implicitWait();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				implicitWait();
				// driver = new EventFiringWebDriver(dr);
				//eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				//System.out.println(System.getProperty("user.dir"));
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
				implicitWait();
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				implicitWait();
				// driver = new EventFiringWebDriver(dr);
				//eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void endTest() {
		
		driver.quit();
		
	}

}
