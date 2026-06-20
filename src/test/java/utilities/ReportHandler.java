package utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportHandler {
	public static ExtentReports extentsReport() throws IOException{
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/index.html");
		spark.config().setReportName("Web Test Automation");
		spark.config().setDocumentTitle("Test Result");
		ExtentReports extentsReport = new ExtentReports(); 
		extentsReport.attachReporter(spark);
		return  extentsReport;
	}

}
