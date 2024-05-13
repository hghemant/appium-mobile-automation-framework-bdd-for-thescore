package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.theScore.driver.Drivers;
import org.theScore.driver.manager.DriverManager;
import org.theScore.enums.ConfigJson;
import org.theScore.enums.MobilePlatformName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.Objects;
import java.util.Optional;

import static org.theScore.utils.AppiumServerManager.startAppiumServer;
import static org.theScore.utils.AppiumServerManager.stopAppiumServer;
import static org.theScore.utils.configloader.JsonParser.getConfig;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
  "summary",
  "html:target/cucumber-html-output/cucumber-html-report.html",
  "json:target/cucumber-json-output/cucumber.json"},
  features = {"src/test/resources/feature"},
  glue = {"org.example.stepdefinitions"},
  monochrome = true,
  tags = "@Login"
)
public class TestRunner {

  @BeforeClass
  public static void setUp() {
    startAppiumServer();
    if (Objects.isNull(DriverManager.getDriver())) {
      Drivers.initializeDriver(MobilePlatformName.valueOf(
        Optional.ofNullable(System.getProperty("platformName"))
          .orElse(getConfig(ConfigJson.PLATFORM)).toUpperCase()));
    }
  }

  @AfterClass
  public static void tearDown() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      Drivers.quitDriver();
    }
    stopAppiumServer();
  }
}

