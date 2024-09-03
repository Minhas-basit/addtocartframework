package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports exReport() {

		String path = System.getProperty("user.dir") + "//reports//+index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Testing by Basit");
		reporter.config().setReportName("end to end testing");

		ExtentReports ereport = new ExtentReports();
		ereport.attachReporter(reporter);
		ereport.setSystemInfo("Tester", "Minhas");

		return ereport;

	}
}
