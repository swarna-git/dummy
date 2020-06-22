package runner1;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/featureFile",
               glue= "stepDefinations")

public class TestRunner {

}

	


