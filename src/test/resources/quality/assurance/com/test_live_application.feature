Feature: Test Google page

  Background: Access Google page

  Scenario Outline: Open page test -  <test_case>
    Given set up
    When I access "<link>"
    When I send request
    Then Verify "<title>" opens
    Examples:
      | link                 | title  | test_case |
      | https://google.co.in | Google | Success   |


  Scenario Outline: Search method test -  <test_case>
    Given set up
    When open the search engine page
    When I search for "<query>"
    Then Check search result page "<condition>" open
    Examples:
      | query    | condition | test_case                         |
      | computer | is        | Success search - Valid key        |
      |          | is not    | Invalid search - Empty key        |
      | dfsserf  | is        | Invalid search - Irrelevant key  |


  Scenario Outline: Search result test -  <test_case>
    Given set up
    When open the search engine page
    When I search for "<key>"
    Then Check "<condition>" search result
    Examples:
      | key       | condition | test_case                   |
      | computer  | not empty | Not empty search result   |
      | ++++++++  | empty     | Empty search result       |