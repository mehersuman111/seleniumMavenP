package day46;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	
	
	public void onStart(ITestContext context) {
	    System.out.println("Test execution is started");
	    
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Report" +LocalDateTime.now().toString() +".html");
	    
	    sparkReporter.config().setDocumentTitle("Automation Report");
	    sparkReporter.config().setReportName("Functional Testing");
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    
	    reports = new ExtentReports();
	    
	    reports.attachReporter(sparkReporter);
	    
	    reports.setSystemInfo("Computer Name", "COMV-9549");
	    reports.setSystemInfo("Environment", "QA");
	    reports.setSystemInfo("Test Engineer Name", "Suman");
	    reports.setSystemInfo("OS", "Windows 11");
	    reports.setSystemInfo("Browser Name", "Chrome");
	    
	  }
	public void onTestStart(ITestResult result) {
	    System.out.println("Test Started ...");
	    
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test Passed ...");
	    
	    test = reports.createTest(result.getName());
	    test.log(Status.PASS, "Testcases passed is " + result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test Failed ...");
	    
	    test = reports.createTest(result.getName());
	    test.log(Status.FAIL, "Testcase failed is " + result.getName());
	    test.log(Status.FAIL, "Testcase is failed due to " + result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test Skipped ...");
	    
	    test = reports.createTest(result.getName());
	    test.log(Status.SKIP, "Testcases skipped is " + result.getName());
	  }
	
	public void onFinish(ITestContext context) {
	    System.out.println("Test execution is Finished ...");
	    reports.flush();
	  }
	
}
