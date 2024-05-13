package org.theScore.utils.screenshot;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.theScore.constants.FrameworkConstants;
import org.theScore.driver.manager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtils {

  // This class is to handle the change in third party library
  @SneakyThrows
  public static void captureScreenshotAsFile(String testName) throws IOException {
    var source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    var destination = new File(FrameworkConstants.SCREENSHOT_PATH + File.separator + testName + ".png");
    FileUtils.copyFile(source, destination);
  }

  public static byte[] captureScreenshotAsBytes() {
    return DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
  }
}
