package commonutils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplementation implements ITestListener {
    
	public ExtentReports rp;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//Reporter.log("Testscript executon is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//To get reason
		String msg = result.getThrowable().toString();
		//To get the methode name
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"Testscript executon is passed"+msg,true);
		test.log(Status.PASS,methodname+"Test Execution is Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//To get reason
		String msg = result.getThrowable().toString();
		//To get the methode name
		String methodname = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodname+"Test Execution is Fail");
		Reporter.log(methodname+"Testscript executon is failed"+msg,true);
		WebDriverUtils wutils = new WebDriverUtils();
		WebDriver dc = null;
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//To get reason
		String msg = result.getThrowable().toString();
		//To get the methode name
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript executon is skipped"+msg,true);
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		// to configure extent reports
		ExtentSparkReporter reports = new ExtentSparkReporter("./Extentreport.html");
		reports.config().setDocumentTitle("Deccan");
		reports.config().setReportName("Pune");
		reports.config().setTheme(Theme.STANDARD);
		
		//To add data to report 
		 rp = new ExtentReports();
		 
		 //To generate the report & attaching the congigiration
		 rp.attachReporter(reports);
		
		 //To add extra information to the report
		 rp.setSystemInfo("OS", "Windows");
		 rp.setSystemInfo("Browser", "Chrome");
		 rp.setSystemInfo("Chrome", "120.0609");
		 rp.setSystemInfo("Programing language", "java");
		 rp.setSystemInfo("reportername", "Sumit");
		 
		
		Reporter.log("Testscript executon is started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		rp.flush();
		
	}
	
	
	

}
