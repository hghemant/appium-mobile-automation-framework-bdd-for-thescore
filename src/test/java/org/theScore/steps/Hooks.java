package org.theScore.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.theScore.utils.screenrecording.ScreenRecordingService;
import org.theScore.utils.screenshot.ScreenshotService;

public class Hooks {

  @Before
  public void setUp() {
    ScreenRecordingService.startRecording();
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario.attach(ScreenshotService.getScreenshotAsBytes(),
                      "image/png", scenario.getName());
    }
    ScreenRecordingService.stopRecording(scenario.getName());
  }
}
