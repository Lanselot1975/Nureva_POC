Feature: Sketch functionality
  @Ignore
  Scenario Outline: Login + Create Sketch
    Given I navigate to a landing page
    When I enter my email "<email>" and push Next button
    And I enter a password value "<passwd>" and push LogIn
    And I expect to navigate to the Canvases page
    Examples:
      | email                     | passwd     |
      | aforzon@qaconsultants.com | Qwerty1234 |

  @Ignore
  Scenario Outline: Create Canvas
    Given I expect to navigate to the Canvases page
    When I create the new canvas, push Create Canvas
    Then Change Canvas name "<name>"

    Examples:
      | name |
      | Test |
  @Ignore
  Scenario: Create Sketch
    Given Create sketch using Create menu
    When Verify the dots menu for the sketch
    And Open the item in editor on the private tray
    Then Post sketch to canvas from private tray
    And Edit sketch on canvas
  @Ignore
  Scenario: Resize Sketch
    Given Resize sketch on canvas
  @Ignore
  Scenario: Duplicate and copy Sketch
     Given Duplicate sketch on canvas
      When Copy sketch on canvas
      Then Verify after all manipulations draw is still there
  @Ignore
  Scenario: Export Sketch
    Given Add sketches and export canvas
    When Delete the Test canvas


