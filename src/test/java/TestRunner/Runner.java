package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(features="Features", glue= {"StepDefinition"})
public class Runner {

}
