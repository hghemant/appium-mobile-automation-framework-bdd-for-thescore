package org.theScore.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.theScore.driver.manager.DriverManager;
import org.theScore.pageobjects.LeaguePage;
import org.theScore.pageobjects.TeamPage;
import org.theScore.pageobjects.PlayerPage;


public class ScoreAppSteps {
    private WebDriver driver = DriverManager.getDriver();
    private LeaguePage leaguePage;
    private TeamPage teamPage;
    private PlayerPage playerPage;

    /*@Given("I have launched theScore app")
    public void i_have_launched_theScore_app() {
      if (!appIsRunning()) {
        driver.launchApp();
      }
    }*/

    @When("I navigate to a {string} page called {string}")
    public void i_navigate_to_a_page_called(String pageType, String pageName) {
      switch (pageType) {
        case "League":
          leaguePage = new LeaguePage(driver);
          leaguePage.navigateToLeague(pageName);
          break;
        case "Team":
          teamPage = new TeamPage(driver);
          teamPage.navigateToTeam(pageName);
          break;
        case "Player":
          playerPage = new PlayerPage(driver);
          playerPage.navigateToPlayer(pageName);
          break;
      }
    }

    @And("I tap on the {string} sub-tab")
    public void i_tap_on_the_sub_tab(String subTab) {
      switch (subTab) {
        case "Standings":
          leaguePage.selectSubTab(subTab);
          break;
        case "Stats":
          teamPage.selectSubTab(subTab);
          break;
        case "Overview":
          playerPage.selectSubTab(subTab);
          break;
      }
    }

    @Then("the {string} page should load with correct data for {string}")
    public void the_page_should_load_with_correct_data(String subTab, String pageName) {
      boolean isDataCorrect = false;
      switch (subTab) {
        case "Standings":
          isDataCorrect = leaguePage.verifyLeagueDataDisplayed(pageName);
          break;
        case "Stats":
          isDataCorrect = teamPage.verifyTeamDataDisplayed(pageName);
          break;
        case "Overview":
          isDataCorrect = playerPage.verifyPlayerDataDisplayed(pageName);
          break;
      }
      assert isDataCorrect : "Data on the " + subTab + " page is incorrect for " + pageName;
    }

    @And("when I perform back navigation")
    public void when_i_perform_back_navigation() {
      // This might be common for all pages, so you can potentially refactor this into a common method if applicable
      leaguePage.navigateBack();  // Assuming all pages use the same method
    }

    @Then("I should return to the {string} page")
    public void i_should_return_to_the_page(String pageType) {
      boolean isCorrectPage = false;
      switch (pageType) {
        case "League":
          isCorrectPage = leaguePage.isOnLeaguePage();
          break;
        case "Team":
          isCorrectPage = teamPage.isOnTeamPage();
          break;
        case "Player":
          isCorrectPage = playerPage.isOnPlayerPage();
          break;
      }
      assert isCorrectPage : "Not returned to the correct " + pageType + " page";
    }
  }
