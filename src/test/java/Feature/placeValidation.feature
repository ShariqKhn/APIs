Feature: Verify the Place API's

  Scenario Outline: Verify place is being sucessfully add using AddPlaceAPI
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with Post http request
    Then the API call is sucess with status code 200
    And and "status" in responce body should be "OK"
    And and "scope" in responce body should be "APP"
	
    Examples: 
      | name    | language | address            |
      | AAhouse | English  | World cross centre |
      | BBhouse | Spanish  | Sea cross Walk     |
