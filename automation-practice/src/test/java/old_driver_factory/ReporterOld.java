package old_driver_factory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReporterOld {

	static ExtentHtmlReporter extentHtmlReporter;
	static ExtentReports extentsReports;
	static ExtentTest extentTest;
	static ExtentTest step;

	public static void initReporter() {

		if (extentsReports == null) {
			extentHtmlReporter = new ExtentHtmlReporter("automation-report.html");
			extentsReports = new ExtentReports();
			extentsReports.attachReporter(extentHtmlReporter);
		}
	}

	public static void createClass(String classname) {

		extentTest = extentsReports.createTest(classname);
	}

	public static void createTest(String testName) {
		step = extentTest.createNode(testName);
	}
	
	public static void verify (String expected, String actual) {
		if(expected.equals(actual)) {
			//pass
			step.pass("Verification sucess. Expected : ["+ expected+" ] Actual :[ "+actual+"]");
		}else {
			//fail
			step.fail("Verification fail. Expected : ["+ expected+" ] Actual :[ "+actual+"]");
		}
	}

	@AfterMethod
	public static void saveReport() {
		extentsReports.flush();
	}
}
