Feature: City Weather Forecast
  Background:
    Given I launch weather forecast site

  Scenario Outline: 5 day weather forecast
    When I enter city name <city>
    Then I should see 5 day weather forecast

    Examples:
      | city      |
      | Edinburgh |
      | Glasgow   |

  Scenario Outline: 5 day weather forecast with Hourly forecast
    When I enter city name <city>
    And I select a day <day>
    Then I should see forecast hourly for selected <day>

    Examples:
      | city      | day  |
      | Edinburgh | 1  |
      | Glasgow   | 2  |

  Scenario Outline:  Minimum and maximum temperatures
    When I enter city name <city>
    And I select a day <day>
    Then I should see the minimim <minTemp> and maximum <maxTemp> temperatures for selected day <day> and hour <hour>

    Examples:
      | city      | day  | hour|  minTemp  |maxTemp|
      | Edinburgh | 1    | 1   |    13     |16     |
      | Edinburgh | 1    | 2   |    14     |16     |
      | Edinburgh | 1    | 3   |    12     |13     |
      | Edinburgh | 1    | 3   |    12     |13    |

