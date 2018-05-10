#Author: selva

@tag
Feature: Delta Flight Bookings
  
  @tag1
  Scenario: Delta Flight Bookings round Way Trip with exact date
    Given user in delta flight booking application
    And click the round trip button
    When I fill mandatory fields and click find flights button
    Then verify user navigated to flight listing page or not
  @tag2  
  Scenario: select flight basic or economy class
		When using flight number user select and click the class
		Then verify the flightnumber, source,destination, date and price 
		When user select the return flight and click continue button
		Then verify user in book a trip regisration form
	@tag3	
	Scenario: Fill the passanger information
	  When user enters mandatory fields firstName, LastName, gender, dateof birth, phonenumber, email, confirmemail 
	  And click continue button