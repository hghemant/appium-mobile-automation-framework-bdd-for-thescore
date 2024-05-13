package org.theScore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeaguePage {

  private WebDriver driver;
  private WebDriverWait wait;


  @FindBy(xpath = "//android.widget.TextView[@content-desc='League Name']")
  private WebElement leagueName;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='Standings Tab']")
  private WebElement standingsTab;

  @FindBy(xpath = "//android.widget.TextView[@content-desc='League Data']")
  private WebElement leagueData;

  @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate Up']")
  private WebElement backButton;

  public LeaguePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver, this);
  }

  public void navigateToLeague(String leagueName) {
    wait.until(ExpectedConditions.visibilityOf(this.leagueName)).click();
  }

  public void selectSubTab(String subTabName) {
    switch (subTabName.toLowerCase()) {
      case "standings":
        wait.until(ExpectedConditions.elementToBeClickable(standingsTab)).click();
        break;
      default:
        System.out.println("Sub-tab not defined in the switch case");
    }
  }

  public boolean verifyLeagueDataDisplayed(String expectedData) {
    WebElement dataElement = wait.until(ExpectedConditions.visibilityOf(leagueData));
    return dataElement.getText().contains(expectedData);
  }

  public void navigateBack() {
    wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
  }

  public boolean isOnLeaguePage() {
    return wait.until(ExpectedConditions.visibilityOf(leagueName)).isDisplayed();
  }
}
