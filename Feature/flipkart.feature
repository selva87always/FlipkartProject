#Author: selva

@tag
Feature: flipkart AddToKart checking
  

  Scenario Outline: Searching an item and adding it to the cart 

	Given User open Flipart Application in browser
	When User search the "<item>" and add to the cart
	Then User verifies whether that item added in cart or not
	
	Examples:
	|item|
	|Sony Led Tv|
	|Apple Iphone X|
	|G shock watch|
	|dell monitor|
	|water purifier|
