Feature: Contact Form Feature

  Scenario Outline: Test Contact Form Feature - Success
    Given Open home page
    When I introduce "Name" value "<name>"
    When I introduce "Email" value "<email>"
    When I introduce "Subject" value "<subject>"
    When I introduce "Message" value "<message>"
    When I submit form
    Then Redirect Page

    Examples:
      |    name    |    email     |    subject   |   message   |
      |    Vlad    |    Vlad@E    |    Subject   |  Message    |

  Scenario Outline: Test Contact Form Feature - Validation Error - <error_message>
    Given Open home page
    When I introduce "Name" value "<name>"
    When I introduce "Email" value "<email>"
    When I introduce "Subject" value "<subject>"
    When I introduce "Message" value "<message>"
    When I submit form
    Then Get Validation Error

    Examples:
      |    name    |    email     |    subject    |     message     |     error_message           |
      |    Vlad    |    Vlad      |    Subject    |     message     |    Invalid Email            |
      |            |    Vlad@E    |    Subject    |     message     |    Empty Name field         |
      |    Vlad    |              |    Subject    |     message     |    Empty Email field        |
      |    Vlad    |    Vlad@E    |               |     message     |    Empty Subject field      |
      |    Vlad    |    Vlad@E    |    Subject    |                 |    Empty Message field      |