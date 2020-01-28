Feature: POM and Cucumber Test
Description: The purpose of this feature file is to implment POM with Cucmber

Scenario Outline: Customer place an order by purchasing an item from search
    Given user "<testCaseID>" is on Home Page
    When user search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter personal details on checkout page
    And place the order
    Then verify the order details
    
Examples:
|testCaseID	|
|TestCase1 	|
|TestCase2 	|