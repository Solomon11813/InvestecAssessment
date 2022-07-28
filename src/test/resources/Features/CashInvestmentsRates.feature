@Reg
Feature: Cash Investment Rates

  Scenario Outline: Sign up to receive focus insights
    Given As a user I am on the Investec website
    When I search for "<SearchData>"
    Then the searched results should appear
    When I click on the searched topic
    Then Understanding cash investment interest rates page should be visible
    When I click on the sign up button
    And I fill in my "<name>", "<surname>", "<email address>", select "<relevant insights>" and click on submit
    Then Thank you message should be displayed to confirm sign up

    Examples:
      | SearchData                                   | name    | surname   | email address       | relevant insights |
      | Understanding cash investment interest rates | Solomon | Mathebula | test@investec.co.za | myself            |