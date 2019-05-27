Feature: Info Page

  Scenario Outline: Login
    Given I navigate to a landing page
    When I enter my email "<email>" and push Next button
    And I enter a password value "<passwd>" and push LogIn
    Then I expect to navigate to the Canvases page

    Examples:
      | email                     | passwd     |
      | aforzon@qaconsultants.com | Qwerty1234 |



  Scenario: Getting Started
    Given I expect to navigate to the Canvases page
    And Click on the Help menu item
    When Click on Getting Started
    Then Verify Getting Started

  Scenario: Customer Support
    Given I expect to navigate to the Canvases page
    And Click on the Help menu item
    When Click on the Customer Support
    Then Verify Customer Support

  Scenario: About
    Given I expect to navigate to the Canvases page
    And Click on the Help menu item
    When Click on About
    Then Span software information panel verification
    And Click on Software license and general terms of use panel
    Then Toggle between French and English
    And Click on Intellectual property statement
