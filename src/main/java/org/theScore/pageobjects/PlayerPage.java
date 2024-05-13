package org.theScore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlayerPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Player Name']")
  private WebElement playerName;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Overview Tab']")
  private WebElement overviewTab;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Player Data']")
  private WebElement playerData;

  @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate Up']")
  private WebElement backButton;

  public PlayerPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver, this);
  }

  public void navigateToPlayer(String playerName) {
    wait.until(ExpectedConditions.visibilityOf(this.playerName)).click();
  }

  public void selectSubTab(String subTabName) {
    switch (subTabName.toLowerCase()) {
      case "overview":
        wait.until(ExpectedConditions.elementToBeClickable(overviewTab)).click();
        break;
      default:
        System.out.println("Sub-tab not defined in the switch case");
    }
  }

  public boolean verifyPlayerDataDisplayed(String expectedData) {
    WebElement dataElement = wait.until(ExpectedConditions.visibilityOf(playerData));
    return dataElement.getText().contains(expectedData);
  }

  public void navigateBack() {
    wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
  }

  public boolean isOnPlayerPage() {
    return wait.until(ExpectedConditions.visibilityOf(playerName)).isDisplayed();
  }
}
