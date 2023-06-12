
package TestRun;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@CucumberOptions(		
//		features = {".//Features/Booking.feature"},
//		glue="StepDef",
//		dryRun = false,
//		monochrome = true,
//		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
//		)


//@CucumberOptions(		
//		features = {".//Features/Properties.feature"},
//		glue="StepDef",
//		dryRun = false,
//		monochrome = true,
//		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
//		)

//public class Run extends AbstractTestNGCucumberTests{
//	/*This class will be empty*/
//}
@CucumberOptions(		
		features = {".//Features/Leads.feature"},
		glue="StepDef",
		dryRun = false,
		monochrome = true,
//		tags="@Analysis_Report or @Effort_Report",
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)

public class Run extends AbstractTestNGCucumberTests{
	/*This class will be empty*/
}

