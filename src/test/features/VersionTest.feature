# new feature
# Tags: optional
    
Feature: Get Version Of SPR
    
Scenario: user calls version api
    Given version exist
    When a user retrieves version
    Then status code is 200
    And response includes the following items
    	| sbtVersion 	 		| 0.13.12 					|
    	| scalaVersion					| 2.11.8			|
