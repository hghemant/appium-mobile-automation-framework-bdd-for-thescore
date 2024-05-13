package org.theScore.utils.screenrecording;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.theScore.enums.ConfigProperties;
import org.theScore.utils.configloader.PropertyUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenRecordingService {

  public static void startRecording() {
    if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
      ScreenRecordingUtils.startScreenRecording();
    }
  }

  public static void stopRecording(String methodName) {
    if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
      ScreenRecordingUtils.stopScreenRecording(methodName);
    }
  }
}
