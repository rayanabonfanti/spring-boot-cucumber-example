package cucumber.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import cucumber.CucumberApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfiguration {

}
