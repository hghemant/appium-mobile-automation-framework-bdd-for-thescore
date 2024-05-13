package org.theScore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TeamPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Team Name']")
  private WebElement teamName;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Stats Tab']")
  private WebElement statsTab;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Team Data']")
  private WebElement teamData;

  @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate Up']")
  private WebElement backButton;

  public TeamPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver, this);
  }

  public void navigateToTeam(String teamName) {
    wait.until(ExpectedConditions.visibilityOf(this.teamName)).click();
  }

  public void selectSubTab(String subTabName) {
    switch (subTabName.toLowerCase()) {
      case "stats":
        wait.until(ExpectedConditions.elementToBeClickable(statsTab)).click();
        break;
      default:
        System.out.println("Sub-tab not defined in the switch case");
    }
  }

  public boolean verifyTeamDataDisplayed(String expectedData) {
    WebElement dataElement = wait.until(ExpectedConditions.visibilityOf(teamData));
    return dataElement.getText().contains(expectedData);
  }

  public void navigateBack() {
    wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
  }

  public boolean isOnTeamPage() {
    return wait.until(ExpectedConditions.visibilityOf(teamName)).isDisplayed();
  }
}
