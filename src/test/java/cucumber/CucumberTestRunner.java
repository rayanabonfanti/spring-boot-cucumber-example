package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.steps",
        plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"
        },
        monochrome = true
)
public class CucumberTestRunner {
}
