/**
 * 
 */
package tests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario;

/**
 * @author SrinivasKalmady
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",monochrome = true,
glue= {"stepdefintions"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/reports.html", "json:target/cucumber-report.json"})



public class Runner {
	

}
