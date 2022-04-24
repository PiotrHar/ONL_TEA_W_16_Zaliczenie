Feature: Add address

  Scenario Outline: Add new address
    Given user is logged in on account page
    When user click on addresses
    When user click add address
    When user fills form with data "<alias>", "<address>", "<postalCode>", "<city>", "<country>", "<homePhone>"
    And click Save button to add first address
    Then first address is added

    Examples:
      |alias |address     |city   |postalCode |country         |homePhone|
      |Mr.   |Mickiewicza |Warsaw |00-001     |United Kingdom  |111212111|
