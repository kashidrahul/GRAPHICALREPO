package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features =".//Features/Customers.feature",
		glue = "StepDefination",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","junit:target/Cucumber_Report/Report_xml.xml",
				"html:target/Cucumber_Report/Report.html","html:target/Cucumber_Report/Report.html"}
		)
//plugin= {"pretty","html:target/Cucumber_Report/Report.html"}

public class Run 
{
//class will be empty
}
