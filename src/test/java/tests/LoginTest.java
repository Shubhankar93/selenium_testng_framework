package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import businessFunctions.HomePage;
import businessFunctions.LoginPage;
import testBase.TestBase;
import utilities.ReportHandler;

public class LoginTest extends TestBase {
	public ExtentTest report;
	LoginPage obj_loginPage;
	HomePage obj_homePage;
	

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method m) throws IOException {
		 report = extentsReport.createTest(m.getName());
		init();

	}
	//@Test (invocationCount = 5)
	
	@Parameters({ "uid", "pass" }) 
	@Test (groups = {"SmokeTest"})
	public void VerifyApplicationLunch(String uid, String pass) throws InterruptedException {
		int i =0;
		obj_loginPage = new LoginPage(driver,report);
		report.log(Status.PASS, "Test Passed");
		obj_loginPage.Login(uid, pass);
		report.pass("Login sucessful");
		// System.out.println(myname);
	}
	@Parameters({ "uid", "pass" })
	@Test (groups = {"UAT"})
	public void AssignLeave(String uid, String pass) throws InterruptedException {
		obj_loginPage = new LoginPage(driver, report);
		obj_homePage = new HomePage(driver);
		obj_loginPage.Login(uid, pass);
		obj_homePage.assignLeave();
		Thread.sleep(5000);
		report.pass("Assign Leave sucessful");

	}

}
