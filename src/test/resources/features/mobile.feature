@MobileCases @AllCases
Feature: Calculate length and speed conversions in the unitConverter app

  @TestCase_1
  Scenario Outline: Calculate length conversions
    Given The user is in the length option
    When Select to convert "<unit>" from "<measure_1>" to "<measure_2>"
    Then The app shows the correct "<answer>"

    Examples:
      | unit | measure_1 | measure_2 | answer  |
      | 13   | in        | mm        | 330.2   |
      | 45   | ftm       | mi        | 0.05114 |

  @TestCase_2
  Scenario Outline: Calculate speed conversions
    Given The user is in the speed option
    When Select to convert "<unit>" from "<measure_1>" to "<measure_2>"
    Then The app shows the correct "<answer>"

    Examples:
      | unit | measure_1 | measure_2 | answer |
      | 23   | fps       | m/s       | 7.0104 |
      | 65   | s/m       | m/min     | 0.9231 |