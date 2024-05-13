Feature: Testing theScore App Navigation

    Scenario Outline: Navigating and verifying league, team, or player pages
        #Given I have launched theScore app
        When I navigate to a "<pageType>" page called "<pageName>"
        And I tap on the "<subTab>" sub-tab
        Then the "<subTab>" page should load with correct data for "<pageName>"
        And when I perform back navigation
        Then I should return to the "<pageType>" page

        Examples:
            | pageType | pageName         | subTab    |
            | League   | Premier League   | Standings |
            | Team     | Chelsea FC       | Stats     |
            | Player   | Cristiano Ronaldo| Overview  |
