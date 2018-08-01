Feature: City Weather Forecast

  Background:
    Given I launch weather forecast site

  Scenario Outline: Entering city name should display 5 day weather forecast
    When I enter city name <city>
    Then I should see 5 day weather forecast

    Examples:
      | city      |
      | Edinburgh |
      | Glasgow   |

  Scenario Outline: Selecting city and day should show all the available hourly forecast
    When I enter city name <city>
    And I select a day <day>
    Then I should see hourly forecast for selected <day>

    Examples:
      | city      | day |
      | Edinburgh | 1   |


  Scenario Outline: Selecting day again should hide hourly forecast
    When I enter city name <city>
    And I select a day <day>
    And I select a day <day>
    Then I should not see hourly forecast for selected <day>

    Examples:
      | city      | day |
      | Edinburgh | 1   |
      | Glasgow   | 2   |


  Scenario Outline: Selecting city and day should show correct Pressure details
    When I enter city name <city>
    And I select a day <day>
    Then I should see the pressure <pressure> for selected day <day>

    Examples:
      | city      | day | pressure |
      | Edinburgh | 1   | 1015     |
      | Edinburgh | 2   | 1013     |
      | Edinburgh | 3   | 1008     |
      | Edinburgh | 4   | 1008     |
      | Edinburgh | 5   | 1000     |

  Scenario Outline: Selecting city and day should show correct wind speed details
    When I enter city name <city>
    And I select a day <day>
    Then I should see the wind speed <windSpeed> for selected day <day>

    Examples:
      | city      | day | windSpeed |
      | Edinburgh | 1   | 3         |
      | Edinburgh | 2   | 1         |
      | Edinburgh | 3   | 4         |
      | Edinburgh | 4   | 6         |
      | Edinburgh | 5   | 11        |

  Scenario Outline: Selecting city and day should show correct aggregate rainfall details
    When I enter city name <city>
    And I select a day <day>
    Then I should see the aggregate rainfall <aggregateRainfall> for selected day <day>

    Examples:
      | city      | day | aggregateRainfall |
      | Edinburgh | 1   | 1                 |
      | Edinburgh | 2   | 6                 |
      | Edinburgh | 3   | 15                |
      | Edinburgh | 4   | 4                 |
      | Edinburgh | 5   | 40                |

  Scenario Outline:  Selecting city and day should show correct Minimum and maximum temperatures
    When I enter city name <city>
    And I select a day <day>
    Then I should see the minimim <minTemp> and maximum <maxTemp> temperatures for selected day <day> and hour <hour>

    Examples:
      | city      | day | hour | minTemp | maxTemp |
      | Edinburgh | 1   | 1    | 13      | 16      |
      | Edinburgh | 1   | 2    | 14      | 16      |
      | Edinburgh | 1   | 3    | 12      | 13      |
      | Edinburgh | 1   | 3    | 12      | 13      |




