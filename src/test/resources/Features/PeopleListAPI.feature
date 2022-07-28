@Reg
Feature: People list

  Scenario Outline: Verify R2-D2 skin color
    Given As a user I have the people list "<API>"
    When I make a "<request type>" request
    Then I should get a response and confirm that "<Person Name>" skin color is "<Color>"


    Examples:
      | API                           | request type | Person Name | Color       |
      | https://swapi.dev/api/people/ | GET          | R2-D2       | white, blue |