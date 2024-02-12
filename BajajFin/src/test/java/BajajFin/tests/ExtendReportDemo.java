package BajajFin.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void startReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtendReportDemo.html");  //We have initialized the object & given Test report name.
		reports = new ExtentReports();  // Create the Object of Report.
		reports.attachReporter(htmlReporter); // We have attached report to ExtentSparkReporter object.
		
		
	}
	

}
