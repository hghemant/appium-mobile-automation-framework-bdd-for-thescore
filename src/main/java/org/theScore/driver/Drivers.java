package org.theScore.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.theScore.driver.factory.DriverFactory;
import org.theScore.driver.manager.DriverManager;
import org.theScore.enums.MobilePlatformName;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Drivers {

  public static void initializeDriver(MobilePlatformName mobilePlatformName) {
    DriverManager.setAppiumDriver(DriverFactory.getDriver(mobilePlatformName));
  }

  public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }
}
