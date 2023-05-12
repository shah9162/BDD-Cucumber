package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "C:\\Users\\Mayank Morya\\eclipse-workspace\\BDD\\Features\\login.feature", glue = "stepDefinitation")
@CucumberOptions(features = "C:\\Users\\Mayank Morya\\eclipse-workspace\\BDD\\Features\\signUp.feature", glue = "stepDefinitation")
public class TestRunner {
}
