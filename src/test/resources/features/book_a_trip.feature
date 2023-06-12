Feature: Book a trip on Mail Travel website
  User Story:
  As a user,I want to navigate to the Mail Travel website, search for a destination,
  book a trip, and verify the booking details


  Scenario: Book a trip to India
    When the user is on the homepage of the "Mail Travel website"
    Then user should see the title is "Home Page | Mail Travel"
    And the user accepts all cookies
    When the user searches for "India" in the search bar
    And the user clicks on the "BOOK ONLINE" button
    And the user scrolls to the bottom of the page and selects the next available date
    Then user should not see the "Please select your departure date" text
    When user select "2" adults from dropdown menu and validate the airport
    And user validate the price for "2" adults
    And user clicks on "BOOK ONLINE" button
    When the user expands the Date, Departure & Passengers section
    Then the details populated are valid
    When the user selects the number of rooms required as 1 for two people
    And the user clicks on "SELECT YOUR ROOMS AND CONTINUE"
    And the user fills in the passenger details
    And the user fills in contact details and selects "Email" as answer to how did you hear about us
    And the user clicks the "CONTINUE" button
    Then the user verifies the "Confirm Details + Book" text is displayed
    And the user verifies that the "BOOK NOW" button is enabled




