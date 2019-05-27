Feature: Create and Duplicate Canvas
    @Ignore
Scenario Outline: Login
    Given I navigate to a landing page
    When I enter my email "<email>" and push Next button
    And I enter a password value "<passwd>" and push LogIn
    Then I expect to navigate to the Canvases page


    Examples:
            | email | passwd |
            | aforzon@qaconsultants.com | Qwerty1234 |
    @Ignore
    Scenario Outline: Create a new Canvas
        Given I create the new canvas, push Create Canvas
        When Change Canvas name "<name>"
        Examples:
            | name |
            | Test |
    @Ignore
    Scenario: Add note
        Given I add note to canvas
        When Share with few people
        Then Duplicate canvas and verify duplicate window
    @Ignore
    Scenario: Verify Duplicate canvas
        Given Verify share users exist in copy
        When Delete the Copy canvas
        Then Delete the Test canvas