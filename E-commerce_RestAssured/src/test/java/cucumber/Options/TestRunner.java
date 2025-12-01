package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resource/features",
        tags="@smokers3",
        glue = {"StepDefinations"},
        plugin = {"pretty","html:target/reports/report3.html"})

public class TestRunner {

}
