@ApiCases @AllCases
Feature: Consume APIS from rickandmortyapi.com

  @TestCase_3
  Scenario Outline:  I should be able to Consuming character endpoint

    Given the "character" endPoint exists
    When I consume the Api<data>
    Then Check status <statusCode>
    And Check response from character Api<expectedResponse>

    Examples:
      | data | statusCode | expectedResponse                       |
      | 492  | 200        | Varrix,Alive,Alien                     |
      | 100  | 200        | Bubonic Plague,Dead,Disease            |
      | 56   | 200        | Bootleg Portal Chemist Rick,Dead,Human |
      | 78   | 200        | Cowboy Rick,Alive,Human                |
      | 2    | 200        | Morty Smith,Alive,Human                |
      | 0    | 404        | Character not found                    |
      | asd  | 500        | Hey! you must provide an id            |

  @TestCase_4
  Scenario Outline:  I should be able to Consuming location endpoint

    Given the "location" endPoint exists
    When I consume the Api<data>
    Then Check status <statusCode>
    And Check response from location Api<expectedResponse>

    Examples:
      | data    | statusCode | expectedResponse                       |
      | 87      | 200        | Globaflyn,Liquid,Replacement Dimension |
      | 3       | 200        | Citadel of Ricks,Space station,unknown |
      | 6000000 | 404        | Location not found                     |
      | 8/&s    | 404        | There is nothing here.                 |
      | ikau8   | 500        | Hey! you must provide an id            |

  @TestCase_5
  Scenario Outline:  I should be able to Consuming episode endpoint

    Given the "episode" endPoint exists
    When I consume the Api<data>
    Then Check status <statusCode>
    And Check response from episode Api<expectedResponse>

    Examples:
      | data  | statusCode | expectedResponse                                        |
      | 9     | 200        | Something Ricked This Way Comes--March 24, 2014--S01E09 |
      | 7     | 200        | Raising Gazorpazorp--March 10, 2014--S01E07             |
      | 55    | 404        | Episode not found                                       |
      | ..--[ | 500        | Bad... bad array :/                                     |
